package study14Download1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListRun {
	public static void main(String[] args) {
		LinkedList<String> llist = new LinkedList<>();
		//추가
		llist.add("재영");
		llist.add("홍근");
		llist.add("선미");
		llist.add(2, "현도");
		System.out.println(llist);
		//읽기
		System.out.println(llist.get(2));
		System.out.println(llist.getFirst());
		System.out.println(llist.getLast());
		//삭제
		System.out.println(llist.remove());
		System.out.println(llist);
		System.out.println(llist.remove(1));
		System.out.println(llist);
		//요소의 개수
		System.out.println(llist.size());
		//수정
		llist.set(1, "수연");
		System.out.println(llist);
		//검색
		System.out.println(llist.contains("홍근"));
		System.out.println(llist.indexOf("미진"));
		llist.add("수연");
		System.out.println(llist);
		System.out.println(llist.indexOf("수연"));
		System.out.println(llist.lastIndexOf("수연"));
		//전체삭제
		llist.clear();
		//빈 값 확인
		System.out.println(llist.isEmpty());
		//초기화
		LinkedList<String> llist2 =
			new LinkedList<>(
				Arrays.asList("예진","민성","현우","시우","지민","정기"));
		System.out.println(llist2);
		LinkedList<String> llist3 =
			new LinkedList<>(
				List.of("예진","민성","현우","시우","지민","정기"));
		System.out.println(llist3);
		//반복
		for(int i=0;i<llist2.size();i++) {
			System.out.print(llist2.get(i));
		}
		System.out.println();
		for(String str:llist2) {
			System.out.print(str);
		}
		System.out.println();
		Iterator<String> iter = llist2.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
		//정렬
		System.out.println(llist3);
		Collections.sort(llist3);
		System.out.println(llist3);
		Collections.sort(llist3,Collections.reverseOrder());
		System.out.println(llist3);
		//값 읽으며 삭제
		System.out.println(llist3.poll());
		System.out.println(llist3);
		System.out.println(llist3.pollLast());
		System.out.println(llist3);
		
	}
}







