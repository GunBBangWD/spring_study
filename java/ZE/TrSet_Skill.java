package ZE;

import java.util.*;

public class TrSet_Skill {
	public static void main(String[] args) {
		TreeSet<String> tset1 = new TreeSet<>();
		tset1.add("apple");
		tset1.add("orange");
		tset1.add("banana");
		System.out.println(tset1);
		TreeSet<Integer> tset2 = new TreeSet<>();
		tset2.add(55);
		tset2.add(7);
		tset2.add(32);
		System.out.println(tset2);
		tset1.addAll(tset1);
		System.out.println(tset1);
		tset2.clear();
		System.out.println(tset2.isEmpty());
		for(int i=3;i<100;i+=3) {
			tset2.add(i);
		}
		System.out.println(tset2);
		System.out.println("--------------------");
		System.out.println(tset2.first()); //첫번째 값
		System.out.println(tset2.last()); //마지막 값
		System.out.println(tset2.lower(51)); //인덱스의
		System.out.println(tset2.higher(51));
		System.out.println(tset2.floor(17));
		System.out.println(tset2.floor(18));
		System.out.println(tset2.ceiling(25));
		System.out.println(tset2.ceiling(24));
		System.out.println(tset2.size());
		System.out.println(tset2.pollFirst()); // 첫번째 반환하면서 삭제
		System.out.println(tset2.pollLast()); // 마지막 반환하면서 삭제
		System.out.println(tset2);
		System.out.println("----------------------");

		// 범위 출력
		System.out.println(tset2.headSet(18));//default:false   // 첫번째부터 인자 까지 반환 headSet의 default = false
		System.out.println(tset2.headSet(18,true));
		System.out.println(tset2.tailSet(84));//default:true  // 마지막부터 인자 까지 반환 tailSet의 default = true
		System.out.println(tset2.tailSet(84,false));
		System.out.println(tset2.subSet(42, 54));
		System.out.println(
				tset2.subSet(42,false,54,true));
		System.out.println("----------------------");
		TreeSet<String> animalTSet = new TreeSet<>(
			Arrays.asList("Dog","Cat","Tiger",
					"Lion","Elephant","Zebra"));
		SortedSet<String> sset = animalTSet.headSet("Z");
		NavigableSet<String> nset = animalTSet.headSet("Z", true);
		System.out.println(sset);
		System.out.println(nset);
		System.out.println(nset.descendingSet());

		//반복 접근
		Iterator<Integer> itr2 = tset2.iterator();
		while(itr2.hasNext()) {
			System.out.printf("%d ",itr2.next());
		}System.out.println();
		Iterator<Integer> itr3 = tset2.descendingIterator();
		while(itr3.hasNext()) {
			System.out.printf("%d ",itr3.next());
		}System.out.println();
		
		TreeSet<Integer> tset3 = new TreeSet<>(tset2);
		System.out.println(tset3);
		
		int treesize=tset2.size();
		for(int i=0;i<treesize;i++) {
			System.out.print(tset2.pollFirst()+" ");
		}System.out.println();
		System.out.println(tset2.isEmpty());
		
		treesize=tset3.size();
		for(int i=0;i<treesize;i++) {
			System.out.print(tset3.pollLast()+" ");
		}System.out.println();
		System.out.println(tset3.isEmpty());
		
		String[] str = tset1.toArray(new String[0]);
		System.out.println(Arrays.toString(str));
		
		for(String s:tset1) {
			System.out.print(s+" ");
		}
	}
}






