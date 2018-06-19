package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Issueblood;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.ArrayList;

public class IssuebloodFileAccess {

    private final File file = new File("DataAccess/issuebloodDataAccess.txt");
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addIssueblood(Issueblood issueblood) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.writeLock().lock();
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                data += issueblood.getBloodbagid() + "$";
                data += issueblood.getDonorid() + "$";
                data += issueblood.getPatientid() + "$";
                data += issueblood.getGuardianid() + "$";
                data += issueblood.getBloodgroup() + "$";
                data += issueblood.getRhfactor() + "$";
                data += issueblood.getQty() + "$";
                data += issueblood.getBloodcomponent() + "$";
                data += issueblood.getDonatedate() + "$";
                data += issueblood.getIssueddate() + "$";

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

    public List<Issueblood> getallIssueblood() throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            ArrayList<Issueblood> issuebloodlist = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, "$");

                        issuebloodlist = new ArrayList<>();
                        String[] ar = new String[tokenizer.countTokens()];
                        for (int i = 0; i < ar.length; i++) {
                            ar[i] = tokenizer.nextToken();
                        }
                        for (int i = 0; i < ar.length; i += 10) {
                            issuebloodlist.add(new Issueblood(ar[i], ar[i + 1], ar[i + 2], ar[i + 3], ar[i + 4], ar[i + 5], ar[i + 6], ar[i + 7], ar[i + 8], ar[i + 9]));
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return issuebloodlist;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<Issueblood> getIssuebloodbyBloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<Issueblood> issuebloodlist = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    issuebloodlist = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    Issueblood issueblood = null;
                    for (int i = 0; i < ar.length; i += 10) {
                        if (bloodgroup.equals(ar[i + 4])) {
                            issueblood = new Issueblood();
                            issueblood.setBloodbagid(ar[i]);
                            issueblood.setDonorid(ar[i + 1]);
                            issueblood.setPatientid(ar[i + 2]);
                            issueblood.setGuardianid(ar[i + 3]);
                            issueblood.setBloodgroup(ar[i + 4]);
                            issueblood.setRhfactor(ar[i + 5]);
                            issueblood.setQty(ar[i + 6]);
                            issueblood.setBloodcomponent(ar[i + 7]);
                            issueblood.setDonatedate(ar[i + 8]);
                            issueblood.setIssueddate(ar[i + 9]);
                            issuebloodlist.add(issueblood);
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return issuebloodlist;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<Issueblood> getIssuebloodbyBloodcomp(String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<Issueblood> issuebloodlist = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    issuebloodlist = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    Issueblood issueblood = null;
                    for (int i = 0; i < ar.length; i += 10) {
                        if (bloodcomponent.equals(ar[i + 7])) {
                            issueblood = new Issueblood();
                            issueblood.setBloodbagid(ar[i]);
                            issueblood.setDonorid(ar[i + 1]);
                            issueblood.setPatientid(ar[i + 2]);
                            issueblood.setGuardianid(ar[i + 3]);
                            issueblood.setBloodgroup(ar[i + 4]);
                            issueblood.setRhfactor(ar[i + 5]);
                            issueblood.setQty(ar[i + 6]);
                            issueblood.setBloodcomponent(ar[i + 7]);
                            issueblood.setDonatedate(ar[i + 8]);
                            issueblood.setIssueddate(ar[i + 9]);
                            issuebloodlist.add(issueblood);
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return issuebloodlist;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<Issueblood> getIssueblood(String bloodgroup, String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<Issueblood> issuebloodlist = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    issuebloodlist = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    Issueblood issueblood = null;
                    for (int i = 0; i < ar.length; i += 10) {
                        if (bloodgroup.equals(ar[i + 4]) && bloodcomponent.equals(ar[i + 7])) {
                            issueblood = new Issueblood();
                            issueblood.setBloodbagid(ar[i]);
                            issueblood.setDonorid(ar[i + 1]);
                            issueblood.setPatientid(ar[i + 2]);
                            issueblood.setGuardianid(ar[i + 3]);
                            issueblood.setBloodgroup(ar[i + 4]);
                            issueblood.setRhfactor(ar[i + 5]);
                            issueblood.setQty(ar[i + 6]);
                            issueblood.setBloodcomponent(ar[i + 7]);
                            issueblood.setDonatedate(ar[i + 8]);
                            issueblood.setIssueddate(ar[i + 9]);
                            issuebloodlist.add(issueblood);
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return issuebloodlist;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
