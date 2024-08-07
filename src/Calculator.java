import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[17];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton logbtn, sinbtn, cosbtn, tanbtn, raisetobtn, sqrbtn, modbtn, factbtn;
    JPanel panel;
    JLabel noticeLabel; // Added JLabel for the notice

    Font myFont = new Font("Courier New", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(680, 800); // Increased frame height to accommodate the notice
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 40, 600, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("+/-");
        modbtn = new JButton("%");
        sinbtn = new JButton("Sin");
        cosbtn = new JButton("Cos");
        tanbtn = new JButton("Tan");
        logbtn = new JButton("Log");
        raisetobtn = new JButton("X^y");
        sqrbtn = new JButton("X^2");
        factbtn = new JButton("X!");

        // Increase the width of the buttons
        sinbtn.setPreferredSize(new Dimension(100, 60));
        cosbtn.setPreferredSize(new Dimension(100, 60));
        tanbtn.setPreferredSize(new Dimension(100, 60));
        logbtn.setPreferredSize(new Dimension(100, 60));
        raisetobtn.setPreferredSize(new Dimension(100, 60));
        sqrbtn.setPreferredSize(new Dimension(100, 60));
        factbtn.setPreferredSize(new Dimension(100, 60));

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = logbtn;
        functionButtons[10] = sinbtn;
        functionButtons[11] = cosbtn;
        functionButtons[12] = tanbtn;
        functionButtons[13] = raisetobtn;
        functionButtons[14] = sqrbtn;
        functionButtons[15] = modbtn;
        functionButtons[16] = factbtn;

        for (int i = 0; i < 17; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 625, 170, 60);
        delButton.setBounds(270, 625, 170, 60);
        clrButton.setBounds(480, 625, 168, 60);

        panel = new JPanel();
        panel.setBounds(50, 100, 600, 520);
        panel.setLayout(new GridLayout(4, 6, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(logbtn);
        panel.add(sinbtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(cosbtn);
        panel.add(tanbtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(raisetobtn);
        panel.add(sqrbtn);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(modbtn);
        panel.add(factbtn);

        // Creating the notice label
        noticeLabel = new JLabel("Please enter a digit first to calculate log, sin, cos, or tan.");
        noticeLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
        noticeLabel.setBounds(50, 680, 600, 30);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.add(noticeLabel); // Adding the notice label
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean showNotice = true;

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                showNotice = false;
            }
        }

        if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==raisetobtn)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='^';
			textfield.setText("");
		}
		if(e.getSource()==modbtn)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='%';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'^':
				result=Math.pow(num1, num2);
				break;
			case '%':
				result=num1%num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
            textfield.setText(textfield.getText().substring(0,(textfield.getText().length() - 1)));
        }
		try {
			if (e.getSource() == negButton) {
				double num = Double.parseDouble(textfield.getText());
				if (num > 0) {
					double resultneg = num * -1;
					textfield.setText(resultneg + "");
				} else {
					double resultpos = num * -1;
					textfield.setText(resultpos + "");
				}
			}
		}
			
		catch (NumberFormatException num) {
			
			System.out.println(
                    "NumberFormatException occurred");
		}
		if(e.getSource()==logbtn)
		{
			double val=Double.parseDouble(textfield.getText());
			double ans=Math.log10(val);
			textfield.setText(String.valueOf(ans));
		}
		if(e.getSource()==factbtn)
		{
			double val=Double.parseDouble(textfield.getText());
			double ans=1.0;
			for(int i=1;i<=val;i++)
			{
				ans*=i;
			}
			textfield.setText(String.valueOf(ans));
		}
		if(e.getSource()==sqrbtn)
		{
			double val=Double.parseDouble(textfield.getText());
			double ans=val*val;
			textfield.setText(String.valueOf(ans));
		}
		if (e.getSource() == sinbtn)
		{
		        double val = Double.parseDouble(textfield.getText());
		        double ans = Math.sin(val);
		        textfield.setText(String.valueOf(ans));
		}

		if (e.getSource() == cosbtn) 
		{
		        double val = Double.parseDouble(textfield.getText());
		        double ans = Math.cos(val);
		        textfield.setText(String.valueOf(ans));
		}

		if (e.getSource() == tanbtn) 
		{
		        double val = Double.parseDouble(textfield.getText());
		        double ans = Math.tan(val);
		        textfield.setText(String.valueOf(ans));
	    }

        if (showNotice) {
            noticeLabel.setVisible(true);
        } else {
            noticeLabel.setVisible(false);
        }
    }
}
