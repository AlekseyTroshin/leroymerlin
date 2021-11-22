import helpers.FileHandler;
import tasks.task2.Task2;
import tasks.task3.Task3;

import java.util.ArrayList;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        FileHandler fileHandler2 = new FileHandler("./../data/task2.txt");
        FileHandler fileHandler3 = new FileHandler("./../data/task3.txt");

        String oneLine = fileHandler2.readFileOneLine();
        ArrayList<String> arrayStrings3 = fileHandler3.readFile();

        Task2 task2 = new Task2(oneLine);
        Task3 task3 = new Task3(arrayStrings3);

        System.out.println("\n============\n" + ANSI_RED + 
            "Извините не успел сделать 1 задачу ! \n" +
            "Сейчас с ней вожусь, хотя думаю это уже не важно ))" + 
            ANSI_RESET + "\n============");
        
        task2.run();
        task3.run();
    }
}
