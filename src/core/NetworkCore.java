/**
 * Interface for obtaining network information
 * 
 * @author William Barden
 * Jan 27, 2017
 */
package core;


public interface NetworkCore {
    public String getDnsIP();
    public String getDnsSuffix();
    public String getIP();
    public String getSubnetMask();
    public String getDefGateway();
    public String getMAC();
    public String pingGoogleTime();
}