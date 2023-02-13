package study10_3;

public class StringStack implements Stack{
	private String[] stack;
	private int top;
	
	public StringStack(int capacity) {
		stack = new String[capacity];
		top = -1;
	}
	
	@Override
	public int length() {
		return top+1;
	}

	@Override
	public int capacity() {
		return stack.length;
	}

	@Override
	public String pop() {
		if(top==-1) return null;
		String str = stack[top];
		top--;
		return str;
	}

	@Override
	public boolean push(String value) {
		if(top == stack.length-1) {
			return false;
		}else {
			top++;
			stack[top] = value;
			return true;
		}
	}

}
