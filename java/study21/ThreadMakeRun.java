package study21;

//thread 클래스 상속
class DdukThread extends Thread {
    @Override
    public void run() {
        String[] man1 = {"짝", "떡", "짝", "떡", "짝", "떡"};
        for (String st : man1) {
            System.out.println(st);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}

//Runnable 인터페이스 구현
class DdukRunnable implements Runnable {
    @Override
    public void run() {
        String[] man2 = {"쿵", "쿵", "쿵", "쿵", "쿵", "쿵"};
        for (String st : man2) {
            System.out.println(st);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

    }
}
public class ThreadMakeRun {
    public static void main(String[] args) {
        Thread th = new DdukThread();
        Thread rman = new Thread(new DdukRunnable());

        new Thread(()-> System.out.println("test")).start();

        th.start();
        rman.start();


    }
}
