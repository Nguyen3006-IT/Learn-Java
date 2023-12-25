package Game_Question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(System.console().readLine());

            switch (choose) {
                case 1:
                    saveQuestion();
                    break;
                case 2:
                    showGame();
                    break;
                case 3:

                    break;

                default:
                    System.out.println("nhap sai, hay nhap lại");
                    break;
            }

        } while (choose != 3);
    }

    public static void saveQuestion() throws IOException {
        FileOutputStream wri = null;
        ObjectOutputStream objWri = null;

        try {
            wri = new FileOutputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Game_Question/Question.dat", true);
            objWri = new ObjectOutputStream(wri);
            while (true) {
                Question question = new Question();
                question = question.input();
                objWri.writeObject(question);
                System.out.println("co muon nhap cau hoi nua khong? Y/N: ");
                if (System.console().readLine().equalsIgnoreCase("N"))
                    break;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objWri.close();
                wri.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showGame() throws IOException, ClassNotFoundException {
        FileInputStream readFile = null;
        ObjectInputStream objRead = null;
        List<Question> question_List = new ArrayList<>();

        try {
            readFile = new FileInputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Game_Question/Question.dat");
            objRead = new ObjectInputStream(readFile);

            Object obj = null;
            while (true) {
                try {
                    obj = objRead.readObject();
                    System.out.println(obj);
                } catch (Exception e) {
                    obj = null;
                }
                if (obj == null)
                    break;
                question_List.add((Question) obj);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            readFile.close();
            objRead.close();
        }

        int correct = 0;
        int total = question_List.size();
        System.out.println(question_List);
        for (Question question : question_List) {
            question.showQuestion();
            int result = Integer.parseInt(System.console().readLine());
            if (question.check(result))
                correct++;

            System.out.format("\nKet qua test: %d/%d \n", correct, total);
        }
    }

    public static void showMenu() {
        System.out.println("1. Nhap cau hoi");
        System.out.println("2. Game");
        System.out.println("3. Thoat");
        System.out.print("Lua chọn: ");
    }
}
