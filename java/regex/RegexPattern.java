package regex;

import java.util.regex.Pattern;

public class RegexPattern {
    public static void main(String[] args) {
        //문자열 형태의 정규표현식을 정규식 패턴으로 변환
        String patternString = "^[0-9]*$";
        Pattern pattern = Pattern.compile(patternString);
        //샘플 문자열
        String txt1 = "123123234";
        String txt2 = "123숫자00";

        boolean res1 = Pattern.matches("^[0-9]*$", txt1);
        System.out.println(res1);
        boolean res2 = Pattern.matches(pattern.pattern(), txt2);
        System.out.println(res2);
        System.out.println(pattern.pattern());

        Pattern p2 = Pattern.compile(",");
        for (String s : p2.split("12,31,41,51")) {
            System.out.println(s);
        }

        System.out.println(p2.asPredicate().test("13,24,52"));
    }
}
