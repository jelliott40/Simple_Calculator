package solution;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * Calculator class.
 * @author elliottjc
 * @version 2/12/18
 *
 */
public class Calculator
{
    private JFrame frame;
    private JTextField left;
    private JTextField right;
    private JLabel resultLabel;
    private int frameSize = 400;

    /**
     * Calculator constructor.
     * 
     */
    public Calculator()
    {
        frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(frameSize, frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Simple Calculator");

        makeCalculator();

        frame.pack();
        frame.setVisible(true); 
    }

    /**
     * makeCalculator method. Creates all panels, buttons, and frames.
     */
    public void makeCalculator()
    {
        //JFrame calculatorFrame = new JFrame();

        JButton add =  new JButton("ADD");
        add.setName("addButton");
        JButton sub =  new JButton("SUB");
        sub.setName("subButton");
        JButton mult =  new JButton("MULT");
        mult.setName("multButton");
        JButton div =  new JButton("DIV");
        div.setName("divButton");

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent add)
            {
                addClicked();
            }
        });

        sub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent sub)
            {
                subClicked();
            }
        });

        mult.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent mult)
            {
                multClicked();
            }
        });

        div.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent div)
            {
                divClicked();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(add);
        buttonPanel.add(sub);
        buttonPanel.add(mult);
        buttonPanel.add(div);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel("Result = ");
        resultLabel.setName("resultLabel");
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        frame.add(resultPanel, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        left = new JTextField("           ");
        left.setName("leftOperand");
        right = new JTextField("           ");
        right.setName("rightOperand");

        textPanel.add(left);
        textPanel.add(right);

        frame.add(textPanel, BorderLayout.NORTH);
    }

    /**
     * add button clicked.
     */

    public void addClicked()
    {
        double l = Double.parseDouble(left.getText());
        double r = Double.parseDouble(right.getText());

        try
        {
            resultLabel.setText("Result = " 
                + (l + r));
        }
        catch (NumberFormatException e)
        {
            resultLabel.setText("That was not a number.");
        }
    }

    /**
     * subtract button clicked.
     */

    public void subClicked()
    {
        double l = Double.parseDouble(left.getText());
        double r = Double.parseDouble(right.getText());

        try
        {
            resultLabel.setText("Result = " 
                + (l - r));
        }
        catch (NumberFormatException e)
        {
            resultLabel.setText("That was not a number.");
        }
    }

    /**
     * multiply button clicked.
     */

    public void multClicked()
    {
        double l = Double.parseDouble(left.getText());
        double r = Double.parseDouble(right.getText());

        try
        {
            resultLabel.setText("Result = " 
                + (l * r));
        }
        catch (NumberFormatException e)
        {
            resultLabel.setText("That was not a number.");
        }
    }

    /**
     * divide button clicked.
     */

    public void divClicked()
    {

        double l = Double.parseDouble(left.getText());
        double r = Double.parseDouble(right.getText());

        try
        {
            if (r == 0)
            {
                resultLabel.setText("Result = Error");
            }
            else
            {
                resultLabel.setText("Result = " 
                    + (l / r));
            }
        }
        catch (NumberFormatException e)
        {
            resultLabel.setText("That was not a number.");
        }
    }

    /**
     * getFrame for testing purposes.
     * @return JFrame 
     */

    public JFrame getFrame()
    {
        return frame;
    }
    /**
     * main method.
     * @param args 
     */

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}
