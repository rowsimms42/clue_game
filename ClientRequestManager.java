/**************************************************************
 * This class contains all functions related to the sending and
 * receiving of data between client side gui and server
 **************************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientRequestManager {

    Client clientConnection;
    Message messageReceived;
    public ClientRequestManager(Client clientConnection){
        this.clientConnection = clientConnection;
    }

    public int requestPlayerRoomLocation() {
        int roomLocation = 0;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_PLAYER_ROOM_LOCATION, null));
            messageReceived = clientConnection.getMessage();
            roomLocation = (int) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return roomLocation;
    }

    public void requestBuildListOfNonPlayingChars() {
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_BUILD_NON_PLAYING_CHAR_LIST, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Characters> requestListNonPlayingChars(){
        ArrayList<Characters> characterList = new ArrayList<>();
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_LIST_OF_NON_PLAYING_CHARACTERS, null));
            messageReceived = clientConnection.getMessage();
            characterList   = (ArrayList<Characters>) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return characterList;
    }

    public ArrayList<Card> requestPlayersCardDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_PlAYERS_DECK , null));
            messageReceived = clientConnection.getMessage();
            deck = (ArrayList<Card>) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return deck;
    }

    public void requestDealCards() {
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_DEAL_CARDS, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void requestToStartGame() {
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_TO_START_GAME , null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean requestIfPlayerCanStartGame() {
        boolean isCanStartGame = false;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_CAN_PLAYER_START_GAME , null));
            messageReceived = clientConnection.getMessage();
            isCanStartGame = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isCanStartGame;
    }

    public boolean requestIfGameHasStarted() {
        boolean isGameStarted = false;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_IF_GAME_HAS_STARTED, null));
            messageReceived = clientConnection.getMessage();
            isGameStarted = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isGameStarted;
    }

    public boolean requestDoesCurrentPlayerGoFirst() {
        boolean isGoingFirst = false;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_DOES_CURRENT_PLAYER_GO_FIRST , null));
            messageReceived = clientConnection.getMessage();
            isGoingFirst = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isGoingFirst;
    }

    public void requestUpdatePlayerRoomLocation(int roomNum) {
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_UPDATE_PLAYER_ROOM_NUMBER, roomNum));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void requestEndOfTurn() {
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_MARK_PLAYER_END_TURN, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean requestIsCurrentTurn() {
        boolean isTurn = false;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_IS_CURRENT_TURN, null));
            messageReceived = clientConnection.getMessage();
            isTurn = (boolean)messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isTurn;
    }

    public int requestDiceRoll(){
        int diceRoll = 0;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_DICE_ROLL, null));
            messageReceived = clientConnection.getMessage();
            diceRoll = (int) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return diceRoll;
    }

    public  HashMap<Long, Player> requestPlayerMap(){
        HashMap<Long, Player> newPlayerMap = new HashMap<Long, Player>();
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_PLAYER_MAP, null));
            messageReceived = clientConnection.getMessage();
            //playerMap = (HashMap<Long, Player>) messageReceived.getData();
            newPlayerMap = (HashMap<Long, Player>) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return newPlayerMap;
    }

    public String[] requestBtns(int x, int y){
        int[] coords = {x, y};
        String btnValues = null;
        String coordinatesStr = x + ", " + y;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_MOVEMENT_BUTTON_VALUES, coords));
            messageReceived = clientConnection.getMessage();
            btnValues = (String) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return new String[]{coordinatesStr, btnValues};
    }

    public boolean requestIfSuggestionMade(){
        boolean isSuggestion = false;
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_IS_SUGGESTION_MADE, null));
            messageReceived = clientConnection.getMessage();
            isSuggestion = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isSuggestion;
    }

    public void requestSubmitSuggestionContentNum(int conentSugNumber){
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_SUBMITTING_SUG_CONTENT_NUM, conentSugNumber));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Card> requestEnvelopeCardDeck() {
        ArrayList<Card> envelopeDeck = new ArrayList<>();
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_ENVELOPE_DECK , null));
            messageReceived = clientConnection.getMessage();
            envelopeDeck = (ArrayList<Card>) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return envelopeDeck;
    }

    public String requestSuggestionContent(){
        String suggestionContent = null;
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_SUGGESTION_CONTENT, null));
            messageReceived = clientConnection.getMessage();
            suggestionContent = (String)messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return suggestionContent;
    }

    public String requestCardRevealed(){
        String card = "";
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_REVEALED_CARD, null));
            messageReceived = clientConnection.getMessage();
            card = (String) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return card;
    }

    /**
     * Called after player who made the suggestion
     * closes their window that shows who showed what
     * cliet uses results to set value of suggestion button
     * @return
     */
    public void requestSetSuggestionToFalse(){
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_SET_SUGGESTION_FALSE, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function requested by player who is making the accusation
     * returns String[] of players and what card they had that
     * matched the suggestion, there can up three strings in the list
     * example <String[0]> == "Mr Green reveals 'The Kitchen' to you"
     * @return String []
     */
    public ArrayList<String[]> requestRevealedCardList(){
       ArrayList<String[]> revealedCardsList = new ArrayList<>();
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_REVEALED_CARD_LIST, null));
            messageReceived = clientConnection.getMessage();
            revealedCardsList = (ArrayList<String[]>) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return revealedCardsList;
    }

    public void requestRemovePlayerFromPlaying(){
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_REMOVE_PLAYER_FROM_PLAYING, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void requestSubmitAccuseContent(int accusedContentNum){
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_SUBMIT_ACCUSE_CONTENT, accusedContentNum));
            messageReceived = clientConnection.getMessage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean requestIfAccusationMade(){
        boolean isAccusationMade = false;
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_IS_ACCUSATION_MADE, null));
            messageReceived = clientConnection.getMessage();
            isAccusationMade = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isAccusationMade;
    }

    public String requestAccusationContent() {
        String accusationContent = null;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_ACCUSATION_CONTENT, null));
            messageReceived = clientConnection.getMessage();
            accusationContent = (String) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return accusationContent;
    }

    public boolean requestIsAccusationCorrect(){
        boolean isAccusationCorrect = false;
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_IS_ACCUSATION_CORRECT, null));
            messageReceived = clientConnection.getMessage();
            isAccusationCorrect = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isAccusationCorrect;
    }

    public void requestSetIsAccusationMadeToFalse(){
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_SET_IS_ACCUSATION_MADE_TO_FALSE, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public int requestNumberofPlayers(){
        int numPlayers = 0;
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_NUMBER_OF_PLAYERS, null));
            messageReceived = clientConnection.getMessage();
            numPlayers = (int)messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return numPlayers;
    }

    public void requestIncrementSuggestionCount(){
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_INCREMENT_SUG_COUNT, null));
            messageReceived = clientConnection.getMessage();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean requestAmIRemainingPlayer(){
        boolean isRemainingPlayer = false;
        try{
            clientConnection.send(new Message(ClueGameConstants.REQUEST_AM_REMAINING_PLAYER, null));
            messageReceived = clientConnection.getMessage();
            isRemainingPlayer = (boolean) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return isRemainingPlayer;
    }
    
    public Player requestThisPlayerObject(){
        Player thisPlayer = null;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_PLAYER_OBJECT, null));
            messageReceived = clientConnection.getMessage();
            thisPlayer = (Player) messageReceived.getData();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return thisPlayer;
    }

    public String requestSuggestedRoomString() {
        String suggestedRoom = null;
        try {
            clientConnection.send(new Message(ClueGameConstants.REQUEST_SUGGESTED_ROOM_STRING, null));
            messageReceived = clientConnection.getMessage();
            suggestedRoom = (String) messageReceived.getData();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return suggestedRoom;
    }
}
