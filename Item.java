import java.util.*;

public class Item {

	protected int price;
	protected String name;
	protected int statChange;
	protected String statName;

	public Item() {
		name = "filler";
		price = 0;
		statName = "hp";
		statChange = 5; 
	}

	// public Item( int setPrice, String setName ) {
	// 	name = setName;
	// 	price = setPrice;
	// }
	
	public String getName() {
		return name;
	}
	public int getStatChange() {
		return statChange;
	}
	
	public int getPrice() {
		return price; 
	}
	
	public int setPrice(int newPrice) {
		int current = price;
		price = newPrice;
		return current;
	}

	
	public String getStatName() {
		return statName; 
	}
	//return -1 if you can't afford the item or decide not to buy it
	//return your new balance otherwise
	 public int buy( Player customer, Item buying ) {
	
	 	Scanner in = new Scanner( System.in );
	 	int confirm;
	 	if ( customer.getBalance() < price ) {
			System.out.println("\nSorry, but you can not afford this item!"); 
			 			return -1;
		}
	 	//double check the player actually wants to buy the item
	 	System.out.println("\nAre you sure you want to buy " + name + " ?\n1. Yes\t\t\t2. No");
	 //	try {
 			// confirm = in.nextLine().toLowerCase().trim();
			confirm = in.nextInt();
		
			
			if ( confirm == 1) {
		
	 			customer.addToBag(buying);
		
	 			customer.changeBal( -1 * price );
			
				System.out.println("You have bought the "+name);
				System.out.println("Your balance is now "+customer.getBalance());
						System.out.print("\n1. Protein Powder Bean\n2. Heart Bean\n3. Exit\n");
	 			return customer.getBalance();
	 		}
			if (confirm == 2) {
				System.out.println("Purchase cancelled");
						System.out.print("\n1. Protein Powder Bean\n2. Heart Bean\n3. Exit\n");
			}

		
	 	//} 
		// catch ( Exception e ) {
	 	// 	System.out.println("Faulty input, cancelling buy...");
	 	// } // catch exception
	 	return -1;
	 }
} // ITEM class

class Bean extends Item {
	protected PomType beanType;
	// protected String statName; 
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