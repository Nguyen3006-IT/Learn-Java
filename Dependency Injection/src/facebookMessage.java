public class facebookMessage implements messageServices {
    public facebookMessage() {}

    @Override
    public void printMessage(String message) {
        System.out.println("Facebook -> " + message);
    }
}
