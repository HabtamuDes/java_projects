
package calculator;
 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
  public class WindowStandardCalculator extends JFrame {
JPanel p1, p2,p3;
//JLabel zero, one, two, three, four, five, six, seven, eight, nine;
JLabel plus, minus, divid, mul, equal;
static JTextField north=new JTextField();
JLabel btn[];
JTextField tf;
static String my;
double result;
String buttonName[] = {"1/x","x2","sqrt", "C","7", "8", "9", "+","4", "5", "6", "-","1", "2", "3", "*","0",".","=","/"};
char op;
double num1 = 0, num2 = 0;
 WindowStandardCalculator() {
setLayout(new BorderLayout(5, 5));
p2 = new JPanel(new GridLayout(5,4));
p1 = new JPanel();
p3=new JPanel(new BorderLayout(0,5));
p3.add(north,BorderLayout.NORTH);
int[] dimW = {300,45,100,90};

    int[] dimH = {35, 40};
 Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
 Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
tf = new JTextField(20);
tf.setPreferredSize(displayDimension);
north.setHorizontalAlignment(JTextField.RIGHT);
tf.setHorizontalAlignment(JTextField.RIGHT);
north.setBackground(Color.green);
north.setEditable(false);
// create number buttons using loop
p3.add(p1,BorderLayout.CENTER);
p1.add(tf);
btn = new JLabel[20];
MyListener my = new MyListener();
for (int i = 0; i < buttonName.length; i++) {
btn[i] = new JLabel(buttonName[i]);
btn[i].setPreferredSize(regularDimension);
p2.add(btn[i]);
btn[i].addMouseListener(my);
}
//give a border to the panel
add(p3, BorderLayout.NORTH);
add(p2, BorderLayout.CENTER);
Font font = new Font("Times new Roman", Font.BOLD, 25);


for (int i = 0; i < buttonName.length; i++) {
    btn[i].setOpaque(rootPaneCheckingEnabled);
btn[i].setBackground(Color.LIGHT_GRAY);
btn[i].setFont(font);
}
}
class MyListener implements MouseListener {
String firstnum;



// display a number
        @Override
        public void mouseClicked(MouseEvent e) {
            String firstnum;
           
// display a number

for (int i = 4; i <7; i++) {
   
if (e.getSource() == btn[i]) {
  
tf.setText(tf.getText() + "" + btn[i].getText());
my=tf.getText();
}
}
for (int i = 8; i <11; i++) {
   
if (e.getSource() == btn[i]) {
  
tf.setText(tf.getText() + "" + btn[i].getText());
my=tf.getText();
}
}
for (int i = 12; i <15; i++) {
   
if (e.getSource() == btn[i]) {
  
tf.setText(tf.getText() + "" + btn[i].getText());
my=tf.getText();
}
}
if (e.getSource() == btn[16]) {
  
tf.setText(tf.getText() + "" + btn[16].getText());
my=tf.getText();
}

if (e.getSource() == btn[7]) {
op = '+';
firstnum= tf.getText();
num1 = Double.parseDouble(firstnum);
north.setText(" "+my+"+");
tf.setText("");

} else if (e.getSource() == btn[11]) {
op = '-';
firstnum = tf.getText();
num1 = Double.parseDouble(firstnum);

tf.setText("");
north.setText(" "+my+"-");
} else if (e.getSource() == btn[19]) {
op = '/';
firstnum = tf.getText();
num1 = Double.parseDouble(firstnum);
north.setText(" "+my+"/");
tf.setText("");
} else if (e.getSource() == btn[15]) {
op = '*';
firstnum = tf.getText();
num1 = Double.parseDouble(firstnum);

tf.setText("");
north.setText(" "+my+"*");
}
else if (e.getSource() == btn[0]) {
firstnum = tf.getText();
num1 = Double.parseDouble(firstnum);
 result=1/num1;
tf.setText(" "+ result);
north.setText("");
} 
else if (e.getSource() == btn[1]) {
firstnum = tf.getText();
num1 = Double.parseDouble(firstnum);
 result=num1*num1;
tf.setText(" "+ result);
} 
else if (e.getSource() == btn[2]) {
firstnum = tf.getText();
num1 = Double.parseDouble(firstnum);
 result=Math.sqrt(num1);
tf.setText(" "+ result);
north.setText("");
} 
else if (e.getSource() == btn[18]) {
 result = calculate();
tf.setText(String.valueOf(result));
north.setText(" ");
} else if (e.getSource() == btn[3]) {
tf.setText("");
north.setText(" ");
}
 else if (e.getSource() == btn[17]) { 
   
             if(!tf.getText().contains(".")||!tf.getText().contains("")) {
                 tf.setText(tf.getText()+btn[17].getText());
              }
        


     }
}
        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
             }
        @Override
        public void mouseEntered(MouseEvent me) {
   for (int i = 0; i < 20; i++) {
    if (me.getSource() == btn[i]) {
btn[i].setBackground((Color.GRAY));
}        
        }
        }
        @Override
        public void mouseExited(MouseEvent me) {
           for (int i = 0; i < 20; i++) {
    if (me.getSource() == btn[i]) {
        
btn[i].setBackground(Color.LIGHT_GRAY);
}        
        } 
}
}
public double calculate() 
{
if (op =='+')
{
String y = tf.getText();
num2 = Integer.parseInt(y);
return (num2 + num1);
} 
else if (op == '-')
{
String y = tf.getText();
num2 = Integer.parseInt(y);
return (num1 - num2);
}
else if (op == '/') {
String y = tf.getText();
num2 = Integer.parseInt(y);
return (num1 / num2);
}
else if (op == '*')
{
String y = tf.getText();
num2 = Integer.parseInt(y);
return (num1 * num2);
}
return 0;
}
public static void main(String s[])
{
 WindowStandardCalculator frame = new  WindowStandardCalculator();
 frame.setTitle("My Calculator Frame");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLocation(100,80);
 frame.setSize(300,325);
 frame.setVisible(true);
 frame.setAlwaysOnTop(true);
 frame.setResizable(false);
}
  }
 
 
