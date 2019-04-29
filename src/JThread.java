// 2 marks
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

  public  BlockingQueue q; // 1/2 marks

    public JThread(BlockingQueue q) { // 1/2 marks
this.q=q;
    }





    @Override
    public void run() {


            try {
                  for (int i=0 ; i<100 ; i++) // 1/2 marks
               q.add("data\\f"+i+".txt"); //f0.txt --> f99.txt // 1/2 marks

            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

    }




}
