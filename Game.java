import java.util.ArrayList; // import the ArrayList class
import java.util.*;
import java.io.*;

public class Game {

	Player protag;
	File text;
	Map mappy;
	Map mapotofu;
	
  public Game() {
		protag = new Player("filler", 50);
		text = new File("map2.map");
		mappy = new Map(text);
		text = new File("map1.map");
		mapotofu = new Map(text);
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

	public void clearLine() {
		//deletes the current line
		System.out.print("\033[2K\r");
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

	//get the protag's name
	Scanner in = new Scanner( System.in );
	String name = "";
	String confirm = "";

	//loop until they confirm it's their name
	while ( confirm == null || !confirm.toLowerCase().trim().equals("confirm") ) {

	    	clearScreen();
		System.out.println("Hello new adventurer! Please give me your name:\n");
		name = in.nextLine();
		System.out.println("\nIs " + name + " right? Type \"confirm\" to confirm.\n");
		confirm = in.nextLine();

	}

	protag.setName(name);
	clearScreen();

	// you wake up from a deep sleep
	try {
		for ( int i = 1; i <= 3; i++ ) {
			Thread.sleep(1200);
			System.out.println("\n\t\t\t.");
		}
	} catch ( Exception e ) {
		clearScreen();
		System.out.println("Name selection interrupted");
		System.exit(0);
	}

	Pomenon starter = new Pomenon();

	// starter selection
	try {
		//transition into starter selection
		clearScreen();
		Thread.sleep(1500);
		System.out.print("\n*You wake up in a frenzy, finally of legal age to own your own Pomenon*");
		Thread.sleep(1750);
		clearLine();
		System.out.print("*You make your way to the nearest Pomenon center in a hurry*");
		Thread.sleep(1750);
		clearLine();

		//starter select
		System.out.print("Which Pomenon would you like to choose? Type their number in.\n");
		System.out.print("1. Riverlotl\n2. Dinosinge\n3. Trilantro\n");

		int starterNum = 0;

		while ( true ) {

			try {
				starterNum = in.nextInt();
			} catch ( Exception e ) {
				System.out.println("\033[2;0H\033[2KPlease, a number this time.\033[6;0H\033[2K");
			}

			if ( starterNum > 0 && starterNum <= 3 ) {

				if ( starterNum == 1 )
					starter = new Riverlotl();

				else if ( starterNum == 2 )
					starter = new Dinosinge();

				else if ( starterNum == 3 )
					starter = new Trilantro();

				protag.addTeam( starter );
				break;
			} // if
		} // while
	} catch ( Exception e ) {
		clearScreen();
		System.out.println("Starter selection interrupted");
		System.exit(0);
	}

    // starter hath been chosen
    clearScreen();
    System.out.println();
    System.out.println("Ah, you chose " + starter.getName() + "!");
    pause1500();
    System.out.println();
    System.out.println("A very good choice if I do say so myself.");

    // ask to change starter's NAME
    pause1500();
    System.out.println();
		System.out.println("Would you like to give your new little buddy a name?");
    System.out.println();
		System.out.println("1. Yes\n2. No\n");

    int inputNum = 0;
    String starterName = starter.getName();
		Scanner in2 = new Scanner( System.in );
		while ( true ) {

			try {
				inputNum = in.nextInt();
			}
      catch ( Exception e ) {
		System.out.println("\033[2;0H\033[2KPlease, a number this time.\033[6;0H\033[2K");

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
					pause1500();
        }

				else if ( inputNum == 2 ) {
          System.out.println("Your starter is still special even though they have no name!");
					pause1500();
        }
					// System.out.println(starter.getMoves().get(0));
				break;
			} // if
		} // while

} // end introduction method

// INVENTORY METHOD

public void inventory() {
	if (protag.getPlayerBag().size() == 0) {
		
	} // 
}








// POMECENTER THAT DOUBLES AS A HEALING STATION AND SUSSY SHOP

public void pomecenter() {
	System.out.println( "[2J" );


	System.out.println("Hello traveller, welcome to the Pomecenter!\n");
	System.out.println("Here, you can heal your Pomenons or check out our Pomeshop! What would you like to do?");
	System.out.print("1. Heal Pomenons\n\n2. Check out Pomeshop\n\n3. Exit\n");
	Scanner in = new Scanner(System.in);
	int inputNum = 0;
	while(inputNum != 3){
	inputNum = in.nextInt();

	if (inputNum == 1) {
		heal();
	}
	if (inputNum == 2) {
		shoppy();
	}
	// if (inputNum == 3) {
	// 	return;
} // while loop

} // end pomecenter

public void shoppy() {

	System.out.println("This is the Pomeshop! What would you like to do?");
	System.out.println();
	System.out.println("\n1. Adopt a Pomenon to add to your team! \n\n2. Buy beans to buff your team! Beans can only be consumed once \n\n3. Buy PMs to teach your pomenons new moves. Make sure to buy the correct move type, or you'll waste money. \n\n4. Exit");
	Scanner in = new Scanner(System.in);
	int input = 0;

	while(input != 4){
		try{

		 input = in.nextInt();
		if(input == 1){
			//adopt your new lovely friend here
		}
		if(input == 2){
			//tasty organic gmo free beans
			Scanner in2 = new Scanner(System.in);
			int input2 = 0;
			
			System.out.println("Welcome to the Bean Shop! Here we have a wonderful selection of Beans!");
			System.out.print("\n1. Protein Powder Bean\n2. Heart Bean\n3. Exit\n");
			
			while (input2 != 3) {
				try {
					input2 = in.nextInt();
					
					if (input2 == 1) {
						Bean stronk = new atkBean();
						System.out.println("This is the " + stronk.getName());
						System.out.println("\nMade only from the finest beta-alanine");
						System.out.println("\nIncreases your Pomenon's attack stat by 5");
						stronk.buy(protag); 
					}
					
					if (input2 == 2) {
						Bean tanky = new hpBean();
						System.out.println("This is the " + tanky.getName());
						System.out.println("\nMade with love from grandma");
						System.out.println("\nIncreases your Pomenon's health stat by 5");
						tanky.buy(protag); 
					}
					if (input2 == 3) {
						System.out.println("You exited the Bean Shop!");
						return;
					}
					
				} // try
				catch(Exception e) {
					System.out.println("Invalid input. Please try again. ");
					in.nextLine(); 
				}
			} // while loop
			
		} // beans 

		if(input == 3){
			//kapow new move
		}
		if(input == 4){
			System.out.println("You exited the shop!");
			return;
		}
	} catch(Exception e){
		System.out.println("Invalid input. Please try again ");
		System.out.println("1. Adopt a Pomenon to add to your team! \n 2. Buy beans to buff your team! Beans can only be consumed once \n3. Buy PMs to teach your pomenons new moves. Make sure to buy the correct move type, or you'll waste money. \n 4. Exit");
		in.nextLine();
	}
	} // while loop
} // end shoppy

public void heal() {

	for(Pomenon pompom : protag.getPlayerTeam()) {

		pompom.setHealth(pompom.getMaxHealth());
	}
	System.out.println("All healed! ^.^");
}


  // Battles
	public void initbattleDisplay(Pomenon me, Pomenon enemy) {
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
	  System.out.println("|                                      _________________|");
		System.out.println("|                                      |                |");
		System.out.println("|   (╯°□°)╯︵◓                         |                |");
		System.out.println("|                                      |________________|");

	}
	
	public void RiverlotlbattleDisplay(Pomenon me, Pomenon enemy) {
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
				s+="           |";
				System.out.println(s);
				s= ""; //reset
		//HARD CODE

		System.out.println("|_________________|                         >>(.___.)<< |");
		System.out.println("|                                              (   )__  |");
		System.out.println("|                                               W  W    |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                      _________________|");
		s="";
										s+="|     ^~^  ,                           | ";
		s+=me.getName();
		while(s.length()<56){
			s+=" ";
		}
		s+="|";
		System.out.println(s);
		
		s="";
										s+="|   ('Y') )                            | ";
		s+=me.getHealth()+"/"+me.getMaxHealth();
		while(s.length()<56){
			s+=" ";
		}
		s+="|";
		System.out.println(s);
		System.out.println("|   /   \\/                             |________________|");
		System.out.println("|  (\\|||/)                                              |");
	

	} // RIVERLOLTLBATTLEDISPLAY
	
	public void TrilantrobattleDisplay(Pomenon me, Pomenon enemy) {
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
				s+="           |";
				System.out.println(s);
				s= ""; //reset
		//HARD CODE

		System.out.println("|_________________|                          :(o v o)   |");
		System.out.println("|                                              (v v)_/  |");
		System.out.println("|                                              //¯\\\\    |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                      _________________|");
		s="";
										s+="|     ^~^  ,                           | ";
		s+=me.getName();
		while(s.length()<56){
			s+=" ";
		}
		s+="|";
		System.out.println(s);
		
		s="";
										s+="|   ('Y') )                            | ";
		s+=me.getHealth()+"/"+me.getMaxHealth();
		while(s.length()<56){
			s+=" ";
		}
		s+="|";
		System.out.println(s);
		System.out.println("|   /   \\/                             |________________|");
		System.out.println("|  (\\|||/)                                              |");
	

	}
	
	public void DinosingebattleDisplay(Pomenon me, Pomenon enemy) {
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
				s+="           |";
				System.out.println(s);
				s= ""; //reset
		//HARD CODE

		System.out.println("|_________________|                           (` M ')   |");
		System.out.println("|                                             =(( ) )=  |");
		System.out.println("|                                              //¯\\\\    |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                                       |");
		System.out.println("|                                      _________________|");
		s="";
		                s+="|     ^~^  ,                           | ";
		s+=me.getName();
		while(s.length()<56){
			s+=" ";
		}
		s+="|";
		System.out.println(s);
		
		s="";
										s+="|   ('Y') )                            | ";
		s+=me.getHealth()+"/"+me.getMaxHealth();
		while(s.length()<56){
			s+=" ";
		}
		s+="|";
		System.out.println(s);
		System.out.println("|   /   \\/                             |________________|");
		System.out.println("|  (\\|||/)                                              |");
	}
	
	
	
	


  public void individualBattle(Player me, Pomenon wild) {

	Pomenon chosen = me.getPlayerTeam().get(0);
	System.out.println("======================================");
	this.initbattleDisplay(chosen, wild);
    String s = "";
    s += "You have encountered a wild " + wild.getName() + "!";
    System.out.println(s);


		if(!checkUsablePomenon(me)){
			System.out.println("Your Pokemon are in no condition to fight!");
			return;
		}

    if(checkUsablePomenon(me)){
      chosen = me.getPlayerTeam().get(me.choosePomenon());
    }

    s = "======================================";
    System.out.println(s);
		if(wild.getName().equals("Riverlotl")){
			RiverlotlbattleDisplay(chosen, wild);
		}
		if(wild.getName().equals("Trilantro")){
			TrilantrobattleDisplay(chosen, wild);
		}
		if(wild.getName().equals("Dinosinge")){
			DinosingebattleDisplay(chosen, wild);
		}
		
		
  //this.battleDisplay(chosen, wild);
    while (checkUsablePomenon(me)) {
      if( wild.checkDead()){
        System.out.println("Battle won!");
				System.out.println("20 added to your balance");
				me.changeBal(20);
				pause1500();
        for(Pomenon p : me.getPlayerTeam()){
            System.out.println(p.getName() + ": "+ p.getHealth() + " hp");

        }
        break;

      }

			if(chosen.checkDead()) {
				System.out.println(chosen.getName() + " fainted!");
				if (checkUsablePomenon(me)) {
					chosen = me.getPlayerTeam().get(me.choosePomenon());
				}
				else {
					System.out.println("You don't have anymore usable Pomenon!");
					System.out.println("We advise you to get to the nearest Pomecenter");
					pause1500();
					break;
				}


			}
//  this.battleDisplay(chosen, wild);

      chosen.chooseMove(chosen, wild);
			
			if(wild.getName().equals("Riverlotl")){
				RiverlotlbattleDisplay(chosen, wild);
			}
			if(wild.getName().equals("Trilantro")){
				TrilantrobattleDisplay(chosen, wild);
			}
			if(wild.getName().equals("Dinosinge")){
				DinosingebattleDisplay(chosen, wild);
			}
			
			
			
		//	this.battleDisplay(chosen, wild);
      //System.out.println(chosen.getName()+": "+ chosen.getHealth()+ " hp");
      //System.out.println(wild.getName()+": "+ wild.getHealth()+ " hp");
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

 // MAPPY ONE EXPERIMENT

 public void map1() {
	 boolean newMap = true;
	 // text = new File("map2.map");
	 // mappy = new Map(text);
	 	System.out.println( "[2J" );
 System.out.println(mappy);
 mappy.playerMove();
 newMap = false;
 System.out.println( "[2J" );
 System.out.println(mappy);
 		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");
 if(!checkUsablePomenon(protag)){
	 System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
 }

 while (Character.compare(mappy.getPrev(),'E')!= 0 && !newMap ) {
   //.originalTile = mappy.mappy[mappy.initRow][mappy.initColumn];
   mappy.playerMove();
	 newMap = false;
	 if (Character.compare(mappy.getPrev(), 'C') == 0) {


		text = new File("pomecenter.map");
		Map center = new Map(text);
		System.out.println( "[2J" );
		System.out.println("Hello traveller, welcome to the Pomecenter!\n");
		System.out.println(center);
		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");

		while (Character.compare(center.getPrev(), 'E') != 0) {
			center.playerMove();

			System.out.println( "[2J" );
			System.out.println(center);
					System.out.println("Key:  E = Exit ; N = Nurse ; $ = Shop");
			if(Character.compare(center.getPrev(),'N')==0){
				heal();
			}
			if(Character.compare(center.getPrev(), '$') == 0) {
				shoppy();
			}
		}

	} // center
   if(Character.compare(mappy.getPrev(), '#') == 0) {

     int randomInt = (int) (Math.random() * 5);
     System.out.println(randomInt);
     if (randomInt==3) {

       randomInt = (int) (Math.random() * 3);
       if(randomInt==0){
       Pomenon wild = new Trilantro();

       individualBattle(protag, wild );
      }
			if(randomInt == 1){
				Pomenon wild = new Riverlotl();
				individualBattle(protag, wild);

			}
			else{
				Pomenon wild = new Dinosinge();
				individualBattle(protag, wild);


   }


}
 }

 System.out.println( "[2J" );
 System.out.println(mappy);
 		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");
 //System.out.println(mappy.getPrev());
  if(!checkUsablePomenon(protag)){
    System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
  }


 //  newGame.battleDisplay();
 //System.out.println()
 } // while loop
 } // map 1


public void map2(){
	// text = new File("map1.map");
	// mappy = new Map(text);

		System.out.println( "[2J" );
	System.out.println(mapotofu);
	mapotofu.playerMove();

	System.out.println( "[2J" );
	System.out.println(mapotofu);
		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");
	if(!checkUsablePomenon(protag)){
		System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
	}
	while (Character.compare(mapotofu.getPrev(),'E')!= 0  ) {
		//.originalTile = mappy.mappy[mappy.initRow][mappy.initColumn];
		mapotofu.playerMove();
		if(Character.compare(mapotofu.getPrev(), 'S')== 0  ){
			this.map1();
		}
		if (Character.compare(mapotofu.getPrev(), 'C') == 0) {


		text = new File("pomecenter.map");
		Map center = new Map(text);
		System.out.println( "[2J" );
		System.out.println("Hello traveller, welcome to the Pomecenter!\n");
		System.out.println(center);
			System.out.println("Key:  E = Exit ; N = Nurse ; $ = Shop");
		while (Character.compare(center.getPrev(), 'E') != 0) {
			center.playerMove();

			System.out.println( "[2J" );
			System.out.println(center);
				System.out.println("Key:  E = Exit ; N = Nurse ; $ = Shop");
						if(Character.compare(center.getPrev(),'N')==0){
				heal();
			}
			if(Character.compare(center.getPrev(), '$') == 0) {
				shoppy();
			}
		}

	} // center
		if(Character.compare(mapotofu.getPrev(), '#') == 0) {

			int randomInt = (int) (Math.random() * 5);
			System.out.println(randomInt);
			if (randomInt==3) {

				randomInt = (int) (Math.random() * 3);
				if(randomInt==0){
				Pomenon wild = new Trilantro();

				individualBattle(protag, wild );
			 }
			 if(randomInt == 1){
				 Pomenon wild = new Riverlotl();
				 individualBattle(protag, wild);

			 }
			 else{
				 Pomenon wild = new Dinosinge();
				 individualBattle(protag, wild);
			 }


		}



	}

	System.out.println( "[2J" );
	System.out.println(mapotofu);
		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");
	//System.out.println(mapotofu.getPrev());
	 if(!checkUsablePomenon(protag)){
		 System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
	 }
} //end while

}//end map2


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
