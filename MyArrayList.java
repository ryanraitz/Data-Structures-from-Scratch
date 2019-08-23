//Program to implement the ArrayList data structure 

import java.util.Arrays;

public class MyArrayList 
{

	private Object[] arrayList;
	private int listSize = 0;
	
   //Constructor
	public MyArrayList()
   {
		arrayList = new Object[10];
	}
	
   //Method to retrieve an element at a desired index
	public Object get(int index)
   {
		if(index < listSize)
      {
			return arrayList[index];
		} 
      else 
      {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
   
   //Accessor method returning the size of the ArrayList
   public int size()
   {
		return listSize;
	}
	
   //Mutator method for appending an element to the ArrayList
	public void add(Object obj)
   {
		if(arrayList.length-listSize <= 5)
      {
			increaseListSize();
		}
		arrayList[listSize++] = obj;
	}
	
   //Mutator method for removing an element at a desired index
	public Object remove(int index)
   {
		if(index < listSize)
      {
			Object obj = arrayList[index];
			arrayList[index] = null;
			int temp = index;
			while(temp < listSize)
         {
				arrayList[temp] = arrayList[temp+1];
				arrayList[temp+1] = null;
				temp++;
			}
         
			listSize--;
			return obj;
		} 
      else 
      {
			throw new ArrayIndexOutOfBoundsException();
		}
		
	}
	
   //Mutator method to double the size of the ArrayList when more space is needed
	private void increaseListSize()
   {
		arrayList = Arrays.copyOf(arrayList, arrayList.length*2);
		System.out.println("\nNew length: "+arrayList.length);
	}
	
   //Main method including testing
	public static void main(String a[])
   {
		MyArrayList test = new MyArrayList();
		test.add(new Integer(1));
		test.add(new Integer(2));
		test.add(new Integer(1));
		test.add(new Integer(4));
		test.add(new Integer(5));
      
		for(int i=0;i<test.size();i++)
      {
			System.out.print(test.get(i)+" ");
		}
      
		test.add(new Integer(29));
		System.out.println("Element at Index 4: "+test.get(4));
		System.out.println("List size: "+test.size());
		System.out.println("Removing element at index 3: "+test.remove(3));
      System.out.println("List size: "+test.size());
		
      for(int i=0;i<test.size();i++)
      {
			System.out.print(test.get(i)+" ");
		}
	}
}