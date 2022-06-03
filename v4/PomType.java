import java.util.ArrayList; // import the ArrayList class

public class PomType {

  protected String typeName;
  protected ArrayList<String> weaknesses;
  protected ArrayList<String> strengths;

  public PomType() {
    // typeName = ptype;
    weaknesses = new ArrayList<String>();
    strengths = new ArrayList<String>();
  }

  //mutators

  public String addWeaknesses(String adding){
    this.weaknesses.add(adding);
    return adding;
  }

  public String addStrengths(String adding) {
    this.strengths.add(adding);
    return adding;
  }
  // accessors

  public String getTypeName() {
    return typeName;
  }

  public ArrayList<String> getWeaknesses(){
    return weaknesses;
  }

  public ArrayList<String> getStrengths(){
    return strengths;
  }

  //NESTED TYPE?



}

class Water extends PomType{

  // private String typeName;
  // private ArrayList<String> weaknesses;
  // private ArrayList<String> strengths;

  public Water() {
    typeName = "Water";
    weaknesses = new ArrayList<String>();
    weaknesses.add("Plant");
    strengths = new ArrayList<String>();
    strengths.add("Fire");
  }


} // Water
