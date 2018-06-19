/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.BloodCamp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Sandali
 */
public class BloodCampFileAccess {

    private final File file = new File("DataAccess/bloodcampAccess.txt");
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addBloodCamp(BloodCamp bloodcamp) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.writeLock().lock();
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                data += bloodcamp.getPlace() + "$";
                data += bloodcamp.getDate() + "$";
                data += bloodcamp.getTime() + "$";
                data += bloodcamp.getContactnumber() + "$";
                data += bloodcamp.getContactperson() + "$";

                fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(data);
                bufferedWriter.flush();
            } finally {
                bufferedWriter.close();
                fileWriter.close();
            }
            return true;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public List<BloodCamp> getallBloodCamps() throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<BloodCamp> bloodcamps = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    bloodcamps = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    for (int i = 0; i < ar.length; i += 5) {
                        bloodcamps.add(new BloodCamp(ar[i], ar[i + 1], ar[i + 2], ar[i + 3], ar[i + 4]));
                    }
                }

            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return bloodcamps;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteBloodCamp(String date) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    String[] data = new String[tokenizer.countTokens()];
                    for (int i = 0; i < data.length; i++) {
                        data[i] = tokenizer.nextToken();
                    }
                    for (int i = 0; i < data.length; i += 5) {
                        if (data[i+1].equals(date)) {

                            for (int j = i; j < data.length - 5; j++) {
                                data[j] = data[j + 5];
                            }
                            break;
                        }
                    }
                    fileWriter = new FileWriter(file);
                    for (int i = 0; i < data.length - 5; i++) {
                        fileWriter.append(data[i].toString() + "$");
                        fileWriter.flush();

                    }

                }
            } finally {
                fileReader.close();
                bufferedReader.close();
                fileWriter.close();
            }
            return true;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
