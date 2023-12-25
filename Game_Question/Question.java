package Game_Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    String title;
    List<String> options = new ArrayList<>();
    int result;

    public Question() {
    }

    public Question(String title, List<String> options, int result) {
        this.title = title;
        this.options = options;
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getOption() {
        return options;
    }

    public void setOption(List<String> option) {
        this.options = option;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Question input() {
        System.out.println("nhap cau hoi: ");
        title = System.console().readLine();

        System.out.println("nhap options: ");
        int i = 1;
        while (true) {
            System.out.format("Option %d: ", i);
            String option = System.console().readLine();
            if (option.equalsIgnoreCase("stop"))
                break;
            options.add(option);

            i++;
        }
        System.out.println("nhap dap an dung: ");
        result = Integer.parseInt(System.console().readLine());
        return new Question(title, options, result);
    }

    public void showQuestion() {
        System.out.println("Question: " + title);
        int i = 1;
        for (String option : options) {
            System.out.println((i++) + ". " + option);
        }
        System.out.println("Dap an: ");
    }

    public boolean check(int result) {
        if (this.result == result)
            return true;
        return false;
    }

}
