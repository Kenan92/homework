
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadResultReadQ extends Thread{
BlockingQueue qFileNames;
public ThreadResultReadQ (BlockingQueue q){
qFileNames = q;
}
    @Override
    public void run() {
        super.run(); 
    try {
       for(int i=0; i<100; i++){
        String result =  Homework.blockingQueueNames.pop().toString();
           System.out.println(result.isEmpty());
        FileUtils.appendStringToFile("result2019.txt", result);
        }
        
    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
    } catch (IOException ex) {
      
        System.out.println(ex.getMessage());
    }
    }
    
}
