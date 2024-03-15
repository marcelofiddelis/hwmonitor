package io.github.marcelofiddelis.hwmonitor.gpu;

public interface Gpu {

    /**
     * 
     * @return Gpu name
     */
    public String product();


    /**
     * 
     * @return Gpu usage
     */
    public String usage();

    /**
     * 
     * @return Gpu temperature
     */
    public String temp();
}
