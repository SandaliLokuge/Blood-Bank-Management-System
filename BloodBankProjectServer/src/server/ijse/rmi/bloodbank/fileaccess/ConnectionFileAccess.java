/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.fileaccess;


import common.ijse.rmi.bloodbank.model.Connection;
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

/**
 *
 * @author Sandali
 */
public class ConnectionFileAccess {

    private final File file = new File("DataAccess/connectionDataAccess.txt");

    public boolean addConnection(Connection connection) throws RemoteException, ClassNotFoundException, IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            String data = "";
            data += connection.getUsername() + "$";
            data += connection.getDate() + "$";
            data += connection.getTime() + "$";
            data += connection.getPort() + "$";
            data += connection.getMessage() + "$";

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

    public boolean deleteConnection(String date) throws RemoteException, ClassNotFoundException, IOException {
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
    }

    public List<Connection> getConnectionList() throws RemoteException, ClassNotFoundException, IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Connection> connections = null;
        try {
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();

                if (line != null) {
                    StringTokenizer tokenizer = new StringTokenizer(line, "$");

                    connections = new ArrayList<>();

                    String[] ar = new String[tokenizer.countTokens()];
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = tokenizer.nextToken();
                    }
                    for (int i = 0; i < ar.length; i += 5) {
                        connections.add(new Connection(ar[i], ar[i + 1], ar[i + 2], ar[i + 3], ar[i + 4]));
                    }
                }
            }
        } finally {
            fileReader.close();
            bufferedReader.close();
        }
        return connections;
    }
}
