
import java.io.IOException;




//by



//yhya rakmani
//kenan alhamoud
//hanadi ali


public class Homework {
 public static BlockingQueue blockingQueue = new BlockingQueue(100);
 public static BlockingQueue blockingQueueNames = new BlockingQueue(100);
    public static void main(String[] args) throws InterruptedException, IOException {
     JThread jf = new JThread();
     jf.start();
     jf.join();
   
     ThReadQ [] thReadQs  = new ThReadQ[100];
//     for (int i= 0 ; i<8 ; i++){
//         if (i<7){
//     thReadQs [i]= new ThReadQ(jf.get(),blockingQueue ,i*12,i*12+11);
//         }else 
//             
//     thReadQs [i]= new ThReadQ(jf.get(),blockingQueue ,i*12,99);
//     thReadQs[i].start();
//     
//     }
     for (int i = 0 ; i<100 ; i++){
     
     thReadQs[i] =new ThReadQ(jf.get(), blockingQueue);
     thReadQs[i].start();
     }
     for (int i= 0 ; i<100 ; i++){
     thReadQs[i].join();
     }
    
      for (int i= 0 ; i<100 ; i++){
     ThreadResultReadQ threadResultReadQ = new ThreadResultReadQ(blockingQueue);

  
    }
// FileUtils.appendStringToFile("yhya.txt","yhya yy");
    }
    
}
