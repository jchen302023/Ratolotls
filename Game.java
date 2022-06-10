import java.util.ArrayList; // import the ArrayList class
import java.util.*;
import java.io.*;

public class Game {

	Player protag;
	File text;
	Map mappy;
	Map mapotofu;
	Map nap; 
	Boolean waiverUsed; 
	
  public Game() {
		protag = new Player("filler", 50);
		text = new File("map2.map");
		mappy = new Map(text, 15, 8);
		text = new File("map1.map");
		mapotofu = new Map(text, 15, 8);
		text = new File("map3.map");
		nap = new Map(text , 14, 14); 
		waiverUsed = false; 
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
				protag.addPomenon( starter);
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
		System.out.println("\nWe wish you good luck on your journey!");
		pause1500(); 
} // end introduction method

// INVENTORY METHOD

public void inventory() {
	Scanner in = new Scanner(System.in);
	int input = 0;
	int counter = 1; 
	if (protag.getPlayerBag().size() == 0) {
		System.out.println("You have nothing in your bag right now!"); 
	}
	if (protag.getPlayerBag().size() != 0) {
		System.out.println( "___" + protag.getPlayerName() + "'s Inventory___");
		System.out.println("______________________________");
			String s = "";
		for (Item a : protag.getPlayerBag()) {
		
			s += "| " + counter + ". " + a.getName();
			while (s.length() < 30) {
				s += " ";
			}
			s += "|"; 
			counter += 1; 
			System.out.println(s);  
			s = "" ; 
			
		}

		String n = "";
		n += "| Balance: " + protag.getBalance();
		while (n.length() < 30) {
			n += " ";
		}
		n += "|";
		System.out.println("|                             |");
		System.out.println(n);
		System.out.println("|_____________________________|");
	} // 
	
	// PROMT USER INPUT TO USE THE ITEMS
	while (protag.getPlayerBag().size() != 0) {
		
	
	// Scanner in = new Scanner(System.in);
	int inputNum = 0;
	
	while (inputNum != 2) {
		
		try {
			System.out.println("\nWould you like to use an item? \n1. Yes \t\t 2. No");
			inputNum = in.nextInt();
			if (inputNum == 1) {
				System.out.println("\nPlease input the number of the item you would like to use");
			//	System.out.println(s);
				// System.out.println(s);
				boolean shouldBreak = false;
				while (!shouldBreak) {
					try{
						inputNum = in.nextInt();
						
						if (inputNum > protag.getPlayerBag().size()) {
							System.out.println("\nPlease input a valid item number");
						//	System.out.println(s);
							in.nextLine();
						}
						else {
							int pomcounter = 1; 
							System.out.println("\nYou selected the " + protag.getPlayerBag().get(inputNum - 1).getName() ); 
							System.out.println("\nWhich Pomenon would you like to use it on?");
							
							for (Pomenon p : protag.getPlayerTeam()) {
								System.out.println(pomcounter + ". " + p.getName()); 
								pomcounter += 1; 
							} // list out yoyur pomes 
							boolean shouldBreak2 = false;
							int inputNum2 = 0; 
							while (!shouldBreak2) {
								try {
									inputNum2 = in.nextInt();
									if (inputNum2 > protag.getPlayerTeam().size()) {
										System.out.println("\nPlease input a valid item number");
										in.nextLine();
									}
									else {
										useItem(protag.getPlayerTeam().get(inputNum2 - 1), protag.getPlayerBag().get(inputNum - 1));
										protag.getPlayerBag().remove(inputNum - 1);
										if(protag.getPlayerBag().size() == 0){
											inputNum = 2;
										}
										break;
									}
									
								} // try
								catch (Exception e) {
									System.out.println("\nPlease input a valid item number");
									in.nextLine();
								} // catch 
								
														
							} // while loop....
						

							shouldBreak = true; 
						} // else statement
						
					} // inner try
					catch(Exception e){
						System.out.println("Invalid input. Please try again. ");
						System.out.println("\nPlease input the number of the item you would like to use");
								// System.out.println(s);
						in.nextLine(); 
					} // inner catch 
					// if(shouldBreak){
					// 		System.out.println("\nWould you like to use an item? \n1. Yes \t\t 2. No");
					// }
				} // while 
					
			
			} // if statement 
		} // outer try
		catch (Exception e) {
			
			System.out.println("Invalid input. Please try again. ");
			System.out.println("\nWould you like to use an item? \n1. Yes \t\t 2. No");

			in.nextLine(); 
		}
		// outer catch 
	} 
	}
	System.out.println("Press a valid move key ( w a s d ) to go on your merry way!"); // while loop
	
	
} // inventory 


public void useItem(Pomenon pome, Item item) {
	if(item.getStatName().equals("atk")) {
		 pome.setAtkdmg(pome.getAtkdmg() + item.getStatChange()); 
	}
	if (item.getStatName().equals("hp")) {
		pome.setMaxHealth(pome.getMaxHealth() + item.getStatChange()); 
	}
	System.out.println("\n" + item.getName() + " successfully used on " + pome.getName() + "!"); 
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
	System.out.println("\n1. Adopt a Pomenon to add to your team! \n\n2. Buy beans to buff your team! Beans can only be consumed once. \n\n3. Exit");
	Scanner in = new Scanner(System.in);
	int input = 0;

	while(input != 3){
		try{

		 input = in.nextInt();
		if(input == 1){
			//adopt your new lovely friend here
			System.out.println("\nWelcome to the Pomenon adoption center! Would you like to adopt one of our little guys for a small fee?");
			if (!waiverUsed ) {
					System.out.println("\n Since you are adopting a Pomenon for the first time, you can adopt for free with your free adoption waiver! ");
			} // waiverUsed
			if(!(! waiverUsed || protag.getBalance()>250)){
				System.out.println("You do not have enough balance to adopt");
			
			}
			
			
			while (input != 4 && (! waiverUsed || protag.getBalance()>250)) {
				System.out.print("\n1. Riverlotl\n2. Dinosinge\n3. Trilantro\n4. Exit");
				try {
					Scanner in4 = new Scanner(System.in);
					int input4 = in4.nextInt();
					
					if (input4 == 1) {
						Pomenon RIVERLOTL = new Riverlotl();
						System.out.println("\nYou chose to adopt a Riverlotl!");
					
						System.out.println("Would you like to give your new little buddy a name?");
						System.out.println();
						System.out.println("1. Yes\n2. No\n"); 
												int inputNum = 0;
												String starterName = ""; 
												Scanner in2 = new Scanner( System.in );
												while ( true ) {
										
													try {
														inputNum = in2.nextInt();
													}
													catch ( Exception e ) {
												System.out.println("\033[2;0H\033[2KPlease, a number this time.\033[6;0H\033[2K");
										
													}
										
													if ( inputNum > 0 && inputNum <= 2 ) {
										
														if ( inputNum == 1 ) {
															Scanner in3 = new Scanner( System.in );
															// clearScreen();
															System.out.println();
															System.out.println("What would you like to name your Riverlotl?");
															starterName = in3.nextLine();
															RIVERLOTL.setName(starterName);
															System.out.println();
															System.out.println(RIVERLOTL.getName() + " is a wonderful name for your new friend!");
															// pause1500();
														}
										
														else if ( inputNum == 2 ) {
															System.out.println("Your new friend is still special even though they have no name!");
															// pause1500();
														}
															// System.out.println(starter.getMoves().get(0));
													
															
														break;
													} // if
												} // while
												if(waiverUsed){
													protag.changeBal(protag.getBalance()- 250);
												}
												waiverUsed = true;
								protag.addPomenon(RIVERLOTL);
								protag.addTeam(RIVERLOTL); 
						break;
					}
					if (input4 == 2) {
						Pomenon DINOSINGE = new Dinosinge();
						System.out.println("\nYou chose to adopt a Dinosinge!");
						System.out.println("Would you like to give your new little buddy a name?");
						System.out.println();
						System.out.println("1. Yes\n2. No\n");
												int inputNum = 0;
												String starterName = ""; 
												Scanner in2 = new Scanner( System.in );
												while ( true ) {
										
													try {
														inputNum = in2.nextInt();
													}
													catch ( Exception e ) {
												System.out.println("\033[2;0H\033[2KPlease, a number this time.\033[6;0H\033[2K");
										
													}
										
													if ( inputNum > 0 && inputNum <= 2 ) {
										
														if ( inputNum == 1 ) {
															Scanner in3 = new Scanner( System.in );
															// clearScreen();
															System.out.println();
															System.out.println("What would you like to name your Dinosinge?");
															starterName = in3.nextLine();
															DINOSINGE.setName(starterName);
															System.out.println();
															System.out.println(DINOSINGE.getName() + " is a wonderful name for your new friend!");
															// pause1500();
														}
										
														else if ( inputNum == 2 ) {
															System.out.println("Your new friend is still special even though they have no name!");
															// pause1500();
														}
															// System.out.println(starter.getMoves().get(0));
														
														break;
													} // if
												} // while
								protag.addPomenon(DINOSINGE);
								protag.addTeam(DINOSINGE); 
				
								if(waiverUsed){
									protag.changeBal(protag.getBalance()- 250);
								}
								waiverUsed = true;
						break;
					}
					if (input4 == 3) {
						Pomenon TRILANTRO = new Trilantro(); 
						System.out.println("\nYou chose to adopt a Trilantro!");
						System.out.println("Would you like to give your new little buddy a name?");
						System.out.println();
						System.out.println("1. Yes\n2. No\n");
						
												int inputNum = 0;
												String starterName = ""; 
												Scanner in2 = new Scanner( System.in );
												while ( true ) {
										
													try {
														inputNum = in2.nextInt();
													}
													catch ( Exception e ) {
												System.out.println("\033[2;0H\033[2KPlease, a number this time.\033[6;0H\033[2K");
										
													}
										
													if ( inputNum > 0 && inputNum <= 2 ) {
										
														if ( inputNum == 1 ) {
															Scanner in3 = new Scanner( System.in );
															// clearScreen();
															System.out.println();
															System.out.println("What would you like to name your Trilantro?");
															starterName = in3.nextLine();
															TRILANTRO.setName(starterName);
															System.out.println();
															System.out.println(TRILANTRO.getName() + " is a wonderful name for your new friend!");
															// pause1500();
														}
										
														else if ( inputNum == 2 ) {
															System.out.println("Your new friend is still special even though they have no name!");
															// pause1500();
														}
															// System.out.println(starter.getMoves().get(0));
														break;
													} // if
												} // while
								protag.addPomenon(TRILANTRO);
								protag.addTeam(TRILANTRO); 
								if(waiverUsed){
									protag.changeBal(protag.getBalance()- 250);
								}
								waiverUsed = true;

						break;
					}
				}
				catch (Exception e) {
					System.out.println("Invalid input. Please type input again");
					System.out.print("\n1. Riverlotl\n2. Dinosinge\n3. Trilantro\n4. Exit");
				}
				
				
			} // while loop
			
			System.out.println("\n1. Adopt a Pomenon to add to your team! \n\n2. Buy beans to buff your team! Beans can only be consumed once. \n\n3. Exit");

		} // input 1
		
		if(input == 2){
			//tasty organic gmo free beans
			Scanner in2 = new Scanner(System.in);
			int input2 = 0;
			
			System.out.println("\nWelcome to the Bean Shop! Here we have a wonderful selection of Beans!");
			System.out.print("\n1. Protein Powder Bean\n2. Heart Bean\n3. Exit\n");
			
			while (input2 != 3) {
				try {
					input2 = in.nextInt();
					
					if (input2 == 1) {
						Bean stronk = new atkBean();
						System.out.println("\nThis is the " + stronk.getName());
						System.out.println("It costs "+ stronk.getPrice()+" coins");
						//System.out.println("\nMade only from the finest beta-alanine");
						System.out.println("\nIncreases your Pomenon's attack stat by 5");
						stronk.buy(protag, stronk); 
					}
					
					if (input2 == 2) {
						Bean tanky = new hpBean();
						System.out.println("\nThis is the " + tanky.getName());
						System.out.println("It costs "+ tanky.getPrice()+" coins");
						//System.out.println("\nMade with love from grandma");
						System.out.println("\nIncreases your Pomenon's max health stat by 5");
						tanky.buy(protag, tanky); 
					} // input 2 
					if (input2 == 3) {
						System.out.println("\nYou exited the Bean Shop!");
	
					// System.out.println(center); 
					 System.out.println("\nThis is the Pomeshop! What would you like to do?");
				 	// System.out.println();
				 	System.out.println("\n1. Adopt a Pomenon to add to your team! \n\n2. Buy beans to buff your team! Beans can only be consumed once \n\n3. Exit");
				} // input 3
			} // inside try  
				 catch(Exception e) {
				 	System.out.println("Invalid input. Please try again. ");
				 	in.nextLine(); 
				} // inside catch 
			} // while loop
			
		} // beans 

		// if(input == 3){
		// 	//kapow new move
		// } // new move 
		
		if(input == 3){ 
			System.out.println("You exited the shop!"); 
			System.out.println("Press w to continue on your merry way"); 
			return;
		} // exit
	} //end try

catch(Exception e){
		System.out.println("Invalid input. Please try again ");
		System.out.println("1. Adopt a Pomenon to add to your team! \n 2. Buy beans to buff your team! Beans can only be consumed once \n3. Exit");
		in.nextLine();
	} // catch 
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
										s+="|    ^~^  ,                            | ";
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
										s+="|    ^~^  ,                            | ";
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
		                s+="|    ^~^  ,                            | ";
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
 		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter ; Enter b for bag");
 if(!checkUsablePomenon(protag)){
	 System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
 }

 while (Character.compare(mappy.getPrev(),'E')!= 0 && !newMap ) {
   //.originalTile = mappy.mappy[mappy.initRow][mappy.initColumn];
   mappy.playerMove();
	 newMap = false;
	 if (Character.compare(mappy.getPrev(), 'C') == 0) {


		text = new File("pomecenter.map");
		Map center = new Map(text, 15, 8);
		System.out.println( "[2J" );
		System.out.println("\nHello traveller, welcome to the Pomecenter!\n");
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
		} // while it is not exit 

	} // center
   if(Character.compare(mappy.getPrev(), '#') == 0) {

     int randomInt = (int) (Math.random() * 5);
     System.out.println(randomInt);
     if (randomInt==3) {

       randomInt = (int) (Math.random() * 3);
       if(randomInt==0){
       Pomenon wild = new Trilantro();

       individualBattle(protag, wild );
			 System.out.println(randomInt);
			// randomInt = (int) (Math.random() * 5);
      }
			
			if(randomInt == 1){
				Pomenon wild = new Riverlotl();
				individualBattle(protag, wild);
				System.out.println(randomInt);
//randomInt = (int) (Math.random() * 5);
			}
			
			else{
				Pomenon wild = new Dinosinge();
				individualBattle(protag, wild);
				System.out.println(randomInt);
				//randomInt = (int) (Math.random() * 5);
   }


}
} // if it is grass? 

 System.out.println( "[2J" );
 System.out.println(mappy);
 		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter\n Enter b for Bag");
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
		Map center = new Map(text, 15, 8);
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


public void map3(){
	// text = new File("map1.map");
	// mappy = new Map(text);

		System.out.println( "[2J" );
	System.out.println(nap);
	nap.playerMove();

	System.out.println( "[2J" );
	System.out.println(nap);
		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");
	if(!checkUsablePomenon(protag)){
		System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
	}
	while (Character.compare(nap.getPrev(),'E')!= 0  ) {
		//.originalTile = mappy.mappy[mappy.initRow][mappy.initColumn];
		nap.playerMove();
		if(Character.compare(nap.getPrev(), 'S')== 0  ){
			this.map2();
		}
		if (Character.compare(nap.getPrev(), 'C') == 0) {


		text = new File("pomecenter.map");
		Map center = new Map(text, 15, 8);
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
		if(Character.compare(nap.getPrev(), '#') == 0) {

			int randomInt = (int) (Math.random() * 5);
			System.out.println(randomInt);
			if (randomInt==3) {

				randomInt = (int) (Math.random() * 5);
				if(randomInt==0){
				Pomenon wild = new Trilantro();

				individualBattle(protag, wild );
			 }
			 if (randomInt == 1 || randomInt == 2 || randomInt == 3){
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
	System.out.println(nap);
		System.out.println("Key: S = Go Back ; E = Exit ; C = Pomecenter");
	//System.out.println(mapotofu.getPrev());
	 if(!checkUsablePomenon(protag)){
		 System.out.println("Your pomenons have all fainted! Go to the nearest PomCenter");
	 }
} //end while

}//end map3




 //returns true if there is still one pom with >0 health. returns false if all are <=0 health
 public boolean checkUsablePomenon(Player gamer){
   for(Pomenon pom: gamer.getPlayerTeam()){
     if(! pom.checkDead()){
       return true;
     }
   }
   return false;
 }

// INSIDE CLASS

 class Map{


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


   public Map( File inputFile , int startCorRow, int startCorCol)
   {
  //   protag = new Player("filler", 50);
     // init 2D array to represent maze
     // (80x25 is default terminal window size)
     _maze = new char[10000][10000];
     height = 0;
     width = 0;
     initRow = startCorRow;
     initColumn = startCorCol;
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

        int compareB = Character.compare(moveKey, 'b');

       if (compareB== 0) {
         
         Game.this.inventory();
       }
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



} // class Map 






}
