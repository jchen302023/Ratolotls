import java.io.*;
import java.util.*;


public class Map{

  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int height, width; // height, width of maze
  private int initRow, initColumn;
  private char originalTile;
  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
   final private char PLAYER =           '@';
   final private char GRASS =           '#';
   final private char EXIT =           '$';
   final private char DIRT =           ' ';
   final private char WALLVert =           '|';
   final private char WALLHor =         '_';
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


   public Map( File inputFile )
   {
     // init 2D array to represent maze
     // (80x25 is default terminal window size)
     _maze = new char[200][100];
     height = 0;
     width = 0;
     initRow = 5;
     initColumn = 5;
     //transcribe maze from file into memory
     try {
       Scanner sc = new Scanner( inputFile );

       System.out.println( "reading in file..." );

       int row = 0;

       while( sc.hasNextLine() ) {

         String line = sc.nextLine();

         if ( width < line.length() )
           width = line.length();

         for( int i=0; i<line.length(); i++ )
           _maze[i][row] = line.charAt( i );

         height++;
         row++;

       }

       for( int i=0; i<width; i++ )
       _maze[i][row] = WALLHor;
       height++;
       row++;

     } catch( Exception e ) { System.out.println( "Error reading file" ); }

   }//end constructor



   public String toString()
   {
     //send ANSI code "ESC[0;0H" to place cursor in upper left
     String retStr = "[0;0H";
     //emacs shortcut: C-q, ESC
     //emacs shortcut: M-x quoted-insert, ESC
//System.out.println("Why ");
     int i, j;
     for( i=0; i<height; i++ ) {
       for( j=0; j<width; j++ )
         retStr = retStr + _maze[j][i];
       retStr = retStr + "\n";
     }
     return retStr;
   }

//ret true if successful
   public boolean placePlayer(int row, int columns) {
     System.out.println("placing");
     if(Character.compare(this._maze[row][columns], '|') != 0){
       if(Character.compare(this._maze[row][columns], '_') != 0){
         if(Character.compare(this._maze[row][columns], '$') != 0){
           
            this._maze[row][columns] = '@';
            return true;
         }       
       }              
   }
   return false;
   
 }
 
 
// ACCESSORS
   public int getInitRow(){
     return this.initRow;
   }

   public int getInitCol(){
     return this.initColumn;
   }

   public int getPrev(){
     return this.originalTile;
   }


   public char playerMove() {
     
    originalTile = this._maze[initRow][initColumn]; 
    char originalTileUp = this._maze[initRow][initColumn - 1]; 
    char originalTileLeft = this._maze[initRow - 1][initColumn]; 
    char originalTileDown = this._maze[initRow][initColumn + 1]; 
    char originalTileRight = this._maze[initRow + 1][initColumn]; 
    
    Scanner userIn = new Scanner(System.in);  // Create a Scanner object
    System.out.println(initRow);
    System.out.println(initColumn);
   System.out.println(originalTile); 

    char moveKey = userIn.nextLine().charAt(0);

    System.out.println(moveKey);

    
     int compareW = Character.compare(moveKey, 'w');
    if (compareW == 0) {
      this._maze[initRow][initColumn]= originalTileUp; 
      if(this.placePlayer(initRow , initColumn - 1 )){
          initColumn -= 1; 
      } 
    }  

    int compareA = Character.compare(moveKey, 'a');
   if (compareA == 0) {
    this._maze[initRow][initColumn]= originalTileLeft;
     if(this.placePlayer(initRow - 1, initColumn )){
        initRow -= 1;
     }
   } 
   
   int compareS = Character.compare(moveKey, 's');
  if (compareS == 0) {
    this._maze[initRow][initColumn]= originalTileDown;
    if(this.placePlayer(initRow, initColumn + 1)){
      initColumn += 1; 
    }

  } 
  
  int compareD = Character.compare(moveKey, 'd');
 if (compareD == 0) {
   this._maze[initRow][initColumn]= originalTileRight;
   if(this.placePlayer(initRow + 1, initColumn)){
      initRow +=1; 
   }
 } 
 
return moveKey;
  
   }

   public static void main(String[] args){
  

     File text = new File("map1.map");


     Map mappy = new Map(text);
     System.out.println( "[2J" );
     System.out.println(mappy);
    

   while (true) {
     // mappy.originalTile = mappy._maze[mappy.initRow][mappy.initColumn];
     mappy.playerMove();
     System.out.println( "[2J" );
     System.out.println(mappy);
   } 
   
  }

}
