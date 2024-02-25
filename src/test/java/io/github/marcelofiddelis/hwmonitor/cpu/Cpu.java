package io.github.marcelofiddelis.hwmonitor.cpu;

/**
 * Responsable interface for cpu monitor
 */
public interface Cpu {
    /**
     * 
     * @return The vendorId.
     */
    public String vendorId();

     /**
     * 
     * @return The processor's modelName.
     */
    public String modelName();

     /**
     * 
     * @return The processor's cpuFamily
     */
    public String cpuFamily();

     /**
     * 
     * @return The processor's frequency
     */
    public String cpuMHz();

     /**
     * 
     * @return The processor's core numbers 
     */
    public String cpuCores();

     /**
     * 
     * @return The processor's cache
     */
    public String cacheSize();


     /**
     * 
     * @return The processor's cache
     */
    public String temperature();

}
