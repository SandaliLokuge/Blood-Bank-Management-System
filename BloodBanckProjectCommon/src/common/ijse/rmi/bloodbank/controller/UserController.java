/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.User;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sandali
 */
public interface UserController extends Remote{
    public boolean addUser(User user) throws RemoteException, ClassNotFoundException, IOException;
    public boolean checkUser(String username) throws RemoteException, ClassNotFoundException, IOException;
    public boolean checkPassword(String username,String password) throws RemoteException, ClassNotFoundException, IOException;
    
}
