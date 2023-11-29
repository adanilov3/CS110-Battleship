/**Move Class. Creates a move object
*/
public class Move{
   //instance variables 
   private int row;
   private int col;
   /** Move constructor takes in the ints for column and row and creates move object 
   @param r row number
   @param c column number*/
   public Move(int c, int r ){
      this.row=r;
      this.col=c;
   }
   /** Move constructor with string parameter creates string object 
   move consisting of a letter and a number 
   @param m move from driver but makes it a string*/
   public Move(String m){ // if statements instead of an array
      char x;
      x = m.charAt(0);
      if (x=='A'){
         this.row=0;
      }
      else if (x=='B'){
         this.row=1;
      }
      else if (x=='C'){
         this.row=2;
      }
      else if (x=='D'){
         this.row=3;
      }
      else if(x=='F'){
         this.row=4;
      }
      else if (m.length()==2){
         this.col=(int)m.charAt(1)-49;
      }
      else if (m.length() == 3) {
         String m1 = m.substring(1);
         this.col= Integer.parseInt(m1)-1;
      }
   }
   /** method row
   accesses the int row in move object
   @return row*/
   public int row(){
      return row;
   }
   /** method col
   accesses the int row in move object
   @return int col*/
   public int col(){
      return col;
   }
   /** toString Method 
   @return String*/
   public String toString(){
      return String.format("%s%s",row,(col+1));
   }
}