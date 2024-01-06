package LyThuyet_Thread;

public class Thread2 extends Thread {
    String name;

    public Thread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " >>> " + i);
        }
    }

}
