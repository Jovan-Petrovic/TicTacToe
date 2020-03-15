/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Bron Zilar
 */
public class ServerResponse implements Serializable {
    
    private Object response;
    private String message;

    public ServerResponse() {
    }

    public ServerResponse(Object response, String message) {
        this.response = response;
        this.message = message;
    } 

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
