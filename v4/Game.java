import java.util.ArrayList; // import the ArrayList class
import java.util.*;

public class Game {

  public Game(){

  }
  public void play() {
    // where we put everything  from intro to battle to etc.
  }

	public void clearScreen() {
		//clears the screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}


  public void introduction(){

	clearScreen();

	//get the protag's name
	Scanner in = new Scanner( System.in );
	String name = "owa";
	String confirm = "no";

	while ( confirm.toLowerCase().trim().equals("no") ) {
		System.out.println("Hello new adventurer! Please give me your name:\n");
		name = in.nextLine();
		System.out.println("Is " + name + " right? Type 'no' if you would like to change it.\n");
		confirm = in.nextLine();

	}

	Player protag = new Player( name, 50 );


}

  public void walk(){
    //zoom zoom
  }

// Battles
  public void battleDisplay(Pomenon me, Pomenon enemy) {
    System.out.println( "[2J" );
    System.out.println("________________________________________________________________________________________________________________");

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
