import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/** userboard class 
The UserBoard maintains a list of all possible moves. Initially, it will be all locations on the
Board. When the computer takes a turn, it randomly selects an item from this list and
removes it from the list.*/
public class UserBoard extends Board{
   //instance variables
   private ArrayList<Move> moves=new ArrayList<>();
   private Random rand = new Random();
   /**userBoard constructor
   Passes the filename on to the Board constructor. initializes random object
   @param fileName*/
   public UserBoard(String fileName)throws IOException {
      super(fileName);
      for (int i=0; i<=9; i++) {
         for (int x=0; x<=9; x++) {
            Move move = new Move(i, x);
            moves.add(move);
         }
      }
   }
   /**makeComputerMove method
   Computer move against UserBoard. Selects and makes a move AGAINST this board.
   @return array of strings*/
   public String[] makeComputerMove(){
      final int SIZE = 2;
      String[] status= new String[SIZE];
      Move move=pickRandomMove();
      status[0] = move.toString();
      status[1] = " ";
      for (int i=0; i<=9; i++){
         if (moveAvailable(move)) {
            int row = move.row();
            int col = move.col();
            CellStatus c = layout.get(row).get(col);
            if (c == CellStatus.NOTHING) {
               layout.get(row).set(col, CellStatus.NOTHING_HIT);
               status[1] = "You missed!";
            } 
            else if (c == CellStatus.AIRCRAFT_CARRIER) {
               layout.get(row).set(col, CellStatus.AIRCRAFT_CARRIER_HIT);
               System.out.println("Hit!");
               if (getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER)) {
                  layout.get(row).set(col, CellStatus.AIRCRAFT_CARRIER_SUNK);
                  status[1] = "My Aircraft Carrier has been sunk!";
               }
            } 
            else if (c == CellStatus.BATTLESHIP) {
               layout.get(row).set(col, CellStatus.BATTLESHIP_HIT);
               System.out.println("Hit!");
               if (getFleet().updateFleet(ShipType.ST_BATTLESHIP)) {
                  layout.get(row).set(col, CellStatus.BATTLESHIP_SUNK);
                  status[1] = "My Battleship has been sunk!";
               }
            } 
            else if (c == CellStatus.CRUISER) {
               layout.get(row).set(col, CellStatus.CRUISER_HIT);
               System.out.println("Hit!");
               if (getFleet().updateFleet(ShipType.ST_CRUISER)) {
                  layout.get(row).set(col, CellStatus.CRUISER_SUNK);
                  status[1] = "My cruiser has been sunk!";
               }
            } 
            else if (c == CellStatus.DESTROYER) 
            {
               layout.get(row).set(col, CellStatus.DESTROYER_HIT);
               System.out.println("Hit!");
               if (getFleet().updateFleet(ShipType.ST_DESTROYER)) {
                  layout.get(row).set(col, CellStatus.DESTROYER_SUNK);
                  status[1] = "My destroyer has been sunk!";
               }
            } 
            else if (c == CellStatus.SUB) {
               layout.get(row).set(col, CellStatus.SUB_HIT);
               System.out.println("Hit!");
               if (getFleet().updateFleet(ShipType.ST_SUB)) {
                  layout.get(row).set(col, CellStatus.SUB_SUNK);
                  status[1] =  "You sunk my submarine!";
               }
            }
         }
      }
   return status;
   }
   /**pickRandomMove method
   makes the computer's random move
   @return Move*/
   private Move pickRandomMove() {
      int moveIndex=rand.nextInt(moves.size());
      Move move = moves.remove(moveIndex);
      return move;
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
            s += (" " + getLayout().get(i).get(j).toString().charAt(1) + " ");
         s += "\n";
      }
      return s;
   }
}