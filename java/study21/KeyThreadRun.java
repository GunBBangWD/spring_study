package study21;

class CommonUse {
    synchronized void commonMethod1() { //동기화 기준 키값을 설정하지 않은것과 비교하여 동기화
        for (int i = 0; i < 4; i++) {
            System.out.println(i+"★");
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
        }
    }

    synchronized void commonMethod2() { //키값이 없는 스레드가 종료되기 전까지 실행 대기
        for (int i = 0; i < 4; i++) {
            System.out.println(i+"＃");
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
        }
    }
    Object obj = new Object();
    void commonMethod3() {
        synchronized (obj) {  //동기화 기준 키값
            for (int i = 0; i < 4; i++) {
                System.out.println(i + "$");
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
            }
        }
    }
    void commonMethod4() {
        synchronized (obj) { // 기존 키값의 쓰레드가 종료되기 전까지 실행 안됨
            for (int i = 0; i < 4; i++) {
                System.out.println(i + "@");
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
            }
        }
    }
}


public class KeyThreadRun {
    public static void main(String[] args) {
        CommonUse cu = new CommonUse();
        new Thread(){
            public void run() {
                cu.commonMethod1();
            }
        }.start();
        new Thread(){
            public void run() {
                cu.commonMethod2();
            }
        }.start();
        new Thread(){
            public void run() {
                cu.commonMethod3();
            }
        }.start();
        new Thread(){
            public void run() {
                cu.commonMethod4();
            }
        }.start();
    }
}
