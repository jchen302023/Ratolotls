import java.util.ArrayList; // import the ArrayList class
import java.util.*;
import java.lang.Integer;


public class Pomenon {

  // Instance vars
  protected String name;
  protected PomType type;
  protected int health;
  protected int maxHealth;
  protected int level;
  protected int experience;
  protected ArrayList<Moves> moves;

  //wat else

//overload
//don't forget to add moves to constructor
//String pname, PomType ptype, int phealth, int pmax, int plevel, int pexperience
  public Pomenon() {
    this.name = "John";
    // this.type = ptype;
    this.health = 100;
    this.maxHealth = 100;
    this.level = 1;
    this.experience = 0;
    this.moves = new ArrayList<Moves>();
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

  public int getMaxHealth() {
    return maxHealth;
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

  public int chooseMove(Pomenon me, Pomenon enemy){
    ArrayList<Moves> myMoves = me.getMoves();
    String s = "";
    int chosen;

      System.out.println("Please input move: ");
      for(int i = 1; i <= myMoves.size() ; i++){
        System.out.println(i + " : "+ myMoves.get(i-1).getMoveName() );
      }
        Scanner userIn = new Scanner(System.in);
    while(true){
      try{

        boolean shouldBreak = true;

        int moveNum = userIn.nextInt();
        chosen = moveNum;

        if(moveNum>4 || moveNum <= 0){
          System.out.println("Try again. Invalid move number. Choose number from 1-4");
          shouldBreak = false;
        }

        if(moveNum == 1){
          System.out.println("You chose "+ myMoves.get(moveNum - 1).getMoveName());
          this.attack(me, myMoves.get(0), enemy);
          this.attack(enemy, enemy.getMoves().get((int)Math.random()*4), me);
        }

        if(moveNum == 2){
          System.out.println("You chose "+ myMoves.get(moveNum - 1).getMoveName());
          this.attack(me, myMoves.get(1), enemy);
          this.attack(enemy, enemy.getMoves().get((int)Math.random()*4), me);
        }

        if(moveNum == 3){
          System.out.println("You chose "+ myMoves.get(moveNum - 1).getMoveName());
          this.attack(me, myMoves.get(2), enemy);
          this.attack(enemy, enemy.getMoves().get((int)Math.random()*4), me);
        }
        if(moveNum == 4){
          System.out.println("You chose "+ myMoves.get(moveNum - 1).getMoveName());
          this.attack(me, myMoves.get(3), enemy);
          this.attack(enemy, enemy.getMoves().get((int)Math.random()*4), me);
        }



        if(shouldBreak){
          //System.out.println("You chose "+ myMoves.get(moveNum - 1).getMoveName());

          break;
        }

      }
      catch(Exception e){
          System.out.println("Invalid move. Re-enter your move.");

          userIn.nextLine();
        }

    }

    return chosen;

  }




  public boolean attack(Pomenon me, Moves myMove, Pomenon enemy) {
      PomType myType = this.type;
      PomType enemyType = enemy.getType();
        int damage = myMove.getMoveDamage();

      if(isWeakness(myMove.getMoveType(), enemyType)){
        damage = (int) (damage * 1.5);
      }

      enemy.setHealth(enemy.getHealth() - damage);
      System.out.println(me.getName() + " did " + damage + " damage to " + enemy.getName() + "!");
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






public static void main(String[] args){

  // Pomenon POMMY = new Pomenon();
  // Pomenon.Riverlotl pommy = POMMY.new Riverlotl();
  // pommy.setName("pommy");
  // Pomenon ENEMIE = new Pomenon();
  // Pomenon.Riverlotl enemie = ENEMIE.new Riverlotl();
  // enemie.setName("enemie");

  Player meme = new Player("i am a meme", 0);
  // // PomType water = new PomType.Water();
  // Pomenon pommy = new Pomenon("pommy", water, 200, 100, 1, 0 );
  // Pomenon enemie = new Pomenon("enemie", water, 100, 100, 1, 0);
  // Moves watergun = new Moves("water gun", 25, water);
  // Moves WATERGUN = new Moves();
  // Moves.WaterGun watergun = WATERGUN.new WaterGun();

  Riverlotl POMMY = new Riverlotl();
  Riverlotl ENEMIE = new Riverlotl();
  Moves WATERGUN = new WaterGun();

//  Dinosinge NICENICEGUY = new Dinosinge();

  POMMY.addMove(WATERGUN);
  ENEMIE.addMove(WATERGUN);
  ENEMIE.addMove(WATERGUN);
  ENEMIE.addMove(WATERGUN);
  ENEMIE.addMove(WATERGUN);
  meme.addTeam(POMMY);

  System.out.println(ENEMIE.getName());

  Game newGame = new Game();
  newGame.individualBattle(meme, ENEMIE);
} // main


} //end class


class Riverlotl extends Pomenon {

  //private ArrayList<Moves> moves = new ArrayList<Moves>();
  
  public Riverlotl() {
    super();

    this.name = "Riverlotl";

    PomType WATER = new Water();
    this.type = WATER;
    
    Moves WATERGUN = new WaterGun();

    this.addMove(WATERGUN); 

    moves.add(WATERGUN); 
      moves.add(WATERGUN); 
        moves.add(WATERGUN); 
          moves.add(WATERGUN); 
          
      
    // this.addMove(WATERGUN); 
    // this.addMove(WATERGUN); 
    // this.addMove(WATERGUN); 


  }


} // Riverlotl (Starter water)


class Dinosinge extends Pomenon {

	public Dinosinge() {

		super();

		this.name = "Dinosinge";

		PomType FIRE = new Fire();
		this.type = FIRE;
    
    Moves SMOKE = new Smoke();
    moves.add(SMOKE);
      moves.add(SMOKE);
        moves.add(SMOKE);
          moves.add(SMOKE);
	}


} // Dinosinge (Starter fire)

class Trilantro extends Pomenon {

  public Trilantro() {
    super();

    this.name = "Trilantro";

    PomType PLANT = new Plant();
    this.type = PLANT;
  }


} // Ackwron (Starter water)