/**
 * Implementation of NetworkCore for Windows
 * 
 * @author William Barden
 * Jan 27, 2017
 */
package core;


import core.NetworkCore;


public class Network implements NetworkCore {

    String OSTYPE;
    
    public Network() {
        String sysOs = System.getProperty("os.name").toLowerCase();
        
        if (sysOs.contains("windows")) {
            OSTYPE = "cmd";
        } 
        else {
            OSTYPE = "bash";
        }
        System.out.println("System shell: " + OSTYPE); 
    }
    
    //ipconfig | find "Connection-specific DNS Suffix"
    @Override
    public String getDnsSuffix() {
        //return "ovh.oakland.edu";
        
        PdProcess test = new PdProcess();
        
        if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("DnsSuffix", "cmd", "/C" , "ipconfig | findstr Connection-specific DNS Suffix");
        }else{
            test.GoldenRetriever("DnsSuffix", "bash", "-c", "cat /etc/resolv.conf | grep domain");
        }
    }
    
    //ipconfig /all | find "DNS Servers"
    @Override
    public String getDnsIP() {
        //return "123.345.789.321";
        
        PdProcess test = new PdProcess();
        
        if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("DnsServers", "cmd", "/C" , "ipconfig | findstr DNS Servers");
        }else{
            test.GoldenRetriever("DnsServers", "bash", "-c", "cat /etc/resolv.conf | grep nameserver");
        }
    }

    //ipconfig /all | find "IPv4 Address"
    @Override
    public String getIP() {
        //return "141.210.237.178";
        
        PdProcess test = new PdProcess();
        
        if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("MyIp", "cmd", "/C" , "ipconfig | findstr IPv4 Address");
        }else{
            test.GoldenRetriever("MyIp", "bash", "-c", "ifconfig | grep \"inet \"  | grep -v 127.0.0.1");
            //returns address, netmask, and brodcast. Will need to filter output in GUI.
        }
    }

    //ipconfig | find "Subnet Mask"
    @Override
    public String getSubnetMask() {
        //return "255.255.254.0";
        
        PdProcess test = new PdProcess();
        
        if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("SubnetMask", "cmd", "/C" , "ipconfig | findstr Subnet Mask");
        }else{
            test.GoldenRetriever("SubnetMask", "bash", "-c", "ifconfig | grep \"inet \"  | grep -v 127.0.0.1");
            //returns address, netmask, and broadcast. Will need to filter output in GUI.
        }
        
    }

    //ipconfig | find "Default Gateway"
    @Override
    public String getDefGateway() {
       //return "141.210.236.1";
        
       PdProcess test = new PdProcess();
        
       if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("DefaultGateway", "cmd", "/C" , "ipconfig | findstr Default Gateway");
       }else{
            test.GoldenRetriever("DefaultGateway", "bash", "-c", "netstat -nr |grep default");
       }
       
    }

    /*ipconfig /all | find "Physical Address"
     *will be first one listed in output
     */
    @Override
    public String getMAC() {
        //return "28-D2-44-4F-D4-12";
        
         PdProcess test = new PdProcess();
        
        if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("MacAddress", "cmd", "/C" , "ipconfig | findstr Physical Address");
        }else{
            test.GoldenRetriever("DefaultGateway", "bash", "-c", "ifconfig | grep ether");
            //Lists MacAddresses for each interfaces. See default gateway for which interface to display.
        }
        
    }

    //ping -n 1 www.google.com
    @Override
    public String pingGoogleTime() {
        //return "12 ms";
        
         PdProcess test = new PdProcess();
        
        if(OSTYPE.equals("cmd")){
            test.GoldenRetriever("pingGoog", "cmd", "/C" , "ping -n 1 www.google.com");
        }else{
            test.GoldenRetriever("pingGoog", "bash", "-c", "ping -c 1 www.google.com");
            //Lists MacAddresses for each interfaces. See default gateway for which interface to display.
        }
        
    }
}
