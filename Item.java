import java.util.*;

public class Item {

	protected int price;
	protected String name;

	public Item() {
		name = "filler";
		price = 0;
	}

	// public Item( int setPrice, String setName ) {
	// 	name = setName;
	// 	price = setPrice;
	// }
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price; 
	}
	
	public int setPrice(int newPrice) {
		int current = price;
		price = newPrice;
		return current;
	}

	//return -1 if you can't afford the item or decide not to buy it
	//return your new balance otherwise
	 public int buy( Player customer ) {
	
	 	Scanner in = new Scanner( System.in );
	 	String confirm;
	 	if ( customer.getBalance() < price ) {
			System.out.println("\nSorry, but you can not afford this item!"); 
			 			return -1;
		}
	 	//double check the player actually wants to buy the item
	 	System.out.println("Are you sure you want to buy " + name + " ?\nYes\t\t\tNo");
	 	try {
 			confirm = in.nextLine().toLowerCase().trim();
			if ( confirm.equals("yes") ) {
	 			customer.addToBag(this);
	 			customer.changeBal( -1 * price );
	 			return customer.getBalance();
	 		}
			else {
				System.out.println("Purchase cancelled");
			}
		
	 	} catch ( Exception e ) {
	 		System.out.println("Faulty input, cancelling buy...");
	 	} // catch exception
	 	return -1;
	 }
} // ITEM class

class Bean extends Item {
	protected PomType beanType;
	protected String statName; 
  protected int statChange;
	
	public Bean(){
		super();
		this.name = "Bean";
		this.price = 50;
		this.statName = "atk"; 
		this.statChange = 5; 
 	}
	
	
} // bean class

 class atkBean extends Bean {
	public atkBean(){
		super();
		this.name = "Protein Powder Bean";
		this.price = 50;
		this.statName = "atk"; 
		this.statChange = 5;
	}
	
} // attack bean 

class hpBean extends Bean {
	public hpBean(){
		super();
		this.name = "Heart Bean";
		this.price = 50;
		this.statName = "hp"; 
		this.statChange = 5;
	}
	
} // attack bean 