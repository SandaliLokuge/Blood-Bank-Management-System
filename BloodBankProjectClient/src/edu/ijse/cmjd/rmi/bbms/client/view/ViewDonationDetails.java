package edu.ijse.cmjd.rmi.bbms.client.view;

import edu.ijse.cmjd.rmi.bbms.client.observer.impl.BloodSampleObserverImpl;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Donor;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

public class ViewDonationDetails extends JFrame {

    //----------panels
    private JPanel mainPanel;
    private JPanel blackPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redtitlePanel;
    private JPanel titlePanel1;
    private JPanel titlePanel2;
    //----------labels
    private JLabel bloodbankLabel;
    private JLabel titleLabel;
    private JLabel bloodgroupLabel;
    private JLabel rhfactorLabel;
    private JLabel donornameLabel;
    //----------textfields
    private JTextField bloodgroupText;
    private JTextField rhfactorText;
    private JTextField donornameText;
    //----------tables
    private JTable donationsTable;
    //----------buttons
    private JButton cancelButton;
    private JButton reloadButton;
    //----------separators
    private JSeparator Separator1;
    private String donorid;
    private BloodSampleController bloodSampleController;
    private BloodSampleObserver bloodSampleObserver;

    public ViewDonationDetails(String donorid) {
        try {
            this.donorid = donorid;
            setComponents();
            setActionListeners();
            setLocationRelativeTo(null);
            loadDonations();

            bloodSampleController = ServerConnector.getServerConnector().getBloodSampleController();
            bloodSampleObserver = new BloodSampleObserverImpl(this);
            bloodSampleController.addBloodSampleObserver(bloodSampleObserver);
            this.bloodSampleObserver = bloodSampleObserver;
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    //load donations

    private void loadDonations() {
        try {
            DonorController donorController = ServerConnector.getServerConnector().getDonorController();
            Donor donor = donorController.searchDonorByid(donorid);
            BloodSampleController bloodSampleController = ServerConnector.getServerConnector().getBloodSampleController();
            BloodSample bloodsample = bloodSampleController.searchBloodSample(donorid);
            bloodgroupText.setText(donor.getBloodgroup());
            rhfactorText.setText(donor.getRhfactor());
            donornameText.setText(donor.getFirstname() + " " + donor.getLastname());
            java.util.List<BloodSample> donations = bloodSampleController.getDonations(donorid);
            DefaultTableModel dtm = (DefaultTableModel) donationsTable.getModel();
            dtm.setRowCount(0);
            for (BloodSample bloodSample : donations) {
                Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonatedate(), bloodSample.getDonationtype(), bloodSample.getQty() + " ml", bloodSample.getBodytemp() + " F", bloodSample.getPulserate() + " bps", bloodSample.getBloodpressure() + " mmHg", bloodSample.getBodyweight() + " kg"};
                dtm.addRow(rowdata);
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

    private void setComponents() {
        //----------panels  
        mainPanel = new JPanel();
        redPanel = new JPanel();
        grayPanel1 = new JPanel();
        redtitlePanel = new JPanel();
        titlePanel1 = new JPanel();
        titlePanel2 = new JPanel();
        //----------labels
        bloodbankLabel = new JLabel();
        titleLabel = new JLabel();
        bloodgroupLabel = new JLabel();
        rhfactorLabel = new JLabel();
        donornameLabel = new JLabel();
        //----------textfields
        bloodgroupText = new JTextField();
        rhfactorText = new JTextField();
        donornameText = new JTextField();
        //----------buttons
        cancelButton = new JButton();
        reloadButton = new JButton();
        //----------separators
        Separator1 = new JSeparator();

        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(151, 185, 185), 8));

        //----------set panels
        mainPanel.setBackground(
                new Color(255, 255, 255));

        grayPanel1.setBackground(
                new Color(153, 153, 153));
        grayPanel1.setPreferredSize(
                new Dimension(700, 36));


        redPanel.setBackground(
                new Color(153, 0, 51));
        redPanel.setPreferredSize(
                new Dimension(120, 36));

        redtitlePanel.setBackground(
                new Color(153, 0, 51));
        redtitlePanel.setPreferredSize(
                new Dimension(20, 20));

        titlePanel1.setBackground(
                new Color(219, 215, 215));
        titlePanel1.setPreferredSize(
                new Dimension(690, 30));

        titlePanel2.setBackground(
                new Color(180, 180, 158));
        titlePanel2.setPreferredSize(
                new Dimension(690, 30));



        //-----------set main title	
        bloodbankLabel.setBackground(
                new Color(255, 255, 255));
        bloodbankLabel.setFont(
                new Font("Segoe UI", 1, 18));
        bloodbankLabel.setText(
                "BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(
                new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(
                new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setText(
                "Donations ");


        //----------set labels and textfields		
        bloodgroupLabel.setFont(
                new Font("Arial", 1, 12));
        bloodgroupLabel.setText(
                "Donor Blood Group :");

        rhfactorLabel.setFont(
                new Font("Arial", 1, 12));
        rhfactorLabel.setText(
                "RH Factor :");

        donornameLabel.setFont(
                new Font("Arial", 1, 12));
        donornameLabel.setText(
                "Donor Name :");

        bloodgroupText.setEditable(
                false);
        bloodgroupText.setFont(
                new Font("Arial", 0, 13));
        bloodgroupText.setHorizontalAlignment(SwingConstants.CENTER);

        rhfactorText.setEditable(
                false);
        rhfactorText.setFont(
                new Font("Arial", 0, 13));
        rhfactorText.setHorizontalAlignment(SwingConstants.CENTER);

        donornameText.setEditable(
                false);
        donornameText.setFont(
                new Font("Arial", 0, 13));
        donornameText.setHorizontalAlignment(SwingConstants.CENTER);

        //-----------buttons
        cancelButton.setBackground(
                new Color(204, 204, 204));
        cancelButton.setFont(
                new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText(
                "Close");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        reloadButton.setBackground(
                new Color(204, 204, 204));
        reloadButton.setFont(
                new java.awt.Font("Segoe UI", 1, 12));
        reloadButton.setText(
                "Reload");
        reloadButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        //Separator
        Separator1.setForeground(
                new Color(0, 0, 0));


        //----------Table
        DefaultTableModel model = new DefaultTableModel(columnNames, 10);
        donationsTable = new JTable(model);
        JScrollPane tablepane = new JScrollPane(donationsTable);

        tablepane.setPreferredSize(
                new Dimension(460, 450));
        donationsTable.setRowHeight(
                30);


        //-----------set panelLayouts

        //grayPanel1Layout
        grayPanel1.setLayout(
                new FlowLayout(FlowLayout.RIGHT));
        grayPanel1.add(redtitlePanel);

        grayPanel1.add(bloodbankLabel);

        //-----------set panelLayouts
        //grayPanel1Layout
        grayPanel1.setLayout(
                new FlowLayout(FlowLayout.RIGHT));
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
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(donornameLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(donornameText)
                .addGap(30, 30, 30)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(bloodgroupText, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(rhfactorLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(rhfactorText, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
                .addComponent(Separator1)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 870, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(reloadButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)));
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(redPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(titlePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(rhfactorLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodgroupText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(donornameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(donornameLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(rhfactorText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(titlePanel2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Separator1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(reloadButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)));

        add(mainPanel);
        pack();
    }

    private void setActionListeners() {

        //addActionListeners for buttons
        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
        reloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDonations();
            }
        });
    }
    private String[] columnNames = {
        "Blood Bag", "Donation date", "Donation Type", "Volume", "Body temp", "Pulse rate", "Blood pressure", "Body weight"
    };

    public void setMessage(String message) {
        String m = message;
        StringTokenizer st = new StringTokenizer(m, "-");
        String ar[] = new String[st.countTokens()];
        ar[0] = st.nextToken();
        ar[1] = st.nextToken();
        if (ar[1].equals(donorid)) {
            JOptionPane.showMessageDialog(null, "New blood sample of " + donorid + " is added");
            reloadButton.doClick();
        }



    }
}
