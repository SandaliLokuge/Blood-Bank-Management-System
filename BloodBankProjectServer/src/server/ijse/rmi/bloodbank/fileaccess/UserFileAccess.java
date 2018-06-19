/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Sandali
 */
public class UserFileAccess {

    private final File file = new File("DataAccess/userDataAccess.txt");

    public boolean addUser(User user) throws RemoteException, ClassNotFoundException, IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            String data = "";
            data += user.getUsername() + "$";
            data += user.getPassword() + "$";

            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.flush();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
        return true;
    }

    public boolean checkUser(String username) throws RemoteException, ClassNotFoundException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
        String ar[] = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < ar.length; i++) {
            if (stringTokenizer.hasMoreTokens()) {
                ar[i] = stringTokenizer.nextToken();
            }
        }
        boolean res = false;
        for (int i = 0; i < ar.length; i += 2) {
            if (username.equals(ar[i])) {
                res = true;
                break;
            }
        }
        return res;

    }

    public boolean checkPassword(String username, String password) throws RemoteException, ClassNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
        String ar[] = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < ar.length; i++) {
            if (stringTokenizer.hasMoreTokens()) {
                ar[i] = stringTokenizer.nextToken();
            }
        }
        boolean res = false;
        String p="";
        for (int i = 0; i < ar.length; i += 2) {
            if (username.equals(ar[i])) {
                p=ar[i+1];
                break;
            }
        }
        if(p.equals(password)){
            res=true;
        }
        return res;
    }
}
