
/**
 * Write a description of class ConnectFour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ConnectFour
{
    public static void main(String[] args) {
    System.out.print("\u000C");
    ConnectFourObject theGameBoard = new ConnectFourObject();   // Create a new object to hold the solution grid
                
    Scanner myScanner = new Scanner(System.in);
    
    boolean gameOver = false;
    
    do 
        {        
            theGameBoard.PrintGrid();
            System.out.println("Player 1: Choose a column to drop a coin in.");
            int column = myScanner.nextInt();
            
            if (theGameBoard.HasFourInARow(column, 1)){
                System.out.println("Player 1: You won! \uD83D\uDE42");
                gameOver = true;
            }
            
            theGameBoard.PrintGrid();
            
            if (gameOver == false)
            {
                System.out.println("Player 2: Choose a column to drop a coin in.");
                column = myScanner.nextInt();
           
                if (theGameBoard.HasFourInARow(column, 2)){
                    System.out.println("Player 2: You won! \uD83D\uDE42");
                    gameOver = true;
                }
                theGameBoard.PrintGrid();
            }
        }
        while (gameOver == false);
   }
}
