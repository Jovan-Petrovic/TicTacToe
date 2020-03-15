/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import form.ClientForm;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.CommunicationWithServer;
import transfer.ServerResponse;

/**
 *
 * @author Bron Zilar
 */
public class AcceptingResponses extends Thread {

    ClientForm clientForm;
    
    public AcceptingResponses(ClientForm clientForm) {
        this.clientForm = clientForm;
    }

    
    @Override
    public void run() {
        while(true) {
            ServerResponse sr = CommunicationWithServer.getInstance().acceptResponse();
            this.clientForm.setValue(sr);
            if(!this.clientForm.isFlag3()) {
                if(this.clientForm.getJbtnPlay().isEnabled()) {
                    this.clientForm.getJlabTurn().setText("It's your turn to play.");
                    this.clientForm.getJlabTurn().setForeground(Color.BLUE);
                } else {
                    this.clientForm.getJlabTurn().setText("It's opponent turn to play.");
                    this.clientForm.getJlabTurn().setForeground(Color.RED);
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(AcceptingResponses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
