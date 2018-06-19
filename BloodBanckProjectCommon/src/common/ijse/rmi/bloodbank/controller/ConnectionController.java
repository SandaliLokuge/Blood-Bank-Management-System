/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.Connection;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Sandali
 */
public interface ConnectionController extends Remote{
    public boolean addConnection(Connection connection)throws RemoteException, ClassNotFoundException, IOException;
    public boolean deleteConnection(String date)throws RemoteException, ClassNotFoundException, IOException;
    public List<Connection> getConnectionList()throws RemoteException, ClassNotFoundException, IOException;
}
