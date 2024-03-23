package io.github.marcelofiddelis.hwmonitor.principalmemory;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerWindows;

public class RamWindows implements Ram {

    private static RamWindows ramWindowsInstance;

    private FileHandlerWindows fileHandler;

    private RamWindows (){
        setFileHandler();
    }

    public static synchronized RamWindows instance(){
        if (ramWindowsInstance == null){
            ramWindowsInstance = new RamWindows();
        }
        return ramWindowsInstance;
    }


    @Override
    public String capacity() {
        return fileHandler.getRamInfo().get("TotalVisibleMemorySize");
    }

    @Override
    public String usage() {
        return fileHandler.getRamInfo().get("FreePhysicalMemory");
    }

    private void setFileHandler(){
        this.fileHandler = new FileHandlerWindows();
    }
    
}
