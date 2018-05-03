//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import java.awt.*;

public abstract class MyBoundedShape extends MyShape
{
    private boolean isFilled;
    public MyBoundedShape()
    {
        super();
        isFilled = false;
    }
    public MyBoundedShape(int x1, int y1, int width, int height, Color colorFigure, boolean isFilled) //Change to height and width to save more work when drawing the shape
    {
        super(x1, y1, x1+width, y1+height, colorFigure);
        this.isFilled = isFilled;
    }
    public Boolean getFilled()
    {
        return isFilled;
    }
    public void setFilled(boolean filled)
    {
        this.isFilled = filled;
    }
    public int getUpperleftX()
    {
        return getX1();
    }
    public int getUpperleftY()
    {
        return getY1();
    }
    public int getWidth()
    {
        return Math.abs(getX1() - getX2());
    }
    public int getHeight()
    {
        return Math.abs(getY1() - getY2());
    }
}
