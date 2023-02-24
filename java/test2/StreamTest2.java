package test2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//컨벤셜룰  65~90, 97~122
public class StreamTest2 {
    public static void main(String[] args) {
        List<String> SPELLS2= Arrays.asList("TOMAS","a","hELLO","B","korea","X","nutella");
       // Map<String,Integer> list = SPELLS2.stream().toMap(SPELLS2.stream(),SPELLS2.stream());

      //Map<String,Integer> m1 =SPELLS2.stream().flatMap(s->s.split(""))
        System.out.println(question1());


        System.out.println(question2());
    }
    private final static List<String> SPELLS= Arrays.asList("TOMAS","a","aELLO","B","korea","X","nutella");

    //list에 저장된 단어에 첫 번째 문자가 각각 몇개있는지 Map<String,Integer>로 반환 예)("X",1),("a",3)....
    static Map<String,Integer> question1(){
        return SPELLS.stream().map(spell->spell.substring(0,1)).collect(Collectors.toMap(head->head,head->2,(oldVal,newVal)->newVal+=oldVal));
    }
    //list에 저장된 단어들 중에서 단어의 길이가 2이상인 경우에 모든 단어를 대문자로 변환하여 구분자를 스페이스로 하는 문자열로 반환
    static String question2(){
        return SPELLS.stream().filter(s->s.length()>=2).map(s->s.toUpperCase()).collect(Collectors.joining(" "));
    }
}
