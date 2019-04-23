
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yhyar
 */
public class JThread extends Thread{

  public  BlockingQueue q = new BlockingQueue(100);

    
    
    @Override
    public void run() {
          
        for (int i=0 ; i<100 ; i++)
            try {
                Homework.blockingQueueNames.add("data\\f"+i+".txt"); //f0.txt --> f99.txt
                
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
       
    }
   
    public BlockingQueue get(){
    return q;
    }
    
    
}
