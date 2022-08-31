import java.util.*;



public class main {
    public static void main(String[] args) {

        //Initiates the Scanner input
        Scanner in = new Scanner(System.in);

        //Initiates the menu while loop
        int exit = 0;

        //Initiates the user Input
        int input = 7;

        //This is to skip the line for an integer input given by the user, so it doesn't skip a string input
        String skip;

        //Universal answer input
        String answer;

        //Creating an inventory and deleted
        HashMap<String, InventoryItem> inventory = new HashMap<>();
        HashMap<String, InventoryItem> deletedItems = new HashMap<>();

        //While loop for the menu, if 6 is chosen the program ends
        while(exit != 6){

            //Main menu display
            System.out.println("""
                    Main Menu:\s
                    1: List Inventory
                    2: Add Item
                    3: Edit Item/s
                    4: Delete Item/s
                    5: View Deleted Items
                    6: Exit
                    =====================================================
                    Enter Input:\s""");


            //Make sure the input is valid to use the menu
            try{
                input = in.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Not valid");
                System.out.println("Run Program again");
                System.exit(0);
            }







            //Dependent on what the user chooses with input
            switch(input){

                //Case 1 lists all inventory items stored in HashMap "inventory"
                case 1:
                    if(inventory.isEmpty()){
                        System.out.println("No items added to inventory yet\n");
                    }else{

                        for(Map.Entry<String, InventoryItem> entry: inventory.entrySet()){
                            System.out.println(entry.getValue());
                        }
                    }
                    break;

                // Case 2 adds new items to "inventory" HashMap
                case 2:
                    String itemName;
                    String itemDescription;

                    skip = in.nextLine();

                    //Enter the name of item
                    System.out.println("Enter Item Name: ");
                    itemName = in.nextLine().strip();

                    //Check if "inventory" has that item already
                    if(inventory.containsKey(itemName)){
                        System.out.println("This item already exist! You may use the menu\n" +
                                "to either delete or edit this item.\n");
                    }

                    //If the item doesn't already exist, the user may continue to add information for the item they're adding
                    else{
                        System.out.println("Enter Item Description: ");
                        itemDescription = in.nextLine().strip();

                        //Creates a new item (object) the user specifies
                        InventoryItem item = new InventoryItem(itemName, itemDescription);

                        //Adds the new item to the "inventory" HashMap
                        inventory.put(itemName, item);
                        System.out.println("Item added!\n\n");
                    }
                    break;

                //Case 3 finds and edits items specified by the user
                case 3:

                    skip = in.nextLine();

                    System.out.println("Enter Item Name to Edit");

                    itemName = in.nextLine();

                    //Check if "inventory" has the item specified
                    if(inventory.containsKey(itemName)){

                        //Variable 'b' retrieves the item given the name of the item specified by user
                        InventoryItem b = inventory.get(itemName);


                        System.out.println("Here is the item found: ");

                        //Prints out the value of item specified
                        System.out.println(b+"\n");


                        //Checks which attribute want's to be changed
                        System.out.println("Which attribute would you like to change?\n" +
                                "Note: Type Name, Description, or Cancel\n" +
                                "Enter Answer: ");

                        answer = in.nextLine();

                        //if the answer isn't name, description, or cancel, it asks for one of those again
                        while (!answer.equalsIgnoreCase("name") && !answer.equalsIgnoreCase("description")
                        && !answer.equalsIgnoreCase("cancel")){

                            System.out.println("This is not an option!\n" +
                                    "Please enter Name, Description, or Cancel:");

                            //Another chance to choose one of the options provided
                            answer = in.nextLine();
                        }

                        //Based on if the user chose "name" or "description", the item (object) will be
                        //updated with whatever the user decides
                        switch (answer.toLowerCase()){
                            case "name":
                                System.out.println("Enter New Name: ");
                                String newName = in.nextLine();
                                b.setItemName(newName);
                                break;
                            case "description":
                                System.out.println("Enter New Description: ");
                                String newDesc = in.nextLine();
                                b.setItemDescription(newDesc);
                                break;
                            case "cancel":
                                break;
                        }

                    }

                    //Tell's user the item doesn't exist if not found in "inventory"
                    else {
                        System.out.println("No such item exists in inventory!\n" +
                                "Add an item to edit using option '2'.\n\n");
                    }
                    break;

                //Case 4 deletes an item from the list that the user specifies
                case 4:

                    skip = in.nextLine();

                    System.out.println("Enter Item Name to Delete: ");

                    itemName = in.nextLine();

                    //Checks if the item specified exists
                    if(inventory.containsKey(itemName)){

                        InventoryItem b = inventory.get(itemName);

                        System.out.println("Here is the item found: ");

                        System.out.println(b+"\n");

                        //Asks user if they are sure they want to delete the item specified
                        System.out.println("Are you sure you want to delete this item? (y or n)");

                        answer = in.nextLine();

                        //Checks for invalid input
                        while(!answer.equalsIgnoreCase("y") && answer.equalsIgnoreCase("n")){
                            System.out.println("Invalid input!\n");
                            System.out.println("Are you sure you want to delete this item? (y or n)");
                            answer = in.nextLine();
                        }

                        //If user answers yes (y)
                        if(answer.equalsIgnoreCase("y")){

                            //Puts item from "inventory" into "deletedItems" HashMap
                            deletedItems.put(itemName, b);

                            //Deletes item specified from "inventory" HashMap
                            inventory.remove(itemName);

                            System.out.println("Item deleted!\n");
                        }

                    }else{
                        System.out.println("This item doesn't exist!\n\n");
                    }
                    break;

                //Case 5 lists the deleted items
                case 5:

                    skip = in.nextLine();

                    //Checks to see if there are any deleted items
                    if(!deletedItems.isEmpty()){

                        System.out.println("Deleted Items: \n");

                        //Lists out all deleted items from "deletedItems" HashMap
                        for(Map.Entry<String, InventoryItem> entry: deletedItems.entrySet()) {
                            System.out.println(entry.getValue());
                        }


                        System.out.println("\n");

                        System.out.println("Would you like to recover a deleted item? (y or n)");

                        answer = in.nextLine();

                        //Ask user if they would like to recover any deleted items listed
                        while(!answer.equalsIgnoreCase("y") && answer.equalsIgnoreCase("n")){
                            System.out.println("Not valid input!\n");
                            System.out.println("Would you like to recover a deleted item? (y or n)");
                            answer = in.nextLine();
                        }

                        //If the user wants to recover a deleted item, they will have to specify which item
                        if(answer.equalsIgnoreCase("y")){

                            System.out.println("Enter item name you'd like to recover: ");

                            itemName = in.nextLine();

                            //Checks if the item specified exists in the deleted items list
                            if(deletedItems.containsKey(itemName)){

                                //Retrieves the item specified
                                InventoryItem b = deletedItems.get(itemName);

                                //Adds the deleted item back into the inventory
                                inventory.put(itemName, b);

                                //Removes the item from the deletedItems HashMap
                                deletedItems.remove(itemName);

                                System.out.println(itemName + " has been recovered!\n");

                            }else{
                                System.out.println("An item with this name has not been deleted!\n");
                            }
                        }
                    }else{
                        System.out.println("Trash can is empty!\n\n");
                    }
                    break;
                case 6:
                    exit = 6;
                    break;
                default:
                    System.out.println("This is not an option");
                    break;
            }
        }
    }
}
