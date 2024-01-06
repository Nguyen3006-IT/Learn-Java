public class MyBank {
    int money;

    public MyBank() {
    }

    public MyBank(int money) {
        this.money = money;
    }

    // synchronized là đồng bộ luồng để cho các đối tượng vào hàng đợi
    public synchronized void withDraw(int money, String ThreadName) {
        if (money <= this.money) {
            System.out.println("so tien rut: " + money + ", Thread: " + ThreadName);
            this.money -= money;
        } else {
            System.out.println("vuot qua so tien vua rut " + ThreadName);
        }
        System.out.println("so tien hien tai: " + this.money);
    }

}
