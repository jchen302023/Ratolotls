
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

class Tackle extends Moves {

	public Tackle() {
		PomType NORMAL = new Normal();

		moveName = "Tackle";
		moveDamage = 20;
		moveType = NORMAL;
	}
} //tackle

class HeadButt extends Moves {

	public HeadButt() {
		PomType NORMAL = new Normal();

		moveName = "Headbutt";
		moveDamage = 25;
		moveType = NORMAL;
	}
} //tackle

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

class BubbleBeam extends Moves {

	public BubbleBeam() {
		PomType WATER = new Water();

		moveName = "Bubblebeam";
		moveDamage = 20;
		moveType = WATER;
	}
} //bubblebeam

class Smoke extends Moves {

	public Smoke() {
		PomType FIRE = new Fire();

		moveName = "Smoke";
		moveDamage = 10;
		moveType = FIRE;
	}
} //smoke

class FireDance extends Moves {

	public FireDance() {
		PomType FIRE = new Fire();

		moveName = "Firedance";
		moveDamage = 30;
		moveType = FIRE;
	}
} //FireDance

class LeafThrow extends Moves {

	public LeafThrow() {
		PomType PLANT = new Plant();

		moveName = "Leafthrow";
		moveDamage = 15;
		moveType = PLANT;
	}
} //leafthrow

class SunBeam extends Moves {

	public SunBeam() {
		PomType FIRE = new Fire();

		moveName = "Sunbeam";
		moveDamage = 25;
		moveType = FIRE;
	}
} //leafthrow


