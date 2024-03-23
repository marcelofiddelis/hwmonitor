package io.github.marcelofiddelis.hwmonitor.cpu;

import org.junit.jupiter.api.Test;

public class CpuWindowsTest {
    
     @Test
    public void getVendorId_ShouldReturnVendorId(){
        Cpu cpu = CpuWindows.instance();
        System.out.println(cpu.vendorId());
    }

    @Test
    public void getCpuMHz_ShouldReturnAllCores(){
        Cpu cpu = CpuWindows.instance();
        // cpu.cpuMHz();
        System.out.println(cpu.cpuMHz());
    }

    @Test
    public void getCpuTemperature_ShouldReturnCpuTemperature(){
        Cpu cpu = CpuWindows.instance();
        System.out.println(cpu.temperature());
    }
}
