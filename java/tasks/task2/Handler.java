package tasks.task2;

import java.util.ArrayList;

public class Handler {
    private int maxCount;

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    protected ListItems getData(String line) {
        String[] numbers = line.split(" ");
        return new ListItems(fromStringToInt(numbers[0]), fromStringToInt(numbers[1]));
    }

    private int fromStringToInt(String s) {
        return Integer.parseInt(s);
    }

    protected int countAmount(ListItems listItems) {
        int n = listItems.getTotalNumber();
        int m = listItems.getMaxCount();
        int avg = 0;
        int count = 0;
        int num = 0;
        int max = 0;
        boolean one = true;
        boolean two = false;

        if (n % m != 0) {
            num = m - (n % m);
            n += num;
        }

        while (n > 0) {
            count = n / m;

            if (count % 2 != 0 && one) {
                avg = (count + 1) / 2 * m;
                max += avg - num;
                one = false;
                two = true;
            }
            else if (count % 2 == 0 && !one) {
                avg = count / 2 * m;
                max += avg;
                two = true;
            }
            else if (count % 2 != 0 && two) {
                avg = (count + 1) / 2 * m;
                one = true;
                two = false;
            }
            else if (count % 2 == 0 && !two) {
                avg = count / 2 * m;
                one = true;
            }

            n -= avg;
            num = 0;
        }

        this.maxCount = max;
        return max;
    }

    @Override
    public String toString() {
        return String.format("%d\n", maxCount);
    }
}
