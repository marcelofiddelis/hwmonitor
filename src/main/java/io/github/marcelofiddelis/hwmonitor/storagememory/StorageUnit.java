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
    public String temp();

    /**
     * 
     * @return a summary of all info on the storage
     */
    public String toSring();
}
