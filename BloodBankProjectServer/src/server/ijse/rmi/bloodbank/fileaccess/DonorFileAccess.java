package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Donor;
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

public class DonorFileAccess {

    private final File file = new File("DataAccess/donorDataAccess.txt");
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addDonor(Donor donor) throws RemoteException, ClassNotFoundException, IOException {

        try {
            readWriteLock.writeLock().lock();
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                data = donor.getDonorid() + "$";
                data += donor.getTitle() + "$";
                data += donor.getFirstname() + "$";
                data += donor.getLastname() + "$";
                data += donor.getRegdate() + "$";
                data += donor.getGender() + "$";
                data += donor.getNic() + "$";
                data += donor.getTelhome() + "$";
                data += donor.getMobile() + "$";
                data += donor.getAddress() + "$";
                data += donor.getDateofbirth() + "$";
                data += donor.getAge() + "$";
                data += donor.getBloodgroup() + "$";
                data += donor.getRhfactor() + "$";

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

    public boolean updateDonor(Donor donor) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.writeLock().lock();
            FileWriter fileWriter = null;
            try {
                if (file.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line = bufferedReader.readLine();
                    StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
                    String ar[] = new String[stringTokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        if (stringTokenizer.hasMoreTokens()) {
                            ar[i] = stringTokenizer.nextToken();
                        }
                    }
                    for (int i = 0; i < ar.length; i += 14) {
                        if (donor.getDonorid().equals(ar[i])) {
                            ar[i + 1] = donor.getTitle();
                            ar[i + 2] = donor.getFirstname();
                            ar[i + 3] = donor.getLastname();
                            ar[i + 4] = donor.getRegdate();
                            ar[i + 5] = donor.getGender();
                            ar[i + 6] = donor.getNic();
                            ar[i + 7] = donor.getTelhome();
                            ar[i + 8] = donor.getMobile();
                            ar[i + 9] = donor.getAddress();
                            ar[i + 10] = donor.getDateofbirth();
                            ar[i + 11] = donor.getAge();
                            ar[i + 12] = donor.getBloodgroup();
                            ar[i + 13] = donor.getRhfactor();
                            break;
                        }
                    }
                    fileWriter = new FileWriter(file);

                    for (String data : ar) {
                        fileWriter.append(data + "$");
                    }
                    fileWriter.flush();
                    return true;

                } else {
                    return false;
                }
            } finally {
                fileWriter.close();
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Donor searchDonorBynic(String nic) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
                String ar[] = new String[stringTokenizer.countTokens()];
                for (int i = 0; i < ar.length; i++) {
                    if (stringTokenizer.hasMoreTokens()) {
                        ar[i] = stringTokenizer.nextToken();
                    }
                }
                Donor donor = null;
                for (int i = 6; i < ar.length; i += 14) {
                    if (nic.equals(ar[i])) {
                        donor = new Donor();
                        donor.setDonorid(ar[i - 6]);
                        donor.setTitle(ar[i - 5]);
                        donor.setFirstname(ar[i - 4]);
                        donor.setLastname(ar[i - 3]);
                        donor.setRegdate(ar[i - 2]);
                        donor.setGender(ar[i - 1]);
                        donor.setNic(ar[i]);
                        donor.setTelhome(ar[i + 1]);
                        donor.setMobile(ar[i + 2]);
                        donor.setAddress(ar[i + 3]);
                        donor.setDateofbirth(ar[i + 4]);
                        donor.setAge(ar[i + 5]);
                        donor.setBloodgroup(ar[i + 6]);
                        donor.setRhfactor(ar[i + 7]);


                        break;
                    }
                }
                return donor;
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public Donor searchDonorByid(String donorid) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
                String ar[] = new String[stringTokenizer.countTokens()];
                for (int i = 0; i < ar.length; i++) {
                    if (stringTokenizer.hasMoreTokens()) {
                        ar[i] = stringTokenizer.nextToken();
                    }
                }
                Donor donor = null;
                for (int i = 0; i < ar.length; i += 14) {
                    if (donorid.equals(ar[i])) {
                        donor = new Donor();
                        donor.setDonorid(ar[i]);
                        donor.setTitle(ar[i + 1]);
                        donor.setFirstname(ar[i + 2]);
                        donor.setLastname(ar[i + 3]);
                        donor.setRegdate(ar[i + 4]);
                        donor.setGender(ar[i + 5]);
                        donor.setNic(ar[i + 6]);
                        donor.setTelhome(ar[i + 7]);
                        donor.setMobile(ar[i + 8]);
                        donor.setAddress(ar[i + 9]);
                        donor.setDateofbirth(ar[i + 10]);
                        donor.setAge(ar[i + 11]);
                        donor.setBloodgroup(ar[i + 12]);
                        donor.setRhfactor(ar[i + 13]);
                        break;
                    }
                }
                return donor;
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<Donor> getallDonors() throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<Donor> donors = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    donors = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    for (int i = 0; i < ar.length; i += 14) {
                        donors.add(new Donor(ar[i], ar[i + 1], ar[i + 2], ar[i + 3], ar[i + 4], ar[i + 5], ar[i + 6], ar[i + 7], ar[i + 8], ar[i + 9], ar[i + 10], ar[i + 11], ar[i + 12], ar[i + 13]));
                    }
                }

            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return donors;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public String getLastId() throws RemoteException, ClassNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        if (line != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
            String ar[] = new String[stringTokenizer.countTokens()];
            for (int i = 0; i < ar.length; i++) {
                if (stringTokenizer.hasMoreTokens()) {
                    ar[i] = stringTokenizer.nextToken();
                }
            }
            return ar[ar.length - 14].toString();
        } else {
            return null;
        }
    }

    public List<Donor> getallDonorsbybloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<Donor> donors = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    donors = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    Donor donor = null;
                    for (int i = 12; i < ar.length; i += 14) {
                        if (bloodgroup.equals(ar[i])) {
                            donor = new Donor();
                            donor.setDonorid(ar[i - 12]);
                            donor.setTitle(ar[i - 11]);
                            donor.setFirstname(ar[i - 10]);
                            donor.setLastname(ar[i - 9]);
                            donor.setRegdate(ar[i - 8]);
                            donor.setGender(ar[i - 7]);
                            donor.setNic(ar[i - 6]);
                            donor.setTelhome(ar[i - 5]);
                            donor.setMobile(ar[i - 4]);
                            donor.setAddress(ar[i - 3]);
                            donor.setDateofbirth(ar[i - 2]);
                            donor.setAge(ar[i - 1]);
                            donor.setBloodgroup(ar[i]);
                            donor.setRhfactor(ar[i + 1]);
                            donors.add(donor);
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return donors;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
