package io.github.marcelofiddelis.hwmonitor.utils.plataforms;

import io.github.marcelofiddelis.hwmonitor.cpu.Cpu;
import io.github.marcelofiddelis.hwmonitor.gpu.Gpu;
import io.github.marcelofiddelis.hwmonitor.mobo.Mobo;
import io.github.marcelofiddelis.hwmonitor.principalmemory.Ram;
import io.github.marcelofiddelis.hwmonitor.storagememory.Storage;

public abstract class DefaultGetter implements Getter{

    @Override
    public Cpu getCpu() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Gpu getGpu() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mobo getMobo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ram getRam() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Storage getStorage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "Default";
    }

    
}
