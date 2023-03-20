package ZE;

import java.util.*;

public class ArList_Skill {
    public static void main(String[] args) {
        //객체를 생성
        ArrayList<String> alist = new ArrayList<>();
        List<String> list = new ArrayList<>();
        //요소 추가
        alist.add("태종");
        alist.add("승진");
        alist.add("주환");
        alist.add(1,"소정");
        alist.add(2,"영화");
        System.out.println(alist);
        //요소 읽기
        System.out.println(alist.get(1));
        //요소 삭제
        System.out.println(alist);
        System.out.println(alist.remove(0));
        System.out.println(alist.remove(0));
        System.out.println(alist);
        System.out.println("--------------------------");
        System.out.println(alist.remove("태종")); //값이 같아야 삭제해줌
        System.out.println(alist);

        //요소 수정
        alist.set(2, "태일");
        System.out.println(alist);
        //요소의 개수
        System.out.println(alist.size());
        //요소의 검색
        System.out.println(alist.contains("승진")); //해당 값을 확인하여 true false 반환
        System.out.println(alist.indexOf("소정")); // 해당 값이 확인되면 index 반환
        //반복
        for(int i=0;i<alist.size();i++) {
            System.out.print(alist.get(i));
        }
        System.out.println();
        for(String str:alist) {
            System.out.print(str);
        }
        System.out.println("------------------------------------");

        //for문에서 이터레이터
//  for(Iterator<String> iter = alist.iterator();iter.hasNext();){
//   System.out.print(iter.next());
//  }
        Iterator<String> iter = alist.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();
        //전체 삭제
        alist.clear();
        //비어있는지 확인
        System.out.println(alist.isEmpty());
        //배열 정렬(sorting)
        alist.add("예진");
        alist.add("민성");
        alist.add("현우");
        alist.add("시우");
        alist.add("지민");
        alist.add("정기");
        System.out.println(alist);
        Collections.sort(alist); // 오른차순으로 정렬
        System.out.println(alist);
        Collections.sort(alist,Collections.reverseOrder()); // 내림차순으로 정렬
        System.out.println(alist);

        // 초기화와 동시에 값 넣기 주의 int[] 형처럼 primitive타입의 경우 반복문이나 Stream을 통해 하나씩 넣어야함
        ArrayList<String> alist2 =
                new ArrayList<>(
                        Arrays.asList("예진","민성","현우","시우","지민","정기"));
        System.out.println(alist2);
        ArrayList<String> alist3 =
                new ArrayList<>(
                        List.of("예진","민성","현우","시우","지민","정기"));
        System.out.println(alist3);

    }
}
