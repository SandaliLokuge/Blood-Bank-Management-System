package edu.ijse.cmjd.rmi.bbms.client.view;

import edu.ijse.cmjd.rmi.bbms.client.observer.impl.IssuebloodObserverImpl;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.controller.GuardianController;
import common.ijse.rmi.bloodbank.controller.IssuebloodController;
import common.ijse.rmi.bloodbank.controller.PatientController;
import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Guardian;
import common.ijse.rmi.bloodbank.model.Issueblood;
import common.ijse.rmi.bloodbank.model.Patient;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ViewIssuedBloodList extends JFrame {

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
    private JLabel bloodcompLabel;
    private JLabel closeLabel;
    //----------comboboxes
    private JComboBox bloodgroupCombo;
    private JComboBox bloodcompCombo;
    //----------tables
    private JTable issuedbloodTable;
    //----------buttons
    private JButton viewallButton;
    private JButton cancelButton;
    private JButton reloadButton;
    private IssuebloodObserver issuebloodObserver = null;
    private IssuebloodController issuebloodController = null;

    public ViewIssuedBloodList() {
        setComponents();
        setActionListeners();
        setActionListeners();
        setLocationRelativeTo(null);
        //add DonorObserver
        try {
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
        bloodgroupLabel = new JLabel();
        bloodcompLabel = new JLabel();
        closeLabel = new JLabel();

        //----------comboboxes
        bloodgroupCombo = new JComboBox();
        bloodcompCombo = new JComboBox();

        //----------buttons
        viewallButton = new JButton();
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

        redtitlePanel.setBackground(new Color(153, 0, 51));
        redtitlePanel.setPreferredSize(new Dimension(20, 20));

        titlePanel1.setBackground(new Color(219, 215, 215));
        titlePanel1.setPreferredSize(new Dimension(730, 30));

        titlePanel2.setBackground(new Color(180, 180, 158));
        titlePanel2.setPreferredSize(new Dimension(730, 60));


        greenPanel.setBackground(new Color(0, 102, 102));
        greenPanel.setPreferredSize(new Dimension(730, 60));

        //-----------set main title	
        bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18));
        bloodbankLabel.setText("BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("View Issued Blood Samples");


        //----------set labels and comboboxes		
        bloodgroupLabel.setFont(new Font("Arial", 1, 12));
        bloodgroupLabel.setText("Reqiured Blood Group :");
        bloodgroupLabel.setForeground(new Color(0, 102, 102));

        bloodcompLabel.setFont(new Font("Arial", 1, 12));
        bloodcompLabel.setText("Blood Component Type :");
        bloodcompLabel.setForeground(new Color(0, 102, 102));

        bloodgroupCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                JButton comboButton = new JButton(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/ComboIcon.png"));
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
        bloodgroupCombo.setPreferredSize(new Dimension(140, 23));

        bloodcompCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                JButton comboButton = new JButton(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/ComboIcon.png"));
                comboButton.setContentAreaFilled(false);
                comboButton.setFocusPainted(false);
                comboButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

                return comboButton;
            }
        });


        bloodcompCombo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setPreferredSize(new Dimension(30, 25));
                setOpaque(true);
                setBackground(new Color(240, 240, 240));
                super.paint(g);
            }
        });
        bloodcompCombo.setOpaque(false);

        bloodcompCombo.setFont(new Font("Arial", 1, 12));
        bloodcompCombo.setModel(new DefaultComboBoxModel(new String[]{"None", "Whole Blood", "Red cells", "Platelets", "Plasma", "Cryoprecipitated AHF"}));
        bloodcompCombo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        bloodcompCombo.setPreferredSize(new Dimension(52, 23));


        //-----------set close Icon
        closeLabel.setIcon(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/closeIcon.png"));
        closeLabel.setToolTipText("Close");

        //-----------buttons

        viewallButton.setBackground(new Color(255, 255, 255));
        viewallButton.setFont(new Font("Segoe UI", 1, 12));
        viewallButton.setText("View All");
        viewallButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        viewallButton.setPreferredSize(new Dimension(47, 19));

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
        issuedbloodTable = new JTable(model);
        JScrollPane tablepane = new JScrollPane(issuedbloodTable);
        tablepane.setPreferredSize(new Dimension(460, 450));
        issuedbloodTable.setRowHeight(30);


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
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE,190, GroupLayout.PREFERRED_SIZE)
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
                .addGap(52, 52, 52)
                .addComponent(bloodcompLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bloodcompCombo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bloodgroupCombo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(viewallButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)));
        titlePanel2Layout.setVerticalGroup(
                titlePanel2Layout.createParallelGroup()
                .addGroup(titlePanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(titlePanel2Layout.createParallelGroup()
                .addComponent(bloodcompLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodcompCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodgroupLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodgroupCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(viewallButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))));

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
                .addGap(20, 20, 20)
                .addComponent(tablepane, GroupLayout.PREFERRED_SIZE, 970, GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
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

    //addActionListeners for buttons
    private void setActionListeners() {

        viewallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadIssuedList();
            }
        });
        reloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadIssuedList();
            }
        });
        closeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    issuebloodController.removeIssuebloodObserver(issuebloodObserver);
                    dispose();
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    issuebloodController.removeIssuebloodObserver(issuebloodObserver);

                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });




    }

    private void loadIssuedList() {
        try {
            IssuebloodController issuebloodController = ServerConnector.getServerConnector().getIssuebloodController();
            java.util.List<Issueblood> allIssuedBloodSamples = null;
            DefaultTableModel dtm = null;
            Guardian guardian = null;
            Patient patient = null;
            GuardianController guardianController = null;
            PatientController patientController = null;
            if (bloodcompCombo.getSelectedItem().toString() == "None" && bloodgroupCombo.getSelectedItem().toString() == "None") {
                allIssuedBloodSamples = issuebloodController.getallIssueblood();
                dtm = (DefaultTableModel) issuedbloodTable.getModel();
                dtm.setRowCount(0);
                guardianController = ServerConnector.getServerConnector().getGuardianController();
                patientController = ServerConnector.getServerConnector().getPatientController();
                for (Issueblood issueblood : allIssuedBloodSamples) {
                    guardian = guardianController.searchGuardianByid(issueblood.getGuardianid());
                    patient = patientController.searchPatientByid(issueblood.getPatientid());
                    Object[] rowdata = {guardian.getNic() + " V", patient.getFirstname() + " " + patient.getLastname(), issueblood.getBloodbagid(), issueblood.getBloodgroup(), issueblood.getRhfactor(), issueblood.getBloodcomponent(), issueblood.getIssueddate(), issueblood.getQty(), guardian.getMobile()};
                    dtm.addRow(rowdata);
                }

            } else if (bloodcompCombo.getSelectedItem().toString() == "None" && bloodgroupCombo.getSelectedItem().toString() != "None") {
                allIssuedBloodSamples = issuebloodController.getIssuebloodbyBloodgroup(bloodgroupCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) issuedbloodTable.getModel();
                dtm.setRowCount(0);
                guardianController = ServerConnector.getServerConnector().getGuardianController();
                patientController = ServerConnector.getServerConnector().getPatientController();
                for (Issueblood issueblood : allIssuedBloodSamples) {
                    guardian = guardianController.searchGuardianByid(issueblood.getGuardianid());
                    patient = patientController.searchPatientByid(issueblood.getPatientid());
                    Object[] rowdata = {guardian.getNic() + " V", patient.getFirstname() + " " + patient.getLastname(), issueblood.getBloodbagid(), issueblood.getBloodgroup(), issueblood.getRhfactor(), issueblood.getBloodcomponent(), issueblood.getIssueddate(), issueblood.getQty(), guardian.getMobile()};
                    dtm.addRow(rowdata);
                }

            } else if (bloodcompCombo.getSelectedItem().toString() != "None" && bloodgroupCombo.getSelectedItem().toString() == "None") {
                allIssuedBloodSamples = issuebloodController.getIssuebloodbyBloodcomp(bloodcompCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) issuedbloodTable.getModel();
                dtm.setRowCount(0);
                guardianController = ServerConnector.getServerConnector().getGuardianController();
                patientController = ServerConnector.getServerConnector().getPatientController();
                for (Issueblood issueblood : allIssuedBloodSamples) {
                    guardian = guardianController.searchGuardianByid(issueblood.getGuardianid());
                    patient = patientController.searchPatientByid(issueblood.getPatientid());
                    Object[] rowdata = {guardian.getNic() + " V", patient.getFirstname() + " " + patient.getLastname(), issueblood.getBloodbagid(), issueblood.getBloodgroup(), issueblood.getRhfactor(), issueblood.getBloodcomponent(), issueblood.getIssueddate(), issueblood.getQty(), guardian.getMobile()};
                    dtm.addRow(rowdata);
                }

            } else {
                allIssuedBloodSamples = issuebloodController.getIssueblood(bloodgroupCombo.getSelectedItem().toString(), bloodcompCombo.getSelectedItem().toString());
                dtm = (DefaultTableModel) issuedbloodTable.getModel();
                dtm.setRowCount(0);
                guardianController = ServerConnector.getServerConnector().getGuardianController();
                patientController = ServerConnector.getServerConnector().getPatientController();
                for (Issueblood issueblood : allIssuedBloodSamples) {
                    guardian = guardianController.searchGuardianByid(issueblood.getGuardianid());
                    patient = patientController.searchPatientByid(issueblood.getPatientid());
                    Object[] rowdata = {guardian.getNic() + " V", patient.getFirstname() + " " + patient.getLastname(), issueblood.getBloodbagid(), issueblood.getBloodgroup(), issueblood.getRhfactor(), issueblood.getBloodcomponent(), issueblood.getIssueddate(), issueblood.getQty(), guardian.getMobile()};
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
        JOptionPane.showMessageDialog(this, message);
        reloadButton.doClick();
    }
    private String[] columnNames = {
        "Acceptor's NIC", "Patient name", "Blood Bag ID", "Required blood group", "RH Factor", "Blood Component", "Issued Date", "Qty", "Mobile"
    };

    public static void main(String args[]) {
        new ViewIssuedBloodList().setVisible(true);
    }
}
