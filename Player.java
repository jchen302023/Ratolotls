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

  public void choosePomenon() {
    String s = "";
    s += "Which Pomenon would you like to choose?";
    for (int i = 1; i <= this.getPlayerTeam().size(); i ++) {
      System.out.println(); 
    }
  }
  
  
  
  // TESTCASE
  public static void main(String[] args){
    // Player me = new Player("Duke", 0);
    // AxoMonPom axo = new AxoMonPom("Axomon", "Water", 25, 1, 0);
    // me.addPomenon(axo);
    // System.out.println(me);
  }


}
