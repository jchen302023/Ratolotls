
public class Moves {


private String moveName;
private int moveDamage;
private PomType moveType;

public Moves(String mName, int mDamage, PomType mType){
  moveName = mName;
  moveDamage = mDamage;
  moveType = mType; 
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
