
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThReadQ extends Thread{
BlockingQueue qFileNames;
BlockingQueue qFileArrays ;
String  file_info ;
    public ThReadQ (BlockingQueue q ,BlockingQueue q2){
        this.qFileNames = q;
        this.qFileArrays =q2;
    }
    @Override
    public void run() {
        super.run(); 
  
        try {
while (!qFileNames.isEmpty()){
           String filename =qFileNames.pop().toString();
        String SFile = FileUtils.readFileAsString(filename);
       
        int numDigit =0 , numLetter =0, numSympol =0;
        for (int ii = 0; ii< SFile.length() ; ii++){
        char [] c = SFile.toCharArray();
        Character character = new Character (' ');
        if (character.isDigit(c[ii]))
            numDigit ++;
        else if (character.isLetter(c[ii]))
            numLetter ++;
        else 
            numSympol ++;
        }
        file_info =filename +" "+numLetter+" ofLetters "+numDigit+" ofDigits "+numSympol+" rest";
        qFileArrays.add(file_info);
}
        
        
    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
      
    } catch (IOException ex) {
        
        System.out.println(ex.getMessage());
    }
    
    }
    
  
    
}
