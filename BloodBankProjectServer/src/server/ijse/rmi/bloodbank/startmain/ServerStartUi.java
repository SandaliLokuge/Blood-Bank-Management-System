/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.startmain;

import AppPackage.AnimationClass;
import common.ijse.rmi.bloodbank.controller.ConnectionController;
import common.ijse.rmi.bloodbank.controller.RemoteFactory;
import common.ijse.rmi.bloodbank.controller.UserController;
import common.ijse.rmi.bloodbank.model.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import server.ijse.rmi.bloodbank.controllerImpl.ConnectionControllerImpl;
import server.ijse.rmi.bloodbank.controllerImpl.RemoteFactoryImpl;
import server.ijse.rmi.bloodbank.controllerImpl.UserControllerImpl;

/**
 *
 * @author Sandali
 */
public class ServerStartUi extends JFrame {

    //----------panels
    private JPanel mainPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redtitlePanel;
    private JPanel titlePanel;
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    //----------labels
    private JLabel bloodbankLabel;
    private JLabel portLabel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel userLabel;
    private JLabel historyLabel;
    private JLabel notificationLabel1;
    private JLabel notificationLabel2;
    private JLabel notificationLabel3;
    //----------Textfields
    private JTextField usernameText;
    private JTextField dateText;
    private JTextField timeText;
    //----------Passwordfields
    private JPasswordField passwordText;
    //----------comboboxes
    private JComboBox portCombo;
    //----------tables
    private JTable connectionTable;
    private JScrollPane tablepane;
    //----------buttons
    private JButton startButton;
    private JButton connectButton;
    private JButton disconnectButton;
    private JButton enterButton;
    AnimationClass ac = new AnimationClass();
    Registry bloodbankRegistry = null;
    private RemoteFactory remoteFactoryImpl = null;

    public ServerStartUi() {
        setComponents();
        setLocationRelativeTo(null);
        addActionListener();
        //deleteOldHistory();
        disconnectButton.setEnabled(false);
        startButton.setEnabled(false);
        usernameText.requestFocus();
        setDate();
        setTime();
        loadConnections();
        try {
            
            bloodbankRegistry = LocateRegistry.createRegistry(Integer.parseInt(portCombo.getSelectedItem().toString()));
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setComponents() {
        //----------panels
        mainPanel = new JPanel();
        redPanel = new JPanel();
        grayPanel1 = new JPanel();
        redtitlePanel = new JPanel();
        titlePanel = new JPanel();
        Panel1 = new JPanel();
        Panel2 = new JPanel();
        Panel3 = new JPanel();

        //----------labels
        bloodbankLabel = new JLabel();
        portLabel = new JLabel();
        titleLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        userLabel = new JLabel();
        historyLabel = new JLabel();
        notificationLabel1 = new JLabel();
        notificationLabel2 = new JLabel();
        notificationLabel3 = new JLabel();
        //----------textfields
        usernameText = new JTextField();
        dateText = new JTextField();
        timeText = new JTextField();
        //----------passwordfields
        passwordText = new JPasswordField();
        //----------comboboxes
        portCombo = new JComboBox();
        //----------tables
        connectionTable = new JTable();


        //----------buttons
        startButton = new JButton();
        connectButton = new JButton();
        disconnectButton = new JButton();
        enterButton = new JButton();

        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(219, 215, 215), 8));


        //----------set panels
        mainPanel.setBackground(new Color(255, 255, 255));

        grayPanel1.setBackground(new Color(153, 153, 153));
        grayPanel1.setPreferredSize(new Dimension(700, 36));

        redPanel.setBackground(new Color(153, 0, 51));
        redPanel.setPreferredSize(new Dimension(230, 36));

        redtitlePanel.setBackground(new Color(153, 0, 51));
        redtitlePanel.setPreferredSize(new Dimension(20, 20));

        titlePanel.setBackground(new Color(219, 215, 215));
        titlePanel.setPreferredSize(new Dimension(730, 30));

        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(240, 240, 240));
        userLabel.setPreferredSize(new Dimension(730, 30));

        Panel1.setBackground(new Color(221, 221, 206));
        Panel1.setPreferredSize(new Dimension(730, 30));

        Panel2.setBackground(new Color(151, 185, 185));
        Panel2.setPreferredSize(new Dimension(730, 10));

        Panel3.setBackground(new Color(151, 185, 185));
        Panel3.setPreferredSize(new Dimension(730, 10));

        //-----------set main title	
        bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18));
        bloodbankLabel.setText("BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Connect to server");

        //----------set labels and comboboxes		
        portLabel.setFont(new Font("Segoe UI", 0, 14));
        portLabel.setText("Select a port :");
        portLabel.setForeground(new Color(0, 0, 0));

        portCombo.setFont(new Font("Arial", 1, 12));
        portCombo.setModel(new DefaultComboBoxModel(new String[]{"5050","5151"}));
        portCombo.setPreferredSize(new Dimension(52, 23));

        portCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                JButton comboButton = new JButton(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/ComboIcon.png"));
                comboButton.setContentAreaFilled(false);
                comboButton.setFocusPainted(false);
                comboButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

                return comboButton;
            }
        });

        portCombo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setPreferredSize(new Dimension(30, 25));
                setOpaque(true);
                setBackground(new Color(240, 240, 240));
                super.paint(g);
            }
        });

        historyLabel.setFont(new Font("Segoe UI", 1, 14));
        historyLabel.setText("Connection history - Today");
        historyLabel.setForeground(new Color(153, 153, 153));

        notificationLabel1.setFont(new Font("Segoe UI", 1, 13));
        notificationLabel1.setBackground(new Color(190, 142, 140));
        notificationLabel1.setOpaque(true);
        notificationLabel1.setForeground(new Color(255, 255, 255));
        notificationLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.add(notificationLabel1);
        notificationLabel1.setBounds(415, 10, 280, 30);
        notificationLabel1.setText("Invalid username!");

        notificationLabel2.setFont(new Font("Segoe UI", 1, 13));
        notificationLabel2.setBackground(new Color(190, 142, 140));
        notificationLabel2.setOpaque(true);
        notificationLabel2.setForeground(new Color(255, 255, 255));
        notificationLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.add(notificationLabel2);
        notificationLabel2.setBounds(415, 120, 280, 30);
        notificationLabel2.setText("Invalid password!");

        notificationLabel3.setFont(new Font("Segoe UI", 1, 13));
        notificationLabel3.setBackground(new Color(190, 142, 140));
        notificationLabel3.setOpaque(true);
        notificationLabel3.setForeground(new Color(255, 255, 255));
        notificationLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(notificationLabel3);
        notificationLabel3.setText("Server is connected");
        notificationLabel3.setBounds(950, 535, 350, 35);


        //-----------buttons

        startButton.setBackground(new Color(255, 255, 255));
        startButton.setFont(new Font("Segoe UI", 1, 14));
        startButton.setText("Home");
        startButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        startButton.setPreferredSize(new Dimension(47, 19));

        connectButton.setBackground(new Color(255, 255, 255));
        connectButton.setFont(new Font("Segoe UI", 0, 13));
        connectButton.setText("Connect");
        connectButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        connectButton.setPreferredSize(new Dimension(47, 19));

        disconnectButton.setBackground(new Color(255, 255, 255));
        disconnectButton.setFont(new Font("Segoe UI", 0, 13));
        disconnectButton.setText("Disconnect");
        disconnectButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        disconnectButton.setPreferredSize(new Dimension(47, 19));

        enterButton.setBackground(new Color(255, 255, 255));
        enterButton.setFont(new Font("Segoe UI", 0, 13));
        enterButton.setText("Enter");
        enterButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        enterButton.setPreferredSize(new Dimension(47, 19));
        enterButton.setEnabled(false);

        //----------Table
        DefaultTableModel model = new DefaultTableModel(columnNames, 10);
        connectionTable = new JTable(model);
        connectionTable.getTableHeader().setFont(new Font("Segoe UI ", 0, 14));
        connectionTable.getTableHeader().setForeground(new Color(105, 81, 81));
        connectionTable.getTableHeader().setBackground(new Color(219, 215, 215));
        connectionTable.setRowHeight(30);
        connectionTable.setRowHeight(35);
        connectionTable.setShowVerticalLines(false);
        connectionTable.setGridColor(new Color(205, 205, 205));
        tablepane = new JScrollPane(connectionTable);
        tablepane.setPreferredSize(new Dimension(460, 450));




        //-----------user panel components
        passwordLabel.setBackground(new Color(204, 204, 204));
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setText("Password  :");
        passwordLabel.setOpaque(true);

        usernameLabel.setBackground(new Color(204, 204, 204));
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setText("Username  :");
        usernameLabel.setOpaque(true);
        //-----------set panelLayouts

        //grayPanel1Layout
        grayPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        grayPanel1.add(redtitlePanel);
        grayPanel1.add(bloodbankLabel);

        //titlePanelLayout
        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup()
                .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)));
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup()
                .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)));


        //-----------Panel1Layout
        GroupLayout Panel1Layout = new GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
                Panel1Layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(portLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(portCombo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(connectButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(disconnectButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)));

        Panel1Layout.setVerticalGroup(
                Panel1Layout.createParallelGroup()
                .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel1Layout.createParallelGroup()
                .addComponent(connectButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, Panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(portCombo, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addComponent(portLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(disconnectButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));


        //----------userLabelLayout
        GroupLayout userLabelLayout = new GroupLayout(userLabel);
        userLabel.setLayout(userLabelLayout);
        userLabelLayout.setHorizontalGroup(
                userLabelLayout.createParallelGroup()
                .addGroup(userLabelLayout.createSequentialGroup()
                .addGroup(userLabelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(GroupLayout.Alignment.LEADING, userLabelLayout.createSequentialGroup()
                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.LEADING, userLabelLayout.createSequentialGroup()
                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
                .addGroup(userLabelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)));
        userLabelLayout.setVerticalGroup(
                userLabelLayout.createParallelGroup()
                .addGroup(userLabelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(userLabelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(userLabelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE)));

        userLabel.setBounds(950, 186, 400, 300);
        mainPanel.add(userLabel);

        //----------mainPanelLayout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(Panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(historyLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
                .addComponent(Panel3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));

        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(redPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Panel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(historyLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
                .addComponent(Panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)));

        add(mainPanel);
        pack();
    }
    private String[] columnNames = {
        "Username", "Port", "Time", "Connectivity"
    };

    private void addActionListener() {
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                tablepane.setSize(500, 260);
                ac.jLabelXLeft(950, 550, 10, 4, userLabel);
            }
        });

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tablepane.setSize(850, 260);
                ac.jLabelXRight(550, 950, 10, 4, userLabel);
                disconnectButton.setEnabled(true);
                try {
                    int port=Integer.parseInt(portCombo.getSelectedItem().toString());
                   remoteFactoryImpl = new RemoteFactoryImpl();
                    Registry bloodbankRegistry = LocateRegistry.createRegistry(port);
                    bloodbankRegistry.rebind("BloodBankServer", remoteFactoryImpl);
                    startButton.setEnabled(true);
                    ac.jLabelXLeft(950, 600, 10, 2, notificationLabel3);
                    ConnectionController connectionController = new ConnectionControllerImpl();
                    connectionController.addConnection(new Connection(
                            usernameText.getText(),
                            dateText.getText(),
                            timeText.getText(),
                            portCombo.getSelectedItem().toString(),
                            notificationLabel3.getText()));
                    loadConnections();
                } catch (ClassNotFoundException ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

      disconnectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bloodbankRegistry != null) {
                    try {
                        bloodbankRegistry.unbind("BloodBankServer");
                        UnicastRemoteObject.unexportObject(remoteFactoryImpl, true);
                        notificationLabel3.setText("Server is disconnected");
                    } catch (RemoteException ex) {
                        Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NotBoundException ex) {
                        Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
                    } 


                }

            }
        });
        usernameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (usernameText.getText().equals("") == true) {
                    ac.jLabelXRight(135, 415, 10, 4, notificationLabel1);
                }
            }
        });
        usernameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UserController userController=new UserControllerImpl();
                    if (userController.checkUser(usernameText.getText())) {
                        passwordText.requestFocus();
                        
                    } else {
                        ac.jLabelXLeft(415, 135, 5, 2, notificationLabel1);
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        passwordText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UserController userController = new UserControllerImpl();
                    boolean res = userController.checkPassword(usernameText.getText(), passwordText.getText());
                    if (res) {
                        enterButton.setEnabled(true);
                        enterButton.requestFocus();
                    } else {
                        ac.jLabelXLeft(415, 135, 10, 4, notificationLabel2);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        passwordText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (passwordText.getText().equals("") == true) {
                    ac.jLabelXRight(135, 415, 10, 4, notificationLabel2);
                }
            }
        });
    }

    private void setDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        dateText.setText(dateformat.format(new Date()));
    }

    private void setTime() {
        SimpleDateFormat sd = new SimpleDateFormat("h:mm a");
        timeText.setText(sd.format(new Date()) + "  ");
    }

    private void deleteOldHistory() {
        try {
            ConnectionController connectionController = new ConnectionControllerImpl();
            connectionController.deleteConnection(dateText.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadConnections() {
        try {
            ConnectionController connectionController = new ConnectionControllerImpl();
            java.util.List<Connection> connections = connectionController.getConnectionList();
            DefaultTableModel dtm = (DefaultTableModel) connectionTable.getModel();
            dtm.setRowCount(0);
            if (connections != null) {
                for (Connection connection : connections) {
                    Object[] rowdata = {connection.getUsername(), connection.getPort(), connection.getTime(), connection.getMessage()};
                    dtm.addRow(rowdata);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerStartUi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new ServerStartUi().setVisible(true);
    }
}
