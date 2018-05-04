//Songren Zhao
//CSC 22100
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class main extends JFrame
{
    private static boolean precedence(char o1, char o2)
    {
        int o1_order = 0;
        int o2_order = 0;
        switch(o1)
        {
            case '+': o1_order = 1; break;
            case '-': o1_order = 1; break;
            case '*': o1_order = 2; break;
            case '/': o1_order = 2; break;
            case '%': o1_order = 2; break;
            case '^': o1_order = 3; break;
        }
        switch(o2)
        {
            case '+': o2_order = 1; break;
            case '-': o2_order = 1; break;
            case '*': o2_order = 2; break;
            case '/': o2_order = 2; break;
            case '%': o2_order = 2; break;
            case '^': o2_order = 3; break;
        }
        return o1_order <= o2_order;
    }
    private static boolean isOperator(char o)
    {
        return o == '+' || o == '-' || o == '*' || o == '/'|| o == '^' || o == '%';
    }
    public static StringBuffer convertToPostfix(StringBuffer infix)
    {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        StringBuffer postFix = new StringBuffer("");
        stack.push('(');
        infix.append(')');
        while(!stack.isEmpty())
        {
            if(Character.isDigit(infix.charAt(count)) || Character.isLetter(infix.charAt(count)))
                postFix.append(infix.charAt(count) + " ");
            else if(infix.charAt(count) == '(')
            {
                stack.push('(');
            }
            else if(isOperator(infix.charAt(count)))
            {
                while(isOperator(stack.peek()) && precedence(infix.charAt(count),stack.peek()))
                    postFix.append(stack.pop() + " ");
                stack.push(infix.charAt(count));
            }
            else if(infix.charAt(count) == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                    postFix.append(stack.pop() + " ");
                stack.pop();
            }
            count++;
        }
        return postFix;
    }
    public main()
    {
        super("Songren Zhao CSC 22100");
        setLayout(new BorderLayout());
        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JTextField in = new JTextField(30);
        JTextField post = new JTextField(30);
        JButton convert = new JButton("Convert");

        leftPanel.add(in);
        middlePanel.add(convert);
        rightPanel.add(post);

        add(leftPanel, BorderLayout.WEST);
        add(middlePanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        pack();

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuffer infix = new StringBuffer("");
                infix.append(in.getText());
                StringBuffer postFix = convertToPostfix(infix);
                post.setText(postFix.toString());
            }
        });
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new main();
    }
}
