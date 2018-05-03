//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import java.awt.*;

public class MyOval extends MyBoundedShape
{
    public MyOval()
    {
        super();
    }
    public MyOval(int x1, int y1, int width, int height, Color colorFigure, boolean isFilled)
    {
        super(x1, y1, width, height, colorFigure, isFilled);
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        int x1 = super.getX1();
        int x2 = super.getX2();
        int y1 = super.getY1();
        int y2 = super.getY2();
        if(x1 > x2)  //It will determine which two are the bigger coordinates,
            x1 = x2; //Allows me to draw the shape however i want.
        if(y1 > y2)  //Without any restriction
            y1 = y2;
        if(getFilled())
            g.fillOval(x1,y1,getWidth(),getHeight());
        else
            g.drawOval(x1,y1,getWidth(),getHeight());
    }
}
