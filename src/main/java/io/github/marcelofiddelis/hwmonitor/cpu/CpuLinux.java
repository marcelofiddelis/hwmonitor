package io.github.marcelofiddelis.hwmonitor.cpu;

import io.github.marcelofiddelis.hwmonitor.utils.filehandler.FileHandlerLinux;

public class CpuLinux implements Cpu {
    private static CpuLinux cpuLinuxInstance;

    private FileHandlerLinux fileHandler;

    private int cpuCores;

    private CpuLinux (){
        setFileHandler();
        setCpuCores();
    }

    public static synchronized CpuLinux instance(){
        if (cpuLinuxInstance == null){
            cpuLinuxInstance = new CpuLinux();
        }
        return cpuLinuxInstance;
    }
    @Override
    public String vendorId() {
        return this.fileHandler.getCpuInfo().get("processor[0] vendor_id");
    }

    @Override
    public String modelName() {
        return this.fileHandler.getCpuInfo().get("processor[0] model name");
    }

    @Override
    public String cpuFamily() {
        
        return this.fileHandler.getCpuInfo().get("processor[0] cpu family");
    }

    @Override
    public String cpuMHz() {
        String value = "";
        for (int i = 0; i < this.cpuCores ; i++){
            value += String.format("processor[%d] cpu MHz: ", i) + this.fileHandler.getCpuInfo().get(String.format("processor[%d] cpu MHz", i)) + "\n";
        }
        return value;
    }

    @Override
    public String cpuCores() {
        
        return String.valueOf(this.cpuCores);
    }

    @Override
    public String cacheSize() {
        
        return this.fileHandler.getCpuInfo().get("processor[0] cache size");
    }

    @Override
    public String temperature() {
        return String.valueOf(this.fileHandler.getCpuTemp());
    }

    private void setFileHandler(){
        this.fileHandler = new FileHandlerLinux();
    
    }
    
    private void setCpuCores(){
        this.cpuCores = Integer.valueOf(fileHandler.getCpuInfo().get("processor[0] cpu cores"));
    }
    
}
