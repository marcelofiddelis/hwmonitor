package io.github.marcelofiddelis.hwmonitor.network;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class NetworkLinux implements Network {

    private static NetworkLinux networkLinuxInstance;
    private FileHandlerLinux fhl;

    private NetworkLinux(){
        this.fhl = new FileHandlerLinux();
    }

    public static synchronized NetworkLinux instance(){
        if(networkLinuxInstance == null){
            networkLinuxInstance = new NetworkLinux();
        }
        return networkLinuxInstance;
    }

    @Override
    public String ipv4Adress() {
        
        return this.fhl.getIpv4Adress();
    }

    @Override
    public String internalIp() {
        
        return this.fhl.getInternalIp();
    }

    @Override
    public String mac() {
        return this.fhl.getMac();
    }
    
}
