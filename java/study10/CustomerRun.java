package study10;

public class CustomerRun {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.buy();
		customer.sell();
		customer.order();
		customer.comp();
		
		Buy buyer = customer;
		buyer.buy();
		buyer.order();
		//buyer.sell();
		//buyer.comp();
		
		Sell seller = customer;
		seller.sell();
		seller.order();
		//seller.buy();
		//seller.comp();
	}
}
