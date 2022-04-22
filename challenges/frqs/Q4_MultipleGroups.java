package frqs;

import java.util.ArrayList;
import java.util.List;

public class Q4_MultipleGroups {
    private List<Q4_NumberGroup> groupList;

    public Q4_MultipleGroups(ArrayList gL) {
        groupList = gL;
    }
    public boolean contains (int num) {
        for (Q4_NumberGroup group : groupList) {
            if (group.contains(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q4_NumberGroup range1 = new Q4_Range(5, 8);
        Q4_NumberGroup range2 = new Q4_Range(10, 12);
        Q4_NumberGroup range3 = new Q4_Range(1, 6);

        ArrayList<Q4_NumberGroup> gL = new ArrayList<>();
        gL.add(range1);
        gL.add(range2);
        gL.add(range3);

        Q4_MultipleGroups multiple1 = new Q4_MultipleGroups(gL);
        System.out.println("Groups:" + range1 + "," + range2 + "," + range3);
        System.out.println("Contains 2: " + multiple1.contains(2));
        System.out.println("Contains 9: " + multiple1.contains(9));
        System.out.println("Contains 6: " + multiple1.contains(6));
    }
}
