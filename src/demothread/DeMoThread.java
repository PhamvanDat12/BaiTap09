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
public class DeMoThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          MyThread mt=new MyThread();
        mt.start();
         MyRunable myRunable= new MyRunable();
        Thread thread= new Thread(myRunable);
        thread.start();
      
        for (int i = 0; i < 100; i++) {
            System.out.println("a");
            
        }
        Thread threadl;
        threadl = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("kk");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DeMoThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          });
       
       threadl.start();
       
    }
    
}
