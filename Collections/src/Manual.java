import java.util.ArrayList;
import java.util.List;

public class Manual {
    public static void main(String[] args) {
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter("IKEA",200.0 );

        //add a few products
        Item item1 = new Item("Table", 10.0, 3, ItemCondition.NEW);
        Item item2 = new Item("Table", 10.0, 3, ItemCondition.NEW);
        Item item3 = new Item("Wardrobe", 210.0, 4, ItemCondition.NEW);
        Item item4 = new Item("Armchair", 10.0, 1, ItemCondition.NEW);
        Item item5 = new Item("Blanket", 1.0, 4, ItemCondition.REFURBISHED);
        Item item6 = new Item("Mug", 0.5, 4, ItemCondition.USED);
        Item item7 = new Item("Cushion", 0.5, 2, ItemCondition.USED);

        fulfillmentCenter.addProduct(item1);
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.summary();
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.addProduct(item3);
        fulfillmentCenter.addProduct(item4);
        fulfillmentCenter.addProduct(item5);
        fulfillmentCenter.addProduct(item6);
        fulfillmentCenter.addProduct(item7);
//
        int newItems = fulfillmentCenter.countByCondition(ItemCondition.NEW);
        System.out.println("There are " + newItems + " items with 'NEW' condition");
        int refurbishedItems = fulfillmentCenter.countByCondition(ItemCondition.REFURBISHED);
        System.out.println("There are " + newItems + " items with 'USED' condition");
        int usedItems = fulfillmentCenter.countByCondition(ItemCondition.USED);
        System.out.println("There are " + newItems + " items with 'REFURBISHED' condition");
//
        fulfillmentCenter.summary();

        fulfillmentCenter.getProduct(item1);
        fulfillmentCenter.getProduct(item2);
        fulfillmentCenter.getProduct(item1);
        fulfillmentCenter.summary();
//
//        fulfillmentCenter.sortByAmount();
//        fulfillmentCenter.summary();
//        fulfillmentCenter.sortByName();
//        fulfillmentCenter.summary();

        try {
            fulfillmentCenter.removeProduct(item1);
            fulfillmentCenter.removeProduct(item1);
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        fulfillmentCenter.summary();
        Item testItem = fulfillmentCenter.search("Blanket");
        testItem.print();
        List <Item> testList = fulfillmentCenter.searchPartial("blan");
        for (Item item:testList){
            item.print();
        }
    }
}
