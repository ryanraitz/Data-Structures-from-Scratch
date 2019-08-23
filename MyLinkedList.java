//Program to implement the singly-linked list data structure

import java.io.*; 
  
 
public class MyLinkedList 
{ 
  
    Node head; 
   
    static class Node 
    { 
  
        int data; 
        Node next; 
  
        //Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    }  
  
    // Mutator method to insert a new node into the LinkedList 
    public static MyLinkedList insert(MyLinkedList list, int data) 
    { 
        
        Node newNode = new Node(data); 
        newNode.next = null; 
  
        /* If the LinkedList is empty, 
           then set the new node as head */ 
        if (list.head == null) 
        { 
            list.head = newNode; 
        } 
        else 
        { 
         /* If the LinkedList is not empty, 
            traverse till the last node 
            and append the newNode there */
            Node last = list.head; 
            while (last.next != null) 
            { 
                last = last.next; 
            } 
  
            // Inserting newNode at last node 
            last.next = newNode; 
        } 
   
        return list; 
    } 
  
  
    // Accessor method to print the LinkedList 
    public static void printList(MyLinkedList list) 
    { 
        Node currentNode = list.head; 
  
        System.out.print("\nLinkedList: "); 
   
        while (currentNode != null) 
        {  
            System.out.print(currentNode.data + " "); 
  
            // Traverse to the next node 
            currentNode = currentNode.next; 
        } 
        System.out.println("\n"); 
    } 
  
  
    // Mutator method to delete a node by key in the LinkedList 
    public static MyLinkedList removeByKey(MyLinkedList list, int key) 
    { 
        
        Node currentNode = list.head, prev = null; 
         
        // If head node itself holds the key to be deleted 
        if (currentNode != null && currentNode.data == key) 
        { 
            list.head = currentNode.next; // Change head node
   
            System.out.println(key + " removed"); 
   
            return list; 
        } 
  
         
        // If the key is somewhere other than head  
        while (currentNode != null && currentNode.data != key) 
        {  
            // Continue to next node 
            prev = currentNode; 
            currentNode = currentNode.next; 
        } 
  
        // If the key was there, it will be at currentNode  
        if (currentNode != null) 
        { 
             
            // Unlink currentNode from the LinkedList 
            prev.next = currentNode.next; 
   
            System.out.println(key + " removed"); 
        } 
  
        // If the key was not present in the LinkedList  
        if (currentNode == null) 
        {  
            System.out.println(key + " not found"); 
        } 
   
        return list; 
    } 
  
  
    // Mutator method to delete a node by position in the LinkedList 
    public static MyLinkedList removeAtPosition(MyLinkedList list, int index) 
    { 
   
        Node currentNode = list.head, prev = null; 
  
       
        // If the index is 0, then the head node needs to be deleted 
         if (index == 0 && currentNode != null) 
         { 
            list.head = currentNode.next; 
   
            System.out.println(index + " position element removed"); 
   
            return list; 
        } 
   
        // If the index is greater than 0 but less than the size of the LinkedList  
        int count = 0; 
  
        /* Count to keep track of the previous node 
         as it needs to change to currNode.next */ 
        while (currentNode != null) 
        { 
  
            if (count == index) 
            { 
                /* If the currentNode is the required position, 
                   unlink the currentNode from the LinkedList */
                prev.next = currentNode.next; 
  
                System.out.println(index + " position element removed"); 
                break; 
            } 
            else 
            { 
                /* If currentNode is not in the required position,
                continue to the next node */
                prev = currentNode; 
                currentNode = currentNode.next; 
                count++; 
            } 
        } 
  
        /*  If the index is greater than the size of the LinkedList, 
            the currentNode should be null */
        if (currentNode == null) 
        {  
            System.out.println(index + " position element not found"); 
        } 
   
        return list; 
    }  
  
    // Main method with testing 
    public static void main(String[] args) 
    { 
        // Create an empty list
        MyLinkedList list = new MyLinkedList(); 
  
        
        // Insert some values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
  
        // Test print LinkedList 
        printList(list); 
  
        // Test case 1 for remove by key
        removeByKey(list, 1); 
        printList(list); 
  
        // Test case 2 for remove by key 
        removeByKey(list, 4);  
        printList(list); 
  
        // Test case 3 for remove by key 
        removeByKey(list, 10);  
        printList(list); 
  
        // Test case 1 for remove at position 
        removeAtPosition(list, 0);  
        printList(list); 
  
        // Test case 2 for remove at position 
        removeAtPosition(list, 2);  
        printList(list); 
  
        // Test case 3 for remove at position 
        removeAtPosition(list, 10);  
        printList(list); 
    } 
} 