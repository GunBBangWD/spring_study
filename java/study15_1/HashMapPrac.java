package study15_1;

import study15.Member;

import java.util.*;

public class HashMapPrac {
    public static void main(String[] args) {
        PersonInfoList pList =new PersonInfoList();
        pList.addPersonInfo("인순이","010-1111-1111","서울");
        pList.addPersonInfo("권보아","010-2222-2222","대전");
        pList.addPersonInfo("이보람","010-3333-3333","대구");
        pList.addPersonInfo("권보아","010-4444-4444","대전");
        Scanner scan = new Scanner(System.in);
        System.out.println("전화번호 목록 검색기");
        while (true) {
            System.out.println("조회대상 선택 \n1.이름\n2.전화번호\n3.종료");
            System.out.print("선택: ");
            int menu = scan.nextInt();
            if (menu == 1) {
                System.out.print("검색: ");
                String search = scan.next();
                System.out.println(pList.getPersonInfoWithName(search));
            } else if (menu == 2) {
                System.out.print("전화번호로 검색: ");
                String search = scan.next();
                String result = pList.getPersonInfoWithTel(search);
                System.out.println(result);
            }else break;
        }

    }
}

class PersonInfo {
    private String name;
    private String address;
    public PersonInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
}

class PersonInfoList {
    private String telNum;
    private HashMap<String, PersonInfo> pList;
    public PersonInfoList() {
        pList = new HashMap<String, PersonInfo>();
    }
    void addPersonInfo(String name, String telNum, String address) {
        PersonInfo pInfo = new PersonInfo(name, address);
        pList.put(telNum, pInfo);
    }

    public String getPersonInfoWithName(String name) {
        Set<String> set = pList.keySet();
        StringBuffer sb = new StringBuffer();
        for(String key:set) {
            if(pList.get(key).getName().contains(name)) {
                sb.append("||이름: "+pList.get(key).getName()+"||전화번호: "+key+"||주소"+pList.get(key).getAddress()+"\n");
            }
        }
        if(sb!=null){
            return sb.toString();
        }
        return "대상이 없습니다";
    }

    public String getPersonInfoWithTel(String telNum) {
        Set<String> set = pList.keySet();
        StringBuffer sb = new StringBuffer();
        for(String key:set) {
            if(key.contains(telNum)) {
                sb.append("||이름: "+pList.get(key).getName()+"||전화번호: "+key+"||주소"+pList.get(key).getAddress()+"\n");
            }
        }
        if(sb!=null){
            return sb.toString();
        }
        return "대상이 없습니다";
    }
}
