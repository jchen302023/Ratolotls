// import java.util.ArrayList; // import the ArrayList class
// import java.util.*;
//
// // OUR LITTLE LAB AXO FOR TESTING :)
// // DONT WORRY WE TREAT HIM WELL
//
// public class AxoMonPom extends Pomenon {
//
//   private String name;
//   private PomType type;
//   private int health;
//   private int level;
//   private int experience;
//
//   public AxoMonPom(String pname,PomType ptype, int phealth, int plevel, int pexperience) {
//
//     super(pname, ptype, phealth, plevel, pexperience);
//
//   }
//
//   public static void main(String[] args){
//
//     PomType Water = new PomType("Water");
//     Water.addWeaknesses("Plant");
//     Water.addStrengths("Fire");
//     Moves BubbleBeam = new Moves("BubbleBeam", 5, Water);
//     AxoMonPom Pom = new AxoMonPom("Axomon", Water, 25, 1, 0); // make new AxoMon
//     Pom.addMove(BubbleBeam);
//
//     PomType Fire = new PomType("Fire");
//     Fire.addWeaknesses("Water");
//     Fire.addStrengths("Plant");
//     Moves FireBlast = new Moves("FireBlast",5, Fire);
//     AxoMonPom Raticate = new AxoMonPom("Raticate", Fire, 50, 1, 0);
//     Raticate.addMove(FireBlast);
//
//
//     System.out.println(Pom.getName());
//     System.out.println(Pom.getType().getTypeName());
//     System.out.println(Pom.getHealth());
//     System.out.println(Pom.getLevel());
//     System.out.println(Pom.getXP());
//
//     Pom.setName("PomPom");
//     Pom.setHealth(Pom.getHealth()+12);
//     Pom.setLevel(Pom.getLevel()+1);
//
//     System.out.println(Pom.getName());
//     System.out.println(Pom.getHealth());
//     System.out.println(Pom.getLevel());
//
//     // FIGHT!!
//
//     while (!(Raticate.checkDead())){
//       Pom.attack(BubbleBeam, Raticate);
//       System.out.println("dying rat: "+Raticate.getHealth());
//
//     }
//
//     while (!(Pom.checkDead())){
//       Raticate.attack(FireBlast, Pom);
//       System.out.println("dying " + Pom.getName() + ": "+ Pom.getHealth());
//
//     }
//
//
//
//   }
//
//
//
// }
