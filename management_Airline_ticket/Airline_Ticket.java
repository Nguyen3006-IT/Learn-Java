package management_Airline_ticket;

import java.io.Serializable;

public class Airline_Ticket implements Serializable {
    String Name, Ticket_ID, date, bag;
    int price;

    public Airline_Ticket(String name, String ticket_ID, String date, String bag, int price) {
        Name = name;
        Ticket_ID = ticket_ID;
        this.date = date;
        this.bag = bag;
        this.price = price;
    }

    public Airline_Ticket() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTicket_ID() {
        return Ticket_ID;
    }

    public void setTicket_ID(String ticket_ID) {
        Ticket_ID = ticket_ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Airline_Ticket [Name=" + Name + ", Ticket_ID=" + Ticket_ID + ", date=" + date + ", bag=" + bag
                + ", price=" + price + "]";
    }

    public void dislay() {
        System.out.println(toString());
    }

    public Airline_Ticket input() {
        System.out.println("Nhap ten chuyen bay: ");
        Name = System.console().readLine();

        System.out.println("Nhap ma ve: ");
        Ticket_ID = System.console().readLine();

        System.out.println("Ngay bay: ");
        date = System.console().readLine();

        System.out.println("Hanh ly ky gui: ");
        bag = System.console().readLine();

        System.out.println("Nhap gia:");
        price = Integer.parseInt(System.console().readLine());

        return new Airline_Ticket(Name, Ticket_ID, date, bag, price);

    }

}
