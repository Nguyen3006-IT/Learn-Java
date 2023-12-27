package management_Airline_ticket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuanLyChuyenBay {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Airline_Ticket> tickets = new ArrayList<>();
        Airline_Ticket chuyenBay = null;
        int choose;
        do {
            ShowMenu();
            System.out.println("Chon: ");
            choose = Integer.parseInt(System.console().readLine());

            switch (choose) {
                case 1:
                    System.out.println("Co bao nhieu chuyen bay: ");
                    int n = Integer.parseInt(System.console().readLine());
                    while (n > 0) {
                        chuyenBay = new Airline_Ticket();
                        tickets.add(chuyenBay.input());
                        n--;
                    }
                    break;
                case 2:
                    FileOutputStream outputStream = null;
                    ObjectOutputStream objWrite = null;

                    outputStream = new FileOutputStream(
                            "C:/Users/Admin/Desktop/baitap Java/management_Airline_ticket/DuLieuBay.dat");
                    objWrite = new ObjectOutputStream(outputStream);
                    for (Airline_Ticket Ticket : tickets) {
                        System.out.println(Ticket);
                        objWrite.writeObject(Ticket);
                    }
                    outputStream.close();
                    objWrite.close();

                    break;
                case 3:
                    FileInputStream inStream = new FileInputStream(
                            "C:/Users/Admin/Desktop/baitap Java/management_Airline_ticket/DuLieuBay.dat");
                    ObjectInputStream objRead = new ObjectInputStream(inStream);
                    List<Airline_Ticket> list = new ArrayList<>();
                    Object obj;

                    while (true) {
                        try {
                            obj = objRead.readObject();
                            list.add((Airline_Ticket) obj);
                        } catch (Exception e) {
                            break;
                        }

                    }
                    inStream.close();
                    objRead.close();

                    for (Airline_Ticket Ticket : list) {
                        Ticket.dislay();
                    }
                    break;
                case 4:
                    Collections.sort(tickets, (Airline_Ticket o1, Airline_Ticket o2) -> {
                        if (o1.getPrice() < o2.getPrice())
                            return -1;
                        return 1;
                    });
                    for (int i = 0; i < tickets.size(); i++) {
                        tickets.get(i).dislay();
                    }
                    break;
                case 5:
                    List<Airline_Ticket> vjList = getAirLine(tickets, "VJ");
                    saveFile("VietJetAir.dat", vjList);

                    List<Airline_Ticket> vnlList = getAirLine(tickets, "VN");
                    saveFile("VietNamAirLine.dat", vnlList);

                    List<Airline_Ticket> jetstarList = getAirLine(tickets, "JET");
                    saveFile("JetStar.dat", jetstarList);

                    break;
                case 6:
                    System.out.println("thoat thanh cong");
                    break;

                default:
                    System.out.println("nhap sai, hay nhap lai");
                    break;
            }

        } while (choose != 6);
    }

    public static List<Airline_Ticket> getAirLine(List<Airline_Ticket> list, String prex) {
        List<Airline_Ticket> airLineList = new ArrayList<>();
        for (Airline_Ticket ticket : list) {
            if (ticket.getTicket_ID().startsWith(prex)) {
                airLineList.add(ticket);
            }
        }
        return airLineList;
    }

    public static void saveFile(String fileName, List<Airline_Ticket> list) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(
                "C:/Users/Admin/Desktop/baitap Java/management_Airline_ticket/" + fileName);
        ObjectOutputStream objWrite = new ObjectOutputStream(outputStream);

        for (Airline_Ticket Ticket : list) {
            objWrite.writeObject(Ticket);
        }
        outputStream.close();
        objWrite.close();
    }

    public static void ShowMenu() {
        System.out.println("1. Nhap N chuyen bay");
        System.out.println("2. Luu thong tin vao DuLieuBay.txt");
        System.out.println("3. Doc thong tin file DuLieuBay.txt va in ra man hinh");
        System.out.println("4. Hien thi thong tin theo gia ve giam dan. ");
        System.out.println("5. In thong tin moi hang bay ra file tuong ung");
        System.out.println("6. Thoat.");
    }
}
