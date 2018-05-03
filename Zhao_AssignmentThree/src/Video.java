//Songren Zhao
//CSC 22100 Spring 2018
import java.util.*;

public class Video extends MultiMediaItem
{
    private String director;
    public Video(String id, String title, Date addedOn,int playingTime, String director)//Constructor
    {
        super(id,title,addedOn,playingTime);
        this.director = director;
        super.author = director;//Override the parent class variable, needed in the toString method
    }
    public String getDirector()
    {
        return this.director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
}
