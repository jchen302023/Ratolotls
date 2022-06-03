import java.util.ArrayList; // import the ArrayList class
import java.util.*;

public class Game {

	Player protag;

  public Game() {
		protag = new Player("filler", 50);
  }
  public void play() {
    // where we put everything  from intro to battle to etc.
		introduction(); 
  }

	public void clearScreen() {
		//clears the screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

  public void pause2000() {
    try {
      Thread.sleep(2000);
    }
    catch (Exception e) {
      
    }
  }
  public void pause1500() {
    try {
      Thread.sleep(1500);
    }
    catch (Exception e) {
      
    }
  }
	// public static String writeLine // what does this do


  public void introduction(){

	clearScreen();

	//get the protag's name
	Scanner in = new Scanner( System.in );
	String name = "";
	String confirm = "";

	//loop until they confirm it's their name
	while ( confirm == null || !confirm.toLowerCase().trim().equals("confirm") ) {
    
		System.out.println("Hello new adventurer! Please give me your name:\n");
		name = in.nextLine();
    System.out.println(); 
		System.out.println("Is " + name + " right? Type \"confirm\" to confirm.\n");
		confirm = in.nextLine();

	}
  
	protag.setName(name);
	clearScreen();

	//starter pokemon
	// try {
		//introducing starter select screen
    pause2000(); 
    System.out.println();
    System.out.print("        .");
    pause2000(); 
    System.out.println();
    System.out.print("        .");
    pause2000(); 
    System.out.println();
    System.out.print("        .");
    pause2000(); 
    
    clearScreen();
		pause2000(); 
    System.out.println();
		System.out.println("*You wake up in a frenzy, finally of legal age to own your own Pomenon*");
		pause2000();
    System.out.println();
    System.out.println("*You make your way to the nearest Pomenon center in a hurry*");
    pause2000();
    pause1500();
		// System.out.print("\033[2K"); //magic escape code to delete the line
		// System.out.flush();
    clearScreen();
    
		//starter select
    pause2000();
    System.out.println();
		System.out.println("Which Pomenon would you like to choose? Type their number in.");
    System.out.println();
		System.out.println("1. Riverlotl\n2. Dinosinge\n3. Trilantro");
    
    Scanner in2 = new Scanner( System.in );
		int starterNum = 0;
    Pomenon starter = new Pomenon(); 

		while ( true ) {
      
			try {
				starterNum = in.nextInt();
			} 
      catch ( Exception e ) {
				System.out.println("\033[H\033[2KPlease, a number this time.");
			}
      
			if ( starterNum > 0 && starterNum <= 3 ) {
        
				if ( starterNum == 1 ) {
          starter = new Riverlotl();
        }
        
				else if ( starterNum == 2 ) {
          starter = new Dinosinge();
        }
					
				else if ( starterNum == 3 ) {
          starter = new Trilantro();
        }
					
				protag.addTeam( starter );
				break;
			} // if 
		} // while 
    
    // starter hath been chosen 
    clearScreen();
    System.out.println();
    System.out.println("Ah, you chose " + starter.getName() + "!");
    pause1500();
    System.out.println();
    System.out.println("A very good choice if I do say so myself.");
    pause2000();
    
    // ask to change starter's NAME
    pause2000();
    System.out.println();
		System.out.println("Would you like to give your new little buddy a name?");
    System.out.println();
		System.out.println("1. Yes\n2. No\n");
    
    int inputNum = 0; 
    String starterName = starter.getName();
		while ( true ) {
      
			try {
				inputNum = in.nextInt();
			} 
      catch ( Exception e ) {
				System.out.println("\033[H\033[2KPlease, a number this time.");
			}
      
			if ( inputNum > 0 && inputNum <= 2 ) {
        
				if ( inputNum == 1 ) {
          clearScreen();
          System.out.println();
          System.out.println("What would you like to name your " + starter.getName() + "?");
          starterName = in2.nextLine();
          starter.setName(starterName); 
          System.out.println();
          System.out.println(starter.getName() + " is a wonderful name for your new friend!");
        }
        
				else if ( inputNum == 2 ) {
          // do later 
        }
					
				break;
			} // if 
		} // while 
    
} // end introduction method


  public void walk(){
    //zoom zoom
  }

  // Battles
	public void battleDisplay(Pomenon me, Pomenon enemy) {
	  System.out.println( "[2J" );
	  System.out.println("_________________________________________________________");
	  //57 characters per line 
	  //NAME LINE
	      String s = "";
	      s+= "| " + enemy.getName();
	      while(s.length()<18){
	        s += " ";
	      } 
	      s += "|";
	       while(s.length()<56){
	         s+= " ";
	       }     
	       s+="|";
	       System.out.println(s);
	       s= ""; //reset
	      
	 
	 //HP LINE
	     s+= "| " + enemy.getHealth()+ "/"+ enemy.getMaxHealth();
	     while(s.length()<18){
	       s += " ";
	     }
	     s += "|";
	      while(s.length()<45){
	        s+= " ";
	      }     
	      s+=",          |";
	      System.out.println(s);
	      s= ""; //reset
	  //HARD CODE 
	  
	  System.out.println("|_________________|                         =')         |");
	  System.out.println("|                                             (¯¯¯)~    |");
	  System.out.println("|                                             //¯\\\\     |");
	  System.out.println("|                                                       |");
	  System.out.println("|                                                       |");
	  System.out.println("|                                                       |");
	  System.out.println("|                                                       |");
	  System.out.println("|                                                       |");
	  System.out.println("|                                                       |");
	  System.out.println("|                                                       |");
	
	
	
	}


  public void individualBattle(Player me, Pomenon wild) {

    String s = "";
    s += "You have encountered a wild " + wild.getName() + "!";
    System.out.println(s);
    Pomenon chosen = me.getPlayerTeam().get(0);



    if(checkUsablePomenon(me)){
      chosen = me.getPlayerTeam().get(me.choosePomenon());
    }

    s = "======================================";
    System.out.println(s);
  this.battleDisplay(chosen, wild);
    while (checkUsablePomenon(me)) {
      if( wild.checkDead()){
        System.out.println("Battle won!");
        for(Pomenon p : me.getPlayerTeam()){
            System.out.println(p.getName() + ": "+ p.getHealth() + " hp");

        }
        break;

      }
//  this.battleDisplay(chosen, wild);
      chosen.chooseMove(chosen, wild);
this.battleDisplay(chosen, wild);
      System.out.println(chosen.getName()+": "+ chosen.getHealth()+ " hp");
      System.out.println(wild.getName()+": "+ wild.getHealth()+ " hp");
      s = "======================================";
      System.out.println(s);
      }



    }



  public void battle(Player me, Player you) {

   /*while I still have usable pokemon AND you have usable pokemon:
   continue with battle loop


   if I run out of usable pomenons and you still have usable pomenon, i lose and pay a fee from
   my balance.

   if you run out of usable pomenon and i still have usable pomenon, you lose and i gain an amount
   of money.

   we don't need to change the opponent balance, just ours.

   within the while game loop:
  - take my input and execute move
  - generate random move of enemy pomenon and execute move.
  - reevaluate while loop condition :)
   */



 }

 //returns true if there is still one pom with >0 health. returns false if all are <=0 health
 public boolean checkUsablePomenon(Player gamer){
   for(Pomenon pom: gamer.getPlayerTeam()){
     if(! pom.checkDead()){
       return true;
     }
   }
   return false;
 }

public static void main(String[] args){
  Game newGame = new Game();
  newGame.introduction();

//  newGame.battleDisplay();
  //System.out.println()
}






}
