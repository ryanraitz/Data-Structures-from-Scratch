//Program to implement the hash map data structure

import java.util.ArrayList;

//Class that defines a node for the hash map
class MyHashNode<K, V>
{
   K key;
   V value;
   MyHashNode<K, V> next;
   
   //Constructor
   public MyHashNode(K key, V value)
   {
      this.key = key;
      this.value = value;
   }
}

//Class to implement hash map functionality
class MyHashMap<K, V>
{
   private ArrayList<MyHashNode<K, V>> bucketArray;
   private int bucketCount;
   private int size;
   
   //Constructor
   public MyHashMap()
   {
      bucketArray = new ArrayList<>();
      bucketCount = 10;
      size = 0;
      
      for(int i = 0;i < bucketCount;i++)
      {
        bucketArray.add(null);
      }
   }
   
   //Accessor method that returns the size of the hash map
   public int size()
   {
      return size;
   }
   
   //Method to verify whether the hash map is populated or not
   public boolean isEmpty()
   {
      return size() == 0;
   }
   
   //Accessor method that returns the index of a hash node given the key
   private int getBucketIndex(K key)
   {
      int hashCode = key.hashCode();
      int index = hashCode % bucketCount;
      return index;
   }
   
   //Mutator method that removes a hash node with a specified key
   //and returns the value associated with the removed node
   public V remove(K key)
   {
      int bucketIndex = getBucketIndex(key);
      MyHashNode<K, V> head = bucketArray.get(bucketIndex);
      MyHashNode<K, V> prev = null;
      //If the hash map is populated
      while(head!=null)
      {
         if(head.key.equals(key))
         {
            break;
         }
         else
         {
            prev = head;
            head = head.next;
         }
      }
      //If the hash map is empty
      if(head == null)
      {
         return null;
      }
      else
      {
         size--;
      }
      //Shift nodes based on removal 
      if(prev != null)
      {
         prev.next = head.next;
      }
      else
      {
         bucketArray.set(bucketIndex, head.next);
      }
      
      return head.value;
   }
   
   //Accessor method to retrieve the value of a node given the key
   public V get(K key)
   {
      int bucketIndex = getBucketIndex(key);
      MyHashNode<K, V> head = bucketArray.get(bucketIndex);
      //If the hash map is populated
      while(head!=null)
      {
         if(head.key.equals(key))
         {
            return head.value;
         }
         else
         {
            head = head.next;
         }
      }
      //If the hash map is empty
      return null;
   }
   
   //Mutator method that adds a node to the hashmap with a specified key and value
   public void add(K key, V value)
   {
      int bucketIndex = getBucketIndex(key);
      MyHashNode<K, V> head = bucketArray.get(bucketIndex);
      //If the hash map is populated
      while(head!=null)
      {
         if(head.key.equals(key))
         {
            head.value = value;
            return;
         }
         
         head = head.next;
      }
      //If the hash map is empty
      size++;
      head = bucketArray.get(bucketIndex);
      MyHashNode<K, V> freshNode = new MyHashNode<K, V>(key, value);
      freshNode.next = head;
      bucketArray.set(bucketIndex, freshNode);
      //Double the size of the hash map to avoid collisions
      if((1.0*size)/bucketCount >= 0.7)
      {
         ArrayList<MyHashNode<K, V>> temp = bucketArray;
         bucketArray = new ArrayList<>();
         bucketCount = 2*bucketCount;
         size = 0;
         for(int i=0;i<bucketCount;i++)
         {
            bucketArray.add(null);
         }
         //Repopulate new hash map
         for(MyHashNode<K, V> headNode: temp)
         {
            while(headNode!=null)
            {
               add(headNode.key, headNode.value);
               headNode = headNode.next;
            }
         }
      }
    }
    
    //Main method
    public static void main(String[] args)
    {
      MyHashMap<String, Integer>map = new MyHashMap<>();
      map.add("I", 1);
      map.add("Think", 2);
      map.add("I", 4);
      map.add("Rock", 5);
      //Test size accessor method
      System.out.println(map.size());
      //Test remove mutator method 
      System.out.println(map.remove("I"));
      System.out.println(map.remove("I"));
      //Verify size after removal method testing
      System.out.println(map.size());
      //Test boolean isEmpty method
      System.out.println(map.isEmpty());
    }
}
        