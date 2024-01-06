package BTap_Thread3;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread t1 = new Thread1(sharedData);
        Thread t2 = new Thread2(sharedData);
        Thread t3 = new Thread3(sharedData);

        t1.start();
        t2.start();
        t3.start();
    }
}
