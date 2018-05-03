//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawPanel extends JPanel
{
    private MyShape[] shapes;
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Color currentColor;
    private boolean filledShape;
    private JLabel statusLabel = new JLabel();

    private int x1, x2;
    private int y1, y2;
    public void setShapes(MyShape[] shapes) //Provide a method to set the array of shapes
    {
        shapeCount = 0;                     //it is required because we will load another array using JFileChooser
        for(int i = 0; i < 100; i++)
        {
            this.shapes[i] = shapes[i];
            if(shapes[i] != null)
                shapeCount++;
        }
        repaint();
    }
    public MyShape[] getShapes()
    {
        return shapes;
    }
    public void setShapeType(int shapeType)
    {
        this.shapeType = shapeType;
    }
    public void setCurrentColor(Color currentColor)
    {
        this.currentColor = currentColor;
    }
    public void setFilledShape(boolean filledShape)
    {
        this.filledShape = filledShape;
    }
    public void clearLastShape() //Check if shapeCount != 0, then repaint after shapeCount decreases
    {
        if(shapeCount != 0)
        {
           shapeCount--;
            repaint();
        }
    }
    public void clearDrawing()  //Clear everything
    {
        shapeCount = 0;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = 0; i < shapeCount; i++)
        {
            if(shapes[i] != null)
                shapes[i].draw(g);
            if(currentShape != null) //Guarantee figure is visibly drawn.
                currentShape.draw(g); //We need two because currentShape represents the shape that can be changing as we adjust the cursor.
        }
    }
    private class Mouse extends MouseAdapter implements MouseMotionListener
    {
        @Override
        public void mousePressed(MouseEvent m)
        {
            //We dont do much for this because we are not creating the drawing yet, we only specify their locations
            x1 = m.getX();
            y1 = m.getY();
        }
        @Override
        public void mouseReleased(MouseEvent m)
        {
            x2 = m.getX();
            y2 = m.getY();
            switch(shapeType) //This switch case will finalize how my shapes/drawings will behave
            {
                case 0:
                    currentShape = new MyLine(x1, y1, x2, y2, currentColor);
                    shapes[shapeCount] = currentShape;
                    currentShape = null;
                    shapeCount++;
                    repaint();
                    break;
                case 1:
                    currentShape = new MyOval(x1, y1, (m.getX()-x1), (m.getY()-y1), currentColor,filledShape); //The height and width are not absoluted because i want them to drag without limitation.
                    shapes[shapeCount] = currentShape; //If it is absolute valued, then i can only draw from upper left to lower right.
                    currentShape = null;
                    shapeCount++;
                    repaint();
                    break;
                case 2:
                    currentShape = new MyRectangle(x1, y1, (m.getX()-x1), (m.getY()-y1), currentColor,filledShape);
                    shapes[shapeCount] = currentShape;
                    currentShape = null;
                    shapeCount++;
                    repaint();
                    break;
            }
        }
        @Override
        public void mouseMoved(MouseEvent m)
        {
            statusLabel.setText(String.format("%d, %d", m.getX(), m.getY()));
        }
        @Override
        public void mouseDragged(MouseEvent m) { //This method provides me how my drawing/shape behaves as I hold my cursor
            x2 = m.getX();
            y2 = m.getY();
            statusLabel.setText(String.format("%d, %d", m.getX(), m.getY()));
            switch (shapeType)
            {
                case 0:
                    currentShape = new MyLine(x1, y1, m.getX(), m.getY(), currentColor);
                    repaint();
                    break;
                case 1:
                    currentShape = new MyOval(x1, y1, (m.getX()-x1), (m.getY()-y1), currentColor, filledShape);
                    repaint();
                    break;
                case 2:
                    currentShape = new MyRectangle(x1, y1, (m.getX()-x1), (m.getY()-y1), currentColor, filledShape);
                    repaint();
                    break;
            }
        }
    }
    public DrawPanel(JLabel statusLabel)
    {
        this.statusLabel = statusLabel;
        shapes = new MyShape[100];
        shapeCount = 0;
        shapeType = 0;
        currentShape = null;
        currentColor = Color.BLACK;
        this.setBackground(Color.WHITE);

        Mouse cursor = new Mouse();
        this.addMouseListener(cursor);
        this.addMouseMotionListener(cursor);
        currentShape = new MyRectangle(5,5,20,20,Color.WHITE,false); //Just a random shape, I need this because it allows a visible first shape. I will set it to white to keep clean.
        shapes[shapeCount] = currentShape;
        currentShape = null;
        shapeCount++;
        repaint();
    }
}
