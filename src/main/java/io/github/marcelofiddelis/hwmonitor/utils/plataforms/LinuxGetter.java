package io.github.marcelofiddelis.hwmonitor.utils.plataforms;

import io.github.marcelofiddelis.hwmonitor.cpu.Cpu;
import io.github.marcelofiddelis.hwmonitor.cpu.CpuLinux;
import io.github.marcelofiddelis.hwmonitor.gpu.Gpu;
import io.github.marcelofiddelis.hwmonitor.mobo.Mobo;
import io.github.marcelofiddelis.hwmonitor.mobo.MoboLinux;
import io.github.marcelofiddelis.hwmonitor.network.Network;
import io.github.marcelofiddelis.hwmonitor.network.NetworkLinux;
import io.github.marcelofiddelis.hwmonitor.principalmemory.Ram;
import io.github.marcelofiddelis.hwmonitor.principalmemory.RamLinux;
import io.github.marcelofiddelis.hwmonitor.storagememory.Storage;
import io.github.marcelofiddelis.hwmonitor.storagememory.StorageLinux;

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
        
        return MoboLinux.instance();
    }

    @Override
    public Ram getRam() {
        
        return RamLinux.instance();
    }

    @Override
    public Storage getStorage() {
        
        return StorageLinux.instance();
    }

    @Override
    public Network getNetwork() {
        return NetworkLinux.instance();
        
    }

   

}
