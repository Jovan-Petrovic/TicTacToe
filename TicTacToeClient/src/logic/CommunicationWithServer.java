/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ClientRequest;
import transfer.ServerResponse;

/**
 *
 * @author Bron Zilar
 */
public class CommunicationWithServer {
    private static CommunicationWithServer instance;
    private Socket s;

    public CommunicationWithServer() {
        try {
            s = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CommunicationWithServer getInstance() {
        if(instance == null) {
            instance = new CommunicationWithServer();
        }
        return instance;
    }
    
    public void sendRequest(ClientRequest cr) {
        try {
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           oos.writeObject(cr);
        } catch (IOException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerResponse acceptResponse() {
        ServerResponse sr = new ServerResponse();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            sr = (ServerResponse) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sr;
    }

    public Socket getS() {
        return s;
    }
    
    
}
