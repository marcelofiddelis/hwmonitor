package io.github.marcelofiddelis.hwmonitor.storagememory;

import java.util.List;

public interface Storage {
    /**
     * 
     * @return A list of disks
     */
    public List<StorageUnit> disks();

    /**
     * 
     * @return A list of disk usage 
     */
    public List<String> disksUsage();



}
