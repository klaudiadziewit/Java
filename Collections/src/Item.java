public class Item
        implements IPrintable, Comparable<Item> {

    String name;
    Double mass;
    Integer amount;
    ItemCondition state;

    public Item(String name, Double mass, Integer amount, ItemCondition state){
        this.name=name;
        this.mass=mass;
        this.amount=amount;
        this.state=state;
    }

    public Item(Item myItem) {
        this.name = myItem.name;
        this.mass = myItem.mass;
        this.amount = myItem.amount;
        this.state = myItem.state;
    }

    @Override
    public void print() {
        if (this.amount == 0)
            System.out.println("There is no item like this in our warehouse");
        else
            System.out.println("ITEM: " + this.name + " WEIGHT: " + this.mass + "kg AMOUNT: " + this.amount + " CONDITION: " + this.state);
    }

    @Override
    public int compareTo(Item o) {
        int comparedItem = this.name.compareTo(o.name);
        return comparedItem;
    }
}
