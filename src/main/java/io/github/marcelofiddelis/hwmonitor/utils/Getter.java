package io.github.marcelofiddelis.hwmonitor.utils;

import io.github.marcelofiddelis.hwmonitor.cpu.Cpu;
import io.github.marcelofiddelis.hwmonitor.gpu.Gpu;
import io.github.marcelofiddelis.hwmonitor.mobo.Mobo;
import io.github.marcelofiddelis.hwmonitor.principalmemory.Ram;
import io.github.marcelofiddelis.hwmonitor.storagememory.Storage;


public interface Getter {

    public Cpu getCpu();

    public Gpu getGpu();

    public Mobo getMobo();

    public Ram getRam();

    public Storage getStorage();
    
    
} 

   

    


