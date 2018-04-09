import java.util.Comparator;

public class AmountComparator implements Comparator<Item> {
    public int compare(Item o1, Item o2) {
        int comparative =  o2.amount - o1.amount;
        return comparative;
    }
}
