
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThReadQ extends Thread{
BlockingQueue qFileNames;
BlockingQueue qFileArrays ;
String  file_info ;
int start , end;
    public ThReadQ (BlockingQueue q ,BlockingQueue q2){
        this.qFileNames = q;
        this.qFileArrays =q2;
    }
    @Override
    public void run() {
        super.run(); 
  
        try {
         
           String filename =Homework.blockingQueueNames.pop().toString();
            System.out.println(filename);
        String SFile = FileUtils.readFileAsString(filename);
       
        int numDigit =0 , numLetter =0, numSympol =0;
        for (int i = 0; i< SFile.length() ; i++){
        char [] c = SFile.toCharArray();
        Character character = new Character (' ');
        if (character.isDigit(c[i]))
            numDigit ++;
        else if (character.isLetter(c[i]))
            numLetter ++;
        else 
            numSympol ++;
        }
        file_info =filename +" "+numLetter+" ofLetters "+numDigit+" ofDigits "+numSympol+" rest";
        Homework.blockingQueue.add(file_info);
        
    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
      
    } catch (IOException ex) {
        
        System.out.println(ex.getMessage());
    }
    
    }
    
  
    
}
