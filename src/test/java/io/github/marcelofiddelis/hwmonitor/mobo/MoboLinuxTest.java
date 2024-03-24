package io.github.marcelofiddelis.hwmonitor.mobo;

import org.junit.jupiter.api.Test;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class MoboLinuxTest {
    
    @Test
    public void getMoboSocket(){
        FileHandlerLinux fhl = new FileHandlerLinux();
        System.out.println(fhl.getMoboSocket());
    }

    @Test
    public void getMoboManufacture(){
        FileHandlerLinux fhl = new FileHandlerLinux();
        System.out.println(fhl.getMoboManufacture());
    }
}
