/*****************************************************************
 * This class contains final variables used throughout server and 
 * client side portions of the game
 ****************************************************************/


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

    public static final int REQUEST_UPDATE_PLAYER_ROOM_NUMBER = 40;

    public static final int REPLY_FROM_SERVER_CONFIRM_UPDATE_PLAYER_ROOM_NUMBER = 41;

    public static final int REQUEST_DOES_CURRENT_PLAYER_GO_FIRST = 42;

    public static final int REPLY_FROM_SERVER_DOES_CURRENT_PLAYER_GO_FIRST = 43;

    public static final int REQUEST_CAN_PLAYER_START_GAME = 44;

    public static final int REPLY_FROM_SERVER_CAN_PLAYER_START_GAME = 45;

    public static final int REQUEST_IF_GAME_HAS_STARTED = 46;

    public static final int REPLY_FROM_SERVER_IF_GAME_HAS_STARTED = 47;

    public static final int REQUEST_TO_START_GAME = 48;

    public static final int REPLY_FROM_SERVER_CONFIRM_START_GAME = 49;

    public static final int REQUEST_DEAL_CARDS = 50;

    public static final int REPLY_FROM_SERVER_CONFIRM_DEAL_CARDS = 51;

    public static final int REQUEST_PlAYERS_DECK = 52;

    public static final int REPLY_FROM_SERVER_CONFIRM_PlAYERS_DECK = 53;

    public static final int REQUEST_LIST_OF_NON_PLAYING_CHARACTERS = 54;

    public static final int REPLY_FROM_SERVER_CONFIRM_LIST_OF_NON_PLAYING_CHARACTERS = 55;

    public static final int REQUEST_BUILD_NON_PLAYING_CHAR_LIST = 56;

    public static final int REPLY_FROM_SERVER_CONFIRM_BUILD_NON_PLAYING_CHAR_LIST = 57;

    public static final int REQUEST_PLAYER_ROOM_LOCATION = 58;

    public static final int REPLY_FROM_SERVER_CONFIRM_PLAYER_ROOM_LOCATION = 59;

    public static final int REQUEST_IS_SUGGESTION_MADE = 60;

    public static final int REPLY_FROM_SERVER_CONFIRM_IS_SUGGESTION_MADE = 61;

    public static final int REQUEST_ENVELOPE_DECK = 62;

    public static final int REPLY_FROM_SERVER_CONFIRM_ENVELOPE_DECK = 63;

    public static final int REQUEST_SUGGESTION_CONTENT = 64;

    public static final int REPLY_FROM_SERVER_CONFIRM_SUGGESTION_CONTENT = 65;

    public static final int REQUEST_REVEALED_CARD = 66;

    public static final int REPLY_FROM_SERVER_CONFIRM__REVEALED_CARD = 67;

    public static final int REQUEST_SUBMITTING_SUG_CONTENT_NUM = 68;

    public static final int REPLY_FROM_SERVER_CONFIRM_SUBMITTING_SUG_CONTENT_NUM = 69;

    public static final int REQUEST_REVEALED_CARD_LIST = 70;

    public static final int REPLY_FROM_SERVER_CONFIRM_REVEALED_CARD_LIST = 71;

    public static final int REQUEST_SET_SUGGESTION_FALSE = 72;

    public static final int REPLY_FROM_SERVER_CONFIRM_SET_SUGGESTION_FALSE = 73;

    public static final int  REQUEST_REMOVE_PLAYER_FROM_PLAYING = 74;

    public static final int REPLY_FROM_SERVER_CONFIRM_REMOVE_PLAYER_FROM_PLAYING = 75;

    public static final int REQUEST_SUBMIT_ACCUSE_CONTENT = 76;

    public static final int REPLY_FROM_SERVER_CONFIRM_CONFIRM_SUBMIT_ACCUSE_CONTENT = 77;

    public static final int REQUEST_IS_ACCUSATION_MADE = 82;

    public static final int REPLY_FROM_SERVER_CONFIRM_IS_ACCUSATION_MADE = 83;

    public static final int REQUEST_ACCUSATION_CONTENT = 84;

    public static final int REPLY_FROM_SERVER_CONFIRM_CONFIRM_ACCUSATION_CONTENT = 85;

    public static final int REQUEST_IS_ACCUSATION_CORRECT = 86;

    public static final int REPLY_FROM_SERVER_CONFIRM_IS_ACCUSATION_CORRECT = 87;

    public static final int REQUEST_SET_IS_ACCUSATION_MADE_TO_FALSE = 88;

    public static final int REPLY_FROM_SERVER_CONFIRM_SET_IS_ACCUSATION_MADE_TO_FALSE = 89;

    public static final int REQUEST_NUMBER_OF_PLAYERS = 90;

    public static final int REPLY_FROM_SERVER_NUMBER_OF_PLAYERS = 91;

    public static final int REQUEST_INCREMENT_SUG_COUNT = 92;

    public static final int REPLY_FROM_SERVER_CONFIRM_INCREMENT_SUG_COUNT = 93;

    public static final int REQUEST_AM_REMAINING_PLAYER = 94;

    public static final int REPLY_FROM_SERVER_CONFIRM_AM_REMAINING_PLAYER = 95;

    public static final int REQUEST_SUGGESTED_ROOM_STRING = 96;

    public static final int REPLY_FROM_SERVER_CONFIRM_SUGGESTED_ROOM_STRING = 97;

    public static final int UNSELECTABLE_TILE = -1;

    public static final String[] CHARACTER_NAMES_ARRAY = {"Mr. Green", "Professor Plum", "Mrs. White", "Colonel Mustard",
            "Miss Scarlett", "Mrs. Peacock"};

    public static final String[] ROOM_NAMES_ARRAY = {"Conversatory", "Billard Room", "Library", "Study", "Ballroom",
            "Hall", "Lounge", "Kitchen","Dining Room"};

    public static final String[] WEAPON_NAMES_ARRAY = {"Pipe", "Candle Stick", "Revolver", "Wrench", "Knife", "Rope"};

    public static enum ROOMS{
        Conservatory(new Rect(0,5,20,23), new Rect(1,4,19,23), 1, new double[]{1,2,3,4,5,6}),
        Billard(new Rect(0, 5, 12, 16), new Rect(0, 5, 12, 16), 2, new double[]{0,0}),
        Library(new Rect(1,5,6,10), new Rect(0,6,7,9), 3, new double[]{0,0}),
        Study(new Rect(0, 5, 0, 3), new Rect(0, 6, 1, 3), 4, new double[]{0,0}),
        Ballroom(new Rect(8, 15, 17, 22), new Rect(10,13,17,23), 5, new double[]{0,0}),
        Hall(new Rect(9, 14, 1, 6), new Rect(9, 14, 1, 6), 6, new double[]{0,0}),
        Lounge(new Rect(18, 23, 0, 5), new Rect(17,23,1,5), 7, new double[]{0,0}),
        Kitchen(new Rect(18, 22, 18, 23), new Rect(18, 23, 18, 23), 8, new double[]{0,0}),
        DinningHall(new Rect(16,23,9,14), new Rect(19,23,9,15), 9, new double[]{0,0}),
        StairCase(new Rect(9,13, 8, 11), new Rect(9,13, 8, 11), 10, new double[]{0,0}),
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
        STUDY_DOOR1(6,4,0,4, 1),
        LIBRARY_DOOR2(7,8,2,3, 2),
        LIBRARY_DOOR1(3,11,0,3, 1),
        BILLARD_DOOR1(1,11,1,2, 1),
        BILLARD_DOOR2(6,15,2,2, 2),
        CONSERVATORY_DOOR1(5,19,2,1, 1),
        HALL_DOOR1(8,4,3,6, 1),
        HALL_DOOR2(11,7,0,6, 2),
        HALL_DOOR3(12,7,0,6, 3),
        BALLROOM_DOOR1(7,19,3,5,1),
        BALLROOM_DOOR2(9,16,1,5,2),
        BALLROOM_DOOR3(14,16,1,5,3),
        BALLROOM_DOOR4(16,19,2,5,4),
        LOUNGE_DOOR1(17,6,0,7, 1),
        DINNING_DOOR2(17,8,1,9,2),
        DINNING_DOOR1(15,12,3,9,1),
        KITCHEN_DOOR1(19,17,1,8, 1);

        private final int row, col, direction, roomNumber,doorID;
        DOORS(int row, int col, int direction, int roomNumber, int doorID){
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.roomNumber = roomNumber;
            this.doorID = doorID;
        }
        public int getRow() {return row;}
        public int getCol() {return col;}
        public int getDirection() {return direction;}
        public int getRoomNumber() {return roomNumber;}
        public int getDoorID(){return doorID;}
    };

    public static enum LEGEND{
        MUSTARD(16576515, 690,610),
        SCARLETT(16515918, 690,636),
        GREEN(261123, 690,663),
        PEACOCK(234748, 690,690),
        WHITE(16777212, 690,717),
        PLUM(10290172, 690,744);

        private final int color, x, y;
        LEGEND(int color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        public int getColor() {return color;}
        public int getXCoordLegend() {return x;}
        public int getYCoordLegend() {return y;}
    };

        public static final String gameRulesObjective =
                "Mr. Boddy is found dead in one of the rooms of his mansion. The players must "
                + "\r\ndetermine the answers to these three questions: Who killed him? Where? "
                + "\r\nWith what weapon?";
        public static final String gameRulesGamePlay =
                "Miss Scarlett opens the game. The turns continue clockwise around the table. "
                + "\r\nOn each turn, a player tries to reach a different room of the mansion "
                + "to \r\ninvestigate. To start your turn, move your token by rolling the die. "
                + "If you are in \r\na corner room, you can use a Secret Passage by pressing the "
                + "\"Shortcut\" button. \r\nIf you roll the die, you can move your token that many"
                + " spaces horizontally or \r\nvertically, forward or backward, but not diagonally. "
                + "You may not enter on a space \r\nthat is already occupied by another player. It "
                + "is possible that your opponents might\r\nblock any and all doors and trap you in a "
                + "room. In that case, you have to wait for \r\nsomeone to move. To end your turn, "
                + "hit the \"End Turn\" button.";
        public static final String gameRulesSuggestion =
                "When you enter a room, you can make a suggestion by naming a suspect,  \r\nmurder "
                + "weapon and the room you just entered. e.g. 'The crime was committed \r\nby Mr. Green"
                + " in the lounge with a knife.' Then your opponents (starting by the \r\nleft player) "
                + "must (if possible) prove that your suggestion is false by showing you \r\none card that "
                + "matches your suggestion. If the first player can't disprove, the next \r\nplayer must "
                + "try it, etc... until all players have passed. As soon as someone shows \r\nyou one of "
                + "the cards, it is proven that it can't be in the envelope and you can cross \r\nit off "
                + "in your notebook as a possibility. If no one is able to prove your suggestion\r\nfalse, "
                + "you may either end your turn or make an accusation.\r\nNote: the suggestion is always "
                + "made for the room your token is at that moment.";
        public static final String gameRulesAccusing =
                "If you think you have solved the crime by deduction, you can end your turn by \r\nmaking "
                + "an accusation and naming any three elements. To do so, press the \r\n\"Accuse\" button "
                + "and pick a suspect, weapon, and room where you think the murder \r\ntook place. Then, you "
                + "must look secretly at the cards in the envelope to check if \r\nyour accusation is correct. "
                + "If you are correct, the winning cards will be shown to \r\nthe rest of the players in the "
                + "game and you win the game. \r\nNote: You can only make one accusation during a game. If your "
                + "accusation is \r\nwrong, you lost and can no longer play in the game.";

}//end class
