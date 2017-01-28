/**
 * Implementation of NetworkCore for Windows
 * 
 * @author William Barden
 * Jan 27, 2017
 */
package core.win;


import core.NetworkCore;


public class WinNetwork implements NetworkCore {

    @Override
    public String getDnsSuffix() {
        return "ovh.oakland.edu";
    }
    
    @Override
    public String getDnsIP() {
        return "";
    }

    @Override
    public String getIP() {
        return "141.210.237.178";
    }

    @Override
    public String getSubnetMask() {
        return "255.255.254.0";
    }

    @Override
    public String getDefGateway() {
        return "141.210.236.1";
    }

    @Override
    public String getMAC() {
        return "28-D2-44-4F-D4-12";
    }

    @Override
    public String pingGoogleTime() {
        return "";
    }
}