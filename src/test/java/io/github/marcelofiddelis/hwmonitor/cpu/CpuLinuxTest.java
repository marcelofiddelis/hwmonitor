package io.github.marcelofiddelis.hwmonitor.cpu;

import org.junit.jupiter.api.Test;

public class CpuLinuxTest {
    

    @Test
    public void getVendorId_ShouldReturnVendorId(){
        Cpu cpu = CpuLinux.instance();
        System.out.println(cpu.vendorId());

    }

    @Test
    public void getCpuMHz_ShouldReturnAllCores(){
        Cpu cpu = CpuLinux.instance();
        // cpu.cpuMHz();
        System.out.println(cpu.cpuMHz());
    }

    @Test
    public void getCpuTemperature_ShouldReturnCpuTemperature(){
        Cpu cpu = CpuLinux.instance();
        System.out.println(cpu.temperature());
    }
}
