package bankLogic;

public enum Currency {
	BLR, USD,EUR,PLN;
	
	
	public static void ñurrencyMenu(){
		System.out.println("1 - Currency BLR");
		System.out.println("2 - Currency EUR");
		System.out.println("3 - Currency PLN");
		System.out.println("4 - Currency USD");
		System.out.println("5 - Back");
	}
	
	public static Currency typeCurrency(int choice){
			Currency cur = null;
		switch(choice){
			case 1:
				cur = Currency.BLR;
				break;
			case 2:
				cur = Currency.EUR;
				break;
			case 3:
				cur = Currency.PLN;
				break;
			case 4:
				cur = Currency.USD;
				break;
			default:
				System.out.println("Somethink wrong");
				break;
		}
		return cur;
	}
}

