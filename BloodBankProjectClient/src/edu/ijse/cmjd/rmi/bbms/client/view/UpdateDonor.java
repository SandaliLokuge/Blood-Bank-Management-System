package edu.ijse.cmjd.rmi.bbms.client.view;

import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import com.sun.nio.sctp.PeerAddressChangeNotification;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.model.Donor;
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

public class UpdateDonor extends JFrame {

    //----------panels
    private JPanel mainPanel;
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
    private JTextField bloodgroupText;
    private JTextField rhfactorText;
    private JTextField telhText;
    private JTextField dobText;
    private JTextField genderText;
    private JTextField Text;
    //----------buttons
    private JButton updateButton;
    private JButton cancelButton;
    //----------separators
    private JSeparator Separator1;
    private ViewDonors vd;
    private DonorController dc;

    public UpdateDonor(String donorid, final DonorController dc) {
        setComponents();
        setLocationRelativeTo(null);

        //load donor details

        try {
            String did = donorid;
            DonorController donorController = ServerConnector.getServerConnector().getDonorController();
            Donor donor = donorController.searchDonorByid(donorid);

            addressText.setText(donor.getAddress());
            ageText.setText(donor.getAge());
            regdateText.setText(donor.getRegdate());
            didText.setText(donor.getDonorid());
            firstnameText.setText(donor.getFirstname());
            lastnameText.setText(donor.getLastname());
            mobileText.setText(donor.getMobile());
            nicText.setText(donor.getNic());
            telhText.setText(donor.getTelhome());
            dobText.setText(donor.getDateofbirth());
            Text.setText(donor.getTitle());
            genderText.setText(donor.getGender());
            rhfactorText.setText(donor.getRhfactor());
            bloodgroupText.setText(donor.getBloodgroup());


        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //addActionListeners for buttons
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DonorController donorController = ServerConnector.getServerConnector().getDonorController();

                    boolean isupdated = donorController.updateDonor(new Donor(
                            didText.getText(),
                            Text.getText(),
                            firstnameText.getText(),
                            lastnameText.getText(),
                            regdateText.getText(),
                            genderText.getText(),
                            nicText.getText(),
                            telhText.getText(),
                            mobileText.getText(),
                            addressText.getText(),
                            dobText.getText(),
                            ageText.getText(),
                            bloodgroupText.getText(),
                            rhfactorText.getText()));
                    if (isupdated) {
                        JOptionPane.showMessageDialog(null, "Donor information is updated successfully");
                        dispose();

                        dc.releaseDonor(vd.did);
                        vd.did = "";

                    } else {
                        JOptionPane.showMessageDialog(null, "An error occured in updating");
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

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to quit?", null, 0, 3);
                if (res == 0) {
                    dispose();
                    try {
                        dc.releaseDonor(vd.did);
                        vd.did = "";
                    } catch (RemoteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());

                    }
                }
            }
        });
        firstnameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (firstnameText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });

        lastnameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (lastnameText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });

        nicText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (nicText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });

        telhText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (telhText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });
        mobileText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (mobileText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });

        addressText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (addressText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });
        dobText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (dobText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });

        ageText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (ageText.getText().equals("") == true) {
                    updateButton.setEnabled(false);
                }
            }
        });
        firstnameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        lastnameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        nicText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        telhText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        mobileText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        addressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        dobText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

            }
        });
        ageText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setEnabled(true);

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
        bloodgroupText = new JTextField();
        rhfactorText = new JTextField();
        telhText = new JTextField();
        dobText = new JTextField();
        genderText = new JTextField();
        Text = new JTextField();


        //----------buttons
        updateButton = new JButton();
        cancelButton = new JButton();

        //----------separators
        Separator1 = new JSeparator();


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
        titleLabel.setText("Update Donor");


        //----------set labels ,comboboxes and textfields

        didLabel.setFont(new Font("Segoe UI", 0, 12));
        didLabel.setText("Donor Id   : ");

        didText.setEditable(false);
        didText.setFont(new Font("Arial", 0, 12));
        didText.setHorizontalAlignment(SwingConstants.CENTER);

        regdateLabel.setFont(new Font("Segoe UI", 0, 12));
        regdateLabel.setText("Register Date   : ");

        regdateText.setEditable(false);
        regdateText.setFont(new Font("Arial", 0, 12));
        regdateText.setHorizontalAlignment(SwingConstants.CENTER);

        pinfoLabel.setFont(new Font("Segoe UI", 1, 14));
        pinfoLabel.setForeground(new Color(255, 255, 255));
        pinfoLabel.setText("Personal Info");

        Text.setFont(new Font("Segoe UI Light", 1, 12));
        Text.setHorizontalAlignment(SwingConstants.CENTER);
        Text.setEditable(false);


        firstnameLabel.setFont(new Font("Segoe UI", 0, 12));
        firstnameLabel.setText("First Name : ");

        firstnameText.setFont(new Font("Arial", 0, 12));

        lastnameLabel.setFont(new Font("Segoe UI", 0, 12));
        lastnameLabel.setText("Last Name   : ");

        lastnameText.setFont(new Font("Arial", 0, 12));

        genderLabel.setFont(new Font("Segoe UI", 0, 12));
        genderLabel.setText("Gender      : ");

        genderText.setFont(new Font("Arial", 0, 12));
        genderText.setEditable(false);

        dobText.setFont(new Font("Arial", 0, 12));

        nicLabel.setFont(new Font("Segoe UI", 0, 12));
        nicLabel.setText("NIC           :");

        nicText.setFont(new Font("Arial", 0, 12));

        vLabel.setFont(new Font("Segoe UI Light", 1, 12));
        vLabel.setText("V");

        telhLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        telhLabel.setText("Tel .(Home)  : ");

        telhText.setFont(new Font("Arial", 0, 12));

        mobileLabel.setFont(new Font("Segoe UI", 0, 12));
        mobileLabel.setText("Mobile      : ");

        mobileText.setFont(new Font("Arial", 0, 12));

        addressLabel.setFont(new Font("Segoe UI", 0, 12));
        addressLabel.setText("Address :");

        addressText.setFont(new Font("Arial", 0, 12));

        bloodgroupLabel.setFont(new Font("Segoe UI", 0, 12));
        bloodgroupLabel.setText("Blood group : ");

        bloodgroupText.setEditable(false);
        bloodgroupText.setFont(new Font("Arial", 0, 12));
        bloodgroupText.setHorizontalAlignment(SwingConstants.CENTER);

        dobLabel.setFont(new Font("Segoe UI", 0, 12));
        dobLabel.setText("Date of birth : ");

        dobText.setFont(new Font("Arial", 0, 12));

        rhfactorLabel.setFont(new Font("Segoe UI", 0, 12));
        rhfactorLabel.setText("Rh factor :");

        rhfactorText.setEditable(false);
        rhfactorText.setFont(new Font("Arial", 0, 12));
        rhfactorText.setHorizontalAlignment(SwingConstants.CENTER);

        ageLabel.setFont(new Font("Segoe UI", 0, 12));
        ageLabel.setText("Age            : ");

        ageText.setFont(new Font("Arial", 0, 12));

        yrsLabel.setFont(new Font("Segoe UI Light", 1, 12));
        yrsLabel.setText("Yrs.");



        //-----------buttons

        updateButton.setBackground(new Color(151, 185, 185));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        updateButton.setText("Update");
        updateButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        cancelButton.setBackground(new Color(153, 153, 153));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));


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
                .addGap(49, 49, 49)
                .addComponent(Text, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(didLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(didText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(regdateLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regdateText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
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
                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)));

        add(mainPanel);

        pack();
    }
}
