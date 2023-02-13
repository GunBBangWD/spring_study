package study01;

import java.util.Scanner;

public class Sysout {

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("입력:");
		int line = scan.nextInt();
		System.out.println(line);
		
		System.out.println("출력");
		System.out.print("hello");
		System.out.print("\n");
		System.out.print("world");
		System.out.print("\n");
		
		String world = "World";
		String java = "Java";
		System.out.printf("Hello, %s, %s %n",world,java);
	}

}
