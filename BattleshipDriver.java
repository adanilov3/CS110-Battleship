import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
/** Battleship Driver
creates the game, decides who goes first, plays the game, decides who won*/
public class BattleshipDriver{

   public static void main(String [] args) throws IOException{
      System.out.println("Let's play Battleship!");
      
      //intialize
      Game game = new Game();
      Random rand = new Random();
      Scanner keyboard = new Scanner(System.in);
      boolean computerTurn = false;
      boolean playerTurn = false;
      
      //determine who is going first
      System.out.println("Tossing coin...");
      int coinToss = rand.nextInt(2);
      if (coinToss==1){
         playerTurn = true;
         System.out.println("Player won the coin toss! You go first.");
         System.out.print("Press any key to continue");
         System.in.read();
      }
      else {
         computerTurn = true;
         System.out.println("The computer won the coin toss! Computer goes first.");
      }
      
      //play game
      do {
         if (playerTurn){
            //get move from user
            System.out.println("Your move? ");
            String strMove = keyboard.next().toUpperCase();
            //create new move, pass input to it
            Move move = new Move(strMove);
            //change play
            computerTurn=true;
            playerTurn=false;
         }
         if (computerTurn){
            //create new move
            String[] computerMove = game.makeComputerMove();
            System.out.println("Computer's move: " + computerMove[0]);
            //change play
            playerTurn = true;
            computerTurn = false;
         }
         System.out.print(game.toString());
      } while (game.computerDefeated() == false && game.userDefeated() == false);
      
      
      //finish the gamee
      System.out.println("The game is over.");
      if (game.userDefeated()){
         System.out.println("Your loss, go get em next time!");
      }
      if (game.computerDefeated()){
         System.out.println("You won! Congratulations!");
      }
   }
}
         