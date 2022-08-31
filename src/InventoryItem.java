public class InventoryItem {

    String itemName, itemDescription;

    public InventoryItem(){

    }

    public InventoryItem(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    @Override
    public String toString(){
        return "\nItem Name: " + getItemName() +"\n"
                +"Description: " + getItemDescription() + "\n"+
                "-------------------------------------------\n";
    }
}
