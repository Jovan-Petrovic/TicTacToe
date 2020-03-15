/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class ServerStart extends Thread {
    
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server started");
            Socket s1 = ss.accept();
            System.out.println("First client is connected. Waiting for second...");
            Socket s2 = ss.accept();
            System.out.println("Second client is connected.");
            ClientHandler ch1 = new ClientHandler(s1, s2, 'X');
            ch1.start();
            ClientHandler2 ch2 = new ClientHandler2(s1, s2, 'O');
            ch2.start();
        } catch (IOException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
