/**
 * Implementation of HardwareCore for Windows
 * 
 * @author William Barden
 * Jan 27, 2017
 */
package core.win;


import core.HardwareCore;


public class WinHardware implements HardwareCore {

    @Override
    public String getHostName() {
        return "Will-Lenovo";
    }

    @Override
    public String getOsName() {
        return "Microsoft Windows 10 Home";
    }

    @Override
    public String getOsVersion() {
        return "10.0.14393 N/A Build 14393";
    }

    @Override
    public String getSysType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBiosVersion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTotalPhysicalMem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTotalAvailableMem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}