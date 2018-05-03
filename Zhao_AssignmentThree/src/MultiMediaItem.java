//Songren Zhao
//CSC 22100 Spring 2018
import java.util.*;

public abstract class MultiMediaItem extends Item
{
    private int playingTime;
    public MultiMediaItem(String id, String title, Date addedOn, int playingTime)//Constructor
    {
        super(id,title,addedOn);
        this.playingTime = playingTime;
        super.playingTime = "" + playingTime;//Override the parent class variable, needed in the toString method
    }
    public int getPlayingTime()
    {
        return this.playingTime;
    }
    public void setPlayingTime(int playingTime)
    {
        this.playingTime = playingTime;
    }
}
