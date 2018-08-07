/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapthread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class buoi9 {
    public static DuLieu duLieu;
    
    public static void main(String[] args) {
        duLieu= new DuLieu();
        duLieu.setLaCo(1);
       Thread threadA= new Thread(new Runnable() {
           @Override
           public void run() {
               synchronized(duLieu){
                   for (int i = 0; i < 100;) {
                       try {
                           if(duLieu.getLaCo()==1){
                               int a=new Random().nextInt(100);
                               System.out.println("A:"+a);
                               duLieu.setA(a);
                               Thread.sleep(33);
                               i++;
                               duLieu.setLaCo(2);
                               duLieu.notifyAll();
                               
                           }else{
                              duLieu.wait();
                           }
                           
                       } catch (InterruptedException ex) {
                           Logger.getLogger(buoi9.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       
                   }
               
           }
       }});
       Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(duLieu){
                    for (int i = 0; i < 100; ) {
                        try {
                            if(duLieu.getLaCo()==2){
                                int b= new Random().nextInt(100);
                                System.out.println("B:"+b);
                                duLieu.setB(b);
                                 Thread.sleep(33);
                                 i++;
                                 duLieu.setLaCo(3);
                                 duLieu.notifyAll();
                            }else{
                                duLieu.wait();
                            }
                           
                        } catch (InterruptedException ex) {
                            Logger.getLogger(buoi9.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }});
    }
    Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(duLieu){
                    for (int i = 0; i < 100; ) {
                        try {
                            if(duLieu.getLaCo()==3){
                                
                                System.out.println("Tong :"+duLieu.tinhTong());
                               
                                 Thread.sleep(33);
                                 
                                 duLieu.setLaCo(1);
                                 duLieu.notifyAll();
                            }else{
                                duLieu.wait();
                            }
                           
                        } catch (InterruptedException ex) {
                            Logger.getLogger(buoi9.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }});
    
    
   
}

