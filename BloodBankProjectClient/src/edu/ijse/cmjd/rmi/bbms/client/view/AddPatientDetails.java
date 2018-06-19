package edu.ijse.cmjd.rmi.bbms.client.view;

import AppPackage.AnimationClass;
import edu.ijse.cmjd.rmi.bbms.client.idgenerator.IdGenerator;
import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import edu.ijse.cmjd.rmi.bbms.client.validation.Validation;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.GuardianController;
import common.ijse.rmi.bloodbank.controller.IssuebloodController;
import common.ijse.rmi.bloodbank.controller.PatientController;
import common.ijse.rmi.bloodbank.model.Guardian;
import common.ijse.rmi.bloodbank.model.Issueblood;
import common.ijse.rmi.bloodbank.model.Patient;
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

public class AddPatientDetails extends JFrame {

    //----------panels
    private JPanel mainPanel;
    private JPanel redPanel;
    private JPanel grayPanel1;
    private JPanel redTitlePanel;
    private JPanel titlePanel1;
    private JPanel titlePanel2;
    private JPanel titlePanel3;
    private JPanel greenPanel;
    //----------labels
    private JLabel bloodBankLabel;
    private JLabel firstNameLabel1;
    private JLabel lastNameLabel1;
    private JLabel genderLabel1;
    private JLabel hospitalLabel;
    private JLabel ageLabel;
    private JLabel yrsLabel;
    private JLabel firstNameLabel2;
    private JLabel lastNameLabel2;
    private JLabel genderLabel2;
    private JLabel nicLabel;
    private JLabel vLabel;
    private JLabel mobileLabel;
    private JLabel telhLabel;
    private JLabel addressLabel;
    private JLabel issuedDateLabel;
    private JLabel titleLabel;
    private JLabel patientInfoLabel;
    private JLabel guardianInfoLabel;
    private JLabel diseaseLabel;
    private JLabel bloodBagIdLabel;
    private JLabel notificationLabel;
    //-----------textfields
    private JTextField firstNameText1;
    private JTextField lastNameText1;
    private JTextField hospitalText;
    private JTextField ageText;
    private JTextField firstNameText2;
    private JTextField lastNameText2;
    private JTextField mobileText;
    private JTextField nicText;
    private JTextField telhText;
    private JTextField addressText;
    private JTextField pidText;
    private JTextField gidText;
    private JTextField issuedDateText;
    private JTextField diseaseText;
    private JTextField bloodBagIdText;
    //----------comboboxes
    private JComboBox Combobox1;
    private JComboBox Combobox2;
    private JComboBox genderCombo1;
    private JComboBox genderCombo2;
    //----------buttons
    private JButton clearButton1;
    private JButton clearButton2;
    private JButton issueButton;
    private JButton cancelButton;
    Validation validation = new Validation();
    boolean isValidated = false;
    AnimationClass ac = new AnimationClass();
    private String bid;
    private String did;
    private String dDate;
    private String rh;
    private String qty;
    private String bloodComp;
    private String bloodGroup;
    private BloodSampleController bsc;

    public AddPatientDetails(final String bid, final String did, final String bloodGroup, final String rh, final String qty, final String bloodComp, final String dDate, final BloodSampleController bsc) {

        setComponents();
        setissueDate();
        addActions();
        setLocationRelativeTo(null);
        bloodBagIdText.setText(bid);
        final AddPatientDetails ap;
        ap = this;
        IdGenerator idGenerator = new IdGenerator();
        Combobox1.requestFocus();
        issueButton.setEnabled(false);
        this.bid = bid;
        this.did = did;
        this.dDate = dDate;
        this.rh = rh;
        this.qty = qty;
        this.bloodComp=bloodComp;
        this.bloodGroup=bloodGroup;
        this.bsc=bsc;
        try {
            pidText.setText(idGenerator.createPatientId());
            gidText.setText(idGenerator.createGuardianId());
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

    private void addActions() {
        clearButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameText1.setText("");
                lastNameText1.setText("");
                ageText.setText("");
                hospitalText.setText("");
                diseaseText.setText("");
                genderCombo1.setSelectedIndex(1);
                genderCombo1.setSelectedIndex(1);
                issueButton.setEnabled(false);

            }
        });
        clearButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameText2.setText("");
                lastNameText2.setText("");
                nicText.setText("");
                telhText.setText("");
                addressText.setText("");
                mobileText.setText("");
                genderCombo2.setSelectedIndex(1);
                genderCombo2.setSelectedIndex(1);
                issueButton.setEnabled(false);
            }
        });

        issueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    PatientController patientController = ServerConnector.getServerConnector().getPatientController();
                    boolean res1 = patientController.addPatient(new Patient(
                            pidText.getText(),
                            Combobox1.getSelectedItem().toString(),
                            firstNameText1.getText(),
                            lastNameText1.getText(),
                            genderCombo1.getSelectedItem().toString(),
                            hospitalText.getText(),
                            ageText.getText(),
                            diseaseText.getText()));

                    GuardianController guardianController = ServerConnector.getServerConnector().getGuardianController();
                    boolean res2 = guardianController.addGuardian(new Guardian(
                            gidText.getText(),
                            Combobox2.getSelectedItem().toString(),
                            firstNameText2.getText(),
                            lastNameText2.getText(),
                            genderCombo2.getSelectedItem().toString(),
                            nicText.getText(),
                            mobileText.getText(),
                            telhText.getText(),
                            addressText.getText()));
                    IssuebloodController issuebloodController = ServerConnector.getServerConnector().getIssuebloodController();
                    boolean res3 = issuebloodController.addIssueblood(new Issueblood(
                            bid,
                            did,
                            pidText.getText(),
                            gidText.getText(),
                            bloodGroup,
                            rh,
                            qty,
                            bloodComp,
                            dDate,
                            issuedDateText.getText()));
                    if (res1 && res2 && res3) {
                        bsc.releaseBloodSample(bid);
                        JOptionPane.showMessageDialog(null, "Blood sample is issued successfully");
                        dispose();
                    } else {
                        if (!res1) {
                            JOptionPane.showMessageDialog(null, "Error occured in adding patient details");
                        } else if (!res2) {
                            JOptionPane.showMessageDialog(null, "Error occured in adding guardian details");
                        } else if (!res3) {
                            JOptionPane.showMessageDialog(null, "Error occured in issuing ");
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

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Do you want to quit?", null, 0, 3);
                if (res == 0) {
                    dispose();
                    try {
                        bsc.releaseBloodSample(bid);
                        new IssueBloodSample().setVisible(true);
                    } catch (RemoteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());

                    }

                }
            }
        });

        Combobox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameText1.requestFocus();
            }
        });
        firstNameText1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(firstNameText1);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        lastNameText1.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }
            }
        });
        firstNameText1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (firstNameText1.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        lastNameText1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(lastNameText1);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        genderCombo1.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        lastNameText1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (lastNameText1.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        genderCombo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!firstNameText1.getText().equals("")
                        && !lastNameText1.getText().equals("")
                        && !ageText.getText().equals("")
                        && !hospitalText.getText().equals("")
                        && !diseaseText.getText().equals("")
                        && !firstNameText2.getText().equals("")
                        && !lastNameText2.getText().equals("")
                        && !nicText.getText().equals("")
                        && !mobileText.getText().equals("")
                        && !telhText.getText().equals("")
                        && !addressText.getText().equals("")) {
                    issueButton.setEnabled(true);
                    issueButton.requestFocus();
                } else {
                    hospitalText.requestFocus();
                }

            }
        });

        hospitalText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(hospitalText);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        ageText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }
            }
        });
        hospitalText.addKeyListener(
                new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        if (hospitalText.getText().equals("") == true) {
                            issueButton.setEnabled(false);
                            ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                        }
                    }
                });
        ageText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.ageValidation(ageText.getText());
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        diseaseText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        ageText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (ageText.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        diseaseText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(diseaseText);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        Combobox2.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        diseaseText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (diseaseText.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        Combobox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameText2.requestFocus();
            }
        });
        firstNameText2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(firstNameText2);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        lastNameText2.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }
            }
        });
        firstNameText2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (firstNameText2.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        lastNameText2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(lastNameText2);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        genderCombo2.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }
            }
        });
        lastNameText2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (lastNameText2.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        genderCombo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nicText.requestFocus();
            }
        });
        nicText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nicValidation(nicText.getText());
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        mobileText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid NIC number! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        nicText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (nicText.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        mobileText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.phoneNumberValidation(mobileText.getText());
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        telhText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        mobileText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (mobileText.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        telhText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.phoneNumberValidation(telhText.getText());
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                        issueButton.requestFocus();
                    } else {
                        addressText.requestFocus();
                    }
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        telhText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (telhText.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
                }
            }
        });
        addressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isValidated = validation.nameValidation(addressText);
                if (isValidated) {
                    if (!firstNameText1.getText().equals("")
                            && !lastNameText1.getText().equals("")
                            && !ageText.getText().equals("")
                            && !hospitalText.getText().equals("")
                            && !diseaseText.getText().equals("")
                            && !firstNameText2.getText().equals("")
                            && !lastNameText2.getText().equals("")
                            && !nicText.getText().equals("")
                            && !mobileText.getText().equals("")
                            && !telhText.getText().equals("")
                            && !addressText.getText().equals("")) {
                        issueButton.setEnabled(true);
                    }
                    issueButton.requestFocus();
                } else {
                    notificationLabel.setText("Invalid input! Check it again");
                    ac.jLabelXLeft(950, 650, 5, 2, notificationLabel);
                }

            }
        });
        addressText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (addressText.getText().equals("") == true) {
                    issueButton.setEnabled(false);
                    ac.jLabelXRight(650, 950, 5, 2, notificationLabel);
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
        titlePanel3 = new JPanel();
        greenPanel = new JPanel();

        //----------labels
        bloodBankLabel = new JLabel();
        firstNameLabel1 = new JLabel();
        lastNameLabel1 = new JLabel();
        genderLabel1 = new JLabel();
        hospitalLabel = new JLabel();
        ageLabel = new JLabel();
        yrsLabel = new JLabel();
        firstNameLabel2 = new JLabel();
        lastNameLabel2 = new JLabel();
        genderLabel2 = new JLabel();
        nicLabel = new JLabel();
        vLabel = new JLabel();
        mobileLabel = new JLabel();
        telhLabel = new JLabel();
        addressLabel = new JLabel();
        issuedDateLabel = new JLabel();
        titleLabel = new JLabel();
        patientInfoLabel = new JLabel();
        guardianInfoLabel = new JLabel();
        diseaseLabel = new JLabel();
        bloodBagIdLabel = new JLabel();
        notificationLabel = new JLabel();

        //-----------textfields
        firstNameText1 = new JTextField();
        lastNameText1 = new JTextField();
        hospitalText = new JTextField();
        ageText = new JTextField();
        firstNameText2 = new JTextField();
        lastNameText2 = new JTextField();
        mobileText = new JTextField();
        nicText = new JTextField();
        telhText = new JTextField();
        addressText = new JTextField();
        gidText = new JTextField();
        pidText = new JTextField();
        issuedDateText = new JTextField();
        diseaseText = new JTextField();
        bloodBagIdText = new JTextField();

        //----------comboboxes
        Combobox1 = new JComboBox();
        Combobox2 = new JComboBox();
        genderCombo1 = new JComboBox();
        genderCombo2 = new JComboBox();

        //----------buttons
        clearButton1 = new JButton();
        clearButton2 = new JButton();
        issueButton = new JButton();
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

        titlePanel1.setBackground(new Color(240, 240, 240));
        titlePanel1.setPreferredSize(new Dimension(690, 30));

        titlePanel2.setBackground(new Color(180, 180, 158));
        titlePanel2.setPreferredSize(new Dimension(690, 30));

        titlePanel3.setBackground(new Color(180, 180, 158));
        titlePanel3.setPreferredSize(new Dimension(690, 30));

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
        titleLabel.setText("Blood Issue Application Form");

        //----------set labels and textfields

        issuedDateLabel.setFont(new Font("Segoe UI", 0, 12));
        issuedDateLabel.setText("Issued Date   :");

        issuedDateText.setEditable(false);
        issuedDateText.setFont(new Font("Arial", 0, 12));
        issuedDateText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        issuedDateText.setHorizontalAlignment(SwingConstants.CENTER);

        bloodBagIdLabel.setFont(new Font("Segoe UI", 0, 12));
        bloodBagIdLabel.setText("Issued Bloodbag id :");

        bloodBagIdText.setEditable(false);
        bloodBagIdText.setFont(new Font("Arial", 0, 12));
        bloodBagIdText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
        bloodBagIdText.setHorizontalAlignment(SwingConstants.CENTER);


        patientInfoLabel.setFont(new Font("Segoe UI", 1, 14));
        patientInfoLabel.setForeground(new Color(255, 255, 255));
        patientInfoLabel.setText("Patient Info");

        guardianInfoLabel.setFont(new Font("Segoe UI", 1, 14));
        guardianInfoLabel.setForeground(new Color(255, 255, 255));
        guardianInfoLabel.setText("Guardian Info");


        pidText.setEditable(false);
        pidText.setFont(new Font("Arial", 0, 12));
        pidText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 2));
        pidText.setHorizontalAlignment(SwingConstants.CENTER);

        Combobox1.setFont(new Font("Segoe UI Light", 1, 12));
        Combobox1.setModel(new DefaultComboBoxModel(new String[]{"Mr.", "Mrs.", "Miss."}));
        Combobox1.setBackground(new Color(255, 255, 255));

        firstNameLabel1.setFont(new Font("Segoe UI", 0, 12));
        firstNameLabel1.setText("First Name : ");

        firstNameText1.setFont(new Font("Arial", 0, 12));
        firstNameText1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        lastNameLabel1.setFont(new Font("Segoe UI", 0, 12));
        lastNameLabel1.setText("Last Name   : ");

        lastNameText1.setFont(new Font("Arial", 0, 12));
        lastNameText1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        genderLabel1.setFont(new Font("Segoe UI", 0, 12));
        genderLabel1.setText("Gender      : ");

        genderCombo1.setFont(new Font("Segoe UI Light", 1, 12));
        genderCombo1.setModel(new DefaultComboBoxModel(new String[]{"Male", "Female"}));
        genderCombo1.setBackground(new Color(255, 255, 255));

        hospitalLabel.setFont(new Font("Segoe UI", 0, 12));
        hospitalLabel.setText("Hospital   : ");

        hospitalText.setFont(new Font("Arial", 0, 12));
        hospitalText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        diseaseLabel.setFont(new Font("Segoe UI", 0, 12));
        diseaseLabel.setText("Disease details : ");

        diseaseText.setFont(new Font("Arial", 0, 12));
        diseaseText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        ageLabel.setFont(new Font("Segoe UI", 0, 12));
        ageLabel.setText("Age   : ");

        ageText.setFont(new Font("Arial", 0, 12));
        ageText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        yrsLabel.setFont(new Font("Segoe UI Light", 1, 12));
        yrsLabel.setText("Yrs.");



        gidText.setEditable(false);
        gidText.setFont(new Font("Arial", 0, 12));
        gidText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 2));
        gidText.setHorizontalAlignment(SwingConstants.CENTER);

        Combobox2.setFont(new Font("Segoe UI Light", 1, 12));
        Combobox2.setModel(new DefaultComboBoxModel(new String[]{"Mr.", "Mrs.", "Miss"}));
        Combobox2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        Combobox2.setBackground(new Color(255, 255, 255));

        firstNameLabel2.setFont(new Font("Segoe UI", 0, 12));
        firstNameLabel2.setText("First Name : ");

        firstNameText2.setFont(new Font("Arial", 0, 12));
        firstNameText2.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        lastNameLabel2.setFont(new Font("Segoe UI", 0, 12));
        lastNameLabel2.setText("Last Name   : ");

        lastNameText2.setFont(new Font("Arial", 0, 12));
        lastNameText2.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        genderLabel2.setFont(new Font("Segoe UI", 0, 12));
        genderLabel2.setText("Gender      : ");

        genderCombo2.setFont(new Font("Segoe UI Light", 1, 12));
        genderCombo2.setModel(new DefaultComboBoxModel(new String[]{"Male", "Female"}));
        genderCombo2.setBackground(new Color(255, 255, 255));

        nicLabel.setFont(new Font("Segoe UI", 0, 12));
        nicLabel.setText("NIC           :");

        nicText.setFont(new Font("Arial", 0, 12));
        nicText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        vLabel.setFont(new Font("Segoe UI Light", 1, 12));
        vLabel.setText("V");

        mobileLabel.setFont(new Font("Segoe UI", 0, 12));
        mobileLabel.setText("Mobile      : ");

        mobileText.setFont(new Font("Arial", 0, 12));
        mobileText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        telhLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        telhLabel.setText("Tel .(Home)  : ");

        telhText.setFont(new Font("Arial", 0, 12));
        telhText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));

        addressLabel.setFont(new Font("Segoe UI", 0, 12));
        addressLabel.setText("Address :");

        addressText.setFont(new Font("Arial", 0, 12));
        addressText.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));


        notificationLabel.setFont(new Font("Segoe UI", 1, 13));
        notificationLabel.setBackground(new Color(190, 142, 140));
        notificationLabel.setOpaque(true);
        notificationLabel.setForeground(new Color(255, 255, 255));
        notificationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel2.add(notificationLabel);
        notificationLabel.setBounds(950, 1, 300, 30);

        //-----------buttons
        clearButton1.setBackground(new Color(204, 204, 204));
        clearButton1.setFont(new Font("Segoe UI", 1, 12));
        clearButton1.setText("Clear");
        clearButton1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        clearButton2.setBackground(new Color(204, 204, 204));
        clearButton2.setFont(new Font("Segoe UI", 1, 12));
        clearButton2.setText("Clear");
        clearButton2.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        issueButton.setBackground(new Color(151, 185, 185));
        issueButton.setFont(new Font("Segoe UI", 1, 12));
        issueButton.setText("Issue");
        issueButton.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));

        cancelButton.setBackground(new Color(153, 153, 153));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));


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
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        titlePanel1Layout.setVerticalGroup(
                titlePanel1Layout.createParallelGroup()
                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE));

        //titlePanel3Layout
        GroupLayout titlePanel2Layout = new GroupLayout(titlePanel2);
        titlePanel2.setLayout(titlePanel2Layout);
        titlePanel2Layout.setHorizontalGroup(
                titlePanel2Layout.createParallelGroup()
                .addGroup(titlePanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(pidText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(patientInfoLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)));
        titlePanel2Layout.setVerticalGroup(
                titlePanel2Layout.createParallelGroup()
                .addComponent(pidText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(patientInfoLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE));

        //titlePanel3Layout
        GroupLayout titlePanel3Layout = new GroupLayout(titlePanel3);
        titlePanel3.setLayout(titlePanel3Layout);
        titlePanel3Layout.setHorizontalGroup(
                titlePanel3Layout.createParallelGroup()
                .addGroup(titlePanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(gidText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(guardianInfoLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)));
        titlePanel3Layout.setVerticalGroup(
                titlePanel3Layout.createParallelGroup()
                .addComponent(gidText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(guardianInfoLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE));

        //mainPanelLayout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(titlePanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bloodBagIdLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bloodBagIdText, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(issuedDateLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issuedDateText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
                .addComponent(greenPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Combobox2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(genderLabel2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(genderCombo2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(firstNameLabel2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(firstNameText2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(mobileLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                .addComponent(lastNameLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastNameText2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nicText, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(vLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(clearButton1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(Combobox1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(firstNameLabel1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameText1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(genderLabel1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genderCombo1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(yrsLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(diseaseLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diseaseText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(lastNameLabel1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastNameText1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(hospitalLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hospitalText, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(92, Short.MAX_VALUE))
                .addGap(300, 300, 300)
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(issueButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
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
                .addComponent(titlePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(bloodBagIdText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(bloodBagIdLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(issuedDateLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(issuedDateText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titlePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstNameLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastNameLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastNameText1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(Combobox1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameText1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(genderLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(hospitalLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addComponent(genderCombo1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addComponent(hospitalText, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(yrsLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(diseaseLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(diseaseText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(clearButton1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titlePanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lastNameLabel2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(firstNameLabel2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(lastNameText2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(firstNameText2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(Combobox2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(genderLabel2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(nicText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(vLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addComponent(genderCombo2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(mobileLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup()
                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(clearButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(issueButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addContainerGap()));
        add(mainPanel);
        pack();

    }

    private void setissueDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        issuedDateText.setText(dateformat.format(new Date()));
    }
}
