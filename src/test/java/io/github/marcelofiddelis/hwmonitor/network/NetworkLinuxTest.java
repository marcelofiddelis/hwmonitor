package io.github.marcelofiddelis.hwmonitor.network;

import org.junit.jupiter.api.Test;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class NetworkLinuxTest {
    
    @Test
    public void getIpv4Adress_ShouldReturnIpv4Adress(){
        FileHandlerLinux fhl = new FileHandlerLinux();

        System.out.println(fhl.getIpv4Adress());
    }

    @Test
    public void getMac_ShouldReturnMac(){
        FileHandlerLinux fhl = new FileHandlerLinux();
        System.out.println(fhl.getMac());
    }

    @Test
    public void getInternalIp_ShouldReturnInternalIp(){
        FileHandlerLinux fhl = new FileHandlerLinux();
        System.out.println(fhl.getInternalIp());
    }
}
