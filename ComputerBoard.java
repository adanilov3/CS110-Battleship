import java.io.IOException;
public class ComputerBoard extends Board {
   /**computerBoard constructor creates board object from super class
   @param fileName */
   public ComputerBoard(String fileName) throws IOException {
      super(fileName);
   }

   /**makePlayerMove method - move against computer
   @param move
   @return String*/
   public String makePlayerMove(Move move) {
      int row = move.row();
      int col = move.col();
      if (moveAvailable(move)) {
         CellStatus c = applyMoveToLayout(move);
         if (c == CellStatus.NOTHING) {
            layout.get(row).set(col, CellStatus.NOTHING_HIT);
            System.out.println("Miss!");
         }
         else if (c == CellStatus.AIRCRAFT_CARRIER) {
            layout.get(row).set(col, CellStatus.AIRCRAFT_CARRIER_HIT);
            System.out.println("Hit!");
            if (getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER)) {
               for(int i=0; i<9; i++){
                  for(int x=0; x<9; x++){
                     CellStatus z = layout.get(i).get(x);
                     if (z == CellStatus.AIRCRAFT_CARRIER_HIT){
                        z = CellStatus.AIRCRAFT_CARRIER_SUNK;
                        layout.get(i).set(x,z);
                     }
                  }
               }
            layout.get(row).set(col, CellStatus.AIRCRAFT_CARRIER_SUNK);
            System.out.println("My Aircraft Carrier has been sunk!");
            }
         }
         else if (c == CellStatus.BATTLESHIP) {
            layout.get(row).set(col, CellStatus.BATTLESHIP_HIT);
            System.out.println("Hit!");
            if (getFleet().updateFleet(ShipType.ST_BATTLESHIP)) {
               for(int i=0; i<9; i++){
                  for(int x=0; x<9; x++){
                     CellStatus z = layout.get(i).get(x);
                     if (z == CellStatus.BATTLESHIP_HIT){
                        z = CellStatus.BATTLESHIP_SUNK;
                        layout.get(i).set(x,z);
                     }
                  }
               }
            layout.get(row).set(col, CellStatus.BATTLESHIP_SUNK);
            System.out.println("My Battleship has been sunk!");
            }
         }
         else if (c == CellStatus.CRUISER) {
            layout.get(row).set(col, CellStatus.CRUISER_HIT);
            System.out.println("Hit!");
            if (getFleet().updateFleet(ShipType.ST_CRUISER)) {
               for(int i=0; i<9; i++) {
                  for(int x=0; x<9; x++){
                     CellStatus z = layout.get(i).get(x);
                     if (z==CellStatus.CRUISER_HIT){
                        z = CellStatus.CRUISER_SUNK;
                        layout.get(i).set(x,z);
                     }
                  }
               }
            layout.get(row).set(col, CellStatus.CRUISER_SUNK);
            System.out.println("My Cruiser has been sunk!");
            }
         } 
         else if (c == CellStatus.DESTROYER) {
            layout.get(row).set(col, CellStatus.DESTROYER_HIT);
            System.out.println("Hit!");
            if (getFleet().updateFleet(ShipType.ST_DESTROYER)) {
               for(int i=0; i<9; i++) {
                  for(int x=0; x<9; x++){
                     CellStatus z = layout.get(i).get(x);
                     if (z==CellStatus.DESTROYER_HIT){
                        z = CellStatus.DESTROYER_SUNK;
                        layout.get(i).set(x,z);
                     }
                  }
               }
            layout.get(row).set(col, CellStatus.DESTROYER_SUNK);
            System.out.println("My Destroyer has been sunk!");
            }         
         } 
         else if (c == CellStatus.SUB) {
            layout.get(row).set(col, CellStatus.SUB_HIT);
            System.out.println("Hit!");
            if (getFleet().updateFleet(ShipType.ST_SUB)) {
               for(int i=0; i<9; i++) {
                  for(int x=0; x<9; x++){
                     CellStatus z = layout.get(i).get(x);
                     if (z==CellStatus.SUB_HIT){
                        z = CellStatus.SUB_SUNK;
                        layout.get(i).set(x,z);
                     }
                  }
               }
            layout.get(row).set(col, CellStatus.SUB_SUNK);
            System.out.println("My Submarine has been sunk!");
            }         
         }
      }
      String result = " "; //string that will be returned with the method
      if (gameOver()==true){
         result = "The game is over!";
      }
      return result;
   }
   /**toString method
   @return String*/
   public String toString() {
      String s = "   ";
      for(int i=1; i<=10; i++)
         s += (" " + i + " ");
      s += "\n";
      for (int i=0; i<10; i++){
         s += (" " + (char)(i+65) + " ");
         for(int j=0; j<10; j++)
            s += (" " + getLayout().get(i).get(j).toString().charAt(0) + " ");
         s += "\n";
      }
      return s;
   }
}


