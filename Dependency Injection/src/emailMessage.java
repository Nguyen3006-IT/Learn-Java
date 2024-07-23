public class emailMessage implements messageServices {
    public emailMessage() {}

    @Override
    public void printMessage(String message) {
        System.out.println("Email -> " + message);
    }
}
