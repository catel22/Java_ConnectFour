import java.util.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class RunConnectFour
{
   
   /**
   * Runs the program using defined methods
   *
   * @param args unused parameters
   */
   public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
      boolean playing = true;
      ConnectFour connect = getNames(console);
      DrawingPanel panel = new DrawingPanel(700,600);
      while (playing) {
         panel = new DrawingPanel(700, 600);
         int i = 0;
         while (connect.checkWin() == null) {
            System.out.println(connect.currentPlayer().getName() + "'s turn:");
            playTurn(console, connect, panel);
         }
         connect.checkWin().addWin();
         System.out.println("");
         System.out.println("The winner is " + connect.checkWin().toString() + "!!!");
         System.out.println("");
         connect.addGame();
         connect.showStats();
         playing = connect.checkPlayAgain(console);
      }
      panel.exit();
   }
      
   /**
   * Gets player names from the users
   *
   * @param Scanner console to get information from the user
   */
   public static ConnectFour getNames(Scanner console) {
      String nameOne = MyUtils.getText(console, "Player 1 name? ");
      String nameTwo = MyUtils.getText(console, "Player 2 name? ");
      while (nameOne.equals(nameTwo)) {
         nameTwo = MyUtils.getText(console, "Invalid. Players cannot have same name in order to differentiate winner. Player 2 name? ");
      }
      return new ConnectFour(nameOne, nameTwo);
   }
   
   /**
   * Executes a turn in the game using defined methods
   *
   * @param Scanner console to get information from the user
   * @param ConnectFour connect object to play pieces
   * @param DrawingPanel panel so ConnectFour class can draw the board
   */
   public static void playTurn(Scanner console, ConnectFour connect, DrawingPanel panel)
   {
      boolean waiting = true;
      boolean piecePlayed = false;
      int row = 0;
      int column = 0;
      MouseListener listener = new MouseListener(panel, connect);
      panel.addMouseListener(listener);
      connect.drawPiece(panel);
      while (!piecePlayed) {
         //Wait for a mouseclick
         while (!connect.getClick()) {
            System.out.print("");
         }
         column = connect.getY();
         row = connect.getX();
         piecePlayed = connect.playPiece(row, column);
      }
      connect.setClick(false);
      connect.drawPiece(panel);
   }
     
   /**
   * A class for responding to mouse clicks on the drawing panel.
   */
   public static class MouseListener extends MouseInputAdapter 
   {
      private DrawingPanel panel;
      
      private ConnectFour connect;
      
      /**
      * Constructor for MouseListener class
      */
      public MouseListener(DrawingPanel panel, ConnectFour connect) 
      {
         this.panel = panel;
         this.connect = connect;
      }
      
      /**
      * Method that executes when a mouse click occurs
      *
      * @param MouseEvent the mouse click event that occured
      */
      public void mousePressed(MouseEvent event) 
      {
         int x = event.getX() / panel.getZoom();
         int y = event.getY() / panel.getZoom();
         connect.setCoord(x, y);
      }
   } 

}