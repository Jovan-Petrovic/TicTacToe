/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import threads.ServerStart;

/**
 *
 * @author Bron Zilar
 */
public class Server {
    
    public static void main(String[] args) {
        ServerStart ss = new ServerStart();
        ss.start();
    }
}
