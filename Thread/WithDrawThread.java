package Thread;

public class WithDrawThread extends Thread {
    String name;
    MyBank mybank;

    public WithDrawThread(MyBank myBank, String name) {
        this.mybank = myBank;
        this.name = name;
    }

    @Override // start()
    public void run() {
        for (int i = 0; i < 5; i++) {
            mybank.withDraw(800, this.name);
        }
    }
}
