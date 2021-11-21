package tasks.task2;

public class Task2 {
    private String line;

    public Task2(String line) {
        this.line = line;
    }

    public void run() {
        Handler handler = new Handler();

        ListItems listItems = handler.getData(line);

        handler.countAmount(listItems);

        System.out.println(handler + "============");
    }
}
