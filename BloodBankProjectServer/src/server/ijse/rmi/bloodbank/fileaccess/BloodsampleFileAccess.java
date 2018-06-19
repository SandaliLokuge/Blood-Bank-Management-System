package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Donor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.RemoteException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.ArrayList;

public class BloodsampleFileAccess {

    private final File file = new File("DataAccess/bloodsampleDataAccess.txt");
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addBloodSample(BloodSample bloodsample) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.writeLock().lock();
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                data += bloodsample.getDonorid() + "$";
                data += bloodsample.getBloodbagid() + "$";
                data += bloodsample.getDonatedate() + "$";
                data += bloodsample.getBloodgroup() + "$";
                data += bloodsample.getDonationtype() + "$";
                data += bloodsample.getRhfactor() + "$";
                data += bloodsample.getBodyweight() + "$";
                data += bloodsample.getBodytemp() + "$";
                data += bloodsample.getPulserate() + "$";
                data += bloodsample.getBloodpressure() + "$";
                data += bloodsample.getQty() + "$";
                data += bloodsample.getTestdate() + "$";
                data += bloodsample.getReportno() + "$";
                data += bloodsample.getHbsag() + "$";
                data += bloodsample.getHiv() + "$";
                data += bloodsample.getHcv() + "$";
                data += bloodsample.getMalariya() + "$";

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

    public List<BloodSample> getallBloodSamples() throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<BloodSample> bloodsamples = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();

                    if (line != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, "$");

                        bloodsamples = new ArrayList<>();

                        String[] ar = new String[tokenizer.countTokens()];
                        for (int i = 0; i < ar.length; i++) {
                            ar[i] = tokenizer.nextToken();
                        }
                        for (int i = 0; i < ar.length; i += 17) {
                            bloodsamples.add(new BloodSample(ar[i], ar[i + 1], ar[i + 2], ar[i + 3], ar[i + 4], ar[i + 5], ar[i + 6], ar[i + 7], ar[i + 8], ar[i + 9], ar[i + 10], ar[i + 11], ar[i + 12], ar[i + 13], ar[i + 14], ar[i + 15], ar[i + 16]));
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return bloodsamples;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public BloodSample searchBloodSample(String donorid) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                BloodSample bloodsample = null;
                if (line != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, "$");
                    String ar[] = new String[stringTokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        if (stringTokenizer.hasMoreTokens()) {
                            ar[i] = stringTokenizer.nextToken();
                        }
                    }

                    for (int i = 0; i < ar.length; i += 17) {

                        if (donorid.equals(ar[i])) {
                            bloodsample = new BloodSample();
                            bloodsample.setDonorid(ar[i]);
                            bloodsample.setBloodbagid(ar[i + 1]);
                            bloodsample.setDonatedate(ar[i + 2]);
                            bloodsample.setBloodgroup(ar[i + 3]);
                            bloodsample.setDonationtype(ar[i + 4]);
                            bloodsample.setRhfactor(ar[i + 5]);
                            bloodsample.setBodyweight(ar[i + 6]);
                            bloodsample.setBodytemp(ar[i + 7]);
                            bloodsample.setPulserate(ar[i + 8]);
                            bloodsample.setBloodpressure(ar[i + 9]);
                            bloodsample.setQty(ar[i + 10]);
                            bloodsample.setTestdate(ar[i + 11]);
                            bloodsample.setReportno(ar[i + 12]);
                            bloodsample.setHbsag(ar[i + 13]);
                            bloodsample.setHiv(ar[i + 14]);
                            bloodsample.setHcv(ar[i + 15]);
                            bloodsample.setMalariya(ar[i + 16]);
                            break;
                        }
                    }
                }
                return bloodsample;
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<BloodSample> getBloodSamplesbyBloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<BloodSample> bloodsamples = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, "$");

                        bloodsamples = new ArrayList<>();
                        String[] ar = new String[tokenizer.countTokens()];
                        for (int i = 0; i < ar.length; i++) {
                            ar[i] = tokenizer.nextToken();
                        }
                        BloodSample bloodsample = null;
                        for (int i = 0; i < ar.length; i += 17) {
                            if (bloodgroup.equals(ar[i + 3])) {
                                bloodsample = new BloodSample();
                                bloodsample.setDonorid(ar[i]);
                                bloodsample.setBloodbagid(ar[i + 1]);
                                bloodsample.setDonatedate(ar[i + 2]);
                                bloodsample.setBloodgroup(ar[i + 3]);
                                bloodsample.setDonationtype(ar[i + 4]);
                                bloodsample.setRhfactor(ar[i + 5]);
                                bloodsample.setBodyweight(ar[i + 6]);
                                bloodsample.setBodytemp(ar[i + 7]);
                                bloodsample.setPulserate(ar[i + 8]);
                                bloodsample.setBloodpressure(ar[i + 9]);
                                bloodsample.setQty(ar[i + 10]);
                                bloodsample.setTestdate(ar[i + 11]);
                                bloodsample.setReportno(ar[i + 12]);
                                bloodsample.setHbsag(ar[i + 13]);
                                bloodsample.setHiv(ar[i + 14]);
                                bloodsample.setHcv(ar[i + 15]);
                                bloodsample.setMalariya(ar[i + 16]);
                                bloodsamples.add(bloodsample);
                            }
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return bloodsamples;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<BloodSample> getBloodSamplesbyBloodcomp(String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<BloodSample> bloodsamples = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, "$");

                        bloodsamples = new ArrayList<>();
                        String[] ar = new String[tokenizer.countTokens()];
                        for (int i = 0; i < ar.length; i++) {
                            ar[i] = tokenizer.nextToken();
                        }
                        BloodSample bloodsample = null;
                        for (int i = 0; i < ar.length; i += 17) {
                            if (bloodcomponent.equals(ar[i + 4])) {
                                bloodsample = new BloodSample();
                                bloodsample.setDonorid(ar[i]);
                                bloodsample.setBloodbagid(ar[i + 1]);
                                bloodsample.setDonatedate(ar[i + 2]);
                                bloodsample.setBloodgroup(ar[i + 3]);
                                bloodsample.setDonationtype(ar[i + 4]);
                                bloodsample.setRhfactor(ar[i + 5]);
                                bloodsample.setBodyweight(ar[i + 6]);
                                bloodsample.setBodytemp(ar[i + 7]);
                                bloodsample.setPulserate(ar[i + 8]);
                                bloodsample.setBloodpressure(ar[i + 9]);
                                bloodsample.setQty(ar[i + 10]);
                                bloodsample.setTestdate(ar[i + 11]);
                                bloodsample.setReportno(ar[i + 12]);
                                bloodsample.setHbsag(ar[i + 13]);
                                bloodsample.setHiv(ar[i + 14]);
                                bloodsample.setHcv(ar[i + 15]);
                                bloodsample.setMalariya(ar[i + 16]);
                                bloodsamples.add(bloodsample);
                            }
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return bloodsamples;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<BloodSample> getBloodSamples(String bloodgroup, String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<BloodSample> bloodsamples = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, "$");

                        bloodsamples = new ArrayList<>();
                        String[] ar = new String[tokenizer.countTokens()];
                        for (int i = 0; i < ar.length; i++) {
                            ar[i] = tokenizer.nextToken();
                        }
                        BloodSample bloodsample = null;
                        for (int i = 0; i < ar.length; i += 17) {
                            if (bloodgroup.equals(ar[i + 3]) && bloodcomponent.equals(ar[i + 4])) {
                                bloodsample = new BloodSample();
                                bloodsample.setDonorid(ar[i]);
                                bloodsample.setBloodbagid(ar[i + 1]);
                                bloodsample.setDonatedate(ar[i + 2]);
                                bloodsample.setBloodgroup(ar[i + 3]);
                                bloodsample.setDonationtype(ar[i + 4]);
                                bloodsample.setRhfactor(ar[i + 5]);
                                bloodsample.setBodyweight(ar[i + 6]);
                                bloodsample.setBodytemp(ar[i + 7]);
                                bloodsample.setPulserate(ar[i + 8]);
                                bloodsample.setBloodpressure(ar[i + 9]);
                                bloodsample.setQty(ar[i + 10]);
                                bloodsample.setTestdate(ar[i + 11]);
                                bloodsample.setReportno(ar[i + 12]);
                                bloodsample.setHbsag(ar[i + 13]);
                                bloodsample.setHiv(ar[i + 14]);
                                bloodsample.setHcv(ar[i + 15]);
                                bloodsample.setMalariya(ar[i + 16]);
                                bloodsamples.add(bloodsample);
                            }
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return bloodsamples;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public List<BloodSample> getDonations(String donorid) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            List<BloodSample> donations = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);

                    String line = bufferedReader.readLine();
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    donations = new ArrayList<>();
                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    BloodSample bloodsample = null;
                    for (int i = 0; i < ar.length; i += 17) {
                        if (donorid.equals(ar[i])) {
                            bloodsample = new BloodSample();
                            bloodsample.setDonorid(ar[i]);
                            bloodsample.setBloodbagid(ar[i + 1]);
                            bloodsample.setDonatedate(ar[i + 2]);
                            bloodsample.setBloodgroup(ar[i + 3]);
                            bloodsample.setDonationtype(ar[i + 4]);
                            bloodsample.setRhfactor(ar[i + 5]);
                            bloodsample.setBodyweight(ar[i + 6]);
                            bloodsample.setBodytemp(ar[i + 7]);
                            bloodsample.setPulserate(ar[i + 8]);
                            bloodsample.setBloodpressure(ar[i + 9]);
                            bloodsample.setQty(ar[i + 10]);
                            bloodsample.setTestdate(ar[i + 11]);
                            bloodsample.setReportno(ar[i + 12]);
                            bloodsample.setHbsag(ar[i + 13]);
                            bloodsample.setHiv(ar[i + 14]);
                            bloodsample.setHcv(ar[i + 15]);
                            bloodsample.setMalariya(ar[i + 16]);
                            donations.add(bloodsample);
                        }
                    }
                }
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
            return donations;
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
            return ar[ar.length - 16].toString();
        } else {
            return null;
        }
    }
}
