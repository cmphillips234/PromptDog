package core;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class PdProcess {

    PdProcess() {
        
    }
   
    public void GoldenRetriever(String tempName, String shellName, String driveName, String command){
        
        
        try{
            
            File tf = new File(tempName + ".txt");
            
            if (!tf.exists()) {
                tf = new File(tempName + ".txt");
            }
            
            ProcessBuilder pb = new ProcessBuilder(shellName,driveName,command);
            pb.redirectOutput(tf);
            Process p = pb.start();
           
            
            
            try {
               p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(PdProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            Scanner output = new Scanner(tf);
            while (output.hasNextLine()){
                System.out.println(output.nextLine());
            }
            
           // System.out.println(System.getProperty("os.name"));
            
        
        
        }catch (IOException e){
        
            e.printStackTrace();
        }
  
    }
}
