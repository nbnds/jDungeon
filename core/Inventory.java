package core;
import java.util.ArrayList;

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory
{
    final int maxSize = 20;
    private ArrayList<Item> inventory;
    public Inventory(){inventory = new ArrayList<Item>();}
    public void addItem(Item i){
        inventory.add(i);
    }
    public void removeItem(Item i){
    }
	public int getSize() {
		// TODO Auto-generated method stub
		return inventory.size();
	}
	public int getMaxSize(){
		return maxSize;
	}
    public Item getItemByName(String s)
    {
        for(int i=0;i < this.getSize();i++)
        {
            if (inventory.get(i).get_name().equals(s))
            {
               return inventory.get(i); 
            }
            else
            {
                
            }
        }
        return null;
    }
    public void list_inventory()
    {
        if(inventory.isEmpty()==false)
        {
          for (int i=0; i<inventory.size();i++)
          {
            System.out.println(inventory.get(i).get_name());
          }
        }
        else
        {
            System.out.println("Inventar ist leer.");
        }
    }
    
    public void drop_item(String s) throws IndexOutOfBoundsException
    {
        try
       {
          if(this.isEmpty()==false)
          {
           inventory.remove(getItemByName(s));
           }
           else
           {
            System.out.println("Inventar ist leer.");
           }
           
            //debugging output
            System.out.println(s+" wurde entfernt");

       }
       catch(IndexOutOfBoundsException IoBE){
        System.out.println("Gegenstand nicht gefunden");
       }
            
    }
    public void drop_item(Item i){
    	inventory.remove(i);
    }
 
	public boolean isEmpty() {
		boolean ret = (this.getSize()==0);
		if (this.getSize()==0){
			ret = true;

		}else if(this.getSize()>0){
			ret = false;

		}
		return ret;
	}
}
