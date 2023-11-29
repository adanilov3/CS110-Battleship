/** Fleet class initalizes ship fields for all types of ships 
*/
public class Fleet{
   //instance variables of ships
   private Ship battleShip;
   private Ship aircraftCarrier;
   private Ship destroyer; 
   private Ship sub;
   private Ship cruiser;
   
   /** Fleet constructor intializes ship fields*/ 
   public Fleet(){
      aircraftCarrier=new AircraftCarrier();
      battleShip= new Battleship(); 
      cruiser=new Cruiser();
      destroyer=new Destroyer();
      sub=new Sub();
   }
   /** updateFleet informs the apporpriate ship that it has been hit. 
   * @param ShipType
   * @return boolean if ship has sank or not */ 
   public boolean updateFleet(ShipType s){
      //if statements per every ship
      if (s==ShipType.ST_BATTLESHIP){
         return battleShip.hit();
      }
      if (s==ShipType.ST_AIRCRAFT_CARRIER){
         return aircraftCarrier.hit();
      }
      if (s==ShipType.ST_CRUISER){
         return cruiser.hit();
      }
      if (s==ShipType.ST_DESTROYER){
         return destroyer.hit();
      }
      if (s==ShipType.ST_SUB){
         return sub.hit();
      }
      //return false if ship has not been hit
      return false;
   }
   /** gameOver method that returns true if all ships have been sunk and false otherwise
   * @return boolean gameover */ 
   public boolean gameOver(){
      if (battleShip.getSunk() && aircraftCarrier.getSunk() && cruiser.getSunk() && destroyer.getSunk() && sub.getSunk()){
         return true;
      }
      else {
         return false;
      }
   }
}