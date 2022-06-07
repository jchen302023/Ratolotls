
public class Moves {


protected String moveName;
protected int moveDamage;
protected PomType moveType;

//String mName, int mDamage, PomType mType
public Moves(){
  // moveName = mName;
  // moveDamage = mDamage;
  // moveType = mType; 
}
// ACCESSORS

public int getMoveDamage() {
  return moveDamage;
}

public PomType getMoveType() {
  return moveType;
}

public String getMoveName() {
  return moveName; 
}



}



class WaterGun extends Moves {
  
  // private String moveName;
  // private int moveDamage;
  // private PomType moveType;
  
  public WaterGun() {
    PomType WATER = new Water(); 
     
    moveName = "Watergun";
    moveDamage = 25;
    moveType = WATER; 
  }
} // watergun

class Smoke extends Moves {

	public Smoke() {
		PomType FIRE = new Fire();

		moveName = "Smoke";
		moveDamage = 10;
		moveType = FIRE;
	}
} //smoke

class LeafThrow extends Moves {

	public LeafThrow() {
		PomType PLANT = new Plant();

		moveName = "Leafthrow";
		moveDamage = 15;
		moveType = PLANT;
	}
} //leafthrow
