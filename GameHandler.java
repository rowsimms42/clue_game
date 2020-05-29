import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class GameHandler {

    GameState gameState;
    int characterIndex;
    HashMap<Long, Player> playerMapTemp;

    GameHandler(GameState gameState) {
        this.gameState = gameState;
        playerMapTemp = new HashMap<Long, Player>();
    }

    public GameState getGameState() {
        return this.gameState;
    }

    /* Increment the number of players in the game state class */
    public void incrementAmountOfPlayers() {
        gameState.setNumberOfPlayers(gameState.getNumberOfPlayers() + 1);
    }

    //add player to the game state
    public void addPlayerToGame(long ID, Player player) {
        gameState.addPlayer(ID, player);
    }

    //return the number of players from the game state
    public int getNumberOfCurrentPlayers() {
        return gameState.getNumberOfPlayers();
    }

    public Message parseMessage(Message msgObj, long threadID) {
        Message returnMessage;
        Player tempPlayer, nextPlayer;
        Characters tempCharacter;
        HashMap<Long, Player> playerMapTemp = new HashMap<Long, Player>();
        ArrayList<Card> playersDeck = new ArrayList<>();
        ArrayList<Characters> nonPlayingCharList;
        ArrayList<Card> envelopeDeck = new ArrayList<>();
        int returnMessageID = 0;
        int msgID = msgObj.getMessageID();
        // System.out.println("Incoming to server MessageID: " + msgID);
        switch (msgID) {

            case ClueGameConstants.REQUEST_AVAILABLE_CHARACTERS:
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_AVAILABLE_CHARACTERS;
                returnMessage = new Message(returnMessageID, Integer.valueOf(gameState.getAvailableCharacters()));
                return returnMessage;

            case ClueGameConstants.REQUEST_IS_SELECTED_CHARACTER_AVAILABLE:
                characterIndex = (Integer) msgObj.getData();
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_IS_CHARACTER_AVAILABLE;
                returnMessage = new Message(returnMessageID, Boolean.valueOf(gameState.isSpecificCharacterAvailable(characterIndex)));
                return returnMessage;

            case ClueGameConstants.REQUEST_INDEED_CHARACTER_AVAILABLE:
                characterIndex = (Integer) msgObj.getData();
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_IS_CHARACTER_AVAILABLE;
                returnMessage = new Message(returnMessageID, Boolean.valueOf(gameState.isSpecificCharacterAvailable(characterIndex)));
                //System.out.println("Client wants to confirm that character is indeed available");
                return returnMessage;

            case ClueGameConstants.REQUEST_MARK_CHARACTER_AS_TAKEN:
                characterIndex = (Integer) msgObj.getData();
                gameState.setSpecificCharacterToUnavailable(characterIndex);
                tempCharacter = (Characters) gameState.getCharacterMap().get(gameState.getCharacterName(characterIndex));
                tempPlayer = new Player((Player) gameState.getPlayerMap().get(threadID));
                tempPlayer.setCharacter(tempCharacter);
                gameState.getPlayerMap().put(threadID, tempPlayer);
                gameState.addTurnOrder(tempPlayer.getCharacter().getTurnOrder());
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_CHARACTER_SELECTED;
                returnMessage = new Message(returnMessageID, null);
                return returnMessage;

            case ClueGameConstants.REQUEST_PLAYER_ID:
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_PLAYER_ID;
                returnMessage = new Message(returnMessageID, tempPlayer.getPlayerId());
                return returnMessage;

            case ClueGameConstants.REQUEST_DICE_ROLL:
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_DICE_ROLL;
                returnMessage = new Message(returnMessageID, gameState.rollDice());
                return returnMessage;

            case ClueGameConstants.REQUEST_MOVEMENT_BUTTON_VALUES:
                int[] locCoords = (int[]) msgObj.getData();
                tempPlayer = new Player((Player) gameState.getPlayerMap().get(threadID));
                tempPlayer.setLocation(locCoords);
                gameState.getPlayerMap().put(threadID, tempPlayer);
                HashMap<String, Boolean> buttonValues = gameState.getAvailableMoves(tempPlayer.getLocationArray());
                StringBuilder sb = new StringBuilder();
                for (String value : buttonValues.keySet()) {
                    boolean val = buttonValues.get(value);
                    int boolToIntVal = (!val) ? 0 : 1;
                    sb.append(boolToIntVal);
                }
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_MOVEMENT_BUTTON_VALUES;
                returnMessage = new Message(returnMessageID, String.valueOf(sb));
                return returnMessage;

            case ClueGameConstants.REQUEST_PLAYER_MAP:
                playerMapTemp.clear();
                playerMapTemp.putAll(gameState.getPlayerMap());
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_PLAYER_MAP;
                returnMessage = new Message(returnMessageID, playerMapTemp);
                return returnMessage;

            case ClueGameConstants.REQUEST_PLAYER_OBJECT:
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_PLAYER_OBJECT;
                returnMessage = new Message(returnMessageID, tempPlayer);
                return returnMessage;

            case ClueGameConstants.REQUEST_IS_CURRENT_TURN:
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_IS_CURRENT_TURN;
                returnMessage = new Message(returnMessageID, tempPlayer.getIsPlayerTurn());
                return returnMessage;

            case ClueGameConstants.REQUEST_MARK_PLAYER_END_TURN:
                tempPlayer = new Player((Player) gameState.getPlayerMap().get(threadID));
                tempPlayer.setIsPlayerTurn(false);
                gameState.getPlayerMap().put(threadID, tempPlayer);
                int nextTurnOrder = gameState.getNextPlayerTurnNumber();
                gameState.setPlayOrderIndex(gameState.getPlayOrderIndex() + 1);
                nextPlayer = (Player) gameState.getPlayerByTurnOrder(nextTurnOrder);
                if (nextPlayer == null) System.out.println("Next turn player was null");
                assert nextPlayer != null;
                tempPlayer = new Player((Player) gameState.getPlayerMap().get(nextPlayer.getPlayerId()));
                tempPlayer.setIsPlayerTurn(true);
                gameState.getPlayerMap().put(tempPlayer.getPlayerId(), tempPlayer);
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_PLAYER_END_TURN;
                returnMessage = new Message(returnMessageID, null);
                return returnMessage;

            case ClueGameConstants.REQUEST_UPDATE_PLAYER_ROOM_NUMBER:
                int roomNumber = (int) msgObj.getData();
                tempPlayer = new Player((Player) gameState.getPlayerMap().get(threadID));
                tempPlayer.setRoomLocation(roomNumber);
                gameState.getPlayerMap().put(threadID, tempPlayer);
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_UPDATE_PLAYER_ROOM_NUMBER;
                returnMessage = new Message(returnMessageID, null);
                return returnMessage;

            case ClueGameConstants.REQUEST_DOES_CURRENT_PLAYER_GO_FIRST:
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                int firstTurnNumberInList = gameState.getTurnOrderList().get(0);
                boolean doesGoFirst = tempPlayer.getCharacter().getTurnOrder() == firstTurnNumberInList;
                if (doesGoFirst) {
                    tempPlayer = new Player((Player) gameState.getPlayerMap().get(threadID));
                    tempPlayer.setIsGoingFirst(doesGoFirst); //true
                    gameState.getPlayerMap().put(threadID, tempPlayer);
                    gameState.setPlayOrderIndex(gameState.getPlayOrderIndex() + 1);
                }
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_DOES_CURRENT_PLAYER_GO_FIRST;
                returnMessage = new Message(returnMessageID, tempPlayer.getIsGoingFirst());
                return returnMessage;

            case ClueGameConstants.REQUEST_CAN_PLAYER_START_GAME:
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                boolean isCanPlayerStartGame = gameState.findIfPlayerCanStartGame(tempPlayer);
                if (isCanPlayerStartGame) {
                    tempPlayer = new Player((Player) gameState.getPlayerMap().get(threadID));
                    tempPlayer.setIsCanStartGame(true);
                    gameState.getPlayerMap().put(threadID, tempPlayer);
                }
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CAN_PLAYER_START_GAME;
                returnMessage = new Message(returnMessageID, tempPlayer.getIsCanStartGame());
                return returnMessage;

            case ClueGameConstants.REQUEST_TO_START_GAME:
                gameState.setIsGameStarted(true);
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_START_GAME;
                returnMessage = new Message(returnMessageID, null);
                return returnMessage;

            case ClueGameConstants.REQUEST_IF_GAME_HAS_STARTED:
                boolean isHasGameStarted = gameState.getIsGameStarted();
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_IF_GAME_HAS_STARTED;
                returnMessage = new Message(returnMessageID, Boolean.valueOf(isHasGameStarted));
                return returnMessage;

            case ClueGameConstants.REQUEST_DEAL_CARDS:
                gameState.dealCardsToPlayers();
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_DEAL_CARDS;
                returnMessage = new Message(returnMessageID, null);
                return returnMessage;

            case ClueGameConstants.REQUEST_PlAYERS_DECK:
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                playersDeck.clear();
                playersDeck.addAll(tempPlayer.getPlayerDeck());
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_PlAYERS_DECK;
                returnMessage = new Message(returnMessageID, playersDeck);
                return returnMessage;

            case ClueGameConstants.REQUEST_LIST_OF_NON_PLAYING_CHARACTERS:
                nonPlayingCharList = gameState.getNonPlayingCharactersArrayList();
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_LIST_OF_NON_PLAYING_CHARACTERS;
                returnMessage = new Message(returnMessageID, nonPlayingCharList);
                return returnMessage;

            case ClueGameConstants.REQUEST_BUILD_NON_PLAYING_CHAR_LIST:
                gameState.buildlistOfAllNonPlayingCharacters();
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_BUILD_NON_PLAYING_CHAR_LIST;
                returnMessage = new Message(returnMessageID, null);
                return returnMessage;

            case ClueGameConstants.REQUEST_IS_SUGGESTION_MADE:
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_IS_SUGGESTION_MADE;
                returnMessage = new Message(returnMessageID, gameState.getIsSuggestionMade());
                return returnMessage;

            case ClueGameConstants.REQUEST_ENVELOPE_DECK:
                envelopeDeck.clear();
                envelopeDeck.addAll(gameState.getEnvelopeDeck());
                returnMessageID = ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_ENVELOPE_DECK;
                returnMessage = new Message(ClueGameConstants.REPLY_FROM_SERVER_CONFIRM_ENVELOPE_DECK, envelopeDeck);
                return returnMessage;
            /*
                //function: requestSetSuggestionToFalse()
                function: gameState.buildeSuggestionString(suggestedCharacter, suggestedWeapon, suggestedRoom);
                //function: requestRevealedCardsList()
                //function: gameState.buildRevealedCardsList();

            case ClueGameConstants.REQUEST_SUBMITTING_SUG_CONTENT_NUM:
                int suggestionConent = (int) msgObj.getData();
                int suggestedCharacter = suggestionConent / 100;
                int suggestedWeapon = (suggestionConent - suggestedCharacter * 100) / 10;
                int suggestedRoom = (suggestionConent % 100) % 10;
                tempPlayer = (Player) gameState.getPlayerMap().get(threadID);
                //gameState.setIsSuggestionMade(true);
                gameState.buildeSuggestionString(suggestedCharacter, suggestedWeapon, suggestedRoom, tempPlayer);
                //TODO --> update suggested player's location to draw in suggested room
                    //suggestedPlayer.setCurrentXLocation(4);
                    //suggestedPlayer.setCurrentYLocation(7);
                //TODO ---> trigger reviewing other's cards.


                //TODO:
                //TODO continue; */
            /*
            case ClueGameConstants.REQUEST_SUGGESTION_CONTENT:
                String suggestionContentString = gameState.getSuggestionContentString();
                returnMessage = new Message(ClueGameConstants., suggestionContentString);
                return returnMessage;*/
            /*
            case ClueGameConstants.REQUEST_REVEALED_CARDS_ARRAY:
                //TODO cycle through suggestion and match with players' hands
                gameState.builderRevealedCardsList();
                ArrayList<Sting[]> revealedCards = new ArrayList<>();
                revealedCards.add(new String[]{"Mr.Whte", "card they had"});
                returnMessage = new Message(ClueGameConstants.REPLY_REVEALED_CARD, null); //TODO not null
                return returnMessage;

            case ClueGameConstants.REQUEST_REVEALED_CARD: */

            default:
                return msgObj; //returns same object sent
        }
    }

    //remove player from game
    public void removePlayerFromGame(long ID, Player player){
        String name = player.getName();
        String[] characterNames = ClueGameConstants.CHARACTER_NAMES_ARRAY;
        int index = Arrays.asList(characterNames).indexOf(name);
        gameState.setSpecificCharacterToAvailable(index);


        //gameState.removePlayer(ID);
        //TODO make character the player was assigned to available.

    }
} //end class