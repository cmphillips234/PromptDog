/**
 * Interface for obtaining hardware information
 * 
 * @author William Barden
 * Jan 27, 2017
 */
package core;

public interface HardwareCore {
    public String getHostName();
    public String getOsName();  //windows 10 home, windows 7 pro, etc.
    public String getOsVersion();   
    public String getSysType();     //64 or 32 bit
    public String getBiosVersion();
    public String getTotalPhysicalMem();    
    public String getTotalAvailableMem();   //return physical mem not in use
}