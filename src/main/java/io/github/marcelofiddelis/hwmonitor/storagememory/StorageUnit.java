package io.github.marcelofiddelis.hwmonitor.storagememory;

public interface StorageUnit {
    /**
     * 
     * @return The product name
     */
    public String product();

    /**
     * 
     * @return the vendor
     */
    public String vendor();

    /**
     * 
     * @return the storage capacity
     */
    public String capacity();

    /**
     * 
     * @return the storage usage
     */
    public String usage();

    /**
     * 
     * @return the storage health
     */
    public String health();

    /**
     * 
     * @return the storage temperature
     */

    
    // public String temp();

    /**
     * 
     * @return if is a HDD or SSD
     */
    public String type();
    
    /**
     * @return if is a SATA,IDE,M.2 or other type of interface
     */
    public String storageInterface();

    /**
     * 
     * @return the storage Serial
     */
    public String storageSerial();
    /**
     * 
     * @return a summary of all info on the storage
     */
    public String toString();
}
