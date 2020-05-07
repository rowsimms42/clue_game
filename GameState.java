import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class GameState {
	
	private int availableCharacters;
	private Boolean availableCharactersArray[];
	private int numberOfPlayers;
	private HashMap<Long, Player> playerMap;
	
	private ArrayList<Card> weaponCardDeck, suspectCardDeck, 
							roomCardDeck, envelopeDeck, combinedDeck;
	
	public GameState(){
		
		initializeVariables();
	}
	
	
	/*
	 * Need to set up call to new Game state and
	 * Initialize all data that need to be set
	 * from a call at the same time that the server
	 * starts functioning. There is only 1 GameState
	 * and it is accessed through the GameHandler
	 * so the data can be undated and shared with 
	 * the clients 
	 */

	public void initializeVariables(){
	
		availableCharacters = 0;

		numberOfPlayers = 0;
		
		availableCharactersArray = new Boolean[ ClueGameConstants.MAX_CHARACTERS ];
		for(int i = 0; i < ClueGameConstants.MAX_CHARACTERS; i++) {
			availableCharactersArray[i] = true;
		}
		
		playerMap = new HashMap<Long, Player>();

		weaponCardDeck  = createAndFillWeaponCardDeck();
		roomCardDeck    = createAndFillRoomCardDeck();
		suspectCardDeck = createAndFillSuspectCardDeck();

	}

	public int getAvailableCharacters() {
		return availableCharacters;
	}

	public boolean isSpecificCharacterAvailable(int index) {
		return (availableCharactersArray[index - 1] == true);
	}
	
	public void setSpecificCharacterToUnavailable(int index ) {
		/* Character: 0 - Mr. Green, 1 - Professor Plumb, 2 - Mrs. White,
		   3 - Colonel Mustard, 4 - Miss Scarlet, 5 - Mrs. Peacock */
		availableCharacters = setNthBit(availableCharacters, index - 1);
		
		availableCharactersArray[index - 1] = false;
	}
	
	private int setNthBit(int number, int n) {
		return ((1 << n) | number);
	}
	
	public  void setNumberOfPlayers(int n){
		numberOfPlayers = n;
	}

	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}
	
	public void addPlayer(Player player, long threadID){
		playerMap.put(threadID, player);
	}

	public HashMap getPlayerMap(){
		return playerMap;
	} 

	public void assignPlayerName(String name, long threadID){
		playerMap.get(threadID).setName(name);
	}

	public String getCharacterName(int index){
		return ClueGameConstants.CHARACTER_NAMES_ARRAY[index - 1];
	}

	public int rollDice(){
		Random rand = new Random();
		int dice_1 = rand.nextInt(7);
		int dice_2 = rand.nextInt(7);
		return dice_1 + dice_2;
	}
	
	private ArrayList<Card> createAndFillWeaponCardDeck(){
		ArrayList<Card> weaponsList = new ArrayList<Card>();
		weaponsList.add(new WeaponCard("Pipe", 1, 1));
		weaponsList.add(new WeaponCard("Candle Stick", 2, 1));
		weaponsList.add(new WeaponCard("Revolver", 3, 1));
		weaponsList.add(new WeaponCard("Wrench", 4, 1));
		weaponsList.add(new WeaponCard("Knife", 5, 1));
		weaponsList.add(new WeaponCard("Rope", 6, 1));
		Collections.shuffle(weaponsList);
		return weaponsList;
	}
	
	private ArrayList<Card> createAndFillRoomCardDeck(){
		ArrayList<Card> roomList = new ArrayList<Card>();
		roomList.add(new RoomCard("Conservatory", 1, 3));
		roomList.add(new RoomCard("Billiard Room", 2, 3));
		roomList.add(new RoomCard("Study Room", 3, 3));
		roomList.add(new RoomCard("Hall", 4, 3));
		roomList.add(new RoomCard("Lounge", 5, 3));
		roomList.add(new RoomCard("Dining Room", 6, 3));
		roomList.add(new RoomCard("Kitchen", 7, 3));
		roomList.add(new RoomCard("Ballroom", 8, 3));
		roomList.add(new RoomCard("Library", 9, 3));
		Collections.shuffle(roomList);
		return roomList;	
	}
	
	private ArrayList<Card> createAndFillSuspectCardDeck(){
		ArrayList<Card> suspectList = new ArrayList<Card>();
		suspectList.add(new SuspectCard("Colonel Mustard", 1, 2));
		suspectList.add(new SuspectCard("Miss Scarlet", 2, 2));
		suspectList.add(new SuspectCard("Professor Plum", 3, 2));
		suspectList.add(new SuspectCard("Mr. Green", 4, 2));
		suspectList.add(new SuspectCard("Mrs. White", 5, 2));
		suspectList.add(new SuspectCard("Mrs. Peacock", 6, 2));
		Collections.shuffle(suspectList);
		return suspectList;
	}
	
} //end class
