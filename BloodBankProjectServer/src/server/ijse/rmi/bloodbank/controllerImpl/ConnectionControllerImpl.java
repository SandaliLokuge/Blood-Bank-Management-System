/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.ConnectionController;
import common.ijse.rmi.bloodbank.model.Connection;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.ijse.rmi.bloodbank.fileaccess.ConnectionFileAccess;

/**
 *
 * @author Sandali
 */
public class ConnectionControllerImpl extends UnicastRemoteObject implements ConnectionController {

    private ConnectionFileAccess connectionFileAccess = new ConnectionFileAccess();

    public ConnectionControllerImpl() throws RemoteException {
    }

    public boolean addConnection(Connection connection) throws RemoteException, ClassNotFoundException, IOException {
        return connectionFileAccess.addConnection(connection);
    }

    public boolean deleteConnection(String date) throws RemoteException, ClassNotFoundException, IOException {
        return connectionFileAccess.deleteConnection(date);
    }

    public List<Connection> getConnectionList() throws RemoteException, ClassNotFoundException, IOException {
        return connectionFileAccess.getConnectionList();
    }
}
