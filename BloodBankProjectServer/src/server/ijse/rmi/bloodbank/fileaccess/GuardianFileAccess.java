package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.Guardian;
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

public class GuardianFileAccess {

    private final File file = new File("DataAccess/guardianDataAccess.txt");
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addGuardian(Guardian guardian) throws RemoteException, ClassNotFoundException, IOException {
        try {
            readWriteLock.writeLock().lock();
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                data += guardian.getGuardianid() + "$";
                data += guardian.getTitle() + "$";
                data += guardian.getFirstname() + "$";
                data += guardian.getLastname() + "$";
                data += guardian.getGender() + "$";
                data += guardian.getNic() + "$";
                data += guardian.getMobile() + "$";
                data += guardian.getTelhome() + "$";
                data += guardian.getAddress() + "$";

                fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(data);
                bufferedWriter.flush();

            } finally {
                fileWriter.close();
                bufferedWriter.close();
            }
            return true;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Guardian searchGuardianByid(String guardianid) throws RemoteException, ClassNotFoundException, IOException {
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
                Guardian guardian = null;
                for (int i = 0; i < ar.length; i += 9) {
                    if (guardianid.equals(ar[i])) {
                        guardian = new Guardian();
                        guardian.setGuardianid(ar[i]);
                        guardian.setTitle(ar[i + 1]);
                        guardian.setFirstname(ar[i + 2]);
                        guardian.setLastname(ar[i + 3]);
                        guardian.setGender(ar[i + 4]);
                        guardian.setNic(ar[i + 5]);
                        guardian.setMobile(ar[i + 6]);
                        guardian.setTelhome(ar[i + 7]);
                        guardian.setAddress(ar[i + 8]);
                        break;
                    }
                }

                return guardian;
            } else {

                return null;
            }
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
            return ar[ar.length - 9].toString();
        } else {
            return null;
        }
    }
}
