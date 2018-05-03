//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import java.awt.*;

public class MyRectangle extends MyBoundedShape
{
    public MyRectangle()
    {
        super();
    }
    public MyRectangle(int x1, int y1, int width, int height, Color colorFigure, boolean isFilled)
    {
        super(x1, y1, width, height, colorFigure, isFilled);
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        int x1 = super.getX1();//It will determine which two are the bigger coordinates,
        int x2 = super.getX2();//Allows me to draw the shape however i want.
        int y1 = super.getY1();//Without any restriction
        int y2 = super.getY2();
        if(x1 > x2)
            x1 = x2;
        if(y1 > y2)
            y1 = y2;
        if(getFilled())
            g.fillRect(x1,y1,getWidth(),getHeight());
        else
            g.drawRect(x1,y1,getWidth(),getHeight());
    }
}
