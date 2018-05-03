// Songren Zhao
// 23390916
// CSC 22100 Spring 2018
public class Player
{
    private int index; //Keeping where the player is located
    private char name; //Just a name
    public Player(char name)
    {
        this.name = name;
        this.index = 0;
    }
    public int getIndex()
    {
        return this.index;
    }
    public void setIndex(int index) //I determine the updated location after i add the action
    {
        if (this.index + index < 0) //make sure negative index will not create any problems
            this.index = 0;
        else
            this.index += index; //Adding actions
    }
}
