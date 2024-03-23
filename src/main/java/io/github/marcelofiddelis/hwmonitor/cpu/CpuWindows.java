package io.github.marcelofiddelis.hwmonitor.cpu;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerWindows;

public class CpuWindows implements Cpu{
    private static CpuWindows cpuWindowsInstance;

    private FileHandlerWindows fileHandler;

    private CpuWindows (){
        setFileHandler();
    }

    public static synchronized CpuWindows instance(){
        if (cpuWindowsInstance == null){
            cpuWindowsInstance = new CpuWindows();
        }
        return cpuWindowsInstance;
    }

    @Override
    public String vendorId() {
       return fileHandler.getCpuInfo().get("Manufacturer");
    }

    @Override
    public String modelName() {
        return fileHandler.getCpuInfo().get("Name");
    }

    @Override
    public String cpuFamily() {
        return fileHandler.getCpuInfo().get("Family");
    }

    @Override
    public String cpuMHz() {
        return fileHandler.getCpuInfo().get("MaxClockSpeed") + "Mhz";
    }

    @Override
    public String cpuCores() {
        return fileHandler.getCpuInfo().get("NumberOfCores");
    }

    @Override
    public String cacheSize() {
        return fileHandler.getCpuInfo().get("L3CacheSize");
    }

    @Override
    public String temperature() {
        return String.valueOf(fileHandler.getCpuTemp());
    }

    private void setFileHandler(){
        this.fileHandler = new FileHandlerWindows();
    }
    
}
