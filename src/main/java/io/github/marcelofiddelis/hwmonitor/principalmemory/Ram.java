package io.github.marcelofiddelis.hwmonitor.principalmemory;

public interface Ram {

    /**
     * 
     * @return The total ram capacity
     */
    public String capacity();

    /**
     * 
     * @return The ram current usage
     */
    public String usage();
}
