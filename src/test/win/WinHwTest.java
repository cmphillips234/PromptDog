/**
 * @author William Barden
 * Jan 27, 2017
 */
package test.win;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.lang.Exception;
import java.io.FileReader;

import core.win.WinHardware;


public class WinHwTest {
    private Map testMap;
    private final String testFilePath = "src/test/win/test.txt";
    private final String[] testKeys = {"HostName", "OsName", "OsVersion",
            "SysType", "BiosVersion", "TotalPhyMem", "TotalAvailableMem"};
    
    private WinHardware wh;
    
    private WinHwTest() {
        testMap = new HashMap<String, String>();
        wh = new WinHardware();
        getTestInfo();
        showTestInfo();
        runTests();
    }
    
    private void addIfKeyValid(String key, String value) {
        for (int i = 0; i < testKeys.length; i++) {
            if (testKeys[i].equalsIgnoreCase(key)) {
                testMap.put(key, value);
            }
        }
    }
    
    private void getTestInfo() {
        try {
            FileReader fr = new FileReader(testFilePath);
            BufferedReader br = new BufferedReader(fr);
            
            String ln = br.readLine();
            while (ln != null) {        //go through file completely
                if (ln.length() > 2) {      //only take line if its long enough
                    if (ln.substring(0, 2) != "//") {
                        int colonIndex = ln.indexOf(":");
                        if (colonIndex > 0) {
                            String key = ln.substring(0, colonIndex).trim();
                            String value = ln.substring(colonIndex + 1).trim();
                            addIfKeyValid(key, value);
                        }
                    }
                }
                ln = br.readLine();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void showTestInfo() {
        for (String key : testKeys) {
            String value = testMap.get(key).toString();
            if (value != null) {
                System.out.println(key + " = " + value);
            } else {
                System.out.println(key + " = null");
            }
        }
    }
    
    private String testStatus(String expected, String received) {
        if (expected.equalsIgnoreCase(received)) {
            return "PASSED";
        }
        return "FAILED";
    }
    
    /*
     * Run tests in order: "HostName", "OsName", "OsVersion",
     *      "SysType", "BiosVersion", "TotalPhyMem", "TotalAvailableMem"
     */
    private void runTests() {
        NanoTestTimer timer = new NanoTestTimer();
        String currTestKey;
        String expected;
        String received;
        String status;
        long time;
        
        System.out.println("\n\nBEGINNING TESTS\n");
        
        currTestKey = testKeys[0];  //host name
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wh.getHostName();
        time = timer.stop();
        status = testStatus(expected, received);
        System.out.println(currTestKey.toUpperCase() + " TEST: " + status);
        System.out.println("Expected: " + expected);
        System.out.println("Received: " + received);
        System.out.print("\n");
        
        currTestKey = testKeys[1];  //OS name
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wh.getOsName();   
        time = timer.stop();
        status = testStatus(expected, received);
        System.out.println(currTestKey.toUpperCase() + " TEST: " + status);
        System.out.println("Expected: " + expected);
        System.out.println("Received: " + received);
        System.out.print("\n");
        
        currTestKey = testKeys[2];  //OS version
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wh.getOsVersion();
        time = timer.stop();
        status = testStatus(expected, received);
        System.out.println(currTestKey.toUpperCase() + " TEST: " + status);
        System.out.println("Expected: " + expected);
        System.out.println("Received: " + received);
        System.out.print("\n");
    }
    
    public static void main(String[] args) {
        new WinHwTest();
    }
}