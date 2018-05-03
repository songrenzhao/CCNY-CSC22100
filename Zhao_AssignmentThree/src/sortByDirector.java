//Songren Zhao
//CSC 22100 Spring 2018
import java.util.Comparator;

public class sortByDirector implements Comparator
{
    public int compare(Object i1, Object i2)
    {
        if(i1 instanceof String && i2 instanceof String) {
            String s1 = (String)i1;
            String s2 = (String)i2;
            return s1.compareTo(s2);
        }
        return 0;
    }
}
