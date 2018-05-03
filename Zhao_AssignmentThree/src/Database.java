//Songren Zhao
//CSC 22100 Spring 2018
import java.util.*;

public class Database
{
    protected LinkedList<Item> item;
    public Database()
    {
        item = new LinkedList<Item>();
    }
    public void addItem(Item element)
    {
        item.add(element);
    }
    public void list()
    {
        for(Item o : item)
            System.out.println(o); //Since i implemented the Item toString, I can simply print the Item o using for each loop
    }
}
