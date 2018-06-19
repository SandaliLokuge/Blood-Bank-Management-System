package server.ijse.rmi.bloodbank.observerble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import common.ijse.rmi.bloodbank.observer.IssuebloodObserver;

public class IssuedbloodObserverble {

    private String message;
    private static List<IssuebloodObserver> observerList = new ArrayList<>();

    public void addIssuebloodObserver(IssuebloodObserver issuebloodObserver) {
        observerList.add(issuebloodObserver);
    }

    public void removeIssuebloodObserver(IssuebloodObserver issuebloodObserver) {
        observerList.remove(issuebloodObserver);
    }

    public void notifyIssuebloodObserver() throws RemoteException {
        for (IssuebloodObserver issuebloodObserver : observerList) {
            issuebloodObserver.Update(message);

        }
    }

    public void setMessage(String message) throws RemoteException {
        if (this.message != message) {
            this.message = message;
            notifyIssuebloodObserver();

        }
    }
}
