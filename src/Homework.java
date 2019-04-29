// 2 marks
import java.io.IOException;




//by



//yhya rakmani
//kenan alhamoud
//hanadi ali


public class Homework {

    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingQueue blockingQueueinfo = new BlockingQueue(100);
 BlockingQueue blockingQueueNames = new BlockingQueue(100); // 1/2 marks
     JThread jf = new JThread(blockingQueueNames); // 1/2 marks
     Thread th1 =new Thread (jf);
     th1.start();

     ThReadQ [] thReadQs  = new ThReadQ[8]; // 1/2 marks
     for (int i= 0 ; i<8 ; i++){

     thReadQs [i]= new ThReadQ(blockingQueueNames,blockingQueueinfo);
     thReadQs[i].start();

     }


     ThreadResultReadQ threadResultReadQ = new ThreadResultReadQ(blockingQueueinfo);

     threadResultReadQ.start();
     th1.join(); // 1/2 marks
     for (int i= 0 ; i<8 ; i++){
     thReadQs[i].join();
     }
     threadResultReadQ.join();
    }

}
