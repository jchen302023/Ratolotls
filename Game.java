import java.util.ArrayList; // import the ArrayList class
import java.util.*;

public class Game {

  public void introduction(){
  //hello what is your name
  // choosing your starter poke? :)
}

  public void walk(){
    //zoom zoom
  }

// Battle

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

 // 
 // public void inputMove(Pomenon pompom){
 //      Scanner player = new Scanner(System.in);
 //   System.out.println("You would like to: ");
 //   System.out.println();
 // }

}
