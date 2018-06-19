/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.cmjd.rmi.bbms.client.view;

import AppPackage.AnimationClass;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import edu.ijse.cmjd.rmi.bbms.client.validation.Validation;
import common.ijse.rmi.bloodbank.controller.BloodCampController;
import common.ijse.rmi.bloodbank.controller.BloodReqController;
import common.ijse.rmi.bloodbank.controller.ConnectionController;
import common.ijse.rmi.bloodbank.controller.UserController;
import common.ijse.rmi.bloodbank.model.BloodCamp;
import common.ijse.rmi.bloodbank.model.BloodReq;
import common.ijse.rmi.bloodbank.model.Connection;
import common.ijse.rmi.bloodbank.model.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sandali
 */
public class Home extends JFrame {

    //panels
    private JPanel mainPanel;
    private JPanel redPanel;
    private JPanel linkPanel;
    private JPanel linkPanel1;
    private JPanel Panel;
    private JPanel bloodCampPanel;
    private JPanel newUserPanel;
    private JPanel bloodReqPanel;
    private JPanel addBloodReqPanel;
    private JPanel notesPanel;
    private JPanel dateTimePanel;
    private JPanel Panel1;
    private JPanel Panel2;
    //labels
    private JLabel bloodBankLabel;
    private JLabel bloodCampLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel bloodReqLabel;
    private JLabel notesLabel;
    private JLabel newUserLabel;
    private JLabel addBloodSampleLabel;
    private JLabel viewBloodSampleLabel;
    private JLabel searchDonorsLabel;
    private JLabel issuedListLabel;
    private JLabel newDonorLabel;
    private JLabel issueLabel;
    private JLabel homeLabel;
    private JLabel linkLabel;
    private JLabel placeLabel;
    private JLabel contactLabel;
    private JLabel campDateLabel;
    private JLabel campTimeLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel reEnterPasswordLabel;
    private JLabel notificationLabel1;
    private JLabel notificationLabel2;
    private JLabel notificationLabel3;
    private JLabel addBloodReqLabel;
    private JLabel nameLabel;
    private JLabel telLabel;
    private JLabel bloodGroupLabel;
    private JLabel imageLabel;
    //textfields
    private JTextField placeText1;
    private JTextField placeText2;
    private JTextField campDateText;
    private JTextField campTimeText;
    private JTextField cNameText;
    private JTextField ctelText;
    private JTextField userNameText;
    private JPasswordField passwordText1;
    private JPasswordField passwordText2;
    private JTextField nameText;
    private JTextField telText;
    private JTextArea noteText;
    private JComboBox bloodGroupCombo;
    //button
    private JButton enterButton;
    private JButton issueButton;
    private JButton closeButton;
    private JButton closeButton2;
    private JButton addButton;
    private JButton addButton2;
    //----------tables
    private JTable bloodReqTable;
    AnimationClass ac = new AnimationClass();
    boolean isValidated = false;
    Validation validation = new Validation();
    UserController userController = null;
    BloodCampController bloodCampController = null;
    BloodReqController bloodReqController = null;

    public Home() {
        setComponents();
        setTime();
        setDate();
        setLocationRelativeTo(null);
        addActionListeners();
        bloodCampPanel.setVisible(false);
        newUserPanel.setVisible(false);
        notesPanel.setVisible(false);
        bloodReqPanel.setVisible(false);

    }

    private void setComponents() {
        //panels
        mainPanel = new JPanel();
        redPanel = new JPanel();
        linkPanel = new JPanel();
        linkPanel1 = new JPanel();
        Panel = new JPanel();
        bloodCampPanel = new JPanel();
        newUserPanel = new JPanel();
        bloodReqPanel = new JPanel();
        addBloodReqPanel = new JPanel();
        notesPanel = new JPanel();
        dateTimePanel = new JPanel();
        Panel1 = new JPanel();
        Panel2 = new JPanel();
        //labels
        bloodBankLabel = new JLabel();
        bloodCampLabel = new JLabel();
        dateLabel = new JLabel();
        timeLabel = new JLabel();
        bloodReqLabel = new JLabel();
        notesLabel = new JLabel();
        newUserLabel = new JLabel();
        addBloodSampleLabel = new JLabel();
        viewBloodSampleLabel = new JLabel();
        searchDonorsLabel = new JLabel();
        issuedListLabel = new JLabel();
        newDonorLabel = new JLabel();
        issueLabel = new JLabel();
        homeLabel = new JLabel();
        linkLabel = new JLabel();
        placeLabel = new JLabel();
        campTimeLabel = new JLabel();
        campDateLabel = new JLabel();
        contactLabel = new JLabel();
        notificationLabel1 = new JLabel();
        notificationLabel2 = new JLabel();
        notificationLabel3 = new JLabel();
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        reEnterPasswordLabel = new JLabel();
        addBloodReqLabel = new JLabel();
        nameLabel = new JLabel();
        telLabel = new JLabel();
        bloodGroupLabel = new JLabel();
        //textfields
        placeText1 = new JTextField();
        placeText2 = new JTextField();
        campDateText = new JTextField();
        campTimeText = new JTextField();
        cNameText = new JTextField();
        ctelText = new JTextField();
        userNameText = new JTextField();
        passwordText1 = new JPasswordField();
        passwordText2 = new JPasswordField();
        nameText = new JTextField();
        telText = new JTextField();
        bloodGroupCombo = new JComboBox();
        noteText = new JTextArea();
        //button
        enterButton = new JButton();
        addButton = new JButton();
        addButton2 = new JButton();
        issueButton = new JButton();
        closeButton = new JButton();
        closeButton2 = new JButton();
        bloodReqTable = new JTable();
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(164, 181, 181), 8));


        //----------set panels
        mainPanel.setBackground(
                new Color(255, 255, 255));

        redPanel.setBackground(
                new Color(153, 0, 51));
        redPanel.setPreferredSize(
                new Dimension(230, 36));

        linkPanel.setBackground(
                new Color(240, 240, 240));
        linkPanel.setPreferredSize(
                new Dimension(700, 36));

        linkPanel1.setBackground(
                new Color(255, 255, 255));


        Panel.setBackground(
                new Color(217, 215, 215));
        Panel.setPreferredSize(
                new Dimension(700, 400));

        linkLabel.setOpaque(
                true);
        linkLabel.setBackground(
                new Color(255, 255, 255));

        bloodCampPanel.setBackground(
                new Color(255, 255, 255));
        newUserPanel.setBackground(
                new Color(255, 255, 255));
        bloodReqPanel.setBackground(
                new Color(255, 255, 255));
        notesLabel.setBackground(
                new Color(255, 255, 255));


        //-----------set main title	
        bloodBankLabel.setForeground(
                new Color(231, 231, 231));
        bloodBankLabel.setFont(
                new Font("Arial Narrow", 1, 18));
        bloodBankLabel.setText(
                "BLOOD BANK");
        bloodBankLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //-----------set link labels
        //-------------buttons
        homeLabel.setFont(
                new Font("Arial Black", 0, 14));
        homeLabel.setText(
                "Home");
        homeLabel.setOpaque(
                true);
        homeLabel.setForeground(
                new Color(153, 153, 153));
        homeLabel.setBackground(
                new Color(255, 255, 255));
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        bloodCampLabel.setFont(
                new Font("Segoe UI", 1, 14));
        bloodCampLabel.setText(
                "New blood camp");
        bloodCampLabel.setForeground(
                new Color(153, 153, 153));
        bloodCampLabel.setHorizontalAlignment(SwingConstants.CENTER);

        newUserLabel.setFont(
                new Font("Segoe UI", 1, 14));
        newUserLabel.setText(
                "Add new user");
        newUserLabel.setForeground(
                new Color(153, 153, 153));
        newUserLabel.setHorizontalAlignment(SwingConstants.CENTER);

        notesLabel.setFont(
                new Font("Segoe UI", 1, 14));
        notesLabel.setText(
                "Special notes");
        notesLabel.setForeground(
                new Color(153, 153, 153));
        notesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        bloodReqLabel.setFont(
                new Font("Segoe UI", 1, 14));
        bloodReqLabel.setText(
                "Blood requirements");
        bloodReqLabel.setForeground(
                new Color(153, 153, 153));
        bloodReqLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //----------set links
        newDonorLabel.setFont(
                new Font("Segoe UI", 0, 14));
        newDonorLabel.setForeground(
                new Color(102, 102, 102));
        newDonorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        newDonorLabel.setText(
                "New Donor");
        newDonorLabel.setOpaque(
                true);
        newDonorLabel.setBackground(
                new Color(240, 240, 240));

        addBloodSampleLabel.setFont(
                new Font("Segoe UI", 0, 14));
        addBloodSampleLabel.setForeground(
                new Color(102, 102, 102));
        addBloodSampleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        addBloodSampleLabel.setText(
                "Add Blood Sample");
        addBloodSampleLabel.setOpaque(
                true);
        addBloodSampleLabel.setBackground(
                new Color(240, 240, 240));

        viewBloodSampleLabel.setFont(
                new Font("Segoe UI", 0, 14));
        viewBloodSampleLabel.setForeground(
                new Color(102, 102, 102));
        viewBloodSampleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        viewBloodSampleLabel.setText(
                "View blood sample details");
        viewBloodSampleLabel.setOpaque(
                true);
        viewBloodSampleLabel.setBackground(
                new Color(240, 240, 240));

        issueLabel.setFont(
                new Font("Segoe UI", 0, 14));
        issueLabel.setForeground(
                new Color(102, 102, 102));
        issueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        issueLabel.setText(
                "Issue blood sample");
        issueLabel.setOpaque(
                true);
        issueLabel.setBackground(
                new Color(240, 240, 240));


        issuedListLabel.setFont(
                new Font("Segoe UI", 0, 14));
        issuedListLabel.setForeground(
                new Color(102, 102, 102));
        issuedListLabel.setHorizontalAlignment(SwingConstants.CENTER);

        issuedListLabel.setText(
                "Issued blood sample details");
        issuedListLabel.setOpaque(
                true);
        issuedListLabel.setBackground(
                new Color(240, 240, 240));

        searchDonorsLabel.setFont(
                new Font("Segoe UI", 0, 14));
        searchDonorsLabel.setForeground(
                new Color(102, 102, 102));
        searchDonorsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        searchDonorsLabel.setText(
                "Search Donors");
        searchDonorsLabel.setOpaque(
                true);
        searchDonorsLabel.setBackground(
                new Color(240, 240, 240));


        //------------set time & date labels

        timeLabel.setOpaque(
                true);
        timeLabel.setBackground(
                new Color(219, 215, 215));
        timeLabel.setFont(
                new Font("Segoe UI", 0, 16));
        timeLabel.setForeground(
                new Color(0, 0, 0));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dateLabel.setOpaque(
                true);
        dateLabel.setBackground(
                new Color(219, 215, 215));
        dateLabel.setFont(
                new Font("Segoe UI", 0, 16));
        dateLabel.setForeground(
                new Color(0, 0, 0));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //-------------bloodCampPanel
        placeLabel.setBackground(
                new Color(204, 204, 204));
        placeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        placeLabel.setText(
                "Place  :");
        placeLabel.setOpaque(
                true);

        contactLabel.setBackground(
                new Color(204, 204, 204));
        contactLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        contactLabel.setText(
                "Contact  :");
        contactLabel.setOpaque(
                true);

        campTimeLabel.setBackground(
                new Color(204, 204, 204));
        campTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        campTimeLabel.setText(
                "Time  :");
        campTimeLabel.setOpaque(
                true);

        campDateLabel.setBackground(
                new Color(204, 204, 204));
        campDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        campDateLabel.setText(
                "Date  :");
        campDateLabel.setOpaque(
                true);

        enterButton.setBackground(
                new Color(151, 185, 185));
        enterButton.setFont(
                new Font("Segoe UI", 0, 13));
        enterButton.setText(
                "Enter");
        enterButton.setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185)));
        enterButton.setPreferredSize(
                new Dimension(47, 19));
        enterButton.setEnabled(
                false);
        enterButton.setHorizontalAlignment(SwingConstants.CENTER);


        notificationLabel1.setFont(
                new Font("Segoe UI", 1, 13));
        notificationLabel1.setBackground(
                new Color(190, 142, 140));
        notificationLabel1.setOpaque(
                true);
        notificationLabel1.setForeground(
                new Color(255, 255, 255));
        notificationLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        bloodCampPanel.add(notificationLabel1);

        notificationLabel1.setBounds(
                466, 10, 280, 30);
        notificationLabel1.setText(
                "Invalid input! Check it again");

        ctelText.setText(
                "Contact number");
        ctelText.setForeground(
                new Color(153, 153, 153));
        cNameText.setText(
                "Contact name");
        cNameText.setForeground(
                new Color(153, 153, 153));

        //-------------newUserPanel
        userNameLabel.setBackground(
                new Color(204, 204, 204));
        userNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        userNameLabel.setText(
                "User name  :");
        userNameLabel.setOpaque(
                true);

        passwordLabel.setBackground(
                new Color(204, 204, 204));
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        passwordLabel.setText(
                "Password  :");
        passwordLabel.setOpaque(
                true);

        reEnterPasswordLabel.setBackground(
                new Color(204, 204, 204));
        reEnterPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        reEnterPasswordLabel.setText(
                "Confirm pass.  :");
        reEnterPasswordLabel.setOpaque(
                true);

        addButton.setBackground(
                new Color(151, 185, 185));
        addButton.setFont(
                new Font("Segoe UI", 0, 13));
        addButton.setText(
                "Enter");
        addButton.setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185)));
        addButton.setPreferredSize(
                new Dimension(47, 19));
        addButton.setEnabled(
                false);
        addButton.setHorizontalAlignment(SwingConstants.CENTER);


        notificationLabel2.setFont(
                new Font("Segoe UI", 1, 12));
        notificationLabel2.setBackground(
                new Color(190, 142, 140));
        notificationLabel2.setOpaque(
                true);
        notificationLabel2.setForeground(
                new Color(255, 255, 255));
        notificationLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        newUserPanel.add(notificationLabel2);

        notificationLabel2.setBounds(
                466, 40, 300, 30);
        notificationLabel2.setText(
                "Someone already has that username. Try another!");

        notificationLabel3.setFont(
                new Font("Segoe UI", 1, 12));
        notificationLabel3.setBackground(
                new Color(190, 142, 140));
        notificationLabel3.setOpaque(
                true);
        notificationLabel3.setForeground(
                new Color(255, 255, 255));
        notificationLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        newUserPanel.add(notificationLabel3);

        notificationLabel3.setBounds(
                466, 210, 300, 30);
        notificationLabel3.setText(
                "These passwords don't match. Try again!");

        //-------------addBloodReqPanel
        addBloodReqLabel.setBackground(
                new Color(204, 204, 204));
        addBloodReqLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        addBloodReqLabel.setText(
                "Add blood requirenment   ");
        addBloodReqLabel.setOpaque(
                true);


        nameLabel.setText(
                "Name  :");



        bloodGroupLabel.setText(
                "Blood group  :");


        telLabel.setText(
                "Tel  :");


        addButton2.setBackground(
                new Color(151, 185, 185));
        addButton2.setFont(
                new Font("Segoe UI", 0, 13));
        addButton2.setText(
                "Enter");
        addButton2.setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185)));
        addButton2.setPreferredSize(
                new Dimension(47, 19));
        addButton2.setHorizontalAlignment(SwingConstants.CENTER);


        bloodGroupCombo.setFont(new Font("Arial", 1, 12));
        bloodGroupCombo.setModel(new DefaultComboBoxModel(new String[]{"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        bloodGroupCombo.setBackground(new Color(255, 255, 255));
        bloodGroupCombo.setPreferredSize(new Dimension(80, 20));
        
        imageLabel=new JLabel(new ImageIcon("I:\\IJSE\\Project-BloodBank\\BloodBankProjectClient\\src\\edu\\ijse\\cmjd\\rmi\\bbms\\client\\images"));

        //----------Table
        DefaultTableModel model = new DefaultTableModel(columnNames, 10);
        bloodReqTable = new JTable(model);
        bloodReqTable.getTableHeader().setFont(new Font("Segoe UI ", 0, 14));
        bloodReqTable.getTableHeader().setForeground(new Color(105, 81, 81));
        bloodReqTable.getTableHeader().setBackground(new Color(219, 215, 215));
        bloodReqTable.setRowHeight(30);
        bloodReqTable.setRowHeight(35);
        bloodReqTable.setShowVerticalLines(false);
        bloodReqTable.setGridColor(new Color(205, 205, 205));
        JScrollPane tablepane = new JScrollPane(bloodReqTable);
        bloodReqTable.setRowHeight(30);

        closeButton.setFont(
                new Font("Segoe UI", 0, 13));
        closeButton.setText(
                "Close");
        closeButton.setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185)));
        closeButton.setPreferredSize(
                new Dimension(47, 19));
        closeButton.setBackground(new Color(151, 185, 185));


        JScrollPane textPane = new JScrollPane(noteText);
        closeButton2.setFont(
                new Font("Segoe UI", 0, 13));
        closeButton2.setText(
                "Close");
        closeButton2.setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185)));
        closeButton2.setPreferredSize(
                new Dimension(47, 19));
        closeButton2.setBackground(new Color(151, 185, 185));

        issueButton.setFont(
                new Font("Segoe UI", 0, 13));
        issueButton.setText(
                "Issue blood");
        issueButton.setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185)));
        issueButton.setPreferredSize(
                new Dimension(47, 19));
        issueButton.setBackground(new Color(151, 185, 185));
        issueButton.setEnabled(false);
        //-----------set panelLayouts

        //redPanelLayout

        GroupLayout redPanelLayout = new GroupLayout(redPanel);

        redPanel.setLayout(redPanelLayout);

        redPanelLayout.setHorizontalGroup(
                redPanelLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, redPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(bloodBankLabel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));
        redPanelLayout.setVerticalGroup(
                redPanelLayout.createParallelGroup()
                .addComponent(bloodBankLabel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));


        //linkPanelLayout

        GroupLayout linkPanelLayout = new GroupLayout(linkPanel);

        linkPanel.setLayout(linkPanelLayout);

        linkPanelLayout.setHorizontalGroup(
                linkPanelLayout.createParallelGroup()
                .addGroup(linkPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(bloodCampLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(newUserLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(notesLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(bloodReqLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)));
        linkPanelLayout.setVerticalGroup(
                linkPanelLayout.createParallelGroup()
                .addGroup(linkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(linkPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodCampLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(newUserLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(notesLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(bloodReqLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


        //----------linklabelLayout
        GroupLayout linklabelLayout = new javax.swing.GroupLayout(linkLabel);

        linkLabel.setLayout(linklabelLayout);

        linklabelLayout.setHorizontalGroup(
                linklabelLayout.createParallelGroup()
                .addGroup(linklabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(linklabelLayout.createParallelGroup()
                .addComponent(issuedListLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(issueLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBloodSampleLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newDonorLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addComponent(searchDonorsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewBloodSampleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));

        linklabelLayout.setVerticalGroup(
                linklabelLayout.createParallelGroup()
                .addGroup(linklabelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(newDonorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBloodSampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(issueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewBloodSampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchDonorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(issuedListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE)));
        linkLabel.setBounds(
                -230, 109, 230, 380);
        mainPanel.add(linkLabel);
        //bloodCampPanelLayout
        GroupLayout bloodCampPanelLayout = new GroupLayout(bloodCampPanel);

        bloodCampPanel.setLayout(bloodCampPanelLayout);

        bloodCampPanelLayout.setHorizontalGroup(
                bloodCampPanelLayout.createParallelGroup()
                .addGroup(bloodCampPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bloodCampPanelLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, bloodCampPanelLayout.createSequentialGroup()
                .addGroup(bloodCampPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(campTimeLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(campDateLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(contactLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bloodCampPanelLayout.createParallelGroup()
                .addComponent(cNameText, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                .addComponent(campTimeText, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                .addComponent(campDateText, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                .addComponent(ctelText, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
                .addComponent(enterButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bloodCampPanelLayout.createSequentialGroup()
                .addComponent(placeLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bloodCampPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(placeText2)
                .addComponent(placeText1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)));
        bloodCampPanelLayout.setVerticalGroup(
                bloodCampPanelLayout.createParallelGroup()
                .addGroup(bloodCampPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(bloodCampPanelLayout.createParallelGroup()
                .addComponent(placeText1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bloodCampPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(placeLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(placeText2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(bloodCampPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(campDateLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(campDateText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(bloodCampPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(campTimeText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addComponent(campTimeLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(bloodCampPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(contactLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(cNameText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ctelText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE)));

        bloodCampPanel.setBounds(
                270, 109, 450, 420);
        mainPanel.add(bloodCampPanel);
        //newUserPanelLayout
        GroupLayout newUserPanelLayout = new GroupLayout(newUserPanel);

        newUserPanel.setLayout(newUserPanelLayout);

        newUserPanelLayout.setHorizontalGroup(
                newUserPanelLayout.createParallelGroup()
                .addGroup(newUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newUserPanelLayout.createParallelGroup()
                .addGroup(newUserPanelLayout.createSequentialGroup()
                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(passwordText1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                .addGroup(newUserPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                .addGroup(newUserPanelLayout.createSequentialGroup()
                .addComponent(reEnterPasswordLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordText2, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, newUserPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)));
        newUserPanelLayout.setVerticalGroup(
                newUserPanelLayout.createParallelGroup()
                .addGroup(newUserPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addComponent(passwordText1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(reEnterPasswordLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addComponent(passwordText2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)));

        newUserPanel.setBounds(
                270, 109, 450, 420);
        mainPanel.add(newUserPanel);
        addBloodReqPanel.setBounds(575, 290, 380, 250);
        dateTimePanel.setBounds(775, 130, 180, 150);
        Panel2.setBounds(575, 130, 180, 150);
        Panel1.setBounds(300, 130, 250, 410);
        mainPanel.add(addBloodReqPanel);
        mainPanel.add(dateTimePanel);
        mainPanel.add(Panel2);
        mainPanel.add(Panel1);

        //addBloodReqPanelLayout
        GroupLayout addBloodReqPanelLayout = new GroupLayout(addBloodReqPanel);
        addBloodReqPanel.setLayout(addBloodReqPanelLayout);
        addBloodReqPanelLayout.setHorizontalGroup(
                addBloodReqPanelLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, addBloodReqPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(addBloodReqPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(addButton2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                .addGroup(addBloodReqPanelLayout.createParallelGroup()
                .addComponent(addBloodReqLabel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                .addGroup(addBloodReqPanelLayout.createSequentialGroup()
                .addGroup(addBloodReqPanelLayout.createParallelGroup()
                .addComponent(nameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                .addComponent(telLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodGroupLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addBloodReqPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(telText, GroupLayout.Alignment.LEADING)
                .addComponent(nameText, GroupLayout.Alignment.LEADING)
                .addComponent(bloodGroupCombo, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25)));
        addBloodReqPanelLayout.setVerticalGroup(
                addBloodReqPanelLayout.createParallelGroup()
                .addGroup(addBloodReqPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addBloodReqLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addBloodReqPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBloodReqPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(telLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(telText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addBloodReqPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(bloodGroupLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodGroupCombo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(23, 23, 23)));



        //bloodReqPanelLayout
        GroupLayout bloodReqPanelLayout = new GroupLayout(bloodReqPanel);
        bloodReqPanel.setLayout(bloodReqPanelLayout);
        bloodReqPanelLayout.setHorizontalGroup(
                bloodReqPanelLayout.createParallelGroup()
                .addGroup(bloodReqPanelLayout.createSequentialGroup()
                .addGroup(bloodReqPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(bloodReqPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.LEADING, bloodReqPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 53)));
        bloodReqPanelLayout.setVerticalGroup(
                bloodReqPanelLayout.createParallelGroup()
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bloodReqPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)));

        issueButton.setBounds(150, 343, 192, 34);
        bloodReqPanel.add(issueButton);
        bloodReqPanel.setBounds(
                270, 109, 550, 420);
        mainPanel.add(bloodReqPanel);

        notesPanel.setBounds(
                270, 109, 500, 420);
        mainPanel.add(notesPanel);

        //notesPanelLayout
        GroupLayout notesPanelLayout = new GroupLayout(notesPanel);
        notesPanel.setLayout(notesPanelLayout);
        notesPanelLayout.setHorizontalGroup(
                notesPanelLayout.createParallelGroup()
                .addGroup(notesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(notesPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                .addComponent(closeButton2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE)));
        notesPanelLayout.setVerticalGroup(
                notesPanelLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, notesPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(closeButton2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)));
        //dateTimePanelLayout
        GroupLayout dateTimePanelLayout = new GroupLayout(dateTimePanel);
        dateTimePanel.setLayout(dateTimePanelLayout);
        dateTimePanelLayout.setHorizontalGroup(
                dateTimePanelLayout.createParallelGroup()
                .addGroup(dateTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
                .addGroup(dateTimePanelLayout.createParallelGroup()
                .addGroup(dateTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())));
        dateTimePanelLayout.setVerticalGroup(
                dateTimePanelLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, dateTimePanelLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
                .addGroup(dateTimePanelLayout.createParallelGroup()
                .addGroup(dateTimePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))));

        //Panel2Layout
        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
                Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap()));
        Panel2Layout.setVerticalGroup(
                Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap()));
        //mainPanelLayout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);

        mainPanel.setLayout(mainPanelLayout);

        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
                .addComponent(linkPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linkPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addGap(30, 30, 30)));
        add(mainPanel);

        pack();
    }

    private void setTime() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    SimpleDateFormat sd = new SimpleDateFormat("h:mm a");
                    timeLabel.setText(sd.format(new Date()) + "  ");
                }
            }
        }).start();
    }

    private void setDate() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    SimpleDateFormat sd = new SimpleDateFormat("EEEE   YYYY:MM:dd");
                    dateLabel.setText(sd.format(new Date()) + "  ");
                }
            }
        }).start();
    }

    private void addActionListeners() {
        homeLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                ac.jLabelXRight(-230, 1, 8, 5, linkLabel);
                bloodReqLabel.setOpaque(true);
                bloodReqLabel.setBackground(new Color(240, 240, 240));
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                bloodCampLabel.setOpaque(true);
                bloodCampLabel.setBackground(new Color(240, 240, 240));
                notesLabel.setOpaque(true);
                notesLabel.setBackground(new Color(240, 240, 240));
            }
        });

        Panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                ac.jLabelXLeft(1, -230, 8, 3, linkLabel);

            }
        });
        addBloodSampleLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                addBloodSampleLabel.setOpaque(true);
                addBloodSampleLabel.setBackground(new Color(212, 217, 217));

            }
        });

        addBloodSampleLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                addBloodSampleLabel.setOpaque(true);
                addBloodSampleLabel.setBackground(new Color(240, 240, 240));

            }
        });

        newDonorLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                newDonorLabel.setOpaque(true);
                newDonorLabel.setBackground(new Color(212, 217, 217));

            }
        });

        newDonorLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                newDonorLabel.setOpaque(true);
                newDonorLabel.setBackground(new Color(240, 240, 240));

            }
        });

        issueLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                issueLabel.setOpaque(true);
                issueLabel.setBackground(new Color(212, 217, 217));

            }
        });

        issueLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                issueLabel.setOpaque(true);
                issueLabel.setBackground(new Color(240, 240, 240));

            }
        });

        viewBloodSampleLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                viewBloodSampleLabel.setOpaque(true);
                viewBloodSampleLabel.setBackground(new Color(212, 217, 217));

            }
        });

        viewBloodSampleLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                viewBloodSampleLabel.setOpaque(true);
                viewBloodSampleLabel.setBackground(new Color(240, 240, 240));

            }
        });

        issuedListLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                issuedListLabel.setOpaque(true);
                issuedListLabel.setBackground(new Color(212, 217, 217));

            }
        });

        issuedListLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                issuedListLabel.setOpaque(true);
                issuedListLabel.setBackground(new Color(240, 240, 240));

            }
        });

        searchDonorsLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                searchDonorsLabel.setOpaque(true);
                searchDonorsLabel.setBackground(new Color(212, 217, 217));

            }
        });

        searchDonorsLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                searchDonorsLabel.setOpaque(true);
                searchDonorsLabel.setBackground(new Color(240, 240, 240));

            }
        });

        bloodCampLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bloodCampLabel.setForeground(new Color(0, 0, 0));
            }
        });

        bloodCampLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                bloodCampLabel.setForeground(new Color(153, 153, 153));
            }
        });

        bloodCampLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                bloodCampLabel.setOpaque(true);
                bloodCampLabel.setBackground(new Color(151, 185, 185));
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                notesLabel.setOpaque(true);
                notesLabel.setBackground(new Color(240, 240, 240));
                bloodReqLabel.setOpaque(true);
                bloodReqLabel.setBackground(new Color(240, 240, 240));
                bloodCampPanel.setVisible(true);
                dateTimePanel.setVisible(false);
                addBloodReqPanel.setVisible(false);
                Panel1.setVisible(false);
                Panel2.setVisible(false);
                newUserPanel.setVisible(false);
                notesPanel.setVisible(false);
                bloodReqPanel.setVisible(false);

            }
        });

        newUserLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                newUserLabel.setForeground(new Color(0, 0, 0));
            }
        });

        newUserLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                newUserLabel.setForeground(new Color(153, 153, 153));
            }
        });
        newUserLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(151, 185, 185));
                bloodCampLabel.setOpaque(true);
                bloodCampLabel.setBackground(new Color(240, 240, 240));
                notesLabel.setOpaque(true);
                notesLabel.setBackground(new Color(240, 240, 240));
                bloodReqLabel.setOpaque(true);
                bloodReqLabel.setBackground(new Color(240, 240, 240));

                bloodCampPanel.setVisible(false);
                dateTimePanel.setVisible(false);
                addBloodReqPanel.setVisible(false);
                Panel1.setVisible(false);
                Panel2.setVisible(false);
                notesPanel.setVisible(false);
                bloodReqPanel.setVisible(false);
                newUserPanel.setVisible(true);
            }
        });

        notesLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                notesLabel.setForeground(new Color(0, 0, 0));
            }
        });

        notesLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                notesLabel.setForeground(new Color(153, 153, 153));
            }
        });

        notesLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                notesLabel.setOpaque(true);
                notesLabel.setBackground(new Color(151, 185, 185));
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                bloodCampLabel.setOpaque(true);
                bloodCampLabel.setBackground(new Color(240, 240, 240));
                bloodReqLabel.setOpaque(true);
                bloodReqLabel.setBackground(new Color(240, 240, 240));
                dateTimePanel.setVisible(false);
                addBloodReqPanel.setVisible(false);
                Panel1.setVisible(false);
                Panel2.setVisible(false);
                newUserPanel.setVisible(false);
                bloodCampPanel.setVisible(false);
                bloodReqPanel.setVisible(false);
                notesPanel.setVisible(true);
            }
        });
        bloodReqLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bloodReqLabel.setForeground(new Color(0, 0, 0));
            }
        });

        bloodReqLabel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                bloodReqLabel.setForeground(new Color(153, 153, 153));
            }
        });
        bloodReqLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {

                bloodReqLabel.setOpaque(true);
                bloodReqLabel.setBackground(new Color(151, 185, 185));
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                bloodCampLabel.setOpaque(true);
                bloodCampLabel.setBackground(new Color(240, 240, 240));
                notesLabel.setOpaque(true);
                notesLabel.setBackground(new Color(240, 240, 240));
                dateTimePanel.setVisible(false);
                addBloodReqPanel.setVisible(false);
                Panel1.setVisible(false);
                Panel2.setVisible(false);
                newUserPanel.setVisible(false);
                bloodCampPanel.setVisible(false);
                bloodReqPanel.setVisible(true);
                notesPanel.setVisible(false);
                loadBloodreqs();



            }
        });
        linkLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                linkLabel.setBounds(1, 109, 230, 380);
                bloodReqLabel.setOpaque(true);
                bloodReqLabel.setBackground(new Color(240, 240, 240));
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                bloodCampLabel.setOpaque(true);
                bloodCampLabel.setBackground(new Color(240, 240, 240));
                notesLabel.setOpaque(true);
                notesLabel.setBackground(new Color(240, 240, 240));
            }
        });


        newDonorLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new AddDonorDetails().setVisible(true);
            }
        });
        addBloodSampleLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new AddBloodSample().setVisible(true);
            }
        });

        viewBloodSampleLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ViewBloodSamples().setVisible(true);
            }
        });
        issueLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new IssueBloodSample().setVisible(true);
            }
        });
        issuedListLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ViewIssuedBloodList().setVisible(true);
            }
        });
        searchDonorsLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ViewDonors().setVisible(true);
            }
        });
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    bloodCampController = ServerConnector.getServerConnector().getBloodCampController();
                    boolean res = bloodCampController.addBloodCamp(new BloodCamp(
                            placeText1.getText() + " " + placeText2.getText(),
                            campDateText.getText(),
                            campTimeText.getText(),
                            ctelText.getText(),
                            cNameText.getText()));
                    if (res) {
                        JOptionPane.showMessageDialog(null, "Blood camp details are entered");
                        bloodCampPanel.setVisible(false);
                        bloodCampLabel.setOpaque(true);
                        bloodCampLabel.setBackground(new Color(240, 240, 240));
                        dateTimePanel.setVisible(true);
                        addBloodReqPanel.setVisible(true);
                        Panel1.setVisible(true);
                        Panel2.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        placeText1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(placeText1);
                if (isValidated) {
                    if (!placeText1.getText().equals("") && !placeText2.getText().equals("") && !campDateText.getText().equals("") && !campTimeText.getText().equals("") && !ctelText.getText().equals("") && !cNameText.getText().equals("")) {
                        enterButton.setEnabled(true);
                        enterButton.requestFocus();
                    } else {
                        placeText2.requestFocus();
                    }
                } else {
                    ac.jLabelXLeft(466, 186, 5, 2, notificationLabel1);
                }
            }
        });
        placeText1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (placeText1.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(186, 466, 5, 2, notificationLabel1);
                }
            }
        });
        placeText2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(placeText2);
                if (isValidated) {
                    if (!placeText1.getText().equals("") && !placeText2.getText().equals("") && !campDateText.getText().equals("") && !campTimeText.getText().equals("") && !ctelText.getText().equals("") && !cNameText.getText().equals("")) {
                        enterButton.setEnabled(true);
                        enterButton.requestFocus();
                    } else {
                        campDateText.requestFocus();
                    }
                } else {
                    ac.jLabelXLeft(466, 186, 5, 2, notificationLabel1);
                }
            }
        });
        placeText2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (placeText2.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(186, 466, 5, 2, notificationLabel1);
                }
            }
        });
        campDateText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.dateValidation(campDateText.getText());
                if (isValidated) {
                    if (!placeText1.getText().equals("") && !placeText2.getText().equals("") && !campDateText.getText().equals("") && !campTimeText.getText().equals("") && !ctelText.getText().equals("") && !cNameText.getText().equals("")) {
                        enterButton.setEnabled(true);
                        enterButton.requestFocus();
                    } else {
                        campTimeText.requestFocus();
                    }
                } else {
                    ac.jLabelXLeft(466, 186, 5, 2, notificationLabel1);
                }
            }
        });
        campDateText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (campDateText.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(186, 466, 5, 2, notificationLabel1);
                }
            }
        });

        campTimeText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cNameText.requestFocus();
                cNameText.setText("");
                cNameText.setForeground(new Color(0, 0, 0));

            }
        });
        campTimeText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (campTimeText.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(186, 466, 5, 2, notificationLabel1);
                }
            }
        });
        cNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(cNameText);
                if (isValidated) {
                    if (!placeText1.getText().equals("") && !placeText2.getText().equals("") && !campDateText.getText().equals("") && !campTimeText.getText().equals("") && !cNameText.getText().equals("")) {
                        enterButton.setEnabled(true);
                        enterButton.requestFocus();
                    } else {
                        ctelText.requestFocus();
                        ctelText.setText("");
                        ctelText.setForeground(new Color(0, 0, 0));
                    }
                } else {
                    ac.jLabelXLeft(466, 186, 5, 2, notificationLabel1);
                }
            }
        });
        cNameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (cNameText.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(186, 466, 5, 2, notificationLabel1);
                }
            }
        });
        ctelText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.phoneNumberValidation(ctelText.getText());
                if (isValidated) {
                    if (!placeText1.getText().equals("") && !placeText2.getText().equals("") && !campDateText.getText().equals("") && !campTimeText.getText().equals("") && !ctelText.getText().equals("") && !cNameText.getText().equals("")) {
                        enterButton.setEnabled(true);
                        enterButton.requestFocus();
                    }
                } else {
                    ac.jLabelXLeft(466, 186, 5, 2, notificationLabel1);
                }
            }
        });
        ctelText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (ctelText.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(186, 466, 5, 2, notificationLabel1);
                }
            }
        });



        userNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    userController = ServerConnector.getServerConnector().getUserController();
                    if (userController.checkUser(userNameText.getText())) {
                        ac.jLabelXLeft(466, 164, 5, 2, notificationLabel2);
                    } else {
                        passwordText1.requestFocus();
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        userNameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (userNameText.getText().equals("") == true) {
                    addButton.setEnabled(false);
                    ac.jLabelXRight(164, 466, 5, 2, notificationLabel2);
                }
            }
        });

        passwordText1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordText2.requestFocus();

            }
        });
        passwordText1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (passwordText1.getText().equals("") == true) {
                    addButton.setEnabled(false);
                    passwordText2.setText("");
                }
            }
        });
        passwordText2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordText2.getText().equals(passwordText1.getText())) {
                    addButton.setEnabled(true);
                    addButton.requestFocus();
                } else {
                    ac.jLabelXLeft(466, 164, 5, 2, notificationLabel3);
                }
            }
        });
        passwordText2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (passwordText2.getText().equals("") == true) {
                    enterButton.setEnabled(false);
                    ac.jLabelXRight(164, 466, 5, 2, notificationLabel3);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    userController = ServerConnector.getServerConnector().getUserController();
                    boolean res = userController.addUser(new User(
                            userNameText.getText(),
                            passwordText2.getText()));
                    if (res) {
                        JOptionPane.showMessageDialog(null, "User is added");
                        newUserPanel.setVisible(false);
                        newUserLabel.setOpaque(true);
                        newUserLabel.setBackground(new Color(240, 240, 240));
                        dateTimePanel.setVisible(true);
                        addBloodReqPanel.setVisible(true);
                        Panel1.setVisible(true);
                        Panel2.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloodReqPanel.setVisible(false);
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                dateTimePanel.setVisible(true);
                addBloodReqPanel.setVisible(true);
                Panel1.setVisible(true);
                Panel2.setVisible(true);

            }
        });

        closeButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notesPanel.setVisible(false);
                newUserLabel.setOpaque(true);
                newUserLabel.setBackground(new Color(240, 240, 240));
                dateTimePanel.setVisible(true);
                addBloodReqPanel.setVisible(true);
                Panel1.setVisible(true);
                Panel2.setVisible(true);

            }
        });
        addButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    bloodReqController = ServerConnector.getServerConnector().getBloodReqController();
                    boolean res = bloodReqController.addBloodreq(new BloodReq(
                            nameText.getText(),
                            telText.getText(),
                            bloodGroupCombo.getSelectedItem().toString()));
                    if (res) {
                        JOptionPane.showMessageDialog(null, "Blood requirement is saved");
                        nameText.setText("");
                        telText.setText("");
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        issueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    bloodReqController = ServerConnector.getServerConnector().getBloodReqController();
                    boolean res = bloodReqController.deleteBloodReq((bloodReqTable.getValueAt(bloodReqTable.getSelectedRow(), 0).toString()));
                    if (res) {
                        JOptionPane.showMessageDialog(null, "You can issue blood for" + " " + (bloodReqTable.getValueAt(bloodReqTable.getSelectedRow(), 0).toString()));
                        new IssueBloodSample().setVisible(true);
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        bloodReqTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (bloodReqTable.getSelectedRowCount() == 1) {
                    issueButton.setEnabled(true);

                }
            }
        });

    }

    public static void main(String args[]) {
        new Home().setVisible(true);
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    private String[] columnNames = {
        "Name", "Tel", "Required blood group"
    };

    private void loadBloodreqs() {
        try {
            bloodReqController = ServerConnector.getServerConnector().getBloodReqController();
            List<BloodReq> allBloodReqs = bloodReqController.getallBloodReqs();
            DefaultTableModel dtm = (DefaultTableModel) bloodReqTable.getModel();
            dtm.setRowCount(0);
            if (allBloodReqs != null) {
                for (BloodReq bloodReq : allBloodReqs) {
                    Object[] rowdata = {bloodReq.getName(), bloodReq.getContactnum(), bloodReq.getBloodgroup()};
                    dtm.addRow(rowdata);
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
