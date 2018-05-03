//Songren Zhao
//CSC 22100
//szhao003@citymail.cuny.edu
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DrawFrame extends JFrame
{
    //Creating GUI components
    private JButton undo = new JButton("Undo");
    private JButton clear = new JButton("Clear");
    private String[] colors = {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray","Magenta","Orange","Pink","Red","White","Yellow"};
    private String[] availableShapes = {"Line","Oval","Rectangle"};
    private JComboBox<String> color = new JComboBox<>(colors);
    private JComboBox<String> shapes = new JComboBox<>(availableShapes);
    private JCheckBox isFilled = new JCheckBox("Filled");
    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");
    private JLabel statusLabel = new JLabel("Label");
    public DrawFrame()
    {
        super("Songren Zhao, CSC 22100");
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout()); //Layout for JButtons
        JPanel southPanel = new JPanel(new FlowLayout()); //Layout for coordinate label and JFileChooser
        DrawPanel drawPanel = new DrawPanel(statusLabel); //The Drawing panel
        northPanel.add(undo);
        northPanel.add(clear);
        northPanel.add(color);
        northPanel.add(shapes);
        northPanel.add(isFilled);

        southPanel.add(statusLabel);
        southPanel.add(save);
        southPanel.add(load);

        add(northPanel,BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        undo.addActionListener(new ActionListener() { //Adding Actionlisteners for JButton
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearLastShape();
            }
        });
        clear.addActionListener(new ActionListener() { //Adding Actionlisteners for JButton
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearDrawing();
            }
        });
        color.addActionListener(new ActionListener() { //Adding Actionlisteners for JButton
            @Override
            public void actionPerformed(ActionEvent e) {
                if(color.getSelectedItem().equals("Black"))
                    drawPanel.setCurrentColor(Color.BLACK);
                if(color.getSelectedItem().equals("Blue"))
                    drawPanel.setCurrentColor(Color.BLUE);
                if(color.getSelectedItem().equals("Cyan"))
                    drawPanel.setCurrentColor(Color.CYAN);
                if(color.getSelectedItem().equals("Dark Gray"))
                    drawPanel.setCurrentColor(Color.DARK_GRAY);
                if(color.getSelectedItem().equals("Gray"))
                    drawPanel.setCurrentColor(Color.GRAY);
                if(color.getSelectedItem().equals("Green"))
                    drawPanel.setCurrentColor(Color.GREEN);
                if(color.getSelectedItem().equals("Light Gray"))
                    drawPanel.setCurrentColor(Color.LIGHT_GRAY);
                if(color.getSelectedItem().equals("Magenta"))
                    drawPanel.setCurrentColor(Color.MAGENTA);
                if(color.getSelectedItem().equals("Orange"))
                    drawPanel.setCurrentColor(Color.ORANGE);
                if(color.getSelectedItem().equals("Pink"))
                    drawPanel.setCurrentColor(Color.PINK);
                if(color.getSelectedItem().equals("Red"))
                    drawPanel.setCurrentColor(Color.RED);
                if(color.getSelectedItem().equals("White"))
                    drawPanel.setCurrentColor(Color.WHITE);
                if(color.getSelectedItem().equals("Yellow"))
                    drawPanel.setCurrentColor(Color.YELLOW);
            }
        });
        shapes.addActionListener(new ActionListener() { //Adding Actionlisteners for JButton
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shapes.getSelectedItem().equals("Line"))
                    drawPanel.setShapeType(0);
                if(shapes.getSelectedItem().equals("Oval"))
                    drawPanel.setShapeType(1);
                if(shapes.getSelectedItem().equals("Rectangle"))
                    drawPanel.setShapeType(2);
            }
        });
        isFilled.addItemListener(new ItemListener() { //Adding Actionlisteners for JButton
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(isFilled.isSelected())
                    drawPanel.setFilledShape(true);
                else
                    drawPanel.setFilledShape(false);
            }
        });
        save.addActionListener(new ActionListener() { //Adding Actionlisteners for JButton
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fs = new JFileChooser();
                fs.setDialogTitle("Save a File");
                int result = fs.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    File file = fs.getSelectedFile();
                    FileOutputStream fis;
                    try
                    {
                        fis = new FileOutputStream(file);
                        ObjectOutputStream input = new ObjectOutputStream(fis);
                        for(int i = 0; i < 100; i++)
                            input.writeObject(drawPanel.getShapes()[i]);
                        fis.close();
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(null,"Error");
                    }
                }
            }
        });
        load.addActionListener(new ActionListener() { //Adding Actionlisteners for JButton
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fs = new JFileChooser();
                fs.setDialogTitle("Load a File");
                int result = fs.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    File file = fs.getSelectedFile();
                    FileInputStream fis;
                    try {
                        fis = new FileInputStream(file);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        MyShape[] another = new MyShape[100];
                        for(int i = 0; i < 100; i++)
                            another[i] = (MyShape)ois.readObject();
                        drawPanel.setShapes(another);
                        drawPanel.repaint();
                        ois.close();
                     } catch(Exception ex) {
                         JOptionPane.showMessageDialog(null,"Error");
                     }
                }
            }
        });
    }
}