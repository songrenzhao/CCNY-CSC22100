// Songren Zhao
// 23390916
// CSC 22100 Spring 2018
public class Board {
    private int gameLength; //User can change the length
    private String[] race = new String[70]; //Default length is 70

    public Board() {
        gameLength = 70;
        for (int i = 0; i < race.length; i++)
            race[i] = " ";
    }
    public Board(int gameLength)
    {
        this.gameLength = gameLength;
        race = new String[gameLength];
        for (int i = 0; i < race.length; i++)
            race[i] = " ";
    }
    public String[] getArray() //Since I am using this class, i need to obtain its array
    {
        return race;
    }
    public int getGameLength() //Getting information from my variable
    {
        return gameLength;
    }
}
