package edu.ijse.cmjd.rmi.bbms.client.view;

import edu.ijse.cmjd.rmi.bbms.client.observer.impl.BloodSampleObserverImpl;
import edu.ijse.cmjd.rmi.bbms.client.observer.impl.IssuebloodObserverImpl;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.IssuebloodController;
import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Issueblood;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import common.ijse.rmi.bloodbank.observer.IssuebloodObserver;
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
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.*;

public class IssueBloodSample extends JFrame {

    //----------panels
    private JPanel mainPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redTitlePanel;
    private JPanel titlePanel1;
    private JPanel titlePanel2;
    private JPanel greenPanel;
    //----------labels
    private JLabel bloodBankLabel;
    private JLabel titleLabel;
    private JLabel bloodGroupLabel;
    private JLabel bloodCompLabel;
    private JLabel closeLabel;
    //----------comboboxes
    private JComboBox bloodGroupCombo;
    private JComboBox bloodCompCombo;
    //----------tables
    private JTable bloodSampleTable;
    //----------buttons
    private JButton searchButton;
    private JButton cancelButton;
    private JButton reloadButton;
    private BloodSampleObserver bloodSampleObserver;
    private BloodSampleController bloodSampleController;
    private IssuebloodObserver issuebloodObserver;
    private IssuebloodController issuebloodController;
    private BloodSampleController bsc;
    public static String bid = "";

    public IssueBloodSample() {

        setComponents();
        setLocationRelativeTo(null);

        //add BloodSampleObserver


        try {
            bloodSampleObserver = new BloodSampleObserverImpl(this);
            bloodSampleController = ServerConnector.getServerConnector().getBloodSampleController();
            bloodSampleController.addBloodSampleObserver(bloodSampleObserver);
            this.bloodSampleObserver = bloodSampleObserver;

            issuebloodObserver = new IssuebloodObserverImpl(this);
            issuebloodController = ServerConnector.getServerConnector().getIssuebloodController();
            issuebloodController.addIssuebloodObserver(issuebloodObserver);
            this.issuebloodObserver = issuebloodObserver;
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        final IssueBloodSample bs = this;

        //addActionListeners for buttons


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    bloodSampleController.removeBloodSampleObserver(bloodSampleObserver);
                    issuebloodController.removeIssuebloodObserver(issuebloodObserver);
                    dispose();
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadBloodsampleList();
            }
        });

        reloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadBloodsampleList();
            }
        });

        closeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to issue this blood sample?", null, 0, 3);
                if (res == 0) {
                    try {
                        bloodSampleController.removeBloodSampleObserver(bloodSampleObserver);
                        issuebloodController.removeIssuebloodObserver(issuebloodObserver);
                        dispose();
                    } catch (RemoteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });

        DefaultTableModel dtm = (DefaultTableModel) bloodSampleTable.getModel();
        bloodSampleTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (bloodSampleTable.getSelectedRowCount() == 1) {
                    int res = JOptionPane.showConfirmDialog(null, "Do you want to issue this blood ?", null, 0, 3);
                    if (res == 0) {
                        try {
                            String bid = bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 0).toString();
                            bsc = ServerConnector.getServerConnector().getBloodSampleController();
                            if (!bs.bid.equals(bid)) {
                                bsc.releaseBloodSample(bs.bid);
                                bs.bid = bid;
                            }
                            if (bsc.reserveBloodSample(bid)) {
                                new AddPatientDetails(
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 0).toString(),
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 1).toString(),
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 2).toString(),
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 3).toString(),
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 4).toString(),
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 5).toString(),
                                        bloodSampleTable.getValueAt(bloodSampleTable.getSelectedRow(), 6).toString(),
                                        bsc).setVisible(true);
                                bloodSampleController.removeBloodSampleObserver(bloodSampleObserver);
                                issuebloodController.removeIssuebloodObserver(issuebloodObserver);
                                dispose();

                            } else {
                                JOptionPane.showMessageDialog(bs, "Blood sample is being issued now");
                            }
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        } catch (NotBoundException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        } catch (MalformedURLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
            }
        });
    }

    private void setComponents() {
        //----------panels
        mainPanel = new JPanel();
        redPanel = new JPanel();
        grayPanel1 = new JPanel();
        redTitlePanel = new JPanel();
        titlePanel1 = new JPanel();
        titlePanel2 = new JPanel();
        greenPanel = new JPanel();

        //----------labels

        bloodBankLabel = new JLabel();
        titleLabel = new JLabel();
        bloodGroupLabel = new JLabel();
        bloodGroupLabel = new JLabel();
        bloodCompLabel = new JLabel();
        closeLabel = new JLabel();

        //----------comboboxes
        bloodGroupCombo = new JComboBox();
        bloodCompCombo = new JComboBox();

        //----------buttons
        searchButton = new JButton();
        cancelButton = new JButton();
        reloadButton = new JButton();

        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(219, 215, 215), 8));

        //----------set panels
        mainPanel.setBackground(new Color(255, 255, 255));

        grayPanel1.setBackground(new Color(153, 153, 153));
        grayPanel1.setPreferredSize(new Dimension(700, 36));


        redPanel.setBackground(new Color(153, 0, 51));
        redPanel.setPreferredSize(new Dimension(230, 36));


        redTitlePanel.setBackground(new Color(153, 0, 51));
        redTitlePanel.setPreferredSize(new Dimension(20, 20));

        titlePanel1.setBackground(new Color(219, 215, 215));
        titlePanel1.setPreferredSize(new Dimension(730, 30));

        titlePanel2.setBackground(new Color(180, 180, 158));
        titlePanel2.setPreferredSize(new Dimension(730, 60));


        greenPanel.setBackground(new Color(0, 102, 102));
        greenPanel.setPreferredSize(new Dimension(730, 60));


        //-----------set main title	
        bloodBankLabel.setBackground(new Color(255, 255, 255));
        bloodBankLabel.setFont(new Font("Segoe UI", 1, 18));
        bloodBankLabel.setText("BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Issue Blood Sample");

        //----------set labels and comboboxes		
        bloodGroupLabel.setFont(new Font("Arial", 1, 12));
        bloodGroupLabel.setText("Reqiured Blood Group :");
        bloodGroupLabel.setForeground(new Color(0, 102, 102));

        bloodCompLabel.setFont(new Font("Arial", 1, 12));
        bloodCompLabel.setText("Blood Component Type :");
        bloodCompLabel.setForeground(new Color(0, 102, 102));

        bloodGroupCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                JButton comboButton = new JButton(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/ComboIcon.png"));
                comboButton.setContentAreaFilled(false);
                comboButton.setFocusPainted(false);
                comboButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

                return comboButton;
            }
        });

        bloodGroupCombo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setPreferredSize(new Dimension(30, 25));
                setOpaque(true);
                setBackground(new Color(240, 240, 240));
                super.paint(g);
            }
        });
        bloodGroupCombo.setOpaque(false);

        bloodGroupCombo.setFont(new Font("Arial", 1, 12));
        bloodGroupCombo.setModel(new DefaultComboBoxModel(new String[]{"None", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        bloodGroupCombo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        bloodGroupCombo.setPreferredSize(new Dimension(140, 23));

        bloodCompCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                JButton comboButton = new JButton(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/ComboIcon.png"));
                comboButton.setContentAreaFilled(false);
                comboButton.setFocusPainted(false);
                comboButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

                return comboButton;
            }
        });


        bloodCompCombo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setPreferredSize(new Dimension(30, 25));
                setOpaque(true);
                setBackground(new Color(240, 240, 240));
                super.paint(g);
            }
        });
        bloodCompCombo.setOpaque(false);

        bloodCompCombo.setFont(new Font("Arial", 1, 12));
        bloodCompCombo.setModel(new DefaultComboBoxModel(new String[]{"None", "Whole Blood", "Red cells", "Platelets", "Plasma", "Cryoprecipitated AHF"}));
        bloodCompCombo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        bloodCompCombo.setPreferredSize(new Dimension(52, 23));

        //-----------set close Icon
        closeLabel.setIcon(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/closeIcon.png"));
        closeLabel.setToolTipText("Close");


        //-----------buttons

        searchButton.setBackground(new Color(255, 255, 255));
        searchButton.setFont(new Font("Segoe UI", 1, 12));
        searchButton.setText("Search");
        searchButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        searchButton.setPreferredSize(new Dimension(47, 19));

        cancelButton.setBackground(new Color(204, 204, 204));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        reloadButton.setBackground(new Color(204, 204, 204));
        reloadButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        reloadButton.setText("Reload");
        reloadButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        //----------Table
        DefaultTableModel model = new DefaultTableModel(columnNames, 10);
        bloodSampleTable = new JTable(model);
        JScrollPane tablepane = new JScrollPane(bloodSampleTable);
        tablepane.setPreferredSize(new Dimension(460, 450));
        bloodSampleTable.setRowHeight(30);

        //-----------set panelLayouts

        //grayPanel1Layout
        grayPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        grayPanel1.add(redTitlePanel);
        grayPanel1.add(bloodBankLabel);

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

        //titlePanel2Layout

        GroupLayout titlePanel2Layout = new GroupLayout(titlePanel2);
        titlePanel2.setLayout(titlePanel2Layout);
        titlePanel2Layout.setHorizontalGroup(
                titlePanel2Layout.createParallelGroup()
                .addGroup(titlePanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(bloodCompLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bloodCompCombo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bloodGroupLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bloodGroupCombo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)));
        titlePanel2Layout.setVerticalGroup(
                titlePanel2Layout.createParallelGroup()
                .addGroup(titlePanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(titlePanel2Layout.createParallelGroup()
                .addComponent(bloodCompLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodCompCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodGroupLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodGroupCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))));

        //mainPanelLayout

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(titlePanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(reloadButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
                .addComponent(greenPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(redPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(titlePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(titlePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(reloadButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE)));
        add(mainPanel);
        pack();
    }

    public void setMessage(String message) {
        StringTokenizer st = new StringTokenizer(message, "-");
        String m = st.nextToken();
        JOptionPane.showMessageDialog(null, m);
        reloadButton.doClick();
    }
    private String[] columnNames = {
        "Blood Bag ID", "Donor ID", "Blood Group", "RH Factor", "Volume/Qty", "Blood Component", "Donate Date"
    };

    private void loadBloodsampleList() {
        try {
            BloodSampleController bloodSampleController = ServerConnector.getServerConnector().getBloodSampleController();
            IssuebloodController issuebloodController = ServerConnector.getServerConnector().getIssuebloodController();
            java.util.List<BloodSample> allBloodSamples = null;
            java.util.List<Issueblood> allIssueblood = null;
            DefaultTableModel dtm = null;
            if (bloodCompCombo.getSelectedItem().toString() == "None" && bloodGroupCombo.getSelectedItem().toString() == "None") {
                allBloodSamples = bloodSampleController.getallBloodSamples();
                allIssueblood = issuebloodController.getallIssueblood();
                dtm = (DefaultTableModel) bloodSampleTable.getModel();
                dtm.setRowCount(0);
                int i = 0;
                if (allIssueblood != null) {
                    String id[] = new String[allIssueblood.size()];
                    for (Issueblood issueblood : allIssueblood) {
                        id[i] = issueblood.getBloodbagid();
                        i++;
                    }

                    boolean isExists;
                    for (BloodSample bloodSample : allBloodSamples) {
                        isExists = false;
                        for (int n = 0; n < allIssueblood.size(); n++) {
                            if (bloodSample.getBloodbagid().equals(id[n])) {
                                isExists = true;
                                break;
                            }
                        }
                        if (!isExists) {
                            Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                            dtm.addRow(rowdata);
                        }
                    }
                } else {
                    for (BloodSample bloodSample : allBloodSamples) {
                        Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                        dtm.addRow(rowdata);
                    }
                }

            } else if (bloodCompCombo.getSelectedItem().toString() == "None" && bloodGroupCombo.getSelectedItem().toString() != "None") {
                allBloodSamples = bloodSampleController.getBloodSamplesbyBloodgroup(bloodGroupCombo.getSelectedItem().toString());
                allIssueblood = issuebloodController.getIssuebloodbyBloodgroup(bloodGroupCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) bloodSampleTable.getModel();
                dtm.setRowCount(0);
                int i = 0;
                if (allIssueblood != null) {
                    String id[] = new String[allIssueblood.size()];
                    for (Issueblood issueblood : allIssueblood) {
                        id[i] = issueblood.getBloodbagid();
                        i++;
                    }

                    boolean isExists;
                    for (BloodSample bloodSample : allBloodSamples) {
                        isExists = false;
                        for (int n = 0; n < allIssueblood.size(); n++) {
                            if (bloodSample.getBloodbagid().equals(id[n])) {
                                isExists = true;
                                break;
                            }
                        }
                        if (!isExists) {
                            Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                            dtm.addRow(rowdata);
                        }
                    }
                } else {
                    for (BloodSample bloodSample : allBloodSamples) {
                        Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                        dtm.addRow(rowdata);
                    }
                }

            } else if (bloodCompCombo.getSelectedItem().toString() != "None" && bloodGroupCombo.getSelectedItem().toString() == "None") {
                allBloodSamples = bloodSampleController.getBloodSamplesbyBloodcomp(bloodCompCombo.getSelectedItem().toString());
                allIssueblood = issuebloodController.getIssuebloodbyBloodcomp(bloodCompCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) bloodSampleTable.getModel();
                dtm.setRowCount(0);
                int i = 0;
                if (allIssueblood != null) {
                    String id[] = new String[allIssueblood.size()];
                    for (Issueblood issueblood : allIssueblood) {
                        id[i] = issueblood.getBloodbagid();
                        i++;
                    }

                    boolean isExists;
                    for (BloodSample bloodSample : allBloodSamples) {
                        isExists = false;
                        for (int n = 0; n < allIssueblood.size(); n++) {
                            if (bloodSample.getBloodbagid().equals(id[n])) {
                                isExists = true;
                                break;
                            }
                        }
                        if (!isExists) {
                            Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                            dtm.addRow(rowdata);
                        }
                    }
                } else {
                    for (BloodSample bloodSample : allBloodSamples) {
                        Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                        dtm.addRow(rowdata);
                    }
                }

            } else {
                allBloodSamples = bloodSampleController.getBloodSamples(bloodGroupCombo.getSelectedItem().toString(), bloodCompCombo.getSelectedItem().toString());
                allIssueblood = issuebloodController.getIssueblood(bloodGroupCombo.getSelectedItem().toString(), bloodCompCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) bloodSampleTable.getModel();
                dtm.setRowCount(0);
                int i = 0;
                if (allIssueblood != null) {
                    String id[] = new String[allIssueblood.size()];
                    for (Issueblood issueblood : allIssueblood) {
                        id[i] = issueblood.getBloodbagid();
                        i++;
                    }

                    boolean isExists;
                    for (BloodSample bloodSample : allBloodSamples) {
                        isExists = false;
                        for (int n = 0; n < allIssueblood.size(); n++) {
                            if (bloodSample.getBloodbagid().equals(id[n])) {
                                isExists = true;
                                break;
                            }
                        }
                        if (!isExists) {
                            Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                            dtm.addRow(rowdata);
                        }
                    }
                } else {
                    for (BloodSample bloodSample : allBloodSamples) {
                        Object[] rowdata = {bloodSample.getBloodbagid(), bloodSample.getDonorid(), bloodSample.getBloodgroup(), bloodSample.getRhfactor(), bloodSample.getQty() + " ml", bloodSample.getDonationtype(), bloodSample.getDonatedate()};
                        dtm.addRow(rowdata);
                    }
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

    public static void main(String args[]) {
        new IssueBloodSample().setVisible(true);
    }
}
