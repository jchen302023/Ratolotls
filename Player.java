import java.util.ArrayList; // import the ArrayList class
import java.util.*;

public class Player {

  // INSTANCEVARS

  private String playerName;
  private ArrayList<Pomenon> playerPomenons; // all the pomenons that you have caught
  private ArrayList<Pomenon> playerTeam; // the pomenons you selected to put on your team
  // TODO private ArrayList<Items> bag;
  private int balance; //moneymoney chaching

  // CONSTRUCTORS

  public Player(String pplayerName, int pbalance) {
    this.playerName = pplayerName;
    this.balance = pbalance;
    playerPomenons = new ArrayList<Pomenon>();
    playerTeam = new ArrayList<Pomenon>(); //max 3 poms
  }

  //TEAM SHENNANIGANS

  public Pomenon addPomenon(Pomenon newPom) {
    this.playerPomenons.add(newPom);
    return newPom;
  }

  public boolean addTeam(Pomenon newPom) {
    int teamCap = 3;
    if (playerTeam.size() == teamCap) {
      System.out.println("Don't got no space for this one");
      return false;
    }
    else {
      playerTeam.add(newPom);
    }
    return true;
  }

  public boolean swapTeam(int position, Pomenon newPom) {
    addPomenon(playerTeam.remove(position));
    playerTeam.add(position, newPom);
    return true;
  }



  // ACCESSORS

  public String getPlayerName() {
    return playerName;
  }
  public int getBalance() {
    return balance;
  }
  public ArrayList<Pomenon> getPlayerPomenons() {
    return playerPomenons;
  }

  public ArrayList<Pomenon> getPlayerTeam(){
    return playerTeam;
  }

  //MUTATORS

public void setName(String name) {
  this.playerName = name; 
}

// STRING PRINT PLAYER

  public String toString(){
    String s = "";
    s += "Name: "+ this.playerName + "\n";
    s += "Balance: "+ this.balance + "\n";
    s += "Team:\n";
    for( int i = 1; i < this.playerPomenons.size() || i < 7; i++ ) {
      s += "Member" + i + ": " + this.playerPomenons.get(i).getName() + "\n";
    } //add more stuff later
    return s;
  }

	public String listPomenons() {
		if ( this.playerPomenons.isEmpty() )
			return "Your team is empty.";
		String list = "TEAM:\n";
		for (int  i = 0; i < this.playerPomenons.size(); i++ ) {
			if ( i == 3 ) //3 or 6?
				list += "\nINVENTORY:\n";
			list += this.playerPomenons.get(i).getName();
		}
		return list;
	}

	public Pomenon releasePomenon( int pokemon ) {
		if ( this.playerPomenons.isEmpty() )
			return null;
		return this.playerPomenons.remove( pokemon );
	}
//FINISHH
// RETURNS THE POSITION OF THE POMENON IN THE ARRAYLIST
  public int choosePomenon() {
    String s = "";
    int chosen = 0;

    s += "Which Pomenon would you like to choose?";
    System.out.println(s);

    Scanner userIn = new Scanner(System.in);

    for (int i = 1; i <= this.getPlayerTeam().size(); i ++) {
      System.out.println(i + " : "+ playerTeam.get(i-1).getName() );
    }

    while (true) {
      try{

        boolean shouldBreak = true;

        int moveNum = userIn.nextInt();

        if(moveNum>3 || moveNum <= 0){
          System.out.println("Try again. Invalid Pomenon number. Choose number from 1-3");
          shouldBreak = false;
        }

        if(moveNum == 1){
          if (playerTeam.get(moveNum - 1).checkDead()) {
            System.out.println("You can not use this Pomenon. Choose again.");
            shouldBreak = false;
          }
          else {
            chosen = moveNum - 1;
            shouldBreak = true;
          }
        }

        else if(moveNum == 2){
          if (playerTeam.get(moveNum - 1).checkDead()) {
            System.out.println("You can not use this Pomenon. Choose again.");
            shouldBreak = false;
          }
          else {
            chosen = moveNum - 1;
            shouldBreak = true;
          }
        }

        else if(moveNum == 3){
          if (playerTeam.get(moveNum - 1).checkDead()) {
            System.out.println("You can not use this Pomenon. Choose again.");
            shouldBreak = false;
          }
          else {
            chosen = moveNum - 1;
            shouldBreak = true;
          }
        }


        if(shouldBreak){
          System.out.println("You chose "+ playerTeam.get(moveNum - 1).getName());

          break;
        }

      }
      catch(Exception e){
          System.out.println("Invalid Pomenon. Re-enter a number.");

          userIn.nextLine();
        }
}

    
    return chosen;


}


  // TESTCASE
  // public static void main(String[] args){
  //   // Player me = new Player("Duke", 0);
  //   // AxoMonPom axo = new AxoMonPom("Axomon", "Water", 25, 1, 0);
  //   // me.addPomenon(axo);
  //   // System.out.println(me);
  // }


}
