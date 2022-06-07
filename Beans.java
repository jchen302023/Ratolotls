public class Bean extends Item {

	private String stat;

	public Bean() {
		super();
		stat = null;
	}

	public Bean( int price, String setStat ) {
		super( price, stat + " Bean");
		stat = setStat;
	}

	//use num beans on the pokemon
	public int useBean( Pomenon pokemon, int num ) {
		return 0;
	}
}

