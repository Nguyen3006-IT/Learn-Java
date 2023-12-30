package Thread;

public class Thread3 implements Runnable {
    String name;
    Thread t;

    public Thread3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " >>> " + i);
        }
    }
}
