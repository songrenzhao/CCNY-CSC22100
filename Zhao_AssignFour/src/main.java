//Songren Zhao
//CSC 22100
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class main extends JFrame
{
    //Create components
    final int HEIGHT = 425;
    final int WIDTH = 600;
    static int fontSize = 18; //Track the font, increase/decrease when buttons are clicked
    final static String[] fontName = new String[]{"Serif","Sans-Serif","Monospaced"};
    private static Font defaultFont = new Font("ROMAN_BASELINE", Font.PLAIN, 20);
    private static JTextArea input = new JTextArea(30, 20);
    private static JScrollPane scroll = new JScrollPane(input,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private static JComboBox<String> comboBox = new JComboBox<>(fontName);
    private static JCheckBox checkBox = new JCheckBox("Bold");
    private static JButton increaseSize = new JButton("Increase Font");
    private static JButton decreaseSize = new JButton("Decrease Font");
    private static JLabel styleLabel = new JLabel("Text Style: ");
    private static JLabel boldLabel = new JLabel("Check to Bold: ");
    private static JLabel fontOutput = new JLabel("Your current font is " + fontSize);
    public main()
    {
        super("Large-Type Displays for People with Low Vision. By Songren Zhao, CSC 22100");
        setSize(WIDTH,HEIGHT);
        setLayout(null); //Set it to null then i can adjust the coordinates
        input.setBounds(10,10,565,250); scroll.setBounds(10,10,565,250); add(scroll);
        styleLabel.setBounds(10,280,100,25); add(styleLabel);
        comboBox.setBounds(110,280,160,25); add(comboBox);
        boldLabel.setBounds(305,280,200,25); add(boldLabel);
        checkBox.setBounds(435,280,100,25); add(checkBox);
        increaseSize.setBounds(20,320,200,25); add(increaseSize);
        decreaseSize.setBounds(310,320,200,25); add(decreaseSize);
        fontOutput.setBounds(180,350,200,25); add(fontOutput);

        //Setting the default font size
        input.setFont(new Font("SERIF", Font.PLAIN, 18));
        comboBox.setFont(defaultFont);
        styleLabel.setFont(defaultFont);
        boldLabel.setFont(defaultFont);
        checkBox.setFont(defaultFont);
        increaseSize.setFont(defaultFont);
        decreaseSize.setFont(defaultFont);
        fontOutput.setFont(defaultFont);

        comboBox.addActionListener(new ActionListener() { //comboBox selection
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(comboBox.getSelectedItem().equals("Serif"))
                {
                    if(checkBox.isSelected())
                        input.setFont(new Font("serif", Font.BOLD, fontSize));
                    else
                        input.setFont(new Font("serif", Font.PLAIN, fontSize));
                }
                if(comboBox.getSelectedItem().equals("Sans-Serif"))
                {
                    if(checkBox.isSelected())
                        input.setFont(new Font("sans-serif", Font.BOLD, fontSize));
                    else
                        input.setFont(new Font("sans-serif", Font.PLAIN, fontSize));
                }
                if(comboBox.getSelectedItem().equals("Monospaced"))
                {
                    if(checkBox.isSelected())
                        input.setFont(new Font("Monospaced", Font.BOLD, fontSize));
                    else
                        input.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
                }
            }
        });
        checkBox.addActionListener(new ActionListener() { //checkBox interaction
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(checkBox.isSelected())
                    input.setFont(input.getFont().deriveFont(Font.BOLD));
                if(!checkBox.isSelected())
                    input.setFont(input.getFont().deriveFont(Font.PLAIN));
            }
        });
        increaseSize.addActionListener(new ActionListener() { //Increase font size by 1
            @Override
            public void actionPerformed(ActionEvent e)
            {
                input.setFont(input.getFont().deriveFont((float)++fontSize));
                input.repaint();
                fontOutput.setText("Your current font is " + fontSize);
            }
        });
        decreaseSize.addActionListener(new ActionListener() { //decrease font size by 1
            @Override
            public void actionPerformed(ActionEvent e)
            {
                input.setFont(input.getFont().deriveFont((float)--fontSize));
                input.repaint();
                fontOutput.setText("Your current font is " + fontSize);
            }
        });
        input.setLineWrap(true); //align the text
        input.setWrapStyleWord(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        main newFrame = new main();
    }
}
