import java.io.*;
import java.util.*;


public class Woo {

  public static void main(String[] args){

    File text = new File("map2.map");


    Map mappy = new Map(text);
    System.out.println( "[2J" );
    System.out.println(mappy);


  while (true) {
    //mappy.originalTile = mappy._maze[mappy.initRow][mappy.initColumn];
    mappy.playerMove();
    System.out.println( "[2J" );
    System.out.println(mappy);
  }



  }


}
