//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Client client;

        // Facebook
        facebookMessage facebookMessage = new facebookMessage();
        client = new Client(facebookMessage);
        client.print("Hello World");

        // Email
        emailMessage emailMessage = new emailMessage();
        client = new Client(emailMessage);
        client.print("Hello World");
    }
}