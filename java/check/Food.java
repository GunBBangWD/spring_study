package check;

public class Food {
	//치킨 34인분, 왕만두 10인분, 쌀국수 12인분
	//가격 치킨:25000원, 왕만두:5000원, 쌀국수:8500원
	/*
		치킨 x 34 = 850000
		왕만두 x  10 = 50000  
		쌀국수 x  12 = 102000  
		===================
		총합: 1002000
	 */
	public static void main(String[] args) {
		String menu1="치킨",menu2="왕만두",menu3="쌀국수";
		int price1=25000,price2=5000,price3=8500;
		int order1=34,order2=10,order3=12;
		int pay1=price1*order1;
		int pay2=price2*order2;
		int pay3=price3*order3;
		int total = pay1+pay2+pay3;

		System.out.printf("%s X %d = %d%n",menu1,price1,pay1);
		System.out.printf("%s X %d = %d%n",menu2,price2,pay2);
		System.out.printf("%s X %d = %d%n",menu3,price3,pay3);
		System.out.println("=======================");
		System.out.printf("총합: %d",total);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
