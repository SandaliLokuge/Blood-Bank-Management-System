package edu.ijse.cmjd.rmi.bbms.client.view;

import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.model.Donor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewSpecificDonorDetails extends JFrame {
    //----------panels

    private JPanel mainPanel;
    private JPanel blackPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redtitlePanel;
    private JPanel titlePanel1;
    private JPanel titlePanel2;
    //----------labels
    private JLabel addressLabel;
    private JLabel ageLabel;
    private JLabel bloodbankLabel;
    private JLabel regdateLabel;
    private JLabel didLabel;
    private JLabel dobLabel;
    private JLabel firstnameLabel;
    private JLabel genderLabel;
    private JLabel lastnameLabel;
    private JLabel mobileLabel;
    private JLabel newdonorLabel;
    private JLabel nicLabel;
    private JLabel bloodgroupLabel;
    private JLabel rhfactorLabel;
    private JLabel pinfoLabel;
    private JLabel telhLabel;
    private JLabel titleLabel;
    private JLabel vLabel;
    private JLabel yrsLabel;
    //----------textfields
    private JTextField addressText;
    private JTextField ageText;
    private JTextField regdateText;
    private JTextField didText;
    private JTextField firstnameText;
    private JTextField lastnameText;
    private JTextField mobileText;
    private JTextField nicText;
    private JTextField telhText;
    private JTextField dobText;
    private JTextField genderText;
    private JTextField Text;
    private JTextField bloodgroupText;
    private JTextField rhfactorText;
    //----------buttons
    private JButton viewdonationsButton;
    private JButton cancelButton;
    //----------separators
    private JSeparator Separator1;
    private JSeparator Separator2;

    public ViewSpecificDonorDetails(String donorid) {
        setComponents();
        setLocationRelativeTo(null);
        setActionListeners();
        //load donor details

        try {

            DonorController donorController = ServerConnector.getServerConnector().getDonorController();
            Donor donor = donorController.searchDonorByid(donorid);
            Text.setText(donor.getTitle());
            genderText.setText(donor.getGender());
            regdateText.setText(donor.getRegdate());
            addressText.setText(donor.getAddress());
            ageText.setText(donor.getAge());
            didText.setText(donor.getDonorid());
            firstnameText.setText(donor.getFirstname());
            lastnameText.setText(donor.getLastname());
            mobileText.setText(donor.getMobile());
            nicText.setText(donor.getNic());
            telhText.setText(donor.getTelhome());
            dobText.setText(donor.getDateofbirth());
            bloodgroupText.setText(donor.getBloodgroup());
            rhfactorText.setText(donor.getRhfactor());

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

    private void setComponents() {

        //----------panels
        mainPanel = new JPanel();
        blackPanel = new JPanel();
        redPanel = new JPanel();
        grayPanel1 = new JPanel();
        redtitlePanel = new JPanel();
        titlePanel1 = new JPanel();
        titlePanel2 = new JPanel();


        //----------labels
        addressLabel = new JLabel();
        ageLabel = new JLabel();
        bloodbankLabel = new JLabel();
        regdateLabel = new JLabel();
        didLabel = new JLabel();
        dobLabel = new JLabel();
        firstnameLabel = new JLabel();
        genderLabel = new JLabel();
        lastnameLabel = new JLabel();
        mobileLabel = new JLabel();
        nicLabel = new JLabel();
        bloodgroupLabel = new JLabel();
        rhfactorLabel = new JLabel();
        pinfoLabel = new JLabel();
        telhLabel = new JLabel();
        titleLabel = new JLabel();
        vLabel = new JLabel();
        yrsLabel = new JLabel();

        //-----------textfields
        addressText = new JTextField();
        ageText = new JTextField();
        regdateText = new JTextField();
        didText = new JTextField();
        firstnameText = new JTextField();
        lastnameText = new JTextField();
        mobileText = new JTextField();
        nicText = new JTextField();
        telhText = new JTextField();
        dobText = new JTextField();
        genderText = new JTextField();
        Text = new JTextField();
        bloodgroupText = new JTextField();
        rhfactorText = new JTextField();


        //----------buttons
        viewdonationsButton = new JButton();
        cancelButton = new JButton();

        //----------separators
        Separator1 = new JSeparator();
        Separator2 = new JSeparator();

        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(180, 180, 158), 8));

        //----------set panels
        mainPanel.setBackground(new Color(255, 255, 255));

        grayPanel1.setBackground(new Color(153, 153, 153));
        grayPanel1.setPreferredSize(new Dimension(700, 36));


        redPanel.setBackground(new Color(153, 0, 51));
        redPanel.setPreferredSize(new Dimension(120, 36));

        redtitlePanel.setBackground(new Color(153, 0, 51));
        redtitlePanel.setPreferredSize(new Dimension(20, 20));

        titlePanel1.setBackground(new Color(240, 240, 240));
        titlePanel1.setPreferredSize(new Dimension(690, 30));

        titlePanel2.setBackground(new Color(180, 180, 158));
        titlePanel2.setPreferredSize(new Dimension(690, 30));

        //-----------set main title	
        bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18));
        bloodbankLabel.setText("BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setText("View Specific Donor");


        //----------set labels ,comboboxes and textfields

        didLabel.setFont(new Font("Segoe UI", 0, 12));
        didLabel.setText("Donor Id   : ");

        didText.setEditable(false);
        didText.setFont(new Font("Arial", 0, 12));
        didText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        didText.setHorizontalAlignment(SwingConstants.CENTER);

        regdateLabel.setFont(new Font("Segoe UI", 0, 12));
        regdateLabel.setText("Register Date   : ");

        regdateText.setEditable(false);
        regdateText.setFont(new Font("Arial", 0, 12));
        regdateText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        regdateText.setHorizontalAlignment(SwingConstants.CENTER);

        pinfoLabel.setFont(new Font("Segoe UI", 1, 14));
        pinfoLabel.setForeground(new Color(255, 255, 255));
        pinfoLabel.setText("Personal Info");

        Text.setEditable(false);
        Text.setFont(new Font("Arial", 0, 12));
        Text.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        Text.setHorizontalAlignment(SwingConstants.CENTER);

        firstnameLabel.setFont(new Font("Segoe UI", 0, 12));
        firstnameLabel.setText("First Name : ");

        firstnameText.setEditable(false);
        firstnameText.setFont(new Font("Arial", 0, 12));
        firstnameText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        lastnameLabel.setFont(new Font("Segoe UI", 0, 12));
        lastnameLabel.setText("Last Name   : ");

        lastnameText.setEditable(false);
        lastnameText.setFont(new Font("Arial", 0, 12));
        lastnameText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        genderLabel.setFont(new Font("Segoe UI", 0, 12));
        genderLabel.setText("Gender      : ");

        genderText.setEditable(false);
        genderText.setFont(new Font("Arial", 0, 12));
        genderText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        nicLabel.setFont(new Font("Segoe UI", 0, 12));
        nicLabel.setText("NIC           :");

        nicText.setEditable(false);
        nicText.setFont(new Font("Arial", 0, 12));
        nicText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        vLabel.setFont(new Font("Segoe UI Light", 1, 12));
        vLabel.setText("V");

        telhLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        telhLabel.setText("Tel .(Home)  : ");

        telhText.setEditable(false);
        telhText.setFont(new Font("Arial", 0, 12));
        telhText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        mobileLabel.setFont(new Font("Segoe UI", 0, 12));
        mobileLabel.setText("Mobile      : ");

        mobileText.setEditable(false);
        mobileText.setFont(new Font("Arial", 0, 12));
        mobileText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        addressLabel.setFont(new Font("Segoe UI", 0, 12));
        addressLabel.setText("Address :");

        addressText.setEditable(false);
        addressText.setFont(new Font("Arial", 0, 12));
        addressText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        bloodgroupText.setEditable(false);
        bloodgroupText.setFont(new Font("Arial", 0, 12));
        bloodgroupText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        bloodgroupText.setHorizontalAlignment(SwingConstants.CENTER);

        bloodgroupLabel.setFont(new Font("Segoe UI", 0, 12));
        bloodgroupLabel.setText("Date of birth : ");

        dobLabel.setFont(new Font("Segoe UI", 0, 12));
        dobLabel.setText("Date of birth : ");

        dobText.setEditable(false);
        dobText.setFont(new Font("Arial", 0, 12));
        dobText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        rhfactorLabel.setFont(new Font("Segoe UI", 0, 12));
        rhfactorLabel.setText("Rh factor :");

        rhfactorText.setEditable(false);
        rhfactorText.setFont(new Font("Arial", 0, 12));
        rhfactorText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        rhfactorText.setHorizontalAlignment(SwingConstants.CENTER);

        ageLabel.setFont(new Font("Segoe UI", 0, 12));
        ageLabel.setText("Age            : ");

        ageText.setEditable(false);
        ageText.setFont(new Font("Arial", 0, 12));
        ageText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        yrsLabel.setFont(new Font("Segoe UI Light", 1, 12));
        yrsLabel.setText("Yrs.");



        //-----------buttons

        viewdonationsButton.setBackground(new Color(153, 153, 153));
        viewdonationsButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        viewdonationsButton.setText("View Donations");
        viewdonationsButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        cancelButton.setBackground(new Color(153, 153, 153));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        //Separators
        Separator1.setForeground(new Color(0, 0, 0));
        Separator2.setForeground(new Color(0, 0, 0));

        //-----------set panelLayouts

        //grayPanel1Layout
        grayPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        grayPanel1.add(redtitlePanel);
        grayPanel1.add(bloodbankLabel);

        //titlePanel1Layout
        GroupLayout titlePanel1Layout = new GroupLayout(titlePanel1);
        titlePanel1.setLayout(titlePanel1Layout);
        titlePanel1Layout.setHorizontalGroup(
                titlePanel1Layout.createParallelGroup()
                .addGroup(titlePanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        titlePanel1Layout.setVerticalGroup(
                titlePanel1Layout.createParallelGroup()
                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE));

        //titlePanel2Layout
        GroupLayout titlePanel2Layout = new GroupLayout(titlePanel2);
        titlePanel2.setLayout(titlePanel2Layout);
        titlePanel2Layout.setHorizontalGroup(
                titlePanel2Layout.createParallelGroup()
                .addGroup(titlePanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(pinfoLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        titlePanel2Layout.setVerticalGroup(
                titlePanel2Layout.createParallelGroup()
                .addComponent(pinfoLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE));


        //mainPanelLayout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(titlePanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ageText)
                .addGap(18, 18, 18)
                .addComponent(yrsLabel))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(dobLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dobText))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addComponent(genderLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(genderText)
                .addComponent(telhText)
                .addComponent(addressText)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(firstnameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(firstnameText, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(rhfactorLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rhfactorText, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(bloodgroupLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastnameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
                .addComponent(mobileLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(lastnameText, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                .addComponent(nicText))
                .addGap(3, 3, 3)
                .addComponent(vLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bloodgroupText, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addComponent(Separator1)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(100,100,100)
                .addComponent(Text, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(didLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(didText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(regdateLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regdateText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewdonationsButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)));

        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(redPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(didLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(regdateText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(didText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(regdateLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addComponent(Text, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(titlePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstnameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastnameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(firstnameLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(genderText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(genderLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(bloodgroupText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(lastnameLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(nicText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(vLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(mobileLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(dobText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(dobLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(rhfactorLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(rhfactorText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(yrsLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)))
                .addGap(25, 25, 25)
                .addComponent(Separator1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(viewdonationsButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)));
        add(mainPanel);
        pack();
    }

    private void setActionListeners() {

        //addActionListeners for buttons

        viewdonationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewDonationDetails(didText.getText()).setVisible(true);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
