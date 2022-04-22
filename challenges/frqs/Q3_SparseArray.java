package frqs;

import java.util.ArrayList;
import java.util.List;

public class Q3_SparseArray {
    private int numRows;
    private int numCols;
    private static List<Q3_SparseArrayEntry> entries;

    public Q3_SparseArray(List<Q3_SparseArrayEntry> en, int nR, int nC) {
        entries = en;
        numRows = nR;
        numCols = nC;
    }

    public int getNumRows() { return numRows; }
    public int getNumCols() { return numCols; }

    public int getValueAt(int row, int col) {
        for (int i=0; i < entries.size(); i++) {
            Q3_SparseArrayEntry entry = entries.get(i);
            if (entry.getRow() == row && entry.getCol() == col) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public void removeColumn(int col) {
        int i = 0;
        while (i<entries.size()){
            Q3_SparseArrayEntry entry = entries.get(i);
            if (entry.getCol() == col) {
                entries.remove(i);
            } else if (entry.getCol() > col) {
                entries.set(i, new Q3_SparseArrayEntry(entry.getRow(), entry.getCol()-1, entry.getValue()));
                i++;
            } else {
                i++;
            }
        }
        numCols--;
    }

    public static void main(String[] args) {
        Q3_SparseArrayEntry en1 = new Q3_SparseArrayEntry(1, 4, 4);
        Q3_SparseArrayEntry en2 = new Q3_SparseArrayEntry(2, 0, 1);
        Q3_SparseArrayEntry en3 = new Q3_SparseArrayEntry(3, 1, -9);
        Q3_SparseArrayEntry en4 = new Q3_SparseArrayEntry(1, 1, 5);

        List<Q3_SparseArrayEntry> en = new ArrayList<>();
        en.add(en1);
        en.add(en2);
        en.add(en3);
        en.add(en4);

        Q3_SparseArray sparse = new Q3_SparseArray(en, 6, 5);
        System.out.println("Initial Sparse Array with " + sparse.getNumRows() + " rows & " + sparse.getNumCols() + " columns");
        System.out.println(entries.toString());
        System.out.println("Value at row=3, col=1 : " + sparse.getValueAt(3, 1));
        System.out.println("Value at row=3, col=3 : " + sparse.getValueAt(3, 3));

        sparse.removeColumn(1);
        System.out.println();
        System.out.println("New Sparse Array with " + sparse.getNumRows() + " rows & " + sparse.getNumCols() + " columns");
        System.out.println(entries.toString());


    }
}
