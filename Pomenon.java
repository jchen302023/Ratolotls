import java.util.ArrayList; // import the ArrayList class

public class Pomenon {
  
  // Instance vars
  private String name;
  private String type;
  private int health; 
  private int level;
  private int experience; 

  // private ArrayList<Moves> moves; ** TODO!!
  //wat else

//overload  
//don't forget to add moves to constructor 
  public Pomenon(String pname, String ptype, int phealth, int plevel, int pexperience) {
    this.name = pname;
    this.type = ptype; 
    this.health = phealth;
    this.level = plevel; 
    this.experience = pexperience; 
  }

  // accessors
  
  public String getName() {
    return name;
  }

  public String getType(){
    return type;
  }

  public int getHealth(){
    return health;
  }

  public int getLevel(){
    return level;
  }
  
  public int getXP() {
    return experience; 
  }
  
  public String setName(String newName){
    String ret = this.name;
    this.name = newName;
    return ret;
  }

//no need for set type because type should not be changed

  public int setHealth(int newHealth){
    int ret = this.health;
    this.health = newHealth;
    return ret;
  }

  public int setLevel(int newLevel){
    int ret = this.level;
    this.level = newLevel;
    return ret;
  }

  public int setXP(int newXP){
    int ret = this.experience;
    this.experience = newXP;
    return ret;
  }

/* 
TODO
  public boolean attack(Pomenon me, Pomenon enemy )
  public boolean checkDead() - returns true if dead because 0 health 
  public 

*/
  


  
}