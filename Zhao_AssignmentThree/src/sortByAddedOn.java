//Songren Zhao
//CSC 22100 Spring 2018
import java.util.Comparator;

public class sortByAddedOn implements Comparator<Item>
{
    public int compare(Item i1, Item i2)
    {
        return i1.getAddedOn().compareTo(i2.getAddedOn());
    }
}