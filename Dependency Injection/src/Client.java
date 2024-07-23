public class Client {
    private messageServices messageServices;

    public Client() {}

    public Client(messageServices messageServices) {
        this.messageServices = messageServices;
    }


    public void print(String message) {
        this.messageServices.printMessage(message);
    }

}
