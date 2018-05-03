import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JHelloFrame extends JFrame implements ActionListener
{
    Font bigFont = new Font("Times New Roman", Font.BOLD, 16);
    JLabel JLabel_firstName = new JLabel("Enter your first name:");
    JTextField firstName = new JTextField(10);
    JLabel JLabel_lastName = new JLabel("Enter your last name:");
    JTextField lastName = new JTextField(10);
    JLabel JLabel_Month = new JLabel("Month of birth:");
    JTextField month = new JTextField(2);
    JLabel JLabel_Day = new JLabel("Day of birth:");
    JTextField day = new JTextField(2);
    JLabel JLabel_Year = new JLabel("Year of birth:");
    JTextField year = new JTextField(4);
    JButton pressMe =  new JButton("Submit");
    JLabel greeting1 = new JLabel("");
    JLabel greeting2 = new JLabel("");
    JLabel greeting3 = new JLabel("");
    JLabel greeting4 = new JLabel("");
    final int WIDTH = 400;
    final int HEIGHT = 300;
    public JHelloFrame() {
        super("Heart Rate Detector by Songren Zhao");
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        JLabel_firstName.setFont(bigFont);
        JLabel_lastName.setFont(bigFont);
        JLabel_Month.setFont(bigFont);
        JLabel_Day.setFont(bigFont);
        JLabel_Year.setFont(bigFont);
        greeting1.setFont(bigFont);
        greeting2.setFont(bigFont);
        greeting3.setFont(bigFont);
        greeting4.setFont(bigFont);

        JLabel_firstName.setBounds(10,10,180,20);
        JLabel_lastName.setBounds(10,35,180,20);
        firstName.setBounds(190,10,150,20);
        lastName.setBounds(190,35,150,20);
        JLabel_Month.setBounds(10,60,150,20);
        month.setBounds(190,60,150,20);
        JLabel_Day.setBounds(10,85,150,20);
        day.setBounds(190,85,150,20);
        JLabel_Year.setBounds(10,110,150,20);
        year.setBounds(190,110,150,20);
        pressMe.setBounds(115,135,150,20);
        greeting1.setBounds(75,160,400,20);
        greeting2.setBounds(120,185,400,20);
        greeting3.setBounds(65,210,4000,20);
        greeting4.setBounds(35,235,4000,20);

        add(JLabel_firstName);
        add(firstName);
        add(JLabel_lastName);
        add(lastName);
        add(JLabel_Day);
        add(day);
        add(JLabel_Month);
        add(month);
        add(JLabel_Year);
        add(year);
        add(pressMe);
        add(greeting1);
        add(greeting2);
        add(greeting3);
        add(greeting4);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pressMe.addActionListener(this);
    }
    public static boolean checkDay(int day, int month, int year) {
        if(year < 1896 || year > 2019)
            return false;
        if(year%4 == 0) {
            if (month == 2)
                return day >= 1 && day <= 29;
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                return day >= 1 && day <= 31;
            else
                return day >= 1 && day <= 30;
        }
        else{
            if (month == 2)
                return day >= 1 && day <= 28;
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                return day >= 1 && day <= 31;
            else
                return day >= 1 && day <= 30;
        }
    }
    public void actionPerformed(ActionEvent e) {
        try {
            String regStr = "[a-zA-Z]+";
            int Person_Month = Integer.parseInt(month.getText());
            int Person_Day = Integer.parseInt(day.getText());
            int Person_Year = Integer.parseInt(year.getText());
            if (!(firstName.getText().matches(regStr) && lastName.getText().matches(regStr))){
                JOptionPane.showMessageDialog(null, "You can't have number/numbers in your name!", "ERROR", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
            HeartRates person = new HeartRates(firstName.getText(), lastName.getText(), Person_Month, Person_Day, Person_Year);
            if (!(checkDay(Person_Month, Person_Day, Person_Year))) {
                JOptionPane.showMessageDialog(null, "Please make sure your date corresponds to the calendar.\nProgram will exit now.",
                        "ERROR", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
            greeting1.setText("Your name is " + person.getFirstName() + " " + person.getLastName());
            greeting2.setText("Your age is "+ person.getAge());
            greeting3.setText("Your maximum heart rate is " + person.getHeartRate());
            greeting4.setText("Target Heart Rate Range:\t" + person.getLowerTargetHeartRate()+ " to " + person.getUpperTargetHeartRate());
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null, "Please check your inputs.\nProgram will exit now.",
                    "ERROR", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        JHelloFrame frame = new JHelloFrame();
    }
}
