package frq15;

public class Q3_SparseArrayEntry {
    private int row;
    private int col;
    private int value;

    public Q3_SparseArrayEntry(int r, int c, int v) {
        row = r;
        col = c;
        value = v;
    }

    public int getRow() { return row;}

    public int getCol() { return col; }

    public int getValue() { return value; }

    public String toString() {
        return "row: " + row + " col: " + col + " value: " + value;
    }
}
