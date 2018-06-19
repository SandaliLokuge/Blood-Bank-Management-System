package edu.ijse.cmjd.rmi.bbms.client.view;

import edu.ijse.cmjd.rmi.bbms.client.observer.impl.BloodSampleObserverImpl;
import edu.ijse.cmjd.rmi.bbms.client.observer.impl.DonorObserverImpl;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Donor;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import common.ijse.rmi.bloodbank.observer.DonorObserver;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ViewDonors extends JFrame {

    //----------panels
    private JPanel mainPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redtitlePanel;
    private JPanel titlePanel1;
    private JPanel titlePanel2;
    private JPanel greenPanel;
    //----------labels
    private JLabel bloodbankLabel;
    private JLabel titleLabel;
    private JLabel bloodgroupLabel;
    private JLabel donoridLabel;
    private JLabel closeLabel;
    //----------textfields
    private JTextField donoridText;
    //----------comboboxes
    private JComboBox bloodgroupCombo;
    //----------tables
    private JTable donorTable;
    //----------buttons
    private JButton updateButton;
    private JButton viewButton;
    private JButton viewallButton;
    private JButton cancelButton;
    private JButton reloadButton;
    //----------separators
    private JSeparator Separator1;
    private DonorObserver donorObserver = null;
    private BloodSampleObserver bloodSampleObserver = null;
    public static String did = "";
    private DonorController donorController;
    private BloodSampleController bloodSampleController;
    private DonorController dC;

    public ViewDonors() {
        setComponents();
        setLocationRelativeTo(null);

        //add DonorObserver and bloodsampleobserver
        try {
            donorObserver = new DonorObserverImpl(this);
            donorController = ServerConnector.getServerConnector().getDonorController();
            donorController.addDonorObserver(donorObserver);
            this.donorObserver = donorObserver;

            bloodSampleObserver = new BloodSampleObserverImpl(this);
            bloodSampleController = ServerConnector.getServerConnector().getBloodSampleController();
            bloodSampleController.addBloodSampleObserver(bloodSampleObserver);
            this.bloodSampleObserver = bloodSampleObserver;

        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //addMouseListener to donorTable 
        donorTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (donorTable.getSelectedRowCount() == 1) {
                    donoridText.setText(donorTable.getValueAt(donorTable.getSelectedRow(), 0).toString());
                }
            }
        });

        final ViewDonors vd = this;
        //addActionListeners for buttons
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    bloodSampleController.removeBloodSampleObserver(bloodSampleObserver);
                    donorController.removeDonorObserver(donorObserver);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        try {
            dC = ServerConnector.getServerConnector().getDonorController();
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String did = donoridText.getText();
                    if (!vd.did.equals(did)) {
                        dC.releaseDonor(vd.did);
                        vd.did = did;
                    }
                    if (dC.reserveDonor(did)) {
                        new UpdateDonor(donoridText.getText(), dC).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(vd, "Donor is being updated now");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String did = donoridText.getText();
                if (!vd.did.equals(did)) {
                    new ViewSpecificDonorDetails(donoridText.getText()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(vd, "Donor is being updated now");
                }


            }
        });

        viewallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDonorList();
            }
        });

        reloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDonorList();
            }
        });

        closeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    dispose();
                    bloodSampleController.removeBloodSampleObserver(bloodSampleObserver);
                    donorController.removeDonorObserver(donorObserver);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

    }

    private void setComponents() {
        //----------panels
        mainPanel = new JPanel();
        redPanel = new JPanel();
        grayPanel1 = new JPanel();
        redtitlePanel = new JPanel();
        titlePanel1 = new JPanel();
        titlePanel2 = new JPanel();
        greenPanel = new JPanel();

        //----------labels

        bloodbankLabel = new JLabel();
        titleLabel = new JLabel();
        bloodgroupLabel = new JLabel();
        donoridLabel = new JLabel();
        closeLabel = new JLabel();

        //----------textfields
        donoridText = new JTextField(18);

        //----------comboboxes
        bloodgroupCombo = new JComboBox();

        //----------buttons
        updateButton = new JButton();
        viewButton = new JButton();
        viewallButton = new JButton();
        cancelButton = new JButton();
        reloadButton = new JButton();

        //----------separators
        Separator1 = new JSeparator();


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

        titlePanel1.setBackground(new Color(219, 215, 215));
        titlePanel1.setPreferredSize(new Dimension(730, 30));

        titlePanel2.setBackground(new Color(0, 102, 102));
        titlePanel2.setPreferredSize(new Dimension(730, 60));


        greenPanel.setBackground(new Color(180, 180, 158));
        greenPanel.setPreferredSize(new Dimension(730, 60));

        //-----------set main title	
        bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18));
        bloodbankLabel.setText("BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("View Donors");



        //----------set labels,textfields and comboboxes		
        bloodgroupLabel.setFont(new Font("Arial", 1, 12));
        bloodgroupLabel.setText("Reqiured Blood Group :");

        bloodgroupCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                JButton comboButton = new JButton(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/ComboIcon.png"));
                comboButton.setBackground(new Color(240, 240, 240));
                comboButton.setContentAreaFilled(false);
                comboButton.setFocusPainted(false);
                comboButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

                return comboButton;
            }
        });

        bloodgroupCombo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setPreferredSize(new Dimension(30, 25));
                setOpaque(true);
                setBackground(new Color(240, 240, 240));
                super.paint(g);
            }
        });


        bloodgroupCombo.setOpaque(false);

        bloodgroupCombo.setFont(new Font("Arial", 1, 12));
        bloodgroupCombo.setModel(new DefaultComboBoxModel(new String[]{"None", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        bloodgroupCombo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        donoridLabel.setFont(new Font("Arial", 1, 12));
        donoridLabel.setText("Donor ID :");

        donoridText.setEditable(false);
        donoridText.setFont(new Font("Arial", 0, 13));
        donoridText.setForeground(new Color(0, 0, 0));
        donoridText.setPreferredSize(new Dimension(6, 20));
        donoridText.setHorizontalAlignment(SwingConstants.CENTER);

        //-----------set close Icon
        closeLabel.setIcon(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/closeIcon.png"));
        closeLabel.setToolTipText("Close");

        //-----------buttons
        viewButton.setBackground(new Color(255, 255, 255));
        viewButton.setFont(new Font("Segoe UI", 1, 12));
        viewButton.setText("View");
        viewButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        viewallButton.setBackground(new Color(255, 255, 255));
        viewallButton.setFont(new Font("Segoe UI", 1, 12));
        viewallButton.setText("View All");
        viewallButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        viewallButton.setPreferredSize(new Dimension(47, 19));

        reloadButton.setBackground(new Color(204, 204, 204));
        reloadButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        reloadButton.setText("Reload");
        reloadButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));

        updateButton.setBackground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Segoe UI", 1, 12));
        updateButton.setText("Update");
        updateButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        cancelButton.setBackground(new Color(204, 204, 204));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        //Separators
        Separator1.setForeground(new Color(0, 0, 0));


        //----------Table
        DefaultTableModel model = new DefaultTableModel(columnNames, 10);
        donorTable = new JTable(model);
        JScrollPane tablepane = new JScrollPane(donorTable);
        tablepane.setPreferredSize(new Dimension(460, 402));
        donorTable.setRowHeight(30);



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
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)));
        titlePanel1Layout.setVerticalGroup(
                titlePanel1Layout.createParallelGroup()
                .addGroup(titlePanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)));




        //greenPanel2Layout
        GroupLayout greenPanelLayout = new GroupLayout(greenPanel);
        greenPanel.setLayout(greenPanelLayout);
        greenPanelLayout.setHorizontalGroup(
                greenPanelLayout.createParallelGroup()
                .addGroup(greenPanelLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(donoridLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(donoridText, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)));
        greenPanelLayout.setVerticalGroup(
                greenPanelLayout.createParallelGroup()
                .addGroup(greenPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(greenPanelLayout.createParallelGroup()
                .addComponent(donoridLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(donoridText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))));

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
                .addComponent(greenPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bloodgroupCombo, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(viewallButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(reloadButton, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 914, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE)));

        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(redPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(titlePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(viewallButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(bloodgroupCombo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(titlePanel2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(reloadButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)));

        add(mainPanel);
        pack();

    }

    private void loadDonorList() {
        try {
            DonorController donorController = ServerConnector.getServerConnector().getDonorController();
            java.util.List<Donor> donors = null;
            DefaultTableModel dtm = null;
            if (bloodgroupCombo.getSelectedItem().toString() != "None") {
                donors = donorController.getallDonorsbybloodgroup(bloodgroupCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) donorTable.getModel();
                dtm.setRowCount(0);
                for (Donor donor : donors) {
                    Object[] rowdata = {donor.getDonorid(), donor.getTitle(), donor.getFirstname() + " " + donor.getLastname(), donor.getNic() + " V", donor.getGender(), donor.getBloodgroup(), donor.getRhfactor(), donor.getMobile(), donor.getRegdate()};
                    dtm.addRow(rowdata);
                }
            } else {
                donors = donorController.getallDonors();
                dtm = (DefaultTableModel) donorTable.getModel();
                dtm.setRowCount(0);
                for (Donor donor : donors) {
                    Object[] rowdata = {donor.getDonorid(), donor.getTitle(), donor.getFirstname() + " " + donor.getLastname(), donor.getNic() + " V", donor.getGender(), donor.getBloodgroup(), donor.getRhfactor(), donor.getMobile(), donor.getRegdate()};
                    dtm.addRow(rowdata);
                }
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NotBoundException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    //-----------setMessage

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
        reloadButton.doClick();
    }
    private String[] columnNames = {
        "Donor ID", " Title", "Name", "NIC", "Gender", "Blood Group", "RH Factor", "Mobile", "Reg.Date"
    };

    public static void main(String args[]) {
        new ViewDonors().setVisible(true);
    }
}
