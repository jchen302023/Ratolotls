import java.io.*;
import java.util.*;


public class Map{

  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int height, width; // height, width of maze
  private int initRow, initColumn;

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

   public void placePlayer(int row, int columns) {
     System.out.println("placing");
     this._maze[row][columns] = '@';

   }

   public char playerMove(int startRow, int startColumn) {
    Scanner userIn = new Scanner(System.in);  // Create a Scanner object

    char moveKey = userIn.nextLine().charAt(0);

    System.out.println(moveKey);
     int compareW = Character.compare(moveKey, 'w');
    if (compareW == 0) {
      this.placePlayer(startRow + 1, startColumn);

    } // do four times for each direction key


return moveKey;
  //  if (moveKey =
   }

   public static void main(String[] args){
     // String mazeInputFile = null;
     // try {
     //   mazeInputFile = args[0];
     //   System.out.println("args");
     // } catch( Exception e ) {
     //   System.out.println( "Error reading input file." );
     //   System.out.println( "USAGE:\n $ java Maze path/to/filename" );
     // }
     //
     // if (mazeInputFile == null) { System.out.println("Exit");
     // System.exit(0); }


     File text = new File("map1.map");


     Map mappy = new Map(text);
       System.out.println( "[2J" );
     System.out.println(mappy);
     mappy.placePlayer(5,5);
     System.out.println( "[2J" );
   System.out.println(mappy);
   mappy.playerMove(5, 5);
   System.out.println( "[2J" );
 System.out.println(mappy);

   }

}
