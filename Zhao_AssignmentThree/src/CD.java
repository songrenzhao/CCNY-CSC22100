//Songren Zhao
//CSC 22100 Spring 2018
import java.util.*;

public class CD extends MultiMediaItem
{
    private String artist;
    public CD(String id, String title, Date addedOn, int playingTime, String artist)//Constructor
    {
        super(id,title,addedOn,playingTime);
        this.artist = artist;
        super.author = artist;//Override the parent class variable, needed in the toString method
    }
    public String getArtist()
    {
        return artist;
    }
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
}
