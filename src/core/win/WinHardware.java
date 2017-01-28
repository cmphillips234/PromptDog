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
        return "x64-based PC";
    }

    @Override
    public String getBiosVersion() {
        return "LENOVO 74CN47WW(V3.08), 1/30/2015";
    }

    @Override
    public String getTotalPhysicalMem() {
        return "8,108 MB";
    }

    @Override
    public String getTotalAvailableMem() {
        return "4,177 MB";
    }

}