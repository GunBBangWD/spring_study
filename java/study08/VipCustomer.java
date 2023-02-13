package study08;

public class VipCustomer extends Customer {
	private double saleRatio; //할인율
	private Manager manager; //담당 관리자
	
	public VipCustomer(String customerName,String managerName) {
		super(customerName);
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
		manager=new Manager(managerName);
		System.out.println("VIPcustomer 생성자");
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint +=price*bonusRatio;
		return price-(int)(price*saleRatio);
	}

	@Override
	public String getCustomerInfo() {
		return super.getCustomerInfo()
				+"|매니저:"+manager.getManagerName();
	}
	
	public Manager getManager() {
		return manager;
	}
	
	
	
	

}
