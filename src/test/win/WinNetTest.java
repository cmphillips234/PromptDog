/**
 * @author William Barden
 * Jan 27, 2017
 */
package test.win;


import core.win.WinHardware;
import core.win.WinNetwork;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class WinNetTest {
    private Map testMap;
    private final String testFilePath = "src/test/win/test.txt";
    private final String[] testKeys = {"DnsSuffix", "DnsIP", "IP", "SubnetMask",
            "DefaultGateway", "MAC", "GooglePing"};
    
    private WinNetwork wn;
    
    private WinNetTest() {
        testMap = new HashMap<String, String>();
        wn = new WinNetwork();
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
    
    private void printTestHeader(String key, String status) {
        System.out.println(key.toUpperCase() + " TEST: " + status);
    }
    
    private void printTestStats(String exp, String rec, long elapsed) {
        System.out.println("Expected: " + exp);
        System.out.println("Received: " + rec);
        System.out.println("Elapsed time: " + String.valueOf(elapsed) + " ns");
        System.out.print("\n");
    }
    
    private String testStatus(String expected, String received) {
        if (expected.equalsIgnoreCase(received)) {
            return "PASSED";
        }
        return "FAILED";
    }
    
    private void runTests() {
        NanoTestTimer timer = new NanoTestTimer();
        NanoTestTimer totalTimer = new NanoTestTimer();
        String currTestKey;
        String expected;
        String received;
        String status;
        long time;
        
        System.out.println("\n\nBEGINNING TESTS\n");
        totalTimer.start();
        
        currTestKey = testKeys[0];  //DNS suffix
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.getDnsSuffix();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        currTestKey = testKeys[1];  //DNS IP
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.getDnsIP();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        currTestKey = testKeys[2];  //IP
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.getIP();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        currTestKey = testKeys[3];  //Subnet mask
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.getSubnetMask();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        currTestKey = testKeys[4];  //Default gateway
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.getDefGateway();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        currTestKey = testKeys[5];  //MAC
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.getMAC();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        currTestKey = testKeys[6];  //Google ping
        expected = testMap.get(currTestKey).toString();
        received = ""; 
        timer.start();
        received = wn.pingGoogleTime();
        time = timer.stop();
        status = testStatus(expected, received);
        printTestHeader(currTestKey, status);
        printTestStats(expected, received, time);
        
        String allTestsTime = String.valueOf(totalTimer.stop());
        System.out.println("\nAll tests completed in " + allTestsTime + " ns");
    }
    
    public static void main(String[] args) {
        new WinNetTest();
    }
}