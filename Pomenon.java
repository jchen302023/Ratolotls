import java.util.ArrayList; // import the ArrayList class

public class Pomenon {

  // Instance vars
  private String name;
  private PomType type;
  private int health;
  private int level;
  private int experience;
  private ArrayList<Moves> moves;

  //wat else

//overload
//don't forget to add moves to constructor
  public Pomenon(String pname, PomType ptype, int phealth, int plevel, int pexperience) {
    this.name = pname;
    this.type = ptype;
    this.health = phealth;
    this.level = plevel;
    this.experience = pexperience;
    moves = new ArrayList<Moves>();
  }

  // accessors

  public String getName() {
    return name;
  }

  public PomType getType(){
    return type;
  }

  public ArrayList<String> getWeaknesses(){
    return type.getWeaknesses();
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

  public ArrayList<Moves> getMoves() {
    return moves;
  }

  public String setName(String newName){
    String ret = this.name;
    this.name = newName;
    return ret;
  }

//no need for set type because type should not be changed

  public Moves addMove(Moves newMove){
    this.moves.add(newMove);
    return newMove;
  }

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


  public boolean attack(Moves myMove, Pomenon enemy) {
      PomType myType = this.type;
      PomType enemyType = enemy.getType();
        int damage = myMove.getMoveDamage();

      if(isWeakness(myMove.getMoveType(), enemyType)){
        damage = (int) (damage * 1.5);
      }

      enemy.setHealth(enemy.getHealth() - damage);
      return true;
  }

  public boolean isWeakness(PomType myType, PomType enemyType) { //myType is a weakness of enemyType
    //my move does extra damage to enemy
      for(String t : enemyType.getWeaknesses()) {
        if (t.equals(myType.getTypeName())){
          return true;
        }
      }
      return false;
  }

  public boolean checkDead() {
    return health <= 0;
  }





}
