import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<WithDrawThread> tList = new ArrayList<>();

        MyBank myBank = new MyBank(1000);
        /*
         * myBank.withDraw(800, "T1");
         * myBank.withDraw(800, "T2");
         * myBank.withDraw(800, "T3");
         */

        for (int i = 0; i < 5; i++) {
            tList.add(new WithDrawThread(myBank, "T" + i));
        }
        for (WithDrawThread withDrawThread : tList) {
            withDrawThread.start();

        }

    }

}
