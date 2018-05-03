//Songren Zhao
//CSC 22100 Spring 2018
import java.util.Comparator;

public class sortByTitle implements Comparator<Item>
{
    public int compare(Item i1, Item i2)
    {
        return i1.getTitle().compareTo(i2.getTitle());
    }
}
