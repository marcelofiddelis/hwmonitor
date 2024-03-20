package io.github.marcelofiddelis.hwmonitor.utils;

public enum PathsLinux {
    CPU ("/proc/cpuinfo"),
    CPU_TEMP ("/sys/class/thermal/thermal_zone0/temp");

    private String path;
    
    PathsLinux(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
