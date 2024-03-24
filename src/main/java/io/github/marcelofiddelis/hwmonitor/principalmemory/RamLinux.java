package io.github.marcelofiddelis.hwmonitor.principalmemory;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class RamLinux implements Ram {

    private static RamLinux ramLinuxInstance;
    private FileHandlerLinux fileHandler;

    private RamLinux (){
        
    }

    public static synchronized RamLinux instance(){
        if(ramLinuxInstance == null){
            ramLinuxInstance = new RamLinux();
        }
        return ramLinuxInstance;
    }
    @Override
    public String capacity() {
        return fileHandler.getTotalRAM();
    }

    @Override
    public String usage() {
        return fileHandler.getRAMInUse();
    }
    
}
