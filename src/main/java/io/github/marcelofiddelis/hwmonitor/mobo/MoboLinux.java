package io.github.marcelofiddelis.hwmonitor.mobo;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class MoboLinux implements Mobo{

    private static MoboLinux moboLinuxInstance;
    private FileHandlerLinux fhl;

    private MoboLinux(){
        this.fhl = new FileHandlerLinux();
    }

    public static synchronized MoboLinux instance(){
        if(moboLinuxInstance == null){
            moboLinuxInstance = new MoboLinux();
        }
        return moboLinuxInstance;
    }

    @Override
    public String family() {
        
        return "Not Found";
    }

    @Override
    public String socket() {
        
        return this.fhl.getMoboSocket();
    }

    @Override
    public String manufacture() {
        return this.fhl.getMoboManufacture();
        
    }
    
}
