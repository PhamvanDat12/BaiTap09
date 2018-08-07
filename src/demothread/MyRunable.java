/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MyRunable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("cc");
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyRunable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    
}
