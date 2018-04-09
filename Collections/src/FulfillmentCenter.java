import java.util.*;

public class FulfillmentCenter {
    String warehouseName;
    Double maxCapacity;
    List <Item> warehouseItems;

    public FulfillmentCenter(String warehouseName, Double maxCapacity){
        this.warehouseName = warehouseName;
        this.maxCapacity = maxCapacity;
        this.warehouseItems = new ArrayList<>();
    }

    public void addProduct(Item myItem) {
        int index = -1;
        for (Item item : warehouseItems) {
            if(item.compareTo(myItem)==0)
                 index = warehouseItems.indexOf(item);
        }

        if (countItemsInWarehouse(myItem)) {
            if (index == -1) {
                warehouseItems.add(myItem);
                System.out.println("Item " + myItem.name + " has been successfully added to the warehouse");
            } else {
                warehouseItems.get(index).amount += myItem.amount;
            }
        } else
            System.err.println("It is impossible to add this item, the warehouse is full!");

    }

    public Item getProduct(Item myItem) throws NullPointerException{
        Iterator <Item> testIterator = warehouseItems.iterator();
        while (testIterator.hasNext()){
            Item testItem = testIterator.next();
            if (testItem.compareTo(myItem)==0){
                  testItem.amount -=1;
                  //testIterator.remove();
                  System.out.println("We found what you want!");
                  return myItem;
            }
            else
                System.err.println("There is no product like this in warehouse");
        }
        return myItem;
    }

    public void removeProduct(Item myItem) throws IllegalArgumentException{
        Iterator <Item> testIterator = warehouseItems.listIterator();
        boolean productState = false;
        while (testIterator.hasNext()) {
            Item testItem = testIterator.next();
            if (testItem.equals(myItem)) {
                testIterator.remove();
                System.out.println(myItem.name + " has been successfully removed");
                productState = true;
            }
        }
        if(!productState)
            throw new IllegalArgumentException("There is no product to remove");
    }

    public Item search(String itemName){
        Item seekItem;
        List<Item> testList = new LinkedList<>();
        for(Item item : warehouseItems) {
            Item testItem = new Item(item);
            testList.add(testItem);
        }
        Collections.sort(testList);
        int index = Collections.binarySearch(testList, new Item(itemName, null, null, null), new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }
        });

        if(index>=0)
            seekItem = testList.get(index);
        else
            seekItem=new Item(null,null,null,null);
        return seekItem;
    }

    public List<Item> searchPartial(String partialName){
        List<Item> testList= new LinkedList<Item>();
        partialName = partialName.toLowerCase();
        for (Item item : warehouseItems){
            String testName = item.name.toLowerCase();
            if (testName.contains(partialName))
                testList.add(item);
        }
        return testList;
    }

    public int countByCondition(ItemCondition itemCondition){
        int amountOfThisCondition = 0;
        for(Item item : warehouseItems){
            if (item.state == itemCondition)
                amountOfThisCondition+=item.amount;
        }
        return amountOfThisCondition;
    }

    public void summary(){
        System.out.println("________________________");
        System.out.println("Warehouse items:");
        for (Item item : warehouseItems){
            item.print();
        }
        System.out.println("________________________");
    }
    public List<Item> sortByName(){
        Collections.sort(warehouseItems);
        return warehouseItems;
    }

    public List<Item> sortByAmount(){
        Collections.sort(warehouseItems, new AmountComparator());
        return warehouseItems;
    }

    public boolean countItemsInWarehouse(Item myItem){
        double actualCapacity = 0.0;
        for (Item item : warehouseItems){
            actualCapacity += item.mass*item.amount;
        }
        if (maxCapacity>(actualCapacity+(myItem.mass*myItem.amount)))
            return true;
        else
            return false;
    }

    public Item max() {
        return Collections.max(warehouseItems);
    }

    public double percent() {
        double space= 0.0;
        for(Item element : warehouseItems)
            space +=  element.mass * element.amount;
        return (space/maxCapacity)*100.0;
    }

    public boolean isEmpty(){
        double totalMass = 0.0;
        for (Item item : warehouseItems){
            totalMass += item.mass*item.amount;
        }
        if (totalMass == 0)
            return true;
        else
            return false;
    }
}
