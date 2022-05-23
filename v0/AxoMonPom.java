import java.util.ArrayList; // import the ArrayList class

public class AxoMonPom extends Pomenon {
  
  private String name;
  private String type;
  private int health; 
  private int level;
  private int experience; 
  
  public AxoMonPom(String pname, String ptype, int phealth, int plevel, int pexperience) {
    
    super(pname, ptype, phealth, plevel, pexperience);
    
  }
  
  public static void main(String[] args){
    
    AxoMonPom Pom = new AxoMonPom("Axomon", "Water", 25, 1, 0); // make new AxoMon 
    
    System.out.println(Pom.getName());
    System.out.println(Pom.getType());
    System.out.println(Pom.getHealth());
    System.out.println(Pom.getLevel());
    System.out.println(Pom.getXP());
    
    Pom.setName("PomPom");
    Pom.setHealth(Pom.getHealth()+12);     
    Pom.setLevel(Pom.getLevel()+1);
    
    System.out.println(Pom.getName());
    System.out.println(Pom.getHealth());
    System.out.println(Pom.getLevel());
  }
  

  
}