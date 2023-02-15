package study14Download1;

import java.util.Arrays;
import java.util.Vector;

import study01.Sysout;

public class VectorRun {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<>();
		Vector<String> vec2 = new Vector<>(
				Arrays.asList("사과","오렌지","망고","배"));
		System.out.println(vec2);
		vec2.add("귤");
		vec2.addElement("감");
		System.out.println(vec2);
		System.out.println(vec2.size());
		System.out.println(vec2.capacity());
		vec2.add("귤");
		vec2.add("귤");
		vec2.add("귤");
		System.out.println(vec2.capacity());
		System.out.println(vec2.remove(7));
		System.out.println(vec2.remove("귤"));
		System.out.println(vec2);
		System.out.println(vec2.contains("망고"));
		System.out.println(vec2.indexOf("사과"));
		System.out.println(vec2.elementAt(1));
		System.out.println(vec2.get(1));
		System.out.println(vec2.firstElement());
		System.out.println(vec2.lastElement());
		System.out.println(vec2.set(6, "수박"));
		System.out.println(vec2);
		vec2.setElementAt("파파야", 2);
		System.out.println(vec2);
		vec2.clear();
		System.out.println(vec2.isEmpty());
	}
			
}






