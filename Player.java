/**
 *
 * @author nbnds
 */
import java.util.*;
public class Player {
    private String name = "dummy";
    private int posx; 
    private int posy;
    private ArrayList<Item> inventory; //inventory not an instance of Inventory? WTF?!
    private World w;
    //Default Konstruktor
    public Player(String n)
    {
        name = n;
        posy = 0;
        posx = 0;
        inventory = new ArrayList<Item>();
        w = new World(); //evry player has own copy of the world
    }
    public Player(String n, Item [] i){
            name = n;
        posy = 0;
        posx = 0;
        inventory = new ArrayList<Item>(Arrays.asList(i));
        w = new World(); //evry player has own copy of the world
    }
    public void getStats()
    {
        System.out.println(name);
        //System.out.println(age);
    }
    public String getPlayerName()
    {
        return name;
    }
    public Item getItemByName(String s)
    {
        for(int i=0;i < inventory.size();i++)
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
    public int getValue(Item i)
    {
        return i.item_value;
    }
    public void pickup_item(String s)
    {   
        Item i = new Item(s);
        inventory.add(i);
    }
    
    public void drop_item(String s) throws IndexOutOfBoundsException
    {
        try
       {
          if(inventory.isEmpty()==false)
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
    public void look_around()
    {
        this.w.descr(this.posx,this.posy);
    }
    public void go_east()
    {
        if ((this.posx+1 <= this.w.getmap()[0].length-1)&&(w.getmap()[posy][posx+1]!=1))
        {
            System.out.println("Sie gehen nach Osten");
            this.posx=this.posx+1;
        }
        else
        {
            System.out.println("Da ist kein Weg nach Osten");
        }
    }
    public void go_north()
    {
        if ((this.posy-1 >= 0) && (this.w.getmap()[this.posy-1][this.posx] !=1))
        {
           System.out.println("Sie gehen nach Norden");
           this.posy=this.posy-1;
        }
        else
        {
            System.out.println("Da ist kein Weg nach Norden"); 
        }
    }
    public void  go_south()
    {
        if ((this.posy+1 <= this.w.getmap()[0].length)&&(this.w.getmap()[this.posy+1][this.posx] !=1))
        {
            System.out.println("Sie gehen nach Sueden");
            this.posy=this.posy+1;
        }
        else
        {   
            System.out.println("Da ist kein Weg nach Sueden");
        }
    }
    public void go_west()
    {
        if ((this.posx-1 >= 0)&&(this.w.getmap()[this.posy][this.posx-1]!=1))
        {
            System.out.println("Sie gehen nach Westen");
            this.posx=this.posx-1;
        }
        else
        {  
            System.out.println("Da ist kein Weg nach Westen");
        }
    }
    public void tell_message()
    {
    }
    public void inspect(Item i)
    {
    }
    public void open(Item i)
    {
    }
    
}
