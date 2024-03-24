package io.github.marcelofiddelis.hwmonitor.network;

public interface Network {

    /**
     * 
     * @return the ipv4 adress
     */
    public String ipv4Adress();

    /**
     * 
     * 
     * @return the internal network ip
     */
    public String internalIp();

    /**
     * 
     * @return the computer mac
     */
    public String mac();


    
}
