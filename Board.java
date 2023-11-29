import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**Board class creates an array of cells */
public class Board{

   private Fleet fleet = new Fleet();
   public int SIZE = 10;
   ArrayList<ArrayList<CellStatus>> layout = new ArrayList<ArrayList<CellStatus>>();
   
   /** board constructor 
   * @param fileName from input file*/ 
   public Board(String fileName) throws IOException {
      Scanner fleetFile = new Scanner(new File(fileName));
      for (int i = 0; i <= 9; i++) {
         ArrayList<CellStatus> addRow = new ArrayList<>(SIZE);
         for (int x = 0; x <= 9; x++) {
            addRow.add(CellStatus.NOTHING);
         }
         layout.add(addRow);
      }
      while(fleetFile.hasNext()){
         String line=fleetFile.nextLine();
         String [] data=line.split(" ");
         String shipType=data[0];
         Move start=new Move (data[1]);
         Move end=new Move (data[2]);
         if (shipType.equals("A")) {
            if (start.row() == end.row()) {
               for (int c = start.col(); c <= end.col(); c++) {
                  layout.get(start.row()).set(c, CellStatus.AIRCRAFT_CARRIER);
               }
            }
            else {
               for (int r = start.row(); r <= end.row(); r++) {
                  layout.get(r).set(start.col(), CellStatus.AIRCRAFT_CARRIER);
               }
            }
         }
         else if (shipType.equals("B")){
            if (start.row()==end.row()){
               for (int c=start.col(); c<=end.col(); c++){
                  layout.get(start.row()).set(c,CellStatus.BATTLESHIP);
               }
            }
            else{
               for (int r=start.row(); r<=end.row(); r++){
                  layout.get(r).set(start.col(),CellStatus.BATTLESHIP);
               }
            }
         }
         else if (shipType.equals("C")){
            if (start.row()==end.row()){
               for (int c=start.col(); c<=end.col(); c++){
                  layout.get(start.row()).set(c,CellStatus.CRUISER);
               }
            }
            else{
               for (int r=start.row(); r<=end.row(); r++){
                  layout.get(r).set(start.col(),CellStatus.CRUISER);
               }
            }
         }
         else if (shipType.equals("D")){
            if (start.row()==end.row()){
               for (int c=start.col(); c<=end.col(); c++){
                  layout.get(start.row()).set(c,CellStatus.DESTROYER);
               }
            }
            else{
                  for (int r=start.row(); r<=end.row(); r++){
                     layout.get(r).set(start.col(),CellStatus.DESTROYER);
                  }
            }
         }
         else if (shipType.equals("S")){
            if (start.row()==end.row()){
               for (int c=start.col(); c<=end.col(); c++){
                  layout.get(start.row()).set(c,CellStatus.SUB);
               }
            }
            else{
               for (int r=start.row(); r<=end.row(); r++){
                  layout.get(r).set(start.col(),CellStatus.SUB);
               }
            }
         }
      }
      fleetFile.close();
   }
   /**applyMoveToLayout method
   Applies a move to the layout
   @param move*/
   public CellStatus applyMoveToLayout(Move move) {
      int row = move.row();
      int col = move.col();
      CellStatus cs = layout.get(row).get(col);
      if (cs == CellStatus.NOTHING){
         layout.get(row).set(col, CellStatus.NOTHING_HIT);
      }
      else if (cs == CellStatus.AIRCRAFT_CARRIER){
         layout.get(row).set(col, CellStatus.AIRCRAFT_CARRIER_HIT);
      }
      else if (cs == CellStatus.BATTLESHIP){
         layout.get(row).set(col, CellStatus.BATTLESHIP_HIT);
      }
      else if (cs == CellStatus.CRUISER){
         layout.get(row).set(col, CellStatus.CRUISER_HIT);
      }
      else if (cs == CellStatus.DESTROYER){
         layout.get(row).set(col, CellStatus.DESTROYER_HIT);
      }
      else if (cs == CellStatus.SUB){
         layout.get(row).set(col, CellStatus.SUB_HIT);
      }
      CellStatus cs1 = cs;
      return cs1;
   }
   /**moveAvailable method
   Takes a move as a parameter and determines if the spot is available
   @param move m*/
   public boolean moveAvailable(Move m){
      int row=m.row();
      int col=m.col();
      CellStatus cs =layout.get(row).get(col);
      if (cs == CellStatus.NOTHING){
         return true;
      }
      else if (cs == CellStatus.BATTLESHIP){
         return true;
      }
      else if (cs == CellStatus.AIRCRAFT_CARRIER){
         return true;
      }
      else if (cs == CellStatus.CRUISER){
         return true;
      }
      else if(cs == CellStatus.DESTROYER){
         return true;
      }
      else if(cs == CellStatus.SUB){
         return true;
      }
      else {
         return false;
      }
   }
   /**getLayout method
   @return layout- reference to layout*/
   public ArrayList<ArrayList<CellStatus>> getLayout() {
      return layout;
   }
   /** getFleet method
   @return fleet- reference to fleet object*/
   public Fleet getFleet(){
      return fleet;
   }          
   /**GameOver method
   returns true if all ships have been sunk
   @return boolean*/
   public boolean gameOver(){
      if (fleet.gameOver()==true){
         return true; }
      else {
         return false;
      }
   }
}






