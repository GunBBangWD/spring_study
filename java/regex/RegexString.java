package regex;


public class RegexString {
    public static void main(String[] args) {
        //matches() 포함 여부 판단하여 참거짓 반환
        String txt = "123456";
        boolean result1 = txt.matches("[0-9]+");
        System.out.println(result1);
        //reqlaceAll() 앞 인자 정규식 외에 것들을 뒤 인자것으로 변환
        String txt2 = "study2023*-;";
        String  result2 = txt2.replaceAll("[^a-z0-9]","!");  //숫자와 알파벳 제외 !로 변환
        System.out.println(result2);
        //split()
        String[] txts = txt2.split("[0-9]+"); // 인자를 기준으로 앞뒤로 분류하여 배열 반환
        for (String tt : txts) {
            System.out.println(tt);
        }

    }
}
