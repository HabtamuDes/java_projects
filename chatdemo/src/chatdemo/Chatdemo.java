/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdemo;

import  javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

/**add(p3);
 * add(jta3);
 * add(d1);
 *
 * @author craft
 */
public class Chatdemo extends JFrame{
    public Chatdemo(){
    
    
    JScrollPane  p3 = new JScrollPane();
  JTextArea      jta3 = new JTextArea();
    JDialog    d1 = new javax.swing.JDialog();
    JToolBar    tb1 = new JToolBar();
       JScrollPane p1= new JScrollPane();
        JScrollPane p2 = new JScrollPane();
   JScrollPane     p5 = new  JScrollPane();
    
        
    JTextArea    msgata = new JTextArea();
   JTextArea      recimsgta = new JTextArea();
 JTextField       nametf = new  JTextField();
  JButton    connect = new JButton();
  JButton   disconnect = new JButton();
   JTextField   writetf = new JTextField();
   JButton  send = new JButton();
     JTextArea onlinelist = new JTextArea();
     JLabel   namejlb = new JLabel();
     
             msgata.setBackground(new Color(153, 255, 255));
        msgata.setColumns(20);
        msgata.setForeground(new Color(102, 255, 51));
        msgata.setRows(5);
        p1.setViewportView(msgata);

        recimsgta.setBackground(new Color(102, 255, 204));
        recimsgta.setColumns(20);
        recimsgta.setForeground(new Color(255, 153, 51));
        recimsgta.setRows(5);
        p2.setViewportView(recimsgta);

        nametf.setText("enter your name");

        connect.setBackground(new Color(0, 255, 0));
        connect.setForeground(new Color(0, 51, 51));
        connect.setText("Connect");

        disconnect.setBackground(new Color(204, 0, 0));
        disconnect.setForeground(new Color(153, 153, 0));
        disconnect.setText("Disconnect");

        writetf.setBackground(new Color(255, 51, 255));
        writetf.setText("write your msg here");

        send.setBackground(new Color(0, 51, 255));
        send.setForeground(new Color(51, 0, 255));
        send.setText("send");
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            }
        });
        
add(p3);
  add(jta3);
  add(d1);


}
    public static void main(String[] args) {
         Chatdemo frame = new Chatdemo();
        frame.setTitle("client");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.pack();
        frame.setVisible(true);
    }
    
}
