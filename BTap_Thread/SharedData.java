package BTap_Thread;

public class SharedData {
    int rad, total, index;

    public SharedData() {
        total = 0;
        index = 1;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void plus(int val) {
        total += val;
    }

    public synchronized boolean checkAvaiable() {
        return total < 2000;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
