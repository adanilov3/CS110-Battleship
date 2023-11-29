import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/** game class
creates the game for the driver*/
public class Game{
   private ComputerBoard computer;
   private UserBoard player;
   
   /**game constructor
   Creates the two boards*/
   public Game() throws IOException {
      computer = new ComputerBoard("compFleet.txt");
      player = new UserBoard("userFleet.txt");
   }
   
   /**makeComputerMove method
   returns an array of two strings*/
   public String [] makeComputerMove(){
      return player.makeComputerMove();
   }
   /**makePlayermove method
   makes the move against the computer*/
   public String makePlayerMove(Move m){
      return computer.makePlayerMove(m);
   }
   /**userDefeated method
   checks if all ships have been sunk
   @return boolean true or false if won or loss*/
   public boolean userDefeated(){
      boolean defeat = player.gameOver();
      if (defeat == true){
         return true;
      }
      else {
         return false;
      }
   }
   /**computerDefeated method
   @returns boolean whether computer has won or not
   checks if all ships have been sunk*/
   public boolean computerDefeated(){
      boolean defeat = computer.gameOver();
      if (defeat == true){
         return true;
      }
      else {
         return false;
      }
   }
   /** tostring method
   returns the battleship boards*/
   @Override
   public String toString(){
      return String.format("COMPUTER" + "\n" + computer.toString()+ "\n" + "PLAYER" + "\n" + player.toString());
   }
}