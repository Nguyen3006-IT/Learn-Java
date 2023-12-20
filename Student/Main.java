package Student;

import java.util.Collections;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static List<Student> stList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer choose;
        Student st1 = new Student("Nguyen", "Ninh thuan", 17, 1234, 9);
        Student st2 = new Student("Sin", "Sai Gon", 17, 9876, 2);
        stList.add(st1);
        stList.add(st2);

        do {
            showMenu();
            choose = Integer.parseInt(sc.next());

            switch (choose) {
                case 1:
                    Integer N = Integer.parseInt(sc.next());
                    for (int i = 0; i < N; i++) {
                        Student st = new Student();
                        stList.add(st.input());
                    }
                    break;
                case 2:
                    for (int i = 0; i < stList.size(); i++) {
                        System.out.println(stList.get(i).toString());
                    }

                    break;
                case 3:
                    System.out.printf("Xin moi nhap id can xoa sinh vien:");
                    Integer id = Integer.parseInt(System.console().readLine());
                    for (int i = 0; i < stList.size(); i++) {
                        if (stList.get(i).getId() == id) {
                            stList.remove(i);
                            System.out.println("delete succesfull");
                            break;
                        } else {
                            System.out.println("have not id in list");
                        }
                    }
                    break;
                case 4:
                    System.out.printf("Xin moi nhap id cần xoa sinh vien:");
                    Integer delId = Integer.parseInt(System.console().readLine());
                    for (int i = 0; i < stList.size(); i++) {
                        if (stList.get(i).getId() == delId) {
                            stList.get(i).input();
                        }
                    }
                    break;
                case 5:
                    Collections.sort(stList, (o1, o2) -> {
                        if (o1.getGpa() < o2.getGpa())
                            return -1;
                        return 1;
                    });
                    break;
                case 6:
                    Collections.sort(stList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
                    break;
                case 7:
                    File file = null;
                    FileOutputStream save = null;
                    ObjectOutputStream write = null;
                    try {
                        file = new File("Student.dat");
                        save = new FileOutputStream(file);
                        write = new ObjectOutputStream(save);
                        for (int i = 0; i < stList.size(); i++) {
                            Student st = stList.get(i);
                            write.writeObject(st);
                        }
                        System.out.println("save succesfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (save != null) {
                            try {
                                save.close();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        if (write != null) {
                            try {
                                write.close();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }

                    break;
                case 8:
                    FileInputStream fi = null;
                    ObjectInputStream readIn = null;
                    try {
                        fi = new FileInputStream("Student.dat");
                        readIn = new ObjectInputStream(fi);
                        while (true) {
                            try {
                                Student st = (Student) readIn.readObject();
                                System.out.println(st.toString());
                            } catch (Exception e) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (fi != null) {
                            try {
                                fi.close();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        if (readIn != null) {
                            try {
                                readIn.close();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }

                    break;
                case 9:
                    System.out.println("thoat thanh cong");
                    break;
                default:
                    System.out.println("nhap sai, moi nhap lai");
                    break;
            }
        } while (choose != 9);
        sc.close();
    }

    static void showMenu() {
        System.out.println("------Chon so tuong ung chuc nang-------");
        System.out.println("1. Nhap N sinh vien");
        System.out.println("2. Hien thi tat ca sinh vien");
        System.out.println("3. Xoa sinh vien co id");
        System.out.println("4. Chinh sua sinh vien co id");
        System.out.println("5. Sap xep sinh vien theo GPA");
        System.out.println("6. Sap xep sinh vien theo ten");
        System.out.println("7. Luu vao file");
        System.out.println("8. Doc du lieu tu file");
        System.out.println("9. Thoat");
        System.out.print("Choose: ");
    }

}