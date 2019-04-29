// 2 marks
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadResultReadQ extends Thread{
BlockingQueue qFileNames; // 1/2 marks
public ThreadResultReadQ (BlockingQueue q){ // 1/2 marks
qFileNames = q;
}
    @Override
    public void run() {
        super.run();
    try {
       for(int i=0; i<100; i++){ // 1/2 marks
        String result =  qFileNames.pop().toString(); // 1/2 marks

        FileUtils.appendStringToFile("result2019.txt", result);
        }

    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
    } catch (IOException ex) {

        System.out.println(ex.getMessage());
    }
    }

}
