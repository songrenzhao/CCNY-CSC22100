//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import java.awt.*;
import java.io.Serializable;

public abstract class MyShape implements Serializable //Must implements Serializable since we are passing seriablizable units
{
    private int x1, x2;
    private int y1, y2;
    private Color colorFigure;
    public MyShape() //Constructor
    {
        x1 = 0; x2 = 0;
        y1 = 0; y2 = 0;
        colorFigure = Color.BLACK;
    }
    public MyShape(int x1, int y1, int x2, int y2, Color colorFigure) //More Constructor
    {
        this.x1 = x1; this.x2 = x2;
        this.y1 = y1; this.y2 = y2;
        this.colorFigure = colorFigure;
    }
    public void setX1(int x1)
    {
        this.x1 = x1;
    }
    public void setX2(int x2)
    {
        this.x2 = x2;
    }
    public void setY1(int y1)
    {
        this.y1 = y1;
    }
    public void setY2(int y2)
    {
        this.y2 = y1;
    }
    public void setColor(Color colorFigure)
    {
        this.colorFigure = colorFigure;
    }
    public int getX1()
    {
        return x1;
    }
    public int getX2()
    {
        return x2;
    }
    public int getY1()
    {
        return y1;
    }
    public int getY2()
    {
        return y2;
    }
    public Color getColor()
    {
        return colorFigure;
    }
    public abstract void draw(Graphics g);
}
