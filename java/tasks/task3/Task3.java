package tasks.task3;

import java.util.ArrayList;

public class Task3 {
    private ArrayList<String> lines;

    public Task3(ArrayList<String> lines) {
        this.lines = lines;
    }

    public void run() {
        Handler handler = new Handler();

        ArrayList<ListItems> listItems = handler.fromStringToArrayObjects(lines);
        ArrayList<ListItems> sortByUseful = handler.sortByUseful(listItems);
        int weight = handler.getWeight(lines);
        handler.collectItems(weight, sortByUseful);

        System.out.println(handler + "============");
    }


}
