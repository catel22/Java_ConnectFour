import java.util.*;
import java.awt.*;

public class Player
{
   /**
   * String name of player
   */
   private String playerName;
   
   /**
   * Color of player's game playing piece
   */
   private Color pieceColor;
   
   /**
   * Number of moves the player has taken
   */
   private int moves;
   
   /**
   * Number of games the player has won
   */
   private int gamesWon;
   
   /**
   * Constructor for player
   *
   * @param String name the name of the player
   * @param Color the color of the player's playing piece
   */
   public Player(String name, Color color) {
      this.playerName = name;
      this.pieceColor = color;
   }
   
   /**
   * Default constructor for Player class
   */
   public Player(){}
   
   /**
   * Adding to the number of moves
   */
   public void addMove()
   {
      this.moves += 1;
   }
   
   /**
   * Returns the number of moves
   *
   * @return int number of moves
   */
   public int getMoves() {
      return this.moves;
   }
   
   /**
   * Adding to the number of games won
   */
   public void addWin()
   {
      this.gamesWon += 1;
   }
   
   /**
   * Returns the number of moves
   *
   * @return int number of moves
   */
   public int getWins() {
      return this.gamesWon;
   }
   
   /**
   * Setter for the name of the player
   *
   * @param String playerName the name of the player
   */
   public void setName(String playerName)
   {
      this.playerName = playerName;
   }
   
   /**
   * Gets the name of the player
   *
   * @return String name the name of the player
   */
   public String getName() {
      return this.playerName;
   }
   
   /**
   * Gets the color of the player's piece
   *
   * @return Color the color of the piece
   */
   public Color getColor() {
      return this.pieceColor;
   }
   
   /**
   * Returns the player's information in string format
   *
   * @return String with player information
   */
   public String toString()
   {
      String colorPrint = "";
      if (this.pieceColor == Color.BLUE) {
         colorPrint = "Blue";
      }
      else {
         colorPrint = "Red";
      }
      return ("Name: " + this.playerName + "\n Color: " + colorPrint);
   }
   
   /**
   * Checks if two players are equal to each other
   *
   * @return boolean whether two players are equal
   */
   public boolean equals(Object other)
   {
      if (other instanceof Player)
      {
         Player otherPlayer = (Player)other;
         return this.playerName == otherPlayer.playerName && this.pieceColor == otherPlayer.pieceColor;
      }
      else
      {
         return false;
      }
   }
}
   
   