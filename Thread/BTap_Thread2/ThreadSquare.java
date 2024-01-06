public class ThreadSquare extends Thread {
    SharedData sharedData;

    public ThreadSquare(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (sharedData) {
                try {
                    sharedData.notifyAll();
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int ran = sharedData.getRad();
                ran *= ran;
                System.out.println("PT: " + ran);
            }
        }
        // stop
        synchronized (sharedData) {
            sharedData.notifyAll();
        }
    }

}
