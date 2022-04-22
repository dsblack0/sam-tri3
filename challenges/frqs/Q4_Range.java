package frqs;

public class Q4_Range implements Q4_NumberGroup{
    private int min;
    private int max;

    public Q4_Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(int num) {
        return num >= min && num <= max;
    }

    public String toString() {
        String range = "";
        for (int i = min; i<=max; i++) {
            range += " " + i;
        }
        return range;
    }
}
