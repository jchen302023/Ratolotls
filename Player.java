import java.util.ArrayList; // import the ArrayList class

public class Player {
  
  // INSTANCEVARS
  
  private String playerName;
  private ArrayList<Pomenon> playerPomenons;
  // TODO private ArrayList<Items> bag;
  private int balance; //moneymoney chaching 

  // CONSTRUCTORS
  
  public Player(String pplayerName, int pbalance) {
    this.playerName = pplayerName;
    this.balance = pbalance; 
    playerPomenons = new ArrayList<Pomenon>(); 
  }

  public Pomenon addPomenon(Pomenon newMember) {
    this.playerPomenons.add(newMember);
    return newMember; 
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
  
// STRING PRINT PLAYER 

  public String toString(){
    String s = "";
    s+= "Name: "+ this.playerName;
    s+= "\nBalance: "+ this.balance;
    for(Pomenon p:playerPomenons){
      s+= "\nPomenons: "; 
      s+= "\n" + p.getName();
      //add more stuff later
    }
    return s;
  }

  // TESTCASE
  public static void main(String[] args){
    // Player me = new Player("Duke", 0); 
    // AxoMonPom axo = new AxoMonPom("Axomon", "Water", 25, 1, 0);
    // me.addPomenon(axo);
    // System.out.println(me);
  }
  
  
}