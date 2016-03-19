package com.leclex;

/**
 * Created by 乐成 on 2016/3/14.
 */
public class SetAsArray {
    String[] items;

    SetAsArray() {
        items = new String[] {};
    }

    int indexOf(String item) {
        // Check if item is already present
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    boolean hasItem(String item) {
        return indexOf(item) > -1;
    }

    void addItem(String item) {
        if (hasItem(item)) {
            // item already present
            return;
        }

        // make new array
        String[] newItems = new String[items.length + 1];

        // add existing items
        System.arraycopy(items, 0, newItems, 0, items.length);

        // add item to new array
        newItems[newItems.length - 1] = item;

        // set new array
        items = newItems;
    }

    void removeItem(String item) {
        if (!hasItem(item)) {
            // item not present
            return;
        }

        // make new array
        String[] newItems = new String[items.length - 1];

        // add existing items except item to be removed
        System.arraycopy(items, 0, newItems, 0, indexOf(item)); // first half
        System.arraycopy(items, indexOf(item) + 1, newItems, indexOf(item),
                items.length - indexOf(item) -1);   // second half

        // set new array
        items = newItems;
    }

    void showContents() {
        System.out.println("Set contains " + items.length + " elements");
        for (int i = 0; i < items.length; i++) {
            System.out.println(" - Element " + i + ": " + items[i]);
        }
    }

    int size() {
        return items.length;
    }

    public static void main(String[] args) {
        SetAsArray mySet = new SetAsArray();
        mySet.addItem("A");
        mySet.addItem("B");
        mySet.addItem("C");
        mySet.addItem("A");
        mySet.showContents();
        mySet.removeItem("B");
        mySet.showContents();
        mySet.addItem("D");
        mySet.showContents();
    }
}
