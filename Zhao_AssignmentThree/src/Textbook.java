//Songren Zhao
//CSC 22100 Spring 2018
import java.util.*;

public class Textbook extends Item
{
    private String author;
    public Textbook(String id, String title, Date addedOn, String author)
    {
        super(id,title,addedOn);
        this.author = author;
        super.author = author;
    }
    public String getAuthor()
    {
        return author;
    }
}

