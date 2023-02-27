package study21;

class SharedClass {
    private int sum=0;

    public void add(int x) {
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "시작");
        sum+=x;
        System.out.println(Thread.currentThread().getName() + "끝");
    }

    public void getSum() {
        System.out.println(sum);
    }
}

public class YieldThreadRun {
    public static void main(String[] args) {
        SharedClass sc = new SharedClass();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                sc.add(13);
                sc.getSum();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                sc.add(10);
                sc.getSum();
            }
        };
        t1.start();
        t2.start();
        System.out.println(Thread.activeCount());
    }
}
