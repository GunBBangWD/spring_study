package study21;

class SaveBox {
    String boxNeed = "in";
    int num;

    synchronized void inputNum(int num) {
        if (boxNeed.equals("out")) {
            try {wait();} catch (InterruptedException e) {}

        }
        this.num=num;
        boxNeed = "out";
        System.out.println("input"+num);
        notify();

    }
    synchronized void outputNum(int i) {
        if (boxNeed.equals("in")) {
            try {wait();} catch (InterruptedException e) {}
        }
        this.num=num;
        boxNeed = "in";
        System.out.println("output"+num);
        notify();
    }
}

public class ThreadWaitNotifyRun {
    public static void main(String[] args) {
        SaveBox sb = new SaveBox();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    sb.inputNum(i);
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    sb.outputNum(i);
                }
            }
        };
        t1.start();
        t2.start();


    }
}
