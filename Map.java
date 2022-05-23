import java.io.*;
import java.util.*;


public class Map{

  final private int FRAME_DELAY = 50;

  private char[][] world;
  public int height, width; // height, width of maze

  
  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
   final private char PLAYER =           '@';
   final private char GRASS =           '#';
   final private char EXIT =           '$';
   final private char DIRT =           ' ';
   final private char WALL =           'W'; 
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


   public Map( String inputFile )
   {
     // init 2D array to represent maze
     // (80x25 is default terminal window size)
     _maze = new char[80][25];
     height = 0;
     width = 0;
 
     //transcribe maze from file into memory
     try {
       Scanner sc = new Scanner( new File(inputFile) );
 
       System.out.println( "reading in file..." );
 
       int row = 0;
 
       while( sc.hasNext() ) {
 
         String line = sc.nextLine();
 
         if ( width < line.length() )
           width = line.length();
 
         for( int i=0; i<line.length(); i++ )
           _maze[i][row] = line.charAt( i );
 
         height++;
         row++;
       }
 
       for( int i=0; i<width; i++ )
         _maze[i][row] = WALL;
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
 
     int i, j;
     for( i=0; i<h; i++ ) {
       for( j=0; j<w; j++ )
         retStr = retStr + _maze[j][i];
       retStr = retStr + "\n";
     }
     return retStr;
   }

  
}


