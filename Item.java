import java.util.*;

public class Item {

	private int price;
	public String name;

	public Item() {
		name = "filler";
		price = 0;
	}

	public Item( int setPrice, String setName ) {
		name = setName;
		price = setPrice;
	}

	//return -1 if you can't afford the item or decide not to buy it
	//return your new balance otherwise
	// public int buy( Player customer ) {
	//
	// 	Scanner in = new Scanner( System.in );
	// 	String confirm;
	// 	if ( customer.getBalance() < price )
	// 		return -1;
	//
	// 	//double check the player actually wants to buy the item
	// 	System.out.println("Are you sure you want to buy " + name + " ?\nYes\t\t\tNo");
	// 	try {
	// 		confirm = in.nextLine().toLowerCase().trim();
	// 	} catch ( Exception e ) {
	// 		System.out.println("Faulty input, cancelling buy...");
	// 	}
	//
	// 	if ( confirm.equals("yes") ) {
	// 		customer.addToBag(this);
	// 		customer.changeBal( -1 * price );
	// 		return customer.getBalance();
	// 	}
	//
	// 	return -1;
	// }
}
