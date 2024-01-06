package LyThuyet_Thread;

public class Main {

    public static void main(String[] args) {
        // cách 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1 >>> " + i);
                }
            }
        });
        t1.start();

        // Lambda cách 1
        new Thread(() -> {
            System.out.println("T1.2 >> Lambda");
        }).start();

        // cách 2
        Thread2 t2 = new Thread2("- T2");
        t2.start();

        // cách 3
        Thread3 t = new Thread3("T3");
        Thread t3 = new Thread((Runnable) t);
        t3.start();

        // main thread
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread >>> " + i);
        }
    }
}