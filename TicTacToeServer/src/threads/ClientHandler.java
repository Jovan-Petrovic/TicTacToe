/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ClientRequest;
import transfer.ServerResponse;
import util.Operations;

/**
 *
 * @author Bron Zilar
 */
public class ClientHandler extends Thread {
    Socket s1;
    Socket s2;
    char player;

    public ClientHandler(Socket s1, Socket s2, char value) {
        this.s1 = s1;
        this.s2 = s2;
        this.player = value;
    }
    
    
    @Override
    public void run() {
        sendResponse1(new ServerResponse('X', "Player X"));
        while (true) {            
            ClientRequest cr = acceptRequest();
            ServerResponse sr = new ServerResponse();
             
            switch(cr.getOperation()) {
                case Operations.writeX:
                    Map<String, Object> data1 = new HashMap<>();
                    data1.put("sign", "X");
                    int number1 = (int) cr.getParametar();
                    data1.put("number", number1);
                    sr.setResponse(data1);
                    break;
                case Operations.writeO:
                    Map<String, Object> data2 = new HashMap<>();
                    data2.put("sign", "O");
                    int number2 = (int) cr.getParametar();
                    data2.put("number", number2);
                    sr.setResponse(data2);
                    break;
            }                       
            sendResponse(sr);
        }
        
    }

    private ClientRequest acceptRequest() {
        ClientRequest cr = new ClientRequest();
        try {
            ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
            cr = (ClientRequest) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cr;
    }
    
    private void sendResponse(ServerResponse sr) {
        try {
            ObjectOutputStream oos1 = new ObjectOutputStream(s1.getOutputStream());
            ObjectOutputStream oos2 = new ObjectOutputStream(s2.getOutputStream());
            oos1.writeObject(sr);
            oos2.writeObject(sr);
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendResponse1(ServerResponse sr) {
        try {
            ObjectOutputStream oos1 = new ObjectOutputStream(s1.getOutputStream());
            oos1.writeObject(sr);
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}
