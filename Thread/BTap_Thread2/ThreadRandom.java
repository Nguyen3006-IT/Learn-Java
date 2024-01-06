import java.util.Random;

public class ThreadRandom extends Thread {
    SharedData share;

    public ThreadRandom(SharedData sData) {
        this.share = sData;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            synchronized (share) {
                int ran = random.nextInt(100);
                share.setRad(ran);
                System.out.println("Rand: " + ran);
                share.notifyAll();
                try {
                    share.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // stop
        synchronized (share) {
            share.notifyAll();
        }
    }
}
