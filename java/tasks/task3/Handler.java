package tasks.task3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Handler {
    private ArrayList<ListItems> superList;

    protected ArrayList<ListItems> fromStringToArrayObjects(ArrayList<String> lines) {
        ArrayList<ListItems> listItems = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(" ");

            listItems.add(new ListItems(
                    Integer.parseInt(splitLine[0]),
                    splitLine[2],
                    Integer.parseInt(splitLine[3]),
                    Integer.parseInt(splitLine[4]))
            );
        }

        return listItems;
    }

    protected int getWeight(ArrayList<String> lines) {
        return Integer.parseInt(lines.get(0).split(" ")[0]);
    }

    protected ArrayList<ListItems> sortByUseful(ArrayList<ListItems> lines) {
        return (ArrayList<ListItems>)lines.stream()
                .sorted((o1, o2) -> Double.compare(o2.getAvgUsefulToMass(), o1.getAvgUsefulToMass()))
                .collect(Collectors.toList());
    }

    protected void collectItems(int weight, ArrayList<ListItems> lines) {
        ArrayList<ListItems> result = new ArrayList<>();

        for (ListItems line : lines) {
            int multiply = line.getWeight() * line.getQuantity();
            if (weight > multiply) {
                weight -= multiply;
                result.add(line);
                continue;
            }

            int count = weight / line.getWeight();
            if (weight > 0) {
                weight -= line.getWeight() * count;
            }
            line.setQuantity(count);
            result.add(line);
        }

        this.superList = (ArrayList<ListItems>) result.stream()
                .sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        for (ListItems listItems : this.superList) {
            System.out.println(listItems);
        }
        return "";
    }
}
