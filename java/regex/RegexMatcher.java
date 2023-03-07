package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
    public static void main(String[] args) {
        String txt = "2023자바";
        String patternString = "^[0-9]+";
        //1) 문자열을 정규식 패턴으로 변환
        Pattern pattern = Pattern.compile(patternString);
        //2) 패턴 객체를 matcher메소드로 매처 객체로 변환
        Matcher matcher = pattern.matcher(txt);
        //3) 정규식 처리 결과를 담은 matcher에서 메소드로 결과를 출력
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        System.out.println("---------------------");
        String target = "java2023!@#;regex66#$%8080";
        Pattern p1 = Pattern.compile("[a-z]+[0-9]+");
        Matcher m1 = p1.matcher(target);
//        Matcher m2 = Pattern.compile(("[a-z]+[0-9]+")).matcher("java2023!@#;regex66#$%8080");
        while (m1.find()) {
            System.out.println(m1.group());
        }

        String t2 = "010-4632-1290, 02-889-7661";
        String p2 = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
        Matcher m2 = Pattern.compile(p2).matcher(t2);

        System.out.println("----------");
        int i=0;
        while (m2.find()){
            System.out.println(++i + ":" + m2.group(0) + "->" + m2.group(1) + " & " + m2.group(2) + " & " + m2.group(3));
        }

        String t3 = "나비야 나비야 이리 날아오너라 호랑나비 흰나비 이리 날아오너라";
        String p3 = "나비";
        Matcher m3 = Pattern.compile(p3).matcher(t3);
        while (m3.find()) {
            System.out.println("매칭되는 문자열 위치: " + m3.start() + "~" + m3.end());
        }

    }
}
