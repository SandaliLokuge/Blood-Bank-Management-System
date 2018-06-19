package edu.ijse.cmjd.rmi.bbms.client.view;

import AppPackage.AnimationClass;
import edu.ijse.cmjd.rmi.bbms.client.idgenerator.IdGenerator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.model.Donor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import edu.ijse.cmjd.rmi.bbms.client.validation.Validation;
import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class AddDonorDetails extends JFrame {

    //----------panels
    private JPanel mainPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redTitlePanel;
    private JPanel titlePanel1;
    private JPanel titlePanel2;
    private JPanel greenPanel;
    //----------labels
    private JLabel addressLabel;
    private JLabel ageLabel;
    private JLabel bloodBankLabel;
    private JLabel regDateLabel;
    private JLabel didLabel;
    private JLabel dobLabel;
    private JLabel firstNameLabel;
    private JLabel genderLabel;
    private JLabel lastNameLabel;
    private JLabel mobileLabel;
    private JLabel nicLabel;
    private JLabel rhLabel;
    private JLabel bloodGroupLabel;
    private JLabel pinfoLabel;
    private JLabel telhLabel;
    private JLabel titleLabel;
    private JLabel vLabel;
    private JLabel yrsLabel;
    private JLabel closeLabel;
    private JLabel notificationLabel;
    //----------textfields
    private JTextField addressText;
    private JTextField ageText;
    private JTextField regDateText;
    private JTextField didText;
    private JTextField firstNameText;
    private JTextField lastNameText;
    private JTextField mobileText;
    private JTextField nicText;
    private JTextField telhText;
    private JTextField yearText;
    //----------comboboxes
    private JComboBox Combobox;
    private JComboBox daysCombo;
    private JComboBox genderCombo;
    private JComboBox monthCombo;
    private JComboBox bloodGroupCombo;
    private JComboBox rhFactorCombo;
    //----------buttons
    private JButton clearButton;
    private JButton nextButton;
    private JButton cancelButton;
    Validation validation = new Validation();
    boolean isValidated = false;
    AnimationClass ac = new AnimationClass();

    public AddDonorDetails() {
        try {
            setComponents();
            setLocationRelativeTo(null);
            setregDate();
            setActions();
            IdGenerator idGenerator = new IdGenerator();
            didText.setText(idGenerator.createDonorId());
            nextButton.setEnabled(false);
            Combobox.requestFocus();
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

    private void setActions() {

        firstNameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (firstNameText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);

                }
            }
        });
        lastNameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (lastNameText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });
        nicText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (nicText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });
        telhText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (telhText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });
        mobileText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (mobileText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });
        addressText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (addressText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });
        yearText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (yearText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });
        ageText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (ageText.getText().equals("") == true) {
                    nextButton.setEnabled(false);
                    ac.jLabelXRight(500, 900, 5, 2, notificationLabel);
                }
            }
        });




        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addressText.setText("");
                ageText.setText("");
                firstNameText.setText("");
                lastNameText.setText("");
                mobileText.setText("");
                nicText.setText("");
                telhText.setText("");
                yearText.setText("");
                nextButton.setEnabled(false);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int res1 = JOptionPane.showConfirmDialog(null, "Are details correct?", null, 0, 3);
                    if (res1 == 0) {
                        DonorController donorController = ServerConnector.getServerConnector().getDonorController();
                        String dateofbirth = yearText.getText() + "/" + monthCombo.getSelectedItem().toString() + "/" + daysCombo.getSelectedItem().toString();
                        boolean res = donorController.addDonor(new Donor(
                                didText.getText(),
                                Combobox.getSelectedItem().toString(),
                                firstNameText.getText(),
                                lastNameText.getText(),
                                regDateText.getText(),
                                genderCombo.getSelectedItem().toString(),
                                nicText.getText(),
                                telhText.getText(),
                                mobileText.getText(),
                                addressText.getText(),
                                dateofbirth,
                                ageText.getText(),
                                bloodGroupCombo.getSelectedItem().toString(),
                                rhFactorCombo.getSelectedItem().toString()));

                        if (res) {
                            JOptionPane.showMessageDialog(null, "Donor is added");
                            String donorid = didText.getText();
                            String bloodgroup = bloodGroupCombo.getSelectedItem().toString();
                            String rhfactor = rhFactorCombo.getSelectedItem().toString();
                            new AddBloodOfNewDonor(donorid, bloodgroup, rhfactor).setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed");
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
        });

        Combobox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameText.requestFocus();
            }
        });

        firstNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(firstNameText);
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    } else {
                        lastNameText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }
            }
        });

        lastNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(lastNameText);
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    } else {
                        genderCombo.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }

            }
        });

        genderCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nicText.requestFocus();
            }
        });

        nicText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nicValidation(nicText.getText());
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    } else {
                        telhText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid NIC number! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }

            }
        });

        telhText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.phoneNumberValidation(telhText.getText());
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    } else {
                        mobileText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }

            }
        });

        mobileText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.phoneNumberValidation(mobileText.getText());
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    } else {
                        addressText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }
            }
        });


        addressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(addressText);
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    } else {
                        bloodGroupCombo.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }

            }
        });

        bloodGroupCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yearText.requestFocus();

            }
        });

        yearText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.yearValidation(yearText.getText());
                if (isValidated) {
                    monthCombo.requestFocus();
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }

            }
        });


        monthCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daysCombo.requestFocus();


            }
        });
        daysCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rhFactorCombo.requestFocus();


            }
        });
        rhFactorCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ageText.requestFocus();

            }
        });

        ageText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.ageValidation(ageText.getText());
                if (isValidated) {
                    if (!firstNameText.getText().equals("") && !lastNameText.getText().equals("") && !nicText.getText().equals("") && !mobileText.getText().equals("") && !telhText.getText().equals("") && !yearText.getText().equals("") && !ageText.getText().equals("")) {
                        nextButton.setEnabled(true);
                        nextButton.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(900, 500, 5, 2, notificationLabel);
                }
            }
        });


        closeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to quit?", null, 0, 3);
                if (res == 0) {
                    dispose();
                }
            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to quit?", null, 0, 3);
                if (res == 0) {
                    dispose();
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
        addressLabel = new JLabel();
        ageLabel = new JLabel();
        bloodBankLabel = new JLabel();
        regDateLabel = new JLabel();
        didLabel = new JLabel();
        dobLabel = new JLabel();
        firstNameLabel = new JLabel();
        genderLabel = new JLabel();
        lastNameLabel = new JLabel();
        mobileLabel = new JLabel();
        nicLabel = new JLabel();
        rhLabel = new JLabel();
        bloodGroupLabel = new JLabel();
        pinfoLabel = new JLabel();
        telhLabel = new JLabel();
        titleLabel = new JLabel();
        vLabel = new JLabel();
        yrsLabel = new JLabel();
        closeLabel = new JLabel();
        notificationLabel = new JLabel();

        //-----------textfields
        addressText = new JTextField();
        ageText = new JTextField();
        regDateText = new JTextField();
        didText = new JTextField();
        firstNameText = new JTextField();
        lastNameText = new JTextField();
        mobileText = new JTextField();
        nicText = new JTextField();
        telhText = new JTextField();
        yearText = new JTextField();

        //----------comboboxes
        Combobox = new JComboBox();
        daysCombo = new JComboBox();
        genderCombo = new JComboBox();
        monthCombo = new JComboBox();
        bloodGroupCombo = new JComboBox();
        rhFactorCombo = new JComboBox();

        //----------buttons
        clearButton = new JButton();
        nextButton = new JButton();
        cancelButton = new JButton();


        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(180, 180, 158), 8));


        //----------set panels
        mainPanel.setBackground(new Color(255, 255, 255));

        grayPanel1.setBackground(new Color(153, 153, 153));
        grayPanel1.setPreferredSize(new Dimension(700, 36));


        redPanel.setBackground(new Color(153, 0, 51));
        redPanel.setPreferredSize(new Dimension(120, 36));

        redTitlePanel.setBackground(new Color(153, 0, 51));
        redTitlePanel.setPreferredSize(new Dimension(20, 20));

        titlePanel1.setBackground(new Color(219, 215, 215));
        titlePanel1.setPreferredSize(new Dimension(690, 30));

        titlePanel2.setBackground(new Color(180, 180, 158));
        titlePanel2.setPreferredSize(new Dimension(690, 30));

        greenPanel.setBackground(new Color(0, 102, 102));
        greenPanel.setPreferredSize(new Dimension(730, 60));

        //-----------set main title	
        bloodBankLabel.setBackground(new Color(255, 255, 255));
        bloodBankLabel.setFont(new Font("Segoe UI", 1, 18));
        bloodBankLabel.setText("BLOOD BANK");

        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setText("Donor Application Form");



        //----------set labels ,comboboxes and textfields

        didLabel.setFont(new Font("Segoe UI", 0, 12));
        didLabel.setText("Donor Id   : ");

        didText.setEditable(false);
        didText.setFont(new Font("Arial", 0, 12));
        didText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        didText.setHorizontalAlignment(SwingConstants.CENTER);

        regDateLabel.setFont(new Font("Segoe UI", 0, 12));
        regDateLabel.setText("Register Date   : ");
        regDateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        regDateText.setEditable(false);
        regDateText.setFont(new Font("Arial", 0, 12));
        regDateText.setHorizontalAlignment(SwingConstants.CENTER);
        regDateText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        pinfoLabel.setFont(new Font("Segoe UI", 1, 14));
        pinfoLabel.setForeground(new Color(255, 255, 255));
        pinfoLabel.setText("Personal Info");


        Combobox.setBackground(new Color(255, 255, 255));
        Combobox.setFont(new Font("Arial", 1, 12));
        Combobox.setModel(new DefaultComboBoxModel(new String[]{"Mr.", "Mrs.", "Miss"}));

        firstNameLabel.setFont(new Font("Segoe UI", 0, 12));
        firstNameLabel.setText("First Name : ");


        firstNameText.setFont(new Font("Arial", 0, 12));
        firstNameText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        lastNameLabel.setFont(new Font("Segoe UI", 0, 12));
        lastNameLabel.setText("Last Name   : ");

        lastNameText.setFont(new Font("Arial", 0, 12));
        lastNameText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        genderLabel.setFont(new Font("Segoe UI", 0, 12));
        genderLabel.setText("Gender      : ");

        genderCombo.setBackground(new Color(255, 255, 255));
        genderCombo.setFont(new Font("Arial", 1, 12));
        genderCombo.setModel(new DefaultComboBoxModel(new String[]{"Male", "Female"}));

        nicLabel.setFont(new Font("Segoe UI", 0, 12));
        nicLabel.setText("NIC           :");

        nicText.setFont(new Font("Arial", 0, 12));
        nicText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        vLabel.setFont(new Font("Arial", 1, 12));
        vLabel.setText("V");

        telhLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        telhLabel.setText("Tel .(Home)  : ");

        telhText.setFont(new Font("Arial", 0, 12));
        telhText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        mobileLabel.setFont(new Font("Segoe UI", 0, 12));
        mobileLabel.setText("Mobile      : ");

        mobileText.setFont(new Font("Arial", 0, 12));
        mobileText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        addressLabel.setFont(new Font("Segoe UI", 0, 12));
        addressLabel.setText("Address :");

        addressText.setFont(new Font("Arial", 0, 12));
        addressText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        rhLabel.setFont(new Font("Segoe UI", 0, 12));
        rhLabel.setText("Rh factor :");

        rhFactorCombo.setFont(new Font("Arial", 1, 12));
        rhFactorCombo.setModel(new DefaultComboBoxModel(new String[]{"Positive", "Negative"}));
        rhFactorCombo.setBackground(new Color(255, 255, 255));
        rhFactorCombo.setPreferredSize(new Dimension(52, 23));

        dobLabel.setFont(new Font("Segoe UI", 0, 12));
        dobLabel.setText("Date of birth : ");

        yearText.setFont(new Font("Arial", 0, 12));
        yearText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));


        monthCombo.setBackground(new Color(255, 255, 255));
        monthCombo.setFont(new Font("Arial", 1, 12));
        monthCombo.setModel(new DefaultComboBoxModel(
                new String[]{"Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"}));



        daysCombo.setBackground(new Color(255, 255, 255));
        daysCombo.setFont(new Font("Arial", 1, 12));
        daysCombo.setModel(new DefaultComboBoxModel(
                new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        bloodGroupLabel.setFont(new Font("Segoe UI", 0, 12));
        bloodGroupLabel.setText("Blood group :");

        bloodGroupCombo.setFont(new Font("Arial", 1, 12));
        bloodGroupCombo.setModel(new DefaultComboBoxModel(new String[]{"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        bloodGroupCombo.setBackground(new Color(255, 255, 255));
        bloodGroupCombo.setPreferredSize(new Dimension(140, 23));

        ageLabel.setFont(new Font("Segoe UI", 0, 12));
        ageLabel.setText("Age            : ");

        ageText.setFont(new Font("Arial", 0, 12));
        ageText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));


        yrsLabel.setFont(new Font("Arial", 1, 12));
        yrsLabel.setText("Yrs.");

        notificationLabel.setFont(new Font("Segoe UI", 1, 13));
        notificationLabel.setBackground(new Color(190, 142, 140));
        notificationLabel.setOpaque(true);
        notificationLabel.setForeground(new Color(255, 255, 255));
        notificationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel2.add(notificationLabel);
        notificationLabel.setBounds(900, 1, 400, 30);


        //-----------set close Icon
        closeLabel.setIcon(new ImageIcon("C:/Users/Sandali/Documents/NetBeansProjects/BloodBankProjectClient/src/images/closeIcon.png"));
        closeLabel.setToolTipText("Close");

        //-----------buttons
        clearButton.setBackground(new Color(204, 204, 204));
        clearButton.setFont(new Font("Segoe UI", 1, 12));
        clearButton.setText("Clear");
        clearButton.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        nextButton.setBackground(new Color(151, 185, 185));
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        nextButton.setText("Next");
        nextButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        cancelButton.setBackground(new Color(204, 204, 204));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));


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
                .addGap(70, 70, 70)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yrsLabel))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(dobLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yearText, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(monthCombo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(daysCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addComponent(genderLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(genderCombo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(bloodGroupLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bloodGroupCombo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(rhLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
                .addComponent(mobileLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(lastNameText, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addComponent(nicText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(vLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rhFactorCombo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addComponent(greenPanel)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(Combobox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(didLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(didText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(regDateLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regDateText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
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
                .addComponent(regDateText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(didText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(regDateLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addComponent(Combobox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(titlePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(genderCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(genderLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(bloodGroupCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
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
                .addComponent(bloodGroupLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(yearText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(monthCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(daysCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(dobLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(rhLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(rhFactorCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(yrsLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)))
                .addGap(20, 20, 20)
                .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)));
        add(mainPanel);
        pack();

    }

    private void setregDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        regDateText.setText(dateformat.format(new Date()));

    }

    public static void main(String args[]) {
        new AddDonorDetails().setVisible(true);

    }
}
