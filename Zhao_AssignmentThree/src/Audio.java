import java.util.*;

public class Audio extends MultiMediaItem
{
    private String Director;
    public Audio(String id, String title, Date addedOn, int playingTime, String Director)
    {
        super(id,title,addedOn,playingTime);
        this.Director = Director;
        super.author = Director;//Override the parent class variable, needed in the toString method
    }
    public String getAuthor()
    {
        return null;
    }
    public String getArtist()
    {
        return null;
    }
    public String getDirector()
    {
        return this.Director;
    }
    public void setDirector(String Director)
    {
        this.Director = Director;
    }
}
