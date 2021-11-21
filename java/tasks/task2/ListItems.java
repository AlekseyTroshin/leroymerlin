package tasks.task2;

public class ListItems {
    private int totalNumber;
    private int maxCount;

    public ListItems(int totalNumber, int maxCount) {
        this.totalNumber = totalNumber;
        this.maxCount = maxCount;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
