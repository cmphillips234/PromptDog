package core;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class PdProcess {

    PdProcess() {
        try {
            File tf = new File("temp.txt");
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", "sw_vers -productName");
            pb.redirectOutput(tf);
            Process p = pb.start();
            
            try {
                p.waitFor();
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            
            Scanner output = new Scanner(tf);
            while (output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
            
            output.close();
            tf.delete();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PdProcess();
    }
}