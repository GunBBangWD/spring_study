package study21;

class SyncResult {
    int result = 100;

    public synchronized void calResult() {
        int temp=result;
        System.out.println(temp);
        try{
            Thread.sleep(2500);
        } catch (InterruptedException e) {
        }
        result=result/2;
        System.out.println(result);

    }
}

class SyncCalThread extends Thread {
    SyncResult result;

    public SyncCalThread(SyncResult result) {
        this.result=result;
    }
    @Override
    public void run() {
        result.calResult();
        System.out.println(getName() + " " + result.result);
    }
}

public class SyncThreadRun {
    public static void main(String[] args) {
        SyncResult res = new SyncResult();
        Thread cal1 = new SyncCalThread(res);
        cal1.setName("no1 thread");
        cal1.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Thread cal2 = new SyncCalThread(res);
        cal2.setName("no2 thread");
        cal2.start();
    }
}
