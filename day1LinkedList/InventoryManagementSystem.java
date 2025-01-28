/*4. Singly Linked List: Inventory Management System
Problem Statement: Design an inventory management system using a singly linked list where each node stores information
 about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:
Add an item at the beginning, end, or at a specific position.
Remove an item based on Item ID.
Update the quantity of an item by Item ID.
        Search for an item based on Item ID or Item Name.
Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
Sort the inventory based on Item Name or Price in ascending or descending order.
Hint:
Use a singly linked list where each node represents an item in the inventory.
Implement sorting using an appropriate algorithm (e.g., merge sort) on the linked list.
For total value calculation, traverse through the list and sum up Quantity * Price for each item.
*/
package com.week3.day1LinkedList;

import java.util.Comparator;

class Inventory {
    protected String itemName;
    protected int itemID;
    protected int quantity;
    protected double price;
    Inventory next;

    public Inventory(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class ItemLinkedList {
    private Inventory head;

    // Add an item at the beginning
    public void addItemAtBegin(String itemName, int itemID, int quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemID, quantity, price);
        newInventory.next = head;
        head = newInventory;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemID, int quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemID, quantity, price);
        if (head == null) {
            head = newInventory;
            return;
        }
        Inventory curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newInventory;
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        if (position <= 0) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            addItemAtBegin(itemName, itemID, quantity, price);
            return;
        }
        Inventory newInventory = new Inventory(itemName, itemID, quantity, price);
        Inventory curr = head;
        for (int i = 1; curr != null && i < position - 1; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Index out of range");
            return;
        }
        newInventory.next = curr.next;
        curr.next = newInventory;
    }

    // Delete an item by Item ID
    public void deleteInventoryRecord(int itemID) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        Inventory curr = head, prev = null;
        while (curr != null && curr.itemID != itemID) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Item Not Found");
            return;
        }
        prev.next = curr.next;
    }

    // Search for an item by Item ID
    public void searchItemDetailByID(int itemID) {
        Inventory curr = head;
        while (curr != null) {
            if (curr.itemID == itemID) {
                System.out.println("Inventory Found: Item Name: " + curr.itemName + ", Item ID: " + curr.itemID + ", Quantity: " + curr.quantity + ", Price: " + curr.price);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Inventory not found!");
    }

    // Search for an item by Item Name
    public void searchItemDetailByName(String itemName) {
        Inventory curr = head;
        while (curr != null) {
            if (curr.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Inventory Found: Item Name: " + curr.itemName + ", Item ID: " + curr.itemID + ", Quantity: " + curr.quantity + ", Price: " + curr.price);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Inventory not found!");
    }

    // Update the price of an item
    public void updatePrice(int itemID, double newPrice) {
        Inventory curr = head;
        while (curr != null) {
            if (curr.itemID == itemID) {
                curr.price = newPrice;
                System.out.println("Price updated for Item ID: " + itemID);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Inventory not found!");
    }

    // Update the quantity of an item
    public void updateQuantity(int itemID, int newQuantity) {
        Inventory curr = head;
        while (curr != null) {
            if (curr.itemID == itemID) {
                curr.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID: " + itemID);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Inventory not found!");
    }

    // Calculate the total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        Inventory curr = head;
        while (curr != null) {
            totalValue += curr.price * curr.quantity;
            curr = curr.next;
        }
        return totalValue;
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String sortBy, boolean ascending) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        // Implementing bubble sort with a while loop
        boolean swapped;
        Inventory curr;
        Inventory prev = null;
        Inventory temp;

        swapped = true;
        while (swapped) {
            swapped = false;
            curr = head;

            while (curr != null && curr.next != null) {
                boolean condition = false;

                if (sortBy.equalsIgnoreCase("name")) {
                    condition = ascending ? curr.itemName.compareTo(curr.next.itemName) > 0 : curr.itemName.compareTo(curr.next.itemName) < 0;
                } else if (sortBy.equalsIgnoreCase("price")) {
                    condition = ascending ? curr.price > curr.next.price : curr.price < curr.next.price;
                }

                if (condition) {
                    // Swap items
                    temp = curr;
                    curr = curr.next;
                    temp.next = curr.next;
                    curr.next = temp;
                    if (prev == null) {
                        head = curr;
                    } else {
                        prev.next = curr;
                    }
                    swapped = true;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }


    // Display all items in the inventory
    public void displayInventoryRecord() {
        if (head == null) {
            System.out.println("No record found");
            return;
        }
        Inventory curr = head;
        while (curr != null) {
            System.out.println("Item Name: " + curr.itemName + ", Item ID: " + curr.itemID + ", Quantity: " + curr.quantity + ", Price: " + curr.price);
            curr = curr.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        ItemLinkedList itemLinkedList = new ItemLinkedList();

        // Add items to inventory
        itemLinkedList.addItemAtBegin("Milk", 100, 2, 12.5);
        itemLinkedList.addItemAtEnd("Water", 102, 1, 2.1);
        itemLinkedList.addItemAtEnd("Knife", 103, 5, 74.0);
        itemLinkedList.addItemAtPosition("Pen", 101, 5, 10.0, 1);

        // Delete an item
        itemLinkedList.deleteInventoryRecord(101);

        // Search items
        itemLinkedList.searchItemDetailByID(102);
        itemLinkedList.searchItemDetailByName("Water");

        // Update price and quantity
        itemLinkedList.updatePrice(103, 72.0);
        itemLinkedList.updateQuantity(102, 10);

        // Display all items
        itemLinkedList.displayInventoryRecord();

        // Calculate total value
        System.out.println("Total Value of Inventory: " + itemLinkedList.calculateTotalValue());

        // Sort the inventory by price in descending order
        itemLinkedList.sortInventory("price", false);
        itemLinkedList.displayInventoryRecord();
    }
}

