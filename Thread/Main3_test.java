package Thread;

public class Main3_test {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        ThreadRandom threadRandom = new ThreadRandom(sharedData);
        ThreadSquare threadSquare = new ThreadSquare(sharedData);

        threadRandom.start();
        threadSquare.start();
    }
}
