package study05;

import java.util.ArrayList;

public class ProcessFlowRun {

	public static void printSquare(int x) {
		ArrayList<Integer> arr = new ArrayList<>();
	    System.out.println(x * x);
	}
	public static void main(String[] args) {
	    int value = 2;
	    System.out.println(value);
	    printSquare(value);
	    printSquare(3);
	    printSquare(value * 2);
	}

}
