package io.github.marcelofiddelis.hwmonitor.storagememory;

import org.junit.jupiter.api.Test;

public class StorageLinuxTest {
    
    @Test
    public void getStorages_ShoulReturnTheStorages(){
        StorageLinux sl = StorageLinux.instance();
        sl.disks().forEach(t -> System.out.println(t.toString()));
    }
}
