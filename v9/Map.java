import java.io.*;
import java.util.*;


public class Map{


//	Player protag;

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
   final private char TREEr =           ')';
   final private char TREEl =            '(';
   final private char SLANT1 =           '\\';
   final private char SLANT2 =           '/';
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_YELLOW = "\u001B[33m";
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_RED = "\u001B[31m";


   public Map( File inputFile )
   {
  //   protag = new Player("filler", 50);
     // init 2D array to represent maze
     // (80x25 is default terminal window size)
     _maze = new char[10000][10000];
     height = 0;
     width = 0;
     initRow = 15;
     initColumn = 8;
     originalTile = 'S';
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
       for( j=0; j<width; j++ ){
         if(Character.compare(_maze[j][i], '#')==0){
           retStr = retStr + ANSI_GREEN + _maze[j][i] + ANSI_RESET;
         }else if(Character.compare(_maze[j][i],'@') == 0){
           retStr = retStr + ANSI_RED + _maze[j][i] + ANSI_RESET;
         } else{

             retStr = retStr + _maze[j][i];
         }

       }

       retStr = retStr + "\n";
     }
     return retStr;
   }

//ret true if successful
   public boolean placePlayer(int row, int columns) {

               // if(Character.compare(this._maze[row][columns], '#') == 0) {
               //   int randomInt = (int) Math.random() * 5;
               //   System.out.println(randomInt);
               //   // if (randomInt==3) {
               //   //
               //   //   randomInt = (int) Math.random() * 3;
               //   //   if(randomInt==0){
               //     Pomenon wild = new Trilantro();
               //     Game woo = new Game();
               //     woo.individualBattle(woo.protag, wild );
               //   // }
               //   //}
               // }

     System.out.println("placing");
     if(Character.compare(this._maze[row][columns], '|') != 0){
       if(Character.compare(this._maze[row][columns], '_') != 0){
         //if(Character.compare(this._maze[row][columns], '$') != 0){
           if(Character.compare(this._maze[row][columns], '(') != 0){
           if(Character.compare(this._maze[row][columns], ')') != 0){
           if(Character.compare(this._maze[row][columns], '/') != 0){
             if(Character.compare(this._maze[row][columns], '\\') != 0){

           this._maze[initRow][initColumn]= originalTile;
             originalTile = this._maze[row][columns];
          // this.initRow = row;
           //this.initColumn = columns;

            this._maze[row][columns] = '@';
            return true;



         }
      // }
     }
   }
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

   public char getPrev(){
     return this.originalTile;
   }

   

   public char playerMove() {

     //char originalTileUp = this._maze[initRow][initColumn - 1];
    // char originalTileLeft = this._maze[initRow - 1][initColumn];
    // char originalTileDown = this._maze[initRow][initColumn + 1];
    // char originalTileRight = this._maze[initRow + 1][initColumn];

    Scanner userIn = new Scanner(System.in);  // Create a Scanner object
   //  System.out.println(initRow);
   //  System.out.println(initColumn);
   // System.out.println(originalTile);
   char moveKey = ' ';
   while(true){
     try{
        boolean shouldBreak = false;
        moveKey = userIn.nextLine().charAt(0);

        System.out.println(moveKey);

        int compareW = Character.compare(moveKey, 'w');

       if (compareW == 0) {
       //  this._maze[initRow][initColumn]= originalTile;
         if(this.placePlayer(initRow , initColumn - 1 )){
           //  this._maze[initRow][initColumn]= originalTile;
             initColumn -= 1;
             shouldBreak = true;
         }
       }

       int compareA = Character.compare(moveKey, 'a');

      if (compareA == 0) {
   //  this._maze[initRow][initColumn]= originalTile;
        if(this.placePlayer(initRow - 1, initColumn )){
           // this._maze[initRow][initColumn]= originalTile;
           initRow -= 1;
           shouldBreak = true;
        }
      }

      int compareS = Character.compare(moveKey, 's');

     if (compareS == 0) {
     //  this._maze[initRow][initColumn]= originalTile;
       if(this.placePlayer(initRow, initColumn + 1)){
         //  this._maze[initRow][initColumn]= originalTile;
         initColumn += 1;
         shouldBreak = true;
       }

     }

     int compareD = Character.compare(moveKey, 'd');

    if (compareD == 0) {
   //this._maze[initRow][initColumn]= originalTile;
      if(this.placePlayer(initRow + 1, initColumn)){
          //this._maze[initRow][initColumn]= originalTile;
         initRow +=1;
         shouldBreak = true; // does it compile
      }




      else{
        System.out.println("Invalid move. Re-enter w, a, s, or d.");
      }

     }
     if(shouldBreak){
       break;
     }
   }

      catch(Exception e) {
         System.out.println("Invalid move. Re-enter w, a, s, or d.");

         userIn.nextLine();
     }





}
 return moveKey;
}






  //  public static void ain(String[] args){
  //
  //
  //    File text = new File("map2.map");
  //
  //
  //    Map mappy = new Map(text);
  //    System.out.println( "[2J" );
  //    System.out.println(mappy);
  //
  //
  //  while (true) {
  //    //mappy.originalTile = mappy._maze[mappy.initRow][mappy.initColumn];
  //    mappy.playerMove();
  //    System.out.println( "[2J" );
  //    System.out.println(mappy);
  //  }
  //
  // }

}
