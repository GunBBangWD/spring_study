package study15_1;


import java.util.Scanner;
import java.util.TreeMap;

public class dictionaryPrac {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary();
        Scanner scan = new Scanner(System.in);
        dic.addWord("baby", "아기");
        dic.addWord("love", "사랑");
        dic.addWord("appple", "사과");

        System.out.println("=======영한사전==============");
        while (true) {
            System.out.println("찾는 영단어: ");
            String input = scan.next();
            if (input.equals("그만")) {
                System.out.println("종류");
                break;
            }
            String output = dic.translate(input);
            if (output.isEmpty()) {
                System.out.println("사전에 없는 단어 입니다");
                System.out.println("사전에 추가하시겠습니까 Y/N");
                String ans = scan.next().toUpperCase();
                if (ans.equals("Y")) {
                    System.out.println("단어 : " + input);
                    System.out.println("의미: ");
                    String kor = scan.next();
                    dic.addWord(input, kor);
                }
            } else {
                System.out.println("의미: " + output);
            }
        }
    }
}

class Dictionary {
    private TreeMap<String, String> dic;
    public Dictionary() {
        dic = new TreeMap<String, String>();
    }
    public boolean addWord(String eng, String kor) {
        dic.put(eng, kor);
        return true;
    }

    public void delWord(String eng) {
        dic.remove(eng);
    }
    public void correctWort(String eng,String kor){
        dic.replace(eng, kor);
    }
    public String translate(String eng) {
        return dic.getOrDefault(eng,"");
    }
    public TreeMap<String, String> getDic() {return dic;}
    public void setDic(TreeMap<String, String> dic) {this.dic = dic;}
}