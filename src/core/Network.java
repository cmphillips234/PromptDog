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
        return "ovh.oakland.edu";
    }
    
    //ipconfig /all | find "DNS Servers"
    @Override
    public String getDnsIP() {
        return "";
    }

    //ipconfig /all | find "IPv4 Address"
    @Override
    public String getIP() {
        return "141.210.237.178";
    }

    //ipconfig | find "Subnet Mask"
    @Override
    public String getSubnetMask() {
        return "255.255.254.0";
    }

    //ipconfig | find "Default Gateway"
    @Override
    public String getDefGateway() {
        return "141.210.236.1";
    }

    /*ipconfig /all | find "Physical Address"
     *will be first one listed in output
     */
    @Override
    public String getMAC() {
        return "28-D2-44-4F-D4-12";
    }

    //ping -n 1 www.google.com
    @Override
    public String pingGoogleTime() {
        return "";
    }
}
