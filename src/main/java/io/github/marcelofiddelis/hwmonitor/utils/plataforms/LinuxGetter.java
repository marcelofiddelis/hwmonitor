package io.github.marcelofiddelis.hwmonitor.utils.plataforms;

import io.github.marcelofiddelis.hwmonitor.cpu.Cpu;
import io.github.marcelofiddelis.hwmonitor.cpu.CpuLinux;
import io.github.marcelofiddelis.hwmonitor.gpu.Gpu;
import io.github.marcelofiddelis.hwmonitor.mobo.Mobo;
import io.github.marcelofiddelis.hwmonitor.principalmemory.Ram;
import io.github.marcelofiddelis.hwmonitor.storagememory.Storage;

public class LinuxGetter extends DefaultGetter {

    @Override
    public Cpu getCpu() {
        
        return CpuLinux.instance();
    }

    @Override
    public Gpu getGpu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGpu'");
    }

    @Override
    public Mobo getMobo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMobo'");
    }

    @Override
    public Ram getRam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRam'");
    }

    @Override
    public Storage getStorage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStorage'");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
