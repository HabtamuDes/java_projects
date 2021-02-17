package payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

class payroll extends JFrame implements ActionListener {

    public static void main(String[] args) {
        payroll panel = new payroll();
        ImageImplement sp = new ImageImplement(new ImageIcon("D:/a/A.jpg").getImage());
        panel.setSize(560, 400);
        panel.setVisible(true);
        panel.setLocation(350, 200);
        panel.setResizable(false);
        panel.getContentPane().add(sp);
    }
    public String USERNAME = "payroll";
    public String PASSWORD = "1234";
    public static final String CONN_STRING =
            "jdbc:oracle:thin:localhost:1521:orcl[c##_habtamu on c##_habtamu]";
    ResultSet rs = null;
    Connection conn;
    Statement stmt = null;
    JLabel lblUser = new JLabel("Username ", JLabel.RIGHT);
    JLabel lblPass = new JLabel("Password ", JLabel.RIGHT);
    JTextField txtUser = new JTextField(20);
    JPasswordField txtPass = new JPasswordField(20);
    JButton btnNew = new JButton("Login");
    JButton btnExit = new JButton("Exit");
    Connection cn;
    Statement st;
    PreparedStatement ps;

    public void clear() {
        txtUser.setText("");
        txtPass.setText("");
    }

    public payroll() {
         super("User Account Settings");
         
        JWindow window = new JWindow();
    int duration = 10000;
     int width = 858;
     int height = 518;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;
   window.setBounds(x, y, width, height);      
   window.getContentPane().add(new JLabel(new ImageIcon("src\\payroll\\splash.png")),"Center");
    window.setVisible(true);
    try {
      Thread.sleep(duration);
    } catch (Exception e) {
    }
    
    window.setVisible(false);
    
       

        JPanel pane = new JPanel();
        pane.setLayout(null);

        lblUser.setBounds(40, 270, 80, 25);
        pane.add(lblUser);
        txtUser.setBounds(140, 270, 150, 25);
        pane.add(txtUser);
        txtUser.setForeground(Color.red);
        lblUser.setForeground(Color.magenta);

        lblPass.setBounds(40, 310, 80, 25);
        pane.add(lblPass);
        txtPass.setBounds(140, 310, 150, 25);
        txtPass.setForeground(Color.red);
        txtPass.setEchoChar('*');
        pane.add(txtPass);
        lblPass.setForeground(Color.magenta);

        btnNew.setBounds(400, 270, 75, 35);
        pane.add(btnNew);
        btnNew.addActionListener(this);
        btnExit.setBounds(400, 310, 75, 35);
        pane.add(btnExit);
        pane.setBackground(Color.green);
        btnExit.addActionListener(this);
        setContentPane(pane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Log In User Account"));

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##_habtamu","hab");
        } catch (ClassNotFoundException ex) {
            System.err.println("Failed to load driver");
            JOptionPane.showMessageDialog(this, "Unable to connect", "WARNING", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex);
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("Unable to connect");
            JOptionPane.showMessageDialog(this, "Unable to connect", "WARNING", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /*** Object source = e.getSource();
       
     //   if (source == btnNew) {
            login();
            
            System.out.println("button clkied");
        }
        if (source == btnExit) {
            dispose();
        }
    }
****/
       
       if(USERNAME.equals(txtUser.getText()) && PASSWORD.equals(txtPass.getText()));
       {
           Default  main=new Default("Wellcome");
       }
    /***public void login() {
        USERNAME = txtUser.getText();
        PASSWORD = txtPass.getText();
        */
        
        
        try {
          conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            Statement stmt = conn.createStatement();
            String query = "  Select * from  c##_habtamu.users  WHERE  USER_NAME='" +USERNAME + "' AND  PASSWORD='" + PASSWORD+ "'";
            ResultSet rs = stmt.executeQuery(query);
            boolean recordfound = rs.next();
            if (recordfound) {
                Default aWindow = new Default("Employee Information And PayRoll System");
                ImageImplement sp = new ImageImplement(new ImageIcon("D:/a/A.jpg").getImage());
                aWindow.getContentPane().add(sp);
                clear();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "invalid log in", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

    }
}

class Default extends JFrame implements ActionListener {

    private String USERNAME = "C##_HABTAMU";
    private String PASSWORD = "HAB";
    private static final String CONN_STRING =
            "jdbc:oracle:thin:@localhost:1521:orcl [c##_habtamu on C##_HABTAMU]";
    JMenuBar menuBar = new JMenuBar();
    Connection cn;
    Statement st;
    PreparedStatement ps;
    JMenuItem opItem, saveItem, exitItem, lookItem, animItem, photo, time;
    JCheckBoxMenuItem toolBarItem;
    JRadioButtonMenuItem windowItem, metalItem, motifItem;
    JButton exitButton, openButton, saveButton, animButton, loginButton;
    String lnf = null;
    boolean flag = true;
    JToolBar toolBar = new JToolBar();

    public Default(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit theKit = getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        setBounds(wndSize.width / 4, wndSize.height / 4, wndSize.width / 2, wndSize.height / 2);
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic('V');
        JMenu guiMenu = new JMenu("About Me");
        guiMenu.setMnemonic('G');
        opItem = fileMenu.add("OPEN");
        saveItem = fileMenu.add("SAVE");
        time = fileMenu.add("TIME");
        fileMenu.addSeparator();
        exitItem = fileMenu.add("EXIT");
        menuBar.add(fileMenu);
        viewMenu.add(toolBarItem = new JCheckBoxMenuItem("Tool Bar", flag));
        viewMenu.addSeparator();
        JMenu lookItem = new JMenu("Look And Feel");
        lookItem.add(windowItem = new JRadioButtonMenuItem("Window", true));
        lookItem.add(metalItem = new JRadioButtonMenuItem("Metal", true));
        lookItem.add(motifItem = new JRadioButtonMenuItem("Motif", true));
        ButtonGroup types = new ButtonGroup();
        types.add(windowItem);
        types.add(motifItem);
        types.add(metalItem);
        menuBar.add(viewMenu);
        viewMenu.add(lookItem);
        animItem = guiMenu.add("About Me");
        animItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));
        menuBar.add(guiMenu);
        exitButton = new JButton(new ImageIcon("pic/Exit.gif"));
        openButton = new JButton(new ImageIcon("pic/Open.gif"));
        saveButton = new JButton(new ImageIcon("pic/Save.gif"));
        animButton = new JButton("About Me");
        loginButton = new JButton("LOGIN HERE");
        exitButton.setBorder(BorderFactory.createRaisedBevelBorder());
        openButton.setBorder(BorderFactory.createRaisedBevelBorder());
        saveButton.setBorder(BorderFactory.createRaisedBevelBorder());
        animButton.setBorder(BorderFactory.createRaisedBevelBorder());
        loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
        exitButton.setToolTipText("Exit");
        openButton.setToolTipText("Open");
        saveButton.setToolTipText("Save");
        animButton.setToolTipText("Animation of Font");
        loginButton.setToolTipText("login here");
        toolBar.add(openButton);
        toolBar.add(saveButton);
        toolBar.add(exitButton);
        toolBar.addSeparator();
        toolBar.add(animButton);
        toolBar.add(loginButton);
        toolBar.setFloatable(true);
        getContentPane().add(toolBar, BorderLayout.NORTH);
        setVisible(true);
        exitItem.addActionListener(this);
        windowItem.addActionListener(this);
        metalItem.addActionListener(this);
        motifItem.addActionListener(this);
        exitButton.addActionListener(this);
        toolBarItem.addActionListener(this);
        opItem.addActionListener(this);
        time.addActionListener(this);
        saveItem.addActionListener(this);
        animItem.addActionListener(this);
        openButton.addActionListener(this);
        saveButton.addActionListener(this);
        animButton.addActionListener(this);
        loginButton.addActionListener(this);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();


        if (ae.getActionCommand().equals("EXIT") || source == exitButton) {
            System.exit(0);
        } else if (ae.getActionCommand().equals("About Me") || source == animButton) {
            Animation a = new Animation();
            Thread b = new Thread(a);
            b.start();
            a.repaint();
        } else if (ae.getActionCommand().equals("Window")) {
            lnf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            setLookAndFeel();
        } else if (ae.getActionCommand().equals("Metal")) {
            lnf = "javax.swing.plaf.metal.MetalLookAndFeel";
            setLookAndFeel();
        } else if (ae.getActionCommand().equals("Motif")) {
            lnf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            setLookAndFeel();
        } else if (ae.getActionCommand().equals("Tool Bar")) {
            if (flag == true) {
                flag = false;
                toolBar.setVisible(flag);
            } else if (flag == false) {
                flag = true;
                toolBar.setVisible(flag);
            }
        } else if (ae.getActionCommand().equals("SAVE") || source == saveButton) {
            nam ope = new nam();
            ope.setEnabled(true);
            ope.setVisible(true);
            ope.setSize(690, 550);
            ope.setLocation(300, 100);
        } else if (ae.getActionCommand().equals("OPEN") || source == openButton) {
            Iom open = new Iom();
            open.setEnabled(true);
            open.setVisible(true);
            open.setSize(690, 550);
            open.setLocation(300, 100);
        } else if (ae.getActionCommand().equals("TIME") || source == time) {
            JFrame frame = new JFrame();
            frame.setLocation(552, 260);

            Calendar now = Calendar.getInstance();
            Calendar earliest = (Calendar) now.clone();
            earliest.add(Calendar.MONTH, -6);
            Calendar latest = (Calendar) now.clone();
            latest.add(Calendar.MONTH, 6);
            SpinnerModel model = new SpinnerDateModel(
                    now.getTime(), earliest.getTime(), latest.getTime(),
                    Calendar.WEEK_OF_YEAR);
            final JSpinner spinner = new JSpinner(model);

            model.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println(((SpinnerDateModel) e.getSource()).getDate());
                }
            });

            frame.getContentPane().add("North", new JLabel("Time/Date"));
            frame.getContentPane().add("Center", spinner);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else if (ae.getActionCommand().equals("LOGIN HERE") || source == loginButton) {
            try {
                cn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                st = cn.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,JOptionPane.INFORMATION_MESSAGE);
                Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
            }
            String user = JOptionPane.showInputDialog("Enter USER name");

            if (user.equals(USERNAME)) {
                String pass = JOptionPane.showInputDialog("Vissible Password");
                if (pass.equals(PASSWORD)) {
                    Client se = new Client();
                    ImageImplement sp = new ImageImplement(new ImageIcon("D:/a/A.jpg").getImage());
                    se.getContentPane().add(sp);
                    se.setVisible(true);
                    se.setSize(600, 500);
                    se.setLocation(300, 100);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Activate", "WARNING", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login", "WARNING", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(lnf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        }
    }
}

class Iom extends JFrame {

    private JTextArea mer = new JTextArea();
    private String fileName;

    public Iom() {
        super("open");
        mer.setLineWrap(true);
        mer.setText(fileName);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("Center", mer);
        FileDialog fDialog = new FileDialog(this, "Open ...", FileDialog.LOAD);
        fDialog.setVisible(true);
        String name = fDialog.getFile();
        if (name == null) {
            return;
        }
        fileName = fDialog.getDirectory() + name;
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(payroll.class.getName()).log(Level.OFF, null, ex);
        }
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder textBuffer = new StringBuilder();
        try {
            String textLine = bReader.readLine();
            while (textLine != null) {
                textBuffer.append(textLine).append('\n');
                textLine = bReader.readLine();
            }
            bReader.close();
            reader.close();
        } catch (IOException ioe) {
            Logger.getLogger(Iom.class.getName()).log(Level.OFF, null, ioe);
        }
        mer.setText(textBuffer.toString());
        add(mer);
        this.getContentPane().add(new JScrollPane(mer));
    }
}

class nam extends JFrame {

    private JTextArea mer = new JTextArea();

    public nam() {
        super("save");
        FileDialog fDialog = new FileDialog(this, "Save ...", FileDialog.SAVE);
        fDialog.setVisible(true);
        String ka = mer.getText();
        String path = fDialog.getDirectory() + fDialog.getFile();
        File f = new File(path);
        try {
            f.createNewFile();
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(f);
            fileWriter.write(ka);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(nam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Animation extends JDialog implements Runnable {

    boolean bouncing = false;
    boolean condition = true;
    Thread bouncer;
    String s = "PAYROlL SYSTEM VERSION !!";
    Dimension d;
    int x = 400;

    Animation() {
        Toolkit kit = getToolkit();
        d = kit.getScreenSize();
        setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);
        setVisible(true);
        x = d.height / 4;
        repaint();
        bouncing = true;

    }

    public void stop() {
        bouncing = false;
        bouncer = null;
    }

    @Override
    public void run() {
        while (true) {
            if (x == -100) {
                condition = true;
            } else if (x == d.height / 2) {
                condition = false;
            }
            if (!condition) {
                x = x - 5;
            } else {
                x = x + 5;
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 600, 600);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.drawString(s, x, 100);

    }
}

class Client extends JFrame implements ActionListener {

    JLabel lb2 = new JLabel("WELL COME TO PAYROLL SYSTEM !!");
    Font f1 = new Font("Times", Font.CENTER_BASELINE, 30);
    private String USERNAME = "C##_HABTAMU";
    private String PASSWORD = "HAB";
    private static final String CONN_STRING =
            "jdbc:oracle:thin:localhost:1521:orcl[c##_habtamu on c##_habtamu]";
    ResultSet rs = null;
    Connection conn;
    Statement stmt = null;
    float days, rate, salary, bonu;
    private Container co;
    JLabel l1 = new JLabel("emp_id");
    JLabel l2 = new JLabel("first_name");
    JLabel l3 = new JLabel("last_name");
    JLabel l4 = new JLabel("sex");
    JLabel l5 = new JLabel("age");
    JLabel l6 = new JLabel("year_birth");
    JLabel l7 = new JLabel("nationality");
    JTextField txt1 = new JTextField(20);
    JTextField txt2 = new JTextField(20);
    JTextField txt3 = new JTextField(20);
    JTextField txt4 = new JTextField(20);
    JTextField txt5 = new JTextField(20);
    JTextField txt6 = new JTextField(20);
    JTextField txt7 = new JTextField(20);
    JButton b1 = new JButton("insert");
    JButton b2 = new JButton("select");
    JButton b3 = new JButton("update");
    JButton b4 = new JButton("delete");
    JButton b5 = new JButton("clear");
    JButton b16 = new JButton("exit");
    JPanel p1 = new JPanel(new GridLayout(7, 2));
    JPanel p2 = new JPanel(new GridLayout(1, 6));
    JFrame frame1 = new JFrame("employee_information");
    JLabel l8 = new JLabel("emp_id");
    JLabel l9 = new JLabel("emp_type");
    JLabel l10 = new JLabel("emp_date");
    JLabel l11 = new JLabel("work_place");
    JLabel l12 = new JLabel("job_name");
    JLabel l13 = new JLabel("salary");
    JTextField txt8 = new JTextField(20);
    JTextField txt9 = new JTextField(20);
    JTextField txt10 = new JTextField(20);
    JTextField txt11 = new JTextField(20);
    JTextField txt12 = new JTextField(20);
    JTextField txt13 = new JTextField(20);
    JButton b6 = new JButton("insert");
    JButton b7 = new JButton("select");
    JButton b8 = new JButton("update");
    JButton b9 = new JButton("delete");
    JButton b10 = new JButton("Clear");
    JButton b19 = new JButton("Bonus");
    JButton b17 = new JButton("exit");
    JPanel p3 = new JPanel(new GridLayout(6, 2));
    JPanel p4 = new JPanel(new GridLayout(1, 6));
    JFrame frame2 = new JFrame("employement_information");
    JLabel l14 = new JLabel("emp_id");
    JLabel l15 = new JLabel("job_name");
    JLabel l16 = new JLabel("bonus_recourd");
    JLabel l17 = new JLabel("gross_salary");
    JLabel l18 = new JLabel("tax");
    JLabel l19 = new JLabel("net_salary");
    JLabel l20 = new JLabel("1)HABTAMU   ASSEGAHEGN  RCS 059/16");
    JLabel l21 = new JLabel("2)AWEL REMETS     RCS 015/16");
    JLabel l22 = new JLabel("3)AYALEW KEBED     RCS 016/16");
    JLabel l23 = new JLabel("4)MEKEDES SAMUEL    RCS /");
    JLabel l24 = new JLabel("5)GELANA HAILU  RCS /");
    JLabel l25 = new JLabel("6)HIWOTE ALMAEHU       RCS /");
    JLabel l26=new  JLabel("7)YARED TESGAYE  RCS 141/15");
    JPanel p7 = new JPanel(new GridLayout(6, 1));
    JTextField txt14 = new JTextField(20);
    JTextField txt15 = new JTextField(20);
    JTextField txt16 = new JTextField(20);
    JTextField txt17 = new JTextField(20);
    JTextField txt18 = new JTextField(20);
    JTextField txt19 = new JTextField(20);
    JButton b11 = new JButton("insert");
    JButton b12 = new JButton("select");
    JButton b13 = new JButton("update");
    JButton b14 = new JButton("delete");
    JButton b15 = new JButton("clear");
    JButton b18 = new JButton("exit");
    JButton b22 = new JButton("Compute");
    JPanel p5 = new JPanel(new GridLayout(7, 1));
    JPanel p6 = new JPanel(new GridLayout(2, 7));
    JFrame frame3 = new JFrame("salary");
    JFrame frame4 = new JFrame("GROUP MEMBER");
    JMenuItem m1 = new JMenuItem("Registration Slip 1");
    JMenuItem m2 = new JMenuItem("Registration Slip 2");
    JMenuItem m3 = new JMenuItem("Salary");
    JMenuItem m5 = new JMenuItem("GROUP MEMBER");
    JMenuItem m4 = new JMenuItem("Exit");
    JMenuItem fram = new JMenuItem("Bonus Record");
    JMenuItem old = new JMenuItem("Bonus Record");
    JMenuItem table = new JMenuItem("Bonus Table");
    JMenuItem tablesal = new JMenuItem("Payment");
    JMenuItem m8 = new JMenuItem("photo");
    JMenuItem m10 = new JMenuItem("Oldest Age");

    public Client() {
        add(lb2);
        lb2.setBounds(10, 270, 550, 100);
        lb2.setHorizontalAlignment(JLabel.NORTH_EAST);
        lb2.setFont(f1);
        lb2.setForeground(Color.magenta);
        co = getContentPane();
        p1.add(l1);
        p1.add(txt1);
        p1.add(l2);
        p1.add(txt2);
        p1.add(l3);
        p1.add(txt3);
        p1.add(l4);
        p1.add(txt4);
        p1.add(l5);
        p1.add(txt5);
        p1.add(l6);
        p1.add(txt6);
        p1.add(l7);
        p1.add(txt7);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b16);
        frame1.add(p1, BorderLayout.WEST);
        frame1.add(p2, BorderLayout.SOUTH);
        frame1.setSize(500, 300);
        frame1.setLocationRelativeTo(null);
        p3.add(l8);
        p3.add(txt8);
        p3.add(l9);
        p3.add(txt9);
        p3.add(l10);
        p3.add(txt10);
        p3.add(l11);
        p3.add(txt11);
        p3.add(l12);
        p3.add(txt12);
        p3.add(l13);
        p3.add(txt13);
        p4.add(b6);
        p4.add(b7);
        p4.add(b8);
        p4.add(b9);
        p4.add(b10);
        p4.add(b17);
        frame2.add(p3, BorderLayout.WEST);
        frame2.add(p4, BorderLayout.SOUTH);
        frame2.setSize(500, 300);
        frame2.setLocationRelativeTo(null);
        p5.add(l14);
        p5.add(txt14);
        p5.add(l15);
        p5.add(txt15);
        p5.add(l16);
        p5.add(txt16);
        p5.add(l17);
        p5.add(txt17);
        p5.add(l18);
        p5.add(txt18);
        p5.add(l19);
        p5.add(txt19);
        p6.add(b11);
        p6.add(b12);
        p6.add(b13);
        p6.add(b14);
        p6.add(b15);
        p6.add(b18);
        p6.add(b19);
        p6.add(b22);
        l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        l2.setBorder(BorderFactory.createLineBorder(Color.black));
        l3.setBorder(BorderFactory.createLineBorder(Color.black));
        l4.setBorder(BorderFactory.createLineBorder(Color.black));
        l5.setBorder(BorderFactory.createLineBorder(Color.black));
        l6.setBorder(BorderFactory.createLineBorder(Color.black));
        l7.setBorder(BorderFactory.createLineBorder(Color.black));
        l8.setBorder(BorderFactory.createLineBorder(Color.blue));
        l9.setBorder(BorderFactory.createLineBorder(Color.blue));
        l10.setBorder(BorderFactory.createLineBorder(Color.blue));
        l11.setBorder(BorderFactory.createLineBorder(Color.blue));
        l12.setBorder(BorderFactory.createLineBorder(Color.blue));
        l13.setBorder(BorderFactory.createLineBorder(Color.blue));
        l14.setBorder(BorderFactory.createLineBorder(Color.black));
        l15.setBorder(BorderFactory.createLineBorder(Color.black));
        l16.setBorder(BorderFactory.createLineBorder(Color.black));
        l17.setBorder(BorderFactory.createLineBorder(Color.black));
        l18.setBorder(BorderFactory.createLineBorder(Color.black));
        l19.setBorder(BorderFactory.createLineBorder(Color.black));
        p1.setBorder(BorderFactory.createLineBorder(Color.red));
        p2.setBorder(BorderFactory.createLineBorder(Color.red));
        p3.setBorder(BorderFactory.createLineBorder(Color.red));
        p4.setBorder(BorderFactory.createLineBorder(Color.red));
        p5.setBorder(BorderFactory.createLineBorder(Color.red));
        p6.setBorder(BorderFactory.createLineBorder(Color.red));
        frame3.add(p5, BorderLayout.WEST);
        frame3.add(p6, BorderLayout.SOUTH);
        frame3.setSize(500, 300);
        frame3.setLocationRelativeTo(null);
        txt19.setEditable(false);
        p7.add(l20);
        p7.add(l21);
        p7.add(l22);
        p7.add(l23);
        p7.add(l24);
        p7.add(l25);
        p7.add(l26);
        frame4.add(p7, BorderLayout.WEST);
        frame4.setSize(500, 300);
        frame4.setLocationRelativeTo(null);
        frame4.setTitle("GROUP Member OF  STUDENT");
        student sp = new student(new ImageIcon("D:/a/me.png").getImage());
        frame4.getContentPane().add(sp);
        JMenuBar bar = new JMenuBar();
        JMenu mu = new JMenu("Registration");
        JMenu mue = new JMenu("Bonus");
        JMenu pay = new JMenu("Payment");
        JMenu pho = new JMenu("Developer Galary");
        JMenu old = new JMenu("Oldest Age");
        setJMenuBar(bar);
        bar.add(mu);
        bar.add(mue);
        bar.add(pay);
        bar.add(pho);
        bar.add(old);
        mu.add(m1);
        mu.add(m2);
        mu.add(m4);
        mu.add(m5);
        mue.add(fram);
        mue.add(table);
        pay.add(m3);
        pay.add(tablesal);
        pho.add(m8);
        old.add(m10);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b22.addActionListener(this);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        m8.addActionListener(this);
        m5.addActionListener(this);
        fram.addActionListener(this);
        m10.addActionListener(this);
        table.addActionListener(this);
        tablesal.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m1) {
            frame1.setVisible(true);
        } else if (e.getSource() == m2) {
            frame2.setVisible(true);
        } else if (e.getSource() == m3) {
            frame3.setVisible(true);
        } else if (e.getSource() == m5) {
            frame4.setVisible(true);
            frame4.setResizable(false);
        } else if (e.getSource() == m4) {
            System.exit(0);
        } else if (e.getSource() == m8) {
            Deve1 frame = new Deve1();
            frame.setSize(600, 500);
            frame.setResizable(true);
            frame.setVisible(true);
            frame.setLocation(542, 200);
        } else if (e.getSource() == table) {
            Main sr = new Main();
            sr.showTableData();
        } else if (e.getSource() == tablesal) {
            Mainsal sr = new Mainsal();
            sr.showTableData();
        } 
        else if (e.getSource() == fram) {
            Frame1 f1 = new Frame1();
            f1.setSize(500, 400);
            f1.setResizable(false);
            f1.setLocation(222, 122);
            f1.setVisible(true);
        } else if (e.getSource() == m10) {
            Frame2 f1 = new Frame2();
            f1.setSize(500, 400);
            f1.setResizable(false);
            f1.setLocation(222, 122);
            f1.setVisible(true);
        } else if (e.getSource() == b16) {
            frame1.setVisible(true);
        } else if (e.getSource() == b17) {
            frame2.setVisible(true);
        } else if (e.getSource() == b18) {
            frame3.setVisible(false);
        } else if (e.getSource() == b19) {
            Main sr = new Main();
            sr.showTableData();
        }

        if (e.getSource() == b1) {
            
            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();

               st.executeUpdate("INSERT INTO  employee_information VALUES ('" + Integer.parseInt(txt1.getText()) + "','" + txt2.getText() + "','" + txt3.getText() + "','" + txt4.getText() + "','" + Integer.parseInt(txt5.getText()) + "','" + Integer.parseInt(txt6.getText()) + "','" + txt7.getText() + "')");
                
                JOptionPane.showMessageDialog(null, "you have enter data into table");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "please insert value " + ex);
                System.out.println(ex.getClass()); System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == b22) {
            try {
                days = Float.parseFloat(txt17.getText());
                rate = Float.parseFloat(txt18.getText());
                bonu = Float.parseFloat(txt16.getText());
                salary = ((days + bonu) - rate);
                float round = Round(salary, 2);
                txt19.setText(Float.toString(round));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "check error" + ex);
                System.out.println(ex);

            }
        } else if (e.getSource() == b3) {

            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                 st.executeUpdate("UPDATE c##_habtamu. employee_information SET emp_id='" + Integer.parseInt(txt1.getText()) + "' ,first_name ='" + txt2.getText() + "',last_name='" + txt3.getText() + "',sex='" + txt4.getText() + "',age='" + Integer.parseInt(txt5.getText()) + "',year_birth='" + Integer.parseInt(txt6.getText()) + "',nationality='" + txt7.getText() + "'");
               
                 JOptionPane.showMessageDialog(null, "you have updated your data successfully!!!");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "primary key");
                System.out.println(ex);
            }
        } else if (e.getSource() == b5) {
            try {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                txt5.setText("");
                txt6.setText("");
                txt7.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b4) {
            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM   c##_habtamu.employee_information WHERE emp_id='" + Integer.parseInt(txt1.getText()) + "'");
                JOptionPane.showMessageDialog(null, Integer.parseInt(txt1.getText()) + "  the value isdeleted");
            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b2) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeQuery("SELECT*FROM  c##_habtamu. employee_information WHERE emp_id='" + Integer.parseInt(txt1.getText()) + "'");
                ResultSet set;
                set = st.getResultSet();
                while (set.next()) {
                    txt1.setText(set.getString("emp_id"));
                    txt2.setText(set.getString("first_name"));
                    txt3.setText(set.getString("last_name"));
                    txt4.setText(set.getString("sex"));
                    txt5.setText(set.getString("age"));
                    txt6.setText(set.getString("year_birth"));
                    txt7.setText(set.getString("nationality"));
                }
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "empity" + ex);
                ex.printStackTrace();


            }

        }
        if (e.getSource() == b8) {

            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("UPDATE    c##_habtamu.employment_information SET emp_id='" + Integer.parseInt(txt8.getText()) + "', emp_type ='" + txt9.getText() + "',emp_date='" + Integer.parseInt(txt10.getText()) + "',work_place='" + txt11.getText() + "',job_name='" + txt12.getText() + "',salary='" + Integer.parseInt(txt13.getText()) + "'");
                JOptionPane.showMessageDialog(null, "you data on the table is updated ");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                System.out.println(ex);

            }
        } else if (e.getSource() == b6) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                Statement st = con.createStatement();

               st.executeUpdate("INSERT INTO  employement_information VALUES ('" + Integer.parseInt(txt8.getText()) + "','" + txt9.getText() + "','" + Integer.parseInt(txt10.getText()) + "','" + txt11.getText() + "','" + txt12.getText() + "','" + Integer.parseInt(txt13.getText()) + "')");
                
                JOptionPane.showMessageDialog(null, "you have enter data into table");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                System.out.println(ex);

            }

        } else if (e.getSource() == b10) {
            try {
                txt8.setText("");
                txt9.setText("");
                txt10.setText("");
                txt11.setText("");
                txt12.setText("");
                txt13.setText("");
            } catch (Exception ex) {
                System.out.println(ex);

            }
        } else if (e.getSource() == b9) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                Statement st = con.createStatement();

                st.executeUpdate("DELETE FROM    c##_habtamu.employment_information WHERE emp_id='" + Integer.parseInt(txt8.getText()) + "'");
                JOptionPane.showMessageDialog(null, Integer.parseInt(txt8.getText()) + "deleted");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b7) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeQuery("SELECT*FROM   c##_habtamu.employment_information WHERE emp_id='" + Integer.parseInt(txt8.getText()) + "'");
                ResultSet set;
                set = st.getResultSet();
                while (set.next()) {
                    txt8.setText(set.getString("emp_id"));
                    txt9.setText(set.getString("emp_type"));
                    txt10.setText(set.getString("emp_date"));
                    txt11.setText(set.getString("work_place"));
                    txt12.setText(set.getString("job_name"));
                    txt13.setText(set.getString("salary"));
                }
            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b13) {

            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                Statement st = con.createStatement();

                st.executeUpdate("UPDATE     c##_habtamu.salery SET emp_id='" + Integer.parseInt(txt14.getText()) + "',job_name ='" + txt15.getText() + "',bonus_recourd ='" + txt16.getText() + "',gross_salary='" + Integer.parseInt(txt17.getText()) + "',tax='" + Integer.parseInt(txt18.getText()) + "',net_salary='" + Integer.parseInt(txt19.getText()) + "'");
                JOptionPane.showMessageDialog(null, "you updated the table");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
                JOptionPane.showMessageDialog(null, "primary key");
                System.out.println(ex);

            }

        } else if (e.getSource() == b11) {
            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO  c##_habtamu. salery (EMP_ID,JOB_NAME,BONUS_RECOURD,GROSS_SALARY,TAX,NET_SALARY) VALUES ('" + txt14.getText() + "','" + txt15.getText() + "','" + txt16.getText() + "','" + txt17.getText() + "','" + txt18.getText() + "','" + txt19.getText() + "')");
                JOptionPane.showMessageDialog(null, "you have enter data into table");
            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Empity Value");
                System.out.println(ex);

            }

        } else if (e.getSource() == b15) {
            try {
                txt14.setText("");
                txt15.setText("");
                txt16.setText("");
                txt17.setText("");
                txt18.setText("");
                txt19.setText("");
            } catch (Exception ex) {
                System.out.println(ex);

            }
        } else if (e.getSource() == b14) {
            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM  c##_habtamu.salery WHERE emp_id='" + Integer.parseInt(txt14.getText()) + "'");
                JOptionPane.showMessageDialog(null, Integer.parseInt(txt14.getText()) + "deleted");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Not Delated");
                System.out.println(ex);
            }
        } else if (e.getSource() == b12) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeQuery("SELECT * FROM   c##_habtamu.salery WHERE emp_id='" + txt14.getText() + "'");
                ResultSet set;
                set = st.getResultSet();
                while (set.next()) {
                    txt14.setText(set.getString("emp_id"));
                    txt15.setText(set.getString("job_name"));
                    txt16.setText(set.getString("bonus_recourd"));
                    txt17.setText(set.getString("gross_salary"));
                    txt18.setText(set.getString("tax"));
                    txt19.setText(set.getString("net_salary"));
                }
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "empity" + ex);
                ex.printStackTrace();
            }
        }

    }

    public static float Round(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }
}

class Frame1 extends JFrame implements ActionListener {

    JLabel lb2 = new JLabel("BONUS  RCCORD SLIP!!");
    Font f2 = new Font("Times", Font.ROMAN_BASELINE, 15);
    JLabel lblid, lblname, lbldepartment, lbldays, lblrate, lblsubmit;
    JLabel lblsalary;
    JTextField txtid, txtname, txtdepartment, txtdays;
    JTextField txtrate, txtsalary;
    JButton btnadd, btnsave, btnupdate, btndelete, btnexit, select;
    JButton btncompute, clear;
    String gen;
    private static final String USERNAME = "C##_HABTAMU";
    private static final String PASSWORD = "HAB";
    private static final String CONN_STRING =
            "jdbc:oracle:thin:@localhost:1521:orcl [c##_habtamu on C##_HABTAMU]";
    ResultSet rs = null;
    Connection con = null;
    Statement stmt = null;
    float days, rate, salary;

    Frame1() {

        super("Employees Information ");
        setLayout(null);
        add(lb2);
        lb2.setBounds(70, 20, 220, 20);
        lb2.setHorizontalAlignment(JLabel.CENTER);
        lb2.setFont(f2);
        lb2.setForeground(Color.magenta);
        lblid = new JLabel("Employee ID");
        lbldays = new JLabel("Number Of Day ");
        lblrate = new JLabel("Rate Per Day");
        lblsalary = new JLabel("Salary");

        lblid.setFont(f2);
        lbldays.setFont(f2);
        lblrate.setFont(f2);
        lblsalary.setFont(f2);
        lblid.setBounds(20, 60, 100, 20);
        lbldays.setBounds(20, 100, 100, 20);
        lblrate.setBounds(20, 140, 100, 20);
        lblsalary.setBounds(20, 180, 100, 20);

        add(lblid);
        add(lbldays);
        add(lblrate);
        add(lblsalary);

        txtid = new JTextField(15);
        txtdays = new JTextField(15);
        txtrate = new JTextField(15);
        txtsalary = new JTextField(15);
        txtsalary.setEditable(false);

        txtid.setBounds(130, 60, 100, 20);
        txtdays.setBounds(130, 100, 100, 20);
        txtrate.setBounds(130, 140, 100, 20);
        txtsalary.setBounds(130, 190, 100, 20);

        add(txtid);
        add(txtdays);
        add(txtrate);
        add(txtsalary);
        btnadd = new JButton("Add");
        btnsave = new JButton("Save");
        btnupdate = new JButton("Update");
        btndelete = new JButton("Delete");
        btnexit = new JButton("Exit");
        btncompute = new JButton("Compute");
        select = new JButton("Select");

        btnadd.setBounds(330, 60, 100, 30);
        btnsave.setBounds(330, 100, 100, 30);
        btnupdate.setBounds(330, 140, 100, 30);
        btndelete.setBounds(330, 180, 100, 30);
        btnexit.setBounds(330, 220, 100, 30);
        btncompute.setBounds(120, 240, 100, 30);
        select.setBounds(120, 280, 100, 30);

        add(btnadd);
        add(btnsave);
        add(btndelete);
        add(btnupdate);
        add(btnexit);
        add(btncompute);
        add(select);

        btnadd.addActionListener(this);
        btnsave.addActionListener(this);
        btnupdate.addActionListener(this);
        btndelete.addActionListener(this);
        btnexit.addActionListener(this);
        btncompute.addActionListener(this);
        select.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == select) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeQuery("SELECT * FROM c##_habtamu.bonus_rec WHERE emp_id='" + txtid.getText() + "'");
                ResultSet set;
                set = st.getResultSet();
                if (set.next()) {
                    txtid.setText(set.getString("emp_id"));
                    txtdays.setText(set.getString("number_of_day"));
                    txtrate.setText(set.getString("rate_per_day"));
                    txtsalary.setText(set.getString("salary"));
                } else {
                    JOptionPane.showMessageDialog(null, "no much ! ");
                }
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, txtid.getText() + " IMPITY ");
                System.out.println(ex);
            }
        } else if (ae.getSource() == btndelete) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM   c##_habtamu.bonus_rec WHERE emp_id='" + txtid.getText() + "'");
                JOptionPane.showMessageDialog(null, txtid.getText() + "  the value is deleted");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, txtid.getText() + " IMPITY delete");
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnsave) {
            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO    c##_habtamu. bonus_rec (EMP_ID,NUMBER_OF_DAY,RATE_PER_DAY,SALARY)VALUES( ' "
                        + txtid.getText() + " ',' " 
                        + txtdays.getText() +  "','" 
                        + txtrate.getText() + "','" 
                        + txtsalary.getText() + "')");
                JOptionPane.showMessageDialog(null, "you have enter data into table");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "please insert value " + ex);
                System.out.println(ex);
            }
        } else if (ae.getSource() == btncompute) {
            try {
                days = Float.parseFloat(txtdays.getText());
                rate = Float.parseFloat(txtrate.getText());
                salary = (days * rate);
                float round = Round(salary, 2);
                txtsalary.setText(Float.toString(round));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "EMPTY VALUE!!!");
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnupdate) {

            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                Statement st = con.createStatement();

                st.executeUpdate("UPDATE  c##_habtamu.bonus_rec SET emp_id='" + txtid.getText() + "',number_of_day='" + txtdays.getText() + "',rate_per_day='" + txtrate.getText() + "',salary='" + txtsalary.getText() + "'");
                JOptionPane.showMessageDialog(null, "you have updated your data successfully!!!");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Primary key " + ex);
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnadd) {
            try {
                txtid.setText("");
                txtdays.setText("");
                txtrate.setText("");
                txtsalary.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnexit) {
            try {
                setVisible(false);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static float Round(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }
}

class Frame2 extends JFrame implements ActionListener {

    JLabel lb2 = new JLabel("OVER AGE SLIP");
    Font f2 = new Font("Times", Font.ROMAN_BASELINE, 15);
    JLabel lblid, lblname, lbldepartment, lbldays, lblrate, lblsubmit;
    JLabel lblsalary;
    JTextField txtid, txtname, txtdepartment, txtdays;
    JTextField txtrate, txtsalary;
    JButton btnadd, btnsave, btnupdate, btndelete, btnexit, select;
    JButton btncompute, clear;
    String gen;
    private static final String USERNAME = "C##_HABTAMU";
    private static final String PASSWORD = "HAB";
    private static final String CONN_STRING =
            "jdbc:oracle:thin:@localhost:1521:orcl [c##_habtamu on C##_HABTAMU]";
    ResultSet rs = null;
    Connection con = null;
    Statement stmt = null;
    float days, rate, salary;

    Frame2() {

        super("c##_habtamu.Employees Information ");
        setLayout(null);
        add(lb2);
        lb2.setBounds(70, 20, 220, 20);
        lb2.setHorizontalAlignment(JLabel.CENTER);
        lb2.setFont(f2);
        lb2.setForeground(Color.magenta);
        lblid = new JLabel("Emp ID");
        lbldays = new JLabel("First Name ");
        lblrate = new JLabel("Middle Name");
        lblsalary = new JLabel("Salary");
        lblid.setFont(f2);
        lbldays.setFont(f2);
        lblrate.setFont(f2);
        lblsalary.setFont(f2);
        lblid.setBounds(20, 60, 100, 20);
        lbldays.setBounds(20, 100, 100, 20);
        lblrate.setBounds(20, 140, 100, 20);
        lblsalary.setBounds(20, 180, 100, 20);

        add(lblid);
        add(lbldays);
        add(lblrate);
        add(lblsalary);
        txtid = new JTextField(15);
        txtdays = new JTextField(15);
        txtrate = new JTextField(15);
        txtsalary = new JTextField(15);
        txtid.setBounds(130, 60, 100, 20);
        txtdays.setBounds(130, 100, 100, 20);
        txtrate.setBounds(130, 140, 100, 20);
        txtsalary.setBounds(130, 190, 100, 20);

        add(txtid);
        add(txtdays);
        add(txtrate);
        add(txtsalary);
        btnadd = new JButton("Add");
        btnsave = new JButton("Save");
        btnupdate = new JButton("Update");
        btndelete = new JButton("Delete");
        btnexit = new JButton("Exit");
        select = new JButton("Select");

        btnadd.setBounds(330, 60, 100, 30);
        btnsave.setBounds(330, 100, 100, 30);
        btnupdate.setBounds(330, 140, 100, 30);
        btndelete.setBounds(330, 180, 100, 30);
        btnexit.setBounds(330, 220, 100, 30);
        select.setBounds(330, 280, 100, 30);

        add(btnadd);
        add(btnsave);
        add(btndelete);
        add(btnupdate);
        add(btnexit);
        add(select);

        btnadd.addActionListener(this);
        btnsave.addActionListener(this);
        btnupdate.addActionListener(this);
        btndelete.addActionListener(this);
        btnexit.addActionListener(this);
        select.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == select) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeQuery("SELECT * FROM  c##_habtamu.bonus_rec WHERE emp_id='" + txtid.getText() + "'");
                ResultSet set;
                set = st.getResultSet();
                if (set.next()) {
                    txtid.setText(set.getString("emp_id"));
                    txtdays.setText(set.getString("first_name"));
                    txtrate.setText(set.getString("last_name"));
                    txtsalary.setText(set.getString("salary"));
                } else {
                    JOptionPane.showMessageDialog(null, "no much ! ");
                }
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, txtid.getText() + " IMPITY ");
                System.out.println(ex);
            }
        } else if (ae.getSource() == btndelete) {
            try {

                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM c##_habtamu.oldest WHERE emp_id='" + txtid.getText() + "'");
                JOptionPane.showMessageDialog(null, txtid.getText() + "  the value is deleted");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, txtid.getText() + " IMPITY delete");
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnsave) {
            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                //st.executeUpdate("INSERT INTO    c##_habtamu. oldest (EMP_ID,NUMBER_OF_DAY,RATE_PER_DAY,SALARY) VALUES ('" + txtid.getText() + "','" + txtdays.getText()
                      //  + "','" + txtrate.getText() + "','" + txtsalary.getText() + "')");
                      String sql="INSERT INTO   c##_habtamu. oldest (EMP_ID,NUMBER_OF_DAY,RATE_PER_DAY,SALARY) VALUES (' "
                              +txtid.getText()  + " ' , ' "
                              
                              + txtdays.getText() + " ' , ' "
                              
                              + txtrate.getText() + " ', ' "
                              
                              
                              + txtsalary.getText()  + "')";
                     
                      st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "you have enter data into table");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "please insert value " + ex);
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnupdate) {

            try {
                Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate("UPDATE c##_habtamu.oldest SET emp_id='" + txtid.getText() + "',number_of_day='" + txtdays.getText() + "',rate_per_day='" + txtrate.getText() + "',salary='" + txtsalary.getText() + "'");
                JOptionPane.showMessageDialog(null, "you have updated your data successfully!!!");

            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Primary key " + ex);
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnadd) {
            try {
                txtid.setText("");
                txtdays.setText("");
                txtrate.setText("");
                txtsalary.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (ae.getSource() == btnexit) {
            try {
                setVisible(false);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}

class Mainsal implements ActionListener {

    JFrame frame, frame1;
    JTextField textbox;
    JLabel label;
    JPanel panel;
    static JTable table;
    String driverName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl [c##_habtamu on C##_HABTAMU]";
    String userName = "C##_HABTAMU";
    String password = "HAB";
    String[] columnNames = {"Employee Id", "Job Name", "Bonus Record", "Gross Salary","Tax","Net Salary"};

    @Override
    public void actionPerformed(ActionEvent ae) {
        showTableData();
    }

    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String roll = "";
        String name = "";
        String cl = "";
        String sec = "";
        String mm = "";
        String net = "";
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql = "select * from  c##_habtamu.salery";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            meta.getColumnCount();
            int i = 0;
            while (rs.next()) {
                roll = rs.getString("emp_Id");
                name = rs.getString("job_name");
                cl = rs.getString("bonus_recourd");
                sec = rs.getString("gross_salary");
                mm = rs.getString("tax");
                net = rs.getString("net_salary");
                model.addRow(new Object[]{roll, name, cl, sec,mm,net});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
            } else {
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);

    }
}

class Main implements ActionListener {

    JFrame frame, frame1;
    JTextField textbox;
    JLabel label;
    // JButton button;
    JPanel panel;
    static JTable table;
    String driverName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl [c##_habtamu on C##_HABTAMU]l";
    String userName = "C##_HABTAMU";
    String password = "HAB";
    String[] columnNames = {"Employee Id", "Number of Day", "Rate Per Day", "salary"};

    @Override
    public void actionPerformed(ActionEvent ae) {
        showTableData();
    }

    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String roll = "";
        String name = "";
        String cl = "";
        String sec = "";
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql = "select * from  c##_habtamu.bonus_rec";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            meta.getColumnCount();
            int i = 0;
            while (rs.next()) {
                roll = rs.getString("emp_Id");
                name = rs.getString("number_of_day");
                cl = rs.getString("rate_per_day");
                sec = rs.getString("Salary");
                model.addRow(new Object[]{roll, name, cl, sec});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
            } else {
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);

    }
}

class Deve1 extends JFrame {

    private JComboBox bx1;
    private JLabel lbl1;
    private JPanel pnl;
    private FlowLayout layout2;
    private static final String[] developer = {"HABTAMU ASSEGAHEGN RCS 059/16",
        " AWEL REMETA 015/16", "AYALEW KEBED 016/16 ", "MEKEDS SMUEL RCS /", " GELANA HAILU RCS  / "," HIWOTE ALMAYEHU RCS /","YARED TESGAYE RCS 141/15",};
    private Icon[] icons = {
        new ImageIcon(getClass().getResource("")),
        new ImageIcon(getClass().getResource("")),
        new ImageIcon(getClass().getResource("")),
        new ImageIcon(getClass().getResource("")),
        new ImageIcon(getClass().getResource(""))};

    public Deve1() {
        super("developer");
        pnl = new JPanel();
        layout2 = new FlowLayout();
        layout2.setAlignment(FlowLayout.CENTER);
        pnl.setLayout(layout2);
        bx1 = new JComboBox(developer);
        bx1.setMaximumRowCount(6);
        lbl1 = new JLabel();
        lbl1.setIcon(icons[0]);
        pnl.add(bx1);
        pnl.add(lbl1);
        add(pnl, BorderLayout.CENTER);
        Deve handler = new Deve();
        bx1.addItemListener(handler);
    }

    class Deve implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lbl1.setIcon(icons[
bx1.getSelectedIndex()]);
            }
        }
    }
}

class ImageImplement extends JPanel {

    private Image img;

    public ImageImplement(Image img) {
        this.img = img;
        Dimension size = new Dimension(700, 600);
        setPreferredSize(size);
        setMinimumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}

class student extends JPanel {

    private Image img;

    public student(Image img) {
        this.img = img;
        Dimension size = new Dimension(700, 700);
        setPreferredSize(size);
        setMinimumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}

class Progress extends JFrame {

    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;

    public Progress() {
        super("Loding");
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        current = new JProgressBar(0, 1500);
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        setContentPane(pane);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
            num += 95;
        }
    }
}





















































































































































































































