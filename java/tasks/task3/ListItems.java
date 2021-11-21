package tasks.task3;

public class ListItems {
    private int quantity;
    private String title;
    private int weight;
    private int usefulItem;
    private double usefulToMass;

    public ListItems(int quantity, String title, int weight, int usefulItem) {
        this.quantity = quantity;
        this.title = title;
        this.weight = weight;
        this.usefulItem = usefulItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getUsefulItem() {
        return usefulItem;
    }

    public double getUsefulToMass() {
        return usefulToMass;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUsefulToMass(double usefulToMass) {
        this.usefulToMass = usefulToMass;
    }

    public double getAvgUsefulToMass() {
        setUsefulToMass((double)getUsefulItem() / getWeight());
        return getUsefulToMass();
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.getQuantity(), this.getTitle());
    }
}
