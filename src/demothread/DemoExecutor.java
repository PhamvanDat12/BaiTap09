/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DemoExecutor {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);//chi tao ra 3 long trong he thong;
        newFixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        newFixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        newFixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("cccccccccccccccccccccccccc");
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Future<String> future= newFixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    System.out.println("eeeeeeeeeeeeeeeee");
                }
                return "ok ok";
            }
            
        })  ;
        newFixedThreadPool.shutdown();
        try {
            //main sẽ hưng về cai ok ok;
            future.get();
            //hàm này sẽ chờ call ở trong call ở trong thread kia chạy xong thì mới chạy 
        } catch (InterruptedException ex) {
            Logger.getLogger(DemoExecutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(DemoExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    
    
}
