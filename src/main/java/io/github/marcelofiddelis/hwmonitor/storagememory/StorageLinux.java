package io.github.marcelofiddelis.hwmonitor.storagememory;

import java.util.List;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class StorageLinux implements Storage {

    private static StorageLinux storageLinuxInstance;
    private FileHandlerLinux fhl;

    private List<StorageUnit> storageUnits;
    

    private StorageLinux(){
        this.fhl = new FileHandlerLinux();
        setStorageUnits();
    }

    public static synchronized StorageLinux instance(){
        if(storageLinuxInstance == null){
            storageLinuxInstance = new StorageLinux();
        }
        return storageLinuxInstance;
    }
    @Override
    public List<StorageUnit> disks() {
        
        return this.storageUnits;
    }

    private void setStorageUnits (){
        this.storageUnits = fhl.getStorageUnits();
    }

  
    
}
