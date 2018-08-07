/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DemoDongBo {
    static AtomicInteger laCo=new AtomicInteger(0);
    
    public static void main(String[] args) {
        
        Thread threadChan= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(laCo){
                for (int i = 0; i < 100; i+=2) {
                    System.out.println(i);
                    try {
                        if(laCo.get()==0){
                            System.out.println(i);
                            Thread.sleep(200);
                            //lam xong viec;
                            laCo.set(1);//chuyeern la co cho thang khac;
                            laCo.notifyAll();
                        }else{
                            laCo.wait();
                        }
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DemoDongBo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            }
            }});
        
         Thread threadLe= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(laCo){
                for (int i = 0; i < 100; i+=2) {
                    System.out.println(i);
                    try {
                        if(laCo.get()==1){
                            System.out.println(i);
                            Thread.sleep(200);
                            //lam xong viec;
                            laCo.set(0);//chuyeern la co cho thang khac;
                            laCo.notifyAll();
                        }else{
                            laCo.wait();
                        }
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DemoDongBo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            }
            }});
         threadChan.start();
         threadLe.start();
    }
    
    
}
