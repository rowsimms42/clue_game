
public final class ClueGameConstants {
	
		public static final int PORT = 6060;
	
		public static final String IP = "localhost";
	
		public static final int MAX_CHARACTERS = 6;
		
		public static final int MIN_CHARACTERS = 3;
		
		public static final int BOARD_ROWS = 25;
		
		public static final int BOARD_COLS = 24;
		
		public static final int REQUEST_AVAILABLE_CHARACTERS = 11;

		public static final int REPLY_FROM_SERVER_AVAILABLE_CHARACTERS = 12;
		
		public static final int CONFIRM_INDEX_AVAILABLE = 13;
	
		public static final int REQUEST_MARK_CHARACTER_AS_TAKEN = 14;
	
		public static final int REQUEST_INDEED_CHARACTER_AVAILABLE = 15;
	
		public static final int REQUEST_IS_SELECTED_CHARACTER_AVAILABLE = 16;

		public static final int REPLY_FROM_SERVER_IS_CHARACTER_AVAILABLE = 17;

		public static final int REPLY_FROM_SERVER_IS_CHARACTER_INDEED_AVAILABLE = 18;

		public static final int REPLY_FROM_SERVER_CONFIRM_CHARACTER_SELECTED = 19;

		public static final int REQUEST_PLAYER_ID = 20;

		public static final int REPLY_FROM_SERVER_PLAYER_ID = 21;

		public static final int REQUEST_PLAYER_NAME = 22;

		public static final int REPLY_FROM_SERVER_PLAYER_NAME = 23;

		public static final int ERROR_CODE = 24;

		public static final int EMPTY_TILE = 25;

		public static final int REQUEST_DICE_ROLL = 26;

		public static final int REPLY_FROM_SERVER_DICE_ROLL= 27;
		
		public static final int REQUEST_PLAYERS_CHARACTER = 28;
		
		public static final int REPLY_FROM_SERVER_PLAYERS_CHARACTER = 29;
		
		public static final int REQUEST_MOVEMENT_BUTTON_VALUES = 30;
		
		public static final int REPLY_FROM_SERVER_MOVEMENT_BUTTON_VALUES = 31;
		
		public static final int REQUEST_PLAYER_MAP = 32;
		
		public static final int REPLY_FROM_SERVER_PLAYER_MAP = 33;
		
		public static final int REQUEST_PLAYER_OBJECT = 34;
		
		public static final int REPLY_FROM_SERVER_PLAYER_OBJECT = 35;
		
		public static final int REQUEST_MARK_PLAYER_END_TURN = 36;
		
		public static final int REPLY_FROM_SERVER_CONFIRM_PLAYER_END_TURN = 37;
		
		public static final int REQUEST_IS_CURRENT_TURN = 38;
		
		public static final int REPLY_FROM_SERVER_IS_CURRENT_TURN = 39;
		
		public static final int UNSELECTABLE_TILE = -1;

		public static final String[] CHARACTER_NAMES_ARRAY = {"Mr. Green", "Professor Plum", "Mrs. White", "Colonel Mustard",
										"Miss Scarlett", "Mrs. Peacock"};

		public static enum ROOMS{
			Conservatory(new Rect(0,5,20,23), new Rect(1,4,19,23), 1, new double[]{1,2,3,4,5,6}),
			Billard(new Rect(0, 5, 12, 16), new Rect(0, 5, 12, 16), 2, new double[]{0,0}),
			Library(new Rect(1,5,6,10), new Rect(0,6,7,9), 3, new double[]{0,0}),
			Study(new Rect(0, 5, 0, 3), new Rect(0, 6, 1, 3), 4, new double[]{0,0}),
			Ballroom(new Rect(8, 15, 17, 22), new Rect(10,13,17,23), 5, new double[]{0,0}),
			Hall(new Rect(9, 14, 1, 6), new Rect(9, 14, 1, 6), 6, new double[]{0,0}),
			StairCase(new Rect(9,13, 8, 11), new Rect(9,13, 8, 11), 7, new double[]{0,0}),
			Lounge(new Rect(18, 23, 0, 5), new Rect(17,23,1,5), 8, new double[]{0,0}),
			Kitchen(new Rect(18, 22, 18, 23), new Rect(18, 23, 18, 23), 9, new double[]{0,0}),
			DinningHall(new Rect(16,23,9,14), new Rect(19,23,9,15), 10, new double[]{0,0}),
			Logo(new Rect(9,13, 12, 14), new Rect(9,13,12,4), 11, new double[]{0,0});

			private Rect rect1, rect2;
			private int id;
			private double []graphicsPoints;

			ROOMS(Rect rect1, Rect rect2, int id, double[] graphicsPoints){
				this.rect1 = rect1;
				this.rect2 = rect2;
				this.id = id;
				this.graphicsPoints = graphicsPoints;
			}

			public Boolean isInRoom(int x, int y){
				return rect1.isWithIn(x, y) || rect2.isWithIn(x,y);
			}
			
			public double[] getGraphicsPointsArray() {return graphicsPoints;}

			public int getID() {return id;}

			public int getRoomId(int id){
				for(ROOMS room :ROOMS.values()){
					if(id == room.getID())
						return room.getID();
				}
				return 0; //not found in room
			}
		};
		
		public static enum DOORS{
			STUDY_DOOR1(6,4,0,4),
			LIBRARY_DOOR1(7,8,2,3),
			LIBRARY_DOOR2(3,11,0,3),
			BILLARD_DOOR1(1,11,1,2),
			BILLARD_DOOR2(6,15,2,2),
			CONSERVATORY_DOOR1(5,19,2,1),
			HALL_DOOR1(8,4,3,6),
			HALL_DOOR2(11,7,0,6),
			HALL_DOOR3(12,7,0,6),
			BALLROOM_DOOR1(7,19,3,5),
			BALLROOM_DOOR2(9,16,1,5),
			BALLROOM_DOOR3(14,16,1,5),
			BALLROOM_DOOR4(16,19,2,5),
			LOUNGE_DOOR1(17,6,0,8),
			DINNING_DOOR1(17,8,1,10),
			DINNING_DOOR2(15,12,3,10),
			KITCHEN_DOOR1(19,17,1,9);
		
			private int row, col, direction, roomNumber;
			DOORS(int row, int col, int direction, int roomNumber){
				this.row = row;
				this.col = col;
				this.direction = direction;
				this.roomNumber = roomNumber;
			}
			public int getRow() {return row;}
			public int getCol() {return col;}
			public int getDirection() {return direction;}
			public int getRoomNumber() {return roomNumber;}
		};
		
		public static final String gameRulesString = 
				"Object of the Game"+
						"Mr. Boddy is found death in one of the rooms of his mansion." +
						"The players must determine the answers to these three questions:" +"\n"+ "Who killed him? Where? and with What Weapon?"+
						" "+
						"	Game Play"+
						"Miss Scarlett opens the game, the turns continue clockwise around the table."+
						"On each turn, a player try to reach a different room of the mansion to investigate."+
						"To start your turn, move your token by rolling the die or use a Secret Passage when you are in a corner room."+
						"If you roll the die, you move your token that many spaces:"+
						"Horizontally or vertically, forward or backward, but not diagonally."+
						"You are not allowed to enter the same space twice on the same turn."+
						"You may not enter on a space that is already occupied by another player."+
						"If you move through a Secret Passage, you don't need to roll and you can move immediately to the other room. This ends your movement."+
						"It is possible that your opponents might block any and all doors and trap you in a room. In that case, you have to wait for someone to move or un-block a door to leave!"+
						" "+
						" "+
						"Suggestions or Guess"+
						"When you enter a room, you can make a suggestion by naming a suspect, murder weapon and the room you just entered."+
						"e.g. 'The crime was committed by Mr. Green in the lounge with a knife'."+
						"Then your opponents (starting by the left player) must (if possible) prove that your suggestion is false by showing you one card that matches your suggestion."+
						"If the first player can't disprove, the next player must try it, etc... until all players have passed."+
						"As soon as someone shows you one of the cards, it is prooved that it can't be in the envelope and you can cross it off in your notebook as a possibility."+
						"If no one is able to prove your suggestion false, you may either end your turn or make an accusation."+
						"Note: the suggestion is always made for the room your token is at that moment."+
						" "+
						"Accusing"+
						"If you think you have solved the crime by deduction, you can end your turn by making an accusation and name any three elements."+
						"you can say: I accuse suspect of committing the crime in the room with the weapon."+
						"Then, you must look secretly at the cards in the envelope to check if your suggestion is correct."+
						"If you are correct, you can place the 3 cards face-up on the table to prove it and you won the game!"+
						" "+
						"Note: You can only make one accusation during a game. If your accusation is wrong, you lost and you must leave the game and board";
						
}//end class
