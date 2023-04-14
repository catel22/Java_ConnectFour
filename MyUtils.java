import java.util.*;
import java.io.*;

//functions that are reusable across assignments

public class MyUtils
{
   
   /**
   * Gets user input and returns it as a valid number for the prompt
   *
   * @param Scanner console the scanner used to get input from the user
   * @param String prompt the question to ask the user
   * @param int min the minimum number valid as user input
   * @param int max the maximum number valid as user input
   * @return returns the user input as an integer
   */
   public static int getNumber(Scanner console, String prompt, int min, int max)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            int number = console.nextInt();
            console.nextLine();
            if (number < min||number > max)
            {
                System.out.println("Your number needs to be between " + min + " and " + max + ".");
            }
            else
            {
                return number;
            }
         }
         catch (Exception e)
         {
            System.out.println("You must enter an *integer* between " + min + " and " + max + ".");
            console.nextLine();
         }        
      }
   }
   
   /**
   * Creates a scanner for a valid file inputed by a user
   *
   * @param Scanner console the scanner used to get input from the user
   * @param String prompt the question to ask the user
   * @return returns the fileScanner for the input file
   */
   public static Scanner getInputScanner(Scanner console, String prompt) {
      System.out.print(prompt);
      String input = console.nextLine();
      //Prompts user until the file name is valid
      while (true)
      {
         try
         {
            File f = new File(input);
            Scanner fileScanner = new Scanner(f);
            return fileScanner;
         }
         catch (Exception e)
         {
            System.out.print("File not found. Try again: ");
            input = console.nextLine();
         }  
      }      
   }
   
   /**
   * Creates a PrintSteam to write an output file
   *
   * @param Scanner console the scanner used to get input from the user
   * @return returns the PrintStream for the output file
   */
   public static PrintStream getPrintStream(Scanner console) {
      System.out.print("Output file name? ");
      String input = console.nextLine();
      try
      {
         PrintStream ps = new PrintStream(new File(input));
         return ps;
      }
      catch (Exception e)
      {
         return null;
      }
   }
   
   /**
   * Gets user input and returns it as a valid text response
   *
   * @param Scanner console the scanner used to get input from the user
   * @param String prompt the question to ask the user
   * @return returns the user input as a String
   */
   public static String getText(Scanner console, String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         String input = console.nextLine();
         if (input.equals(null)||input.equals(""))
         {
            System.out.println("Input is not valid, you need to enter some text");
         }
         else
         {
            return input;
         }
      }
   }
   
   /**
   * Gets user input and returns it as a valid character response
   *
   * @param Scanner console the scanner used to get input from the user
   * @param String prompt the question to ask the user
   * @return returns the user input as a char
   */
   public static char getChar(Scanner console, String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         String in = console.nextLine();
         char input = in.charAt(0);
         if (input == ' ')
         {
            System.out.println("Input is not valid, you need to enter a character");
         }
         else
         {
            return input;
         }
      }
   }
}