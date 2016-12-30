package Draft;

import java.util.HashMap;

public class Counter {
	 
    public static int count = 0;
 
    public synchronized static void inc() {
        count++;
    }

    public static void main(String[] args) {
 
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
        HashMap d = new HashMap();
		while(Thread.activeCount() > 1){
			Thread.yield();
		}

        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}
