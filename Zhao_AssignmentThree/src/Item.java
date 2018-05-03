//Songren Zhao
//CSC 22100 Spring 2018
import java.util.*;

public abstract class Item implements Comparable<Item>
{
    private String id;
    private String title;
    private Date addedOn;
    String playingTime = "NULL";//Needed since toString method requires all instance variables from all subclasses
    String author;//Needed since toString method requires all instance variables from all subclasses
    public Item(String id, String title, Date addedOn) //Constructor
    {
        this.id = id;
        this.title = title;
        this.addedOn = addedOn;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setAddedOn(Date addedOn)
    {
        this.addedOn = addedOn;
    }
    public String getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public Date getAddedOn()
    {
        return addedOn;
    }
    public int compareTo(Item event)
    {
        return this.id.compareTo(event.id);
    }
    public String toString() //This will print the item's information regarding to its type
    {
        return "\nID: " + this.getId() + "\tTitle: " + this.getTitle() + "\tDate: " + addedOn.toString()
                + "\tPlaying Time: " + this.playingTime + "\tAuthor/Artist/Director: " + this.author;
    }
}
