// 2 marks
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThReadQ extends Thread{
BlockingQueue qFileNames;
BlockingQueue qFileArrays ; // 1/2 marks
String  file_info ;
    public ThReadQ (BlockingQueue q ,BlockingQueue q2){ // 1/2 marks
        this.qFileNames = q;
        this.qFileArrays =q2;
    }
    @Override
    public void run() {
        super.run();

        try {
while (!qFileNames.isEmpty()){
           String filename =qFileNames.pop().toString(); // 1/2 marks
        String SFile = FileUtils.readFileAsString(filename);
        char [] c = SFile.toCharArray();
        int numDigit =0 , numLetter =0, numSympol =0;
        for (int ii = 0; ii< SFile.length() ; ii++){

        Character character = new Character (' ');
        if (character.isDigit(c[ii]))
            numDigit ++;
        else if (character.isLetter(c[ii]))
            numLetter ++;
        else
            numSympol ++;
        }
        file_info =filename +" "+numLetter+" ofLetters "+numDigit+" ofDigits "+numSympol+" rest";
        qFileArrays.add(file_info); // 1/2 marks
}


    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());

    } catch (IOException ex) {

        System.out.println(ex.getMessage());
    }

    }



}
