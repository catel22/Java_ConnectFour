import java.util.*;
import java.awt.*;

public class ConnectFour
{
   /**
   * Array board to store players and their moves
   */
   private Player[][] board;
   
   /**
   * Players for game
   */
   private Player playerOne;
   private Player playerTwo;
   
   /**
   * Player whose turn it is
   */
   private Player currentPlayer;
   
   /**
   * Variable to keep track of the number of games played
   */
   private int gamesPlayed;
   
   
   /**
   * Variables for the coordinates of a user click and whether they have clicked
   */
   private int xCoord;
   private int yCoord;
   private boolean clicked;
   
   /**
   * Constructor for ConnectFour
   *
   * @param String name the name of player 1
   * @param String name the name of player 2
   */
   public ConnectFour(String name1, String name2) {
      playerOne = new Player(name1, Color.BLUE);
      playerTwo = new Player(name2, Color.RED);
      currentPlayer = playerOne;
      board = new Player[6][7];
      for (int j = 0; j < board.length; j++){
			for (int k = 0; k < board[0].length; k++){
				board[j][k] = new Player();
			}
		}
   }
   
    /**
   * Plays player piece in board
   *
   * @param int column in which to play piece
   * @param int column in which to play piece
   * @return boolean whether the piece was successfully played
   */
   public boolean playPiece(int x, int y) {
      int row = -1;
      int column = -1;
      column = x/100;
      
      if (column >= board[0].length || column < 0) {
         return false;
      }
      
      for (int i = 0; i < board.length; i++) {
         if (!board[i][column].equals(playerOne)&&!board[i][column].equals(playerTwo)) {
            row = i;
         }
      }
      
      if (row >= board.length || row < 0) {
         return false;
      }
      
      
      if (!board[row][column].equals(playerOne)&&!board[row][column].equals(playerTwo)) {
         
         board[row][column] = currentPlayer;
         currentPlayer.addMove();
         if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
         }
         else {
            currentPlayer = playerOne;
         }
         return true;
      }
      return false;
   }
   
   /**
   * Gets the current player
   *
   * @return Player the current player
   */
   public Player currentPlayer() {
      return this.currentPlayer;
   }
   
   /**
   * Adds to the count of games played
   */
   public void addGame() {
      this.gamesPlayed += 1;
   }
   
   /**
   * Checks if a player has won by getting four in a row
   *
   * @return boolean a player has won
   */
   public Player checkWin() {
      Player player = playerOne;
      for (int i = 0; i < 2; i++) {
         // Check for four in a row horizontally
         for(int row = 0; row<board.length; row++){
      		for (int col = 0;col < board[0].length - 3;col++){
      			if (board[row][col] == player   && 
   					board[row][col+1] == player &&
   					board[row][col+2] == player &&
   					board[row][col+3] == player){
   					return player;
   				}
   			}			
   		}
         
      	// Check for four in a row vertically
      	for(int row = 0; row < board.length - 3; row++){
      		for(int col = 0; col < board[0].length; col++){
      			if (board[row][col] == player   && 
   					board[row+1][col] == player &&
   					board[row+2][col] == player &&
   					board[row+3][col] == player){
   					return player;
   				}
   			}
   		}
      	
         // Check for four in a row diagonally up
   		for(int row = 3; row < board.length; row++){
   			for(int col = 0; col < board[0].length - 3; col++){
   				if (board[row][col] == player   && 
   					board[row-1][col+1] == player &&
   					board[row-2][col+2] == player &&
   					board[row-3][col+3] == player){
   					return player;
   				}
   			}
   		}
         
   		// Check for four in a row diagonally down
   		for(int row = 0; row < board.length - 3; row++){
   			for(int col = 0; col < board[0].length - 3; col++){
   				if (board[row][col] == player   && 
   					board[row+1][col+1] == player &&
   					board[row+2][col+2] == player &&
   					board[row+3][col+3] == player){
   					return player;
   				}
   			}
   		}
         player = playerTwo;
      }
   	return null;
   }
   
   /**
   * Draws the board and pieces
   *
   * @param DrawingPanel to draw the board
   */
   public void drawPiece(DrawingPanel panel) {
      panel.setBackground(Color.WHITE);
      Graphics g = panel.getGraphics();
      //7 rows and 6 columns
      for (int row = 0; row < board.length; row++) {
         for (int col = 0; col < board[0].length; col++) {
            //Use 25 so the circles are correctly positioned on the board
            g.setColor(Color.BLACK);
            g.fillOval(col*100 + 25, row*100 + 25, 60, 60);
            if (board[row][col].equals(playerOne) || board[row][col].equals(playerTwo)) {
               g.setColor(board[row][col].getColor());
               g.fillOval(col*100 + 25, row*100 + 25, 60, 60);
            }
         }
      }
   }
   
   /**
   * Checks if the user wants to play again
   *
   * @param Scanner console to get user input
   */
   public boolean checkPlayAgain(Scanner console) {
      String input = MyUtils.getText(console, "Would you like to play again? (Yes or No) ");
      if (input.equals("Yes")||input.equals("yes")) {
         board = new Player[6][7];
         for (int j = 0; j < board.length; j++){
   			for (int k = 0; k < board[0].length; k++){
   				board[j][k] = new Player();
			   }
         }
         return true;
		}
      else {
         return false;
      }
   }
   
   /**
   * Prints game stats to the console
   */
   public void showStats() {
      System.out.println("Stats:");
      System.out.println("Games Played: " + this.gamesPlayed);
      System.out.println(playerOne.getName() + ": Wins - " + playerOne.getWins() + " Total moves - " + playerOne.getMoves());
      System.out.println(playerTwo.getName() + ": Wins - " + playerTwo.getWins() + " Total moves - " + playerTwo.getMoves());
      
   }
   
   /**
   * Setter for the variables storing the coordinates of a click
   *
   * @param int x the x-coordinate of the click
   * @param int y the y-coordinate of the click
   */
   public void setCoord(int x, int y) {
      this.xCoord = x;
      this.yCoord = y;
      this.clicked = true;
   }
   
   /**
   * Setter for the boolean clicked variable
   *
   * @param boolean clickedIn whether the user has clicked a location
   */
   public void setClick(boolean clickedIn) {
      this.clicked = clickedIn;
   }
   
   /**
   * Getter for the status of a mouse click
   */
   public boolean getClick() {
      return this.clicked;
   }

   /**
   * Getter for the x-coordinate of a mouse click
   */
   public int getX() {
      return this.xCoord;
   }
   
   /**
   * Getter for the y-coordinate of a mouse click
   */
   public int getY() {
      return this.yCoord;
   }
}