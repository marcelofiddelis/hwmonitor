package io.github.marcelofiddelis.hwmonitor.principalmemory;

import org.junit.jupiter.api.Test;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class RamLinuxTest {
    
    @Test
    public void getTotalRam_ShouldReturnTotalRam(){
        FileHandlerLinux fhl = new FileHandlerLinux();
        System.out.println(fhl.getTotalRAM());
    }

    @Test
    public void getRAMInUse_ShouldReturnRamUsage(){
        FileHandlerLinux fhl = new FileHandlerLinux();
        System.out.println(fhl.getRAMInUse());
    }
}
