package BTap_Thread3;

public class Thread2 extends Thread {
    SharedData sharedData;

    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.checkAvaiable()) {
            synchronized (sharedData) {
                sharedData.notifyAll();
                try {
                    while ((sharedData.getIndex() != 2) && sharedData.checkAvaiable()) {
                        sharedData.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int rad = sharedData.getRad();

                if (rad % 3 == 0) {
                    rad *= rad;
                    System.out.println("T2 >> " + rad);
                }
                sharedData.setIndex(1);
            }
        }
        synchronized (sharedData) {
            sharedData.notifyAll();
        }
    }
}
