
import java.io.IOException;




//by



//yhya rakmani
//kenan alhamoud
//hanadi ali


public class Homework {

    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingQueue blockingQueueinfo = new BlockingQueue(100);
 BlockingQueue blockingQueueNames = new BlockingQueue(100);
     JThread jf = new JThread(blockingQueueNames);
     Thread th1 =new Thread (jf);
     th1.start();
   
     ThReadQ [] thReadQs  = new ThReadQ[8];
     for (int i= 0 ; i<8 ; i++){
        
     thReadQs [i]= new ThReadQ(blockingQueueNames,blockingQueueinfo);
     thReadQs[i].start();
        
     }
   
     
     ThreadResultReadQ threadResultReadQ = new ThreadResultReadQ(blockingQueueinfo); 
   
     threadResultReadQ.start();
     th1.join();
     for (int i= 0 ; i<8 ; i++){
     thReadQs[i].join();
     }
     threadResultReadQ.join();
    }
    
}
