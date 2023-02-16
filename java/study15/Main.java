//package study15;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static void clear() {
//        for (int i = 0; i < 14; i++) {
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) throws InterruptedException {
//        //이름 혹은 전화번호로 개인정보 찾기 프로그램(시간,공간 복잡도 생각x,급하게 와가지고..)
//        //완성시간 1시간 26분..(흡연시간 포함)
//        BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
//        PersonList l = new PersonList();
//        ArrayList<String> k;
//
//        l.addPerson("공", "가리봉", "1234");
//        l.addPerson("공2", "가리봉2", "1235");
//        l.addPerson("공3", "가리봉3", "1236");//디버깅 겸 계정 넣기
//        while(true) {
//            try {
//                clear();
//                System.out.println("개인정보 조회 메뉴");
//                System.out.println("1:이름으로 찾기, 2.전화번호로 찾기 3.종료");
//                int token = Integer.parseInt(n.readLine());
//                switch(token) {
//                    case 1:
//                        System.out.println("이름을 입력하십시오");
//                        String name = n.readLine();
//                        //찾는 메소드란
//                        k=l.showPersonByName(name);
//                        if(k.size()==0)System.out.println("찾는 이름의 사람이 없습니다.");else {
//                            for (String s : k) {
//                                System.out.println(s);
//                            }//결과 값 출력
//                            Thread.sleep(1000);
//                            Thread.sleep(1000);
//                        }
//
//                        break;
//                    case 2:
//                        System.out.println("전화번호를 입력하십시오");
//                        String phoneNum = n.readLine();
//                        //전화번호로 개인정보 찾는 란
//                        clear();
//                        k=l.showPersonByNum(phoneNum);
//                        if(k.size()==0) {System.out.println("찾는 전화번호가 없습니다.");}else {
//                            for (String s : k) {
//                                System.out.println(s);
//                            }//결과 값 출력
//                            Thread.sleep(1000);
//                            Thread.sleep(1000);
//                        }
//                        break;
//
//                    case 3:
//                        System.out.println("정말 프로그램을 종료하시겠습니까? (y/n)");
//                        String exit = n.readLine();
//                        if((exit.equals("y"))||(exit.equals("Y"))) {
//                            return;//종료
//                        }else if((exit.equals("x"))||(exit.equals("X"))) {
//                            System.out.println("프로그램을 계속합니다.");
//                            Thread.sleep(1000);
//                            Thread.sleep(1000);
//                        }else {
//                            System.out.println("y,n외의 값으로 잘못 입력하셨습니다.");
//
//                            Thread.sleep(1000);
//                            Thread.sleep(1000);
//                        } break;
//                    default:System.out.println("1,2외에 잘못된 값을 입력하셨습니다.");
//
//                }
//            } catch (IOException e) {
//                System.out.println("잘못된 값을 입력하셨습니다");
//            }
//
//        }
//    }
//
//}
//
//class PersonInfo {
//    private String name;
//    private String address;
//
//    PersonInfo(String n,String ad){
//        name=n;
//        address=ad;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getAddress() {
//        return address;
//    }
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//
//}
//
//class PersonList {
//    HashMap<String,PersonInfo> m;
//
//    PersonList(){
//        m=new HashMap<>();
//    }
//    void addPerson(String name,String address,String num){
//        m.put(num,new PersonInfo(name,address));
//
//    }//개인정보 추가 메소드(이름으로)
//    ArrayList<String> showPersonByName(String name){
//        //personInfo의 이름가지고 찾고
//        //객체를 map에 집어 넣었을때 조회하는 기능
//        //이 두 과정을 한다
//        ArrayList<String> list = new ArrayList<>();
//
//        Set<Map.Entry<String,PersonInfo>> a = m.entrySet();
//
//        Iterator<Map.Entry<String,PersonInfo>> b = a.iterator();
//
//        while(b.hasNext()) {
//            Entry<String,PersonInfo> c = (Entry<String, PersonInfo>) b.next();
//            PersonInfo info = c.getValue();
//            if(info.getName().equals(name)) {
//                list.add("이름:"+info.getName()+" 전화번호:"+c.getKey()+" 주소:"+info.getAddress());
//            }
//        }
//        return list;
//    }//개인정보 추가 메소드(전화번호로)
//    ArrayList<String> showPersonByNum(String n){
//        ArrayList<String> list = new ArrayList<>();
//        Set<Map.Entry<String,PersonInfo>> a = m.entrySet();
//        Iterator<Map.Entry<String,PersonInfo>> b = a.iterator();
//
//        while(b.hasNext()) {
//            Entry<String,PersonInfo> c = (Entry<String, PersonInfo>) b.next();
//            if(n.equals(c.getKey())) {
//                String info = c.getKey();
//                if(c.getValue().equals(m.get(info))) {
//                    list.add("이름:"+m.get(info).getName()+" 전화번호:"+info+"주소:"+m.get(info).getAddress());
//                }
//            }
//        }
//        return list;
//    }
//
//}
