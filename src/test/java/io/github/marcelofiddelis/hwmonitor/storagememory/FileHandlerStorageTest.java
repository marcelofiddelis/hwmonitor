package io.github.marcelofiddelis.hwmonitor.storagememory;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class FileHandlerStorageTest {

    /**
    * The setup tested was composed by 1 ssd and 1 hdd
    */
    @Test
    public void getStorageUnits() {
        FileHandlerLinux fhl = new FileHandlerLinux();
        List<StorageUnit> su = fhl.getStorageUnits();
        System.out.println(su.get(0).toString());
        System.out.println(su.get(1).toString());
    }
}
