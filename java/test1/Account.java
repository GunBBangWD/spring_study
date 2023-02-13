package test1;

public class Account {
	//필드
    int id;
    String password;
    String ownerName;
    int balance;
	//생성자
    Account(int id,String password,String ownerName){
        this.id=id;
        this.password=password;
        this.ownerName=ownerName;
        this.balance=0;
    }
	//메소드
    public void deposit(int money){
        balance += money;
    }
    public int withdraw(int money,String password){
        if(isCorrectPassword(password)){
            if(balance>=money){
                balance -= money;
                return balance;
            }else{ return -2;} //잔액 부족
        }else{
            return -1; //암호 틀림
        }
    }
	public int checkBalance(String password){
        if(isCorrectPassword(password)){
            return balance;
        }else{
            return -1; //암호 틀림
        }
    }
	public boolean isCorrectPassword(String password){
        return this.password.equals(password)?true:false;
    }
    public void showResult(int result){
        String s = "";
        switch(result){
            case -1:
                s="암호 부정확";
                break;
            case -2:
                s="잔액부족";
                break;
            default:
                s=Integer.toString(result);
        }
        System.out.println(s);
    }
	public static void main(String[] args) {
		//계좌 생성
		Account account = new Account(1,"password!@#","park");
		//10만원 입금
		account.deposit(100000);
		//잔액 확인
		account.showResult(account.checkBalance("password!@#"));
		//2만원 출금
		account.showResult(account.withdraw(200000000,"password!@#"));
		//잔액 확인
		account.showResult(account.checkBalance("password!@#"));
	}
}
