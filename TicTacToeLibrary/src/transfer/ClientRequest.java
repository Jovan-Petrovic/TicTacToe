/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Bron Zilar
 */
public class ClientRequest implements Serializable {
    
    private int operation;
    private Object parametar;

    public ClientRequest() {
    }

    public ClientRequest(int operation, Object parametar) {
        this.operation = operation;
        this.parametar = parametar;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
        
}
