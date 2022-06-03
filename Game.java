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

	public static String writeLine


  public void introduction(){

	clearScreen();

	//get the protag's name
	Scanner in = new Scanner( System.in );
	String name;
	String confirm;

	//loop until they confirm it's their name
	while ( confirm == null || !confirm.toLowerCase().trim().equals("confirm") ) {
		System.out.println("Hello new adventurer! Please give me your name:\n");
		name = in.nextLine();
		System.out.println("Is " + name + " right? Type \"confirm\" to confirm.\n");
		confirm = in.nextLine();

	}
	protag.setName(name);
	clearScreen();

	//starter pokemon
	try {
		//introducing starter select screen
		Thread.sleep(2000);
		System.out.print("*You wake up in a frenzy, finally of legal age to own your own Pomenon*");
		Thread.sleep(2000);
		System.out.print("\033[2K"); //magic escape code to delete the line
		System.out.flush();

		//starter select
		System.out.println("Which Pomenon would you like to choose? Type their number in.");
		System.out.println("1. Riverlotl\n2. Dinosinge\n3. Ackwron");
		int starterNum = 0;

		while ( true ) {
			try {
				starterNum = in.nextInt();
			} catch ( InputMismatchException e ) {
				System.out.println("\033[H\033[2KPlease, a number this time.");
			}

			if ( starterNum > 0 && starterNum <= 3 ) {
				if ( starterNum = 1 ) 
					Riverlotl starter = new Riverlotl();
				else if ( starterNum = 2 )
					Dinosinge starter = new Dinosinge();
				else if ( starterNum = 3 )
					Ackwron starter = new Ackwron();

				protag.addTeam( starter );
				break;
			}
		}
	}

}

  public void walk(){
    //zoom zoom
  }

// Battles
  public void battleDisplay(Player me, Pomenon enemy) {
    System.out.println("________________________________AMAZING BATTLE________________________________");

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

    while (checkUsablePomenon(me)) {
      if( wild.checkDead()){
        System.out.println("Battle won!");
        for(Pomenon p : me.getPlayerTeam()){
            System.out.println(p.getName() + ": "+ p.getHealth() + " hp");

        }
        break;

      }

      chosen.chooseMove(chosen, wild);
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








}
