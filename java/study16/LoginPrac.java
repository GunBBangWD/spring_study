package study16;

class NoExistIDException extends Exception {
    public NoExistIDException() {}
    public NoExistIDException(String messge) {
        super(messge);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {}
    public WrongPasswordException(String message) {
        super(message);
    }
}

public class LoginPrac {
    public static void main(String[] args) {
        try {
            login("apple", "1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            login("java", "2345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static void login(String id,String  pw) throws Exception {
        String[] idar={"ajax", "java", "script", "css"};
        String[] idar2={"1234", "3424", "2345", "3456"};
        int index=-1;
        for (int i = 0; i < idar.length; i++) {
            if(idar[i].equals(id)) {
                index=i;
            }
        }
        if (index < 0) {
            throw new NoExistIDException("아이디가 존재하지 않읏다비다");

        } else if (!idar2[index].equals(idar2)) {
            throw new WrongPasswordException("암호가 틀립니다");
        } else {
            System.out.println("로그인 완료.");
        }


    }
}
