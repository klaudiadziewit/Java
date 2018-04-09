import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FulfillmentCenterContainer {
    Map <String, FulfillmentCenter> container;

    public FulfillmentCenterContainer(){
        container = new HashMap<>();
    }

    public void addCenter(String warehouseName, double maxCapacity){
        container.put(warehouseName, new FulfillmentCenter(warehouseName, maxCapacity));
    }

    public void addCenter(FulfillmentCenter warehouse ){
        container.put(warehouse.warehouseName, warehouse);
    }

    public void removeCenter (String warehouseName){
        if (container.containsKey(warehouseName)){
            container.remove(warehouseName);
            System.out.println("Warehouse " + warehouseName + " has been successfully removed");
        }
        else
            System.err.println("There is no " + warehouseName + " warehouse");
    }

    public List<FulfillmentCenter> countEmptyWarehouses (){
        List<FulfillmentCenter> emptyWarehouses = new LinkedList<FulfillmentCenter>();
        for(String name : container.keySet() ) {
            FulfillmentCenter testWarehouse = container.get(name);
            if(testWarehouse.isEmpty())
                emptyWarehouses.add(testWarehouse);
            else
                System.out.println("There is no empty warehouse");
        }
        return emptyWarehouses;
    }

    public void makeSummary (){
        for (FulfillmentCenter fulfillmentCenter : container.values()){
            System.out.println("Warehouse name: " + fulfillmentCenter.warehouseName + " is loaded in: " + fulfillmentCenter.percent() + "%");
        }
    }

}
