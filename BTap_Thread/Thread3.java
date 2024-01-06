package BTap_Thread;

public class Thread3 extends Thread {
    SharedData sharedData;

    public Thread3(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.checkAvaiable()) {
            synchronized (sharedData) {
                sharedData.notifyAll();
                try {
                    while (sharedData.getIndex() != 3 && sharedData.checkAvaiable()) {
                        sharedData.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int rad = sharedData.getRad();

                if (rad % 2 == 0) {
                    if (rad % 4 == 0) {
                        System.out.println("so chia het cho 4");
                    } else {
                        System.out.println("khong chia het cho 4");
                    }
                }
                sharedData.setIndex(1);
            }

            synchronized (sharedData) {
                sharedData.notifyAll();
            }
        }
    }
}
