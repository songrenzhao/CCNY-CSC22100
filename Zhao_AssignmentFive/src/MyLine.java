//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import java.awt.*;

public class MyLine extends MyShape
{
    public MyLine()
    {
        super();
    }
    public MyLine(int x1, int y1, int x2, int y2, Color colorFigure)
    {
        super(x1, y1, x2, y2, colorFigure);
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        g.drawLine(getX1(),getY1(),getX2(),getY2());
    }
}
