/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.UserController;
import common.ijse.rmi.bloodbank.model.User;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.ijse.rmi.bloodbank.fileaccess.UserFileAccess;

/**
 *
 * @author Sandali
 */
public class UserControllerImpl extends UnicastRemoteObject implements UserController {

    private UserFileAccess userFileAccess = new UserFileAccess();

    public UserControllerImpl() throws RemoteException {
    }

    public boolean addUser(User user) throws RemoteException, ClassNotFoundException, IOException {
        return userFileAccess.addUser(user);
    }


    public boolean checkUser(String username) throws RemoteException, ClassNotFoundException, IOException {
        return userFileAccess.checkUser(username);
    }


    public boolean checkPassword(String username, String password) throws RemoteException, ClassNotFoundException, IOException {
         return userFileAccess.checkPassword(username,password);
    }
}
