/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.cmjd.rmi.bbms.client.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Sandali
 */
public class Validation {

    public boolean dateValidation(String date) {
        String regx = "((19|20)\\d\\d)/([012]0?[0-9]|1)/(0[1-9]|[12][0-9]|3[01])";

        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            matcher.reset();
            if (matcher.find()) {
                int yy = Integer.parseInt(matcher.group(1));
                String mm = matcher.group(3);
                String dd = matcher.group(4);
                if (dd.equals("31") && (mm.equals("4") || mm.equals("6") || mm.equals("9")
                        || mm.equals("11") || mm.equals("04") || mm.equals("06")
                        || mm.equals("09"))) {
                    return false;

                } else if (mm.equals("2") || mm.equals("02")) {
                    if (yy % 4 == 0) {
                        if (dd.equals("30") || dd.equals("31")) {
                            return false;
                        } else {
                            return true;
                        }

                    } else {
                        if (dd.equals("29") || dd.equals("30") || dd.equals("31")) {
                            return false;
                        } else {
                            return true;

                        }
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public boolean phoneNumberValidation(String phoneNumber) {
        String regex = "([0-9]{10})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean nicValidation(String nic) {
        String regex = "([0-9]{9})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nic);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean nameValidation(JTextField nameText) {
        String regex = "^[A-za-z ]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameText.getText());
        if (matcher.matches()) {
            String name = nameText.getText();
            char c = name.charAt(0);
            String str = Character.toString(c);
            nameText.setText(str.toUpperCase() + name.substring(1));
            return true;
        } else {
            return false;
        }
    }

    public boolean intnumberValidation(String number) {
        String regex = "^[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean yearValidation(String year) {
        String regex = "((19|20)\\d\\d)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(year);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ageValidation(String age) {
        String regex = "([0-9]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(age);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
