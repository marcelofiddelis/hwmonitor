package io.github.marcelofiddelis.hwmonitor.mobo;
/**
 * Responsible interface for mobo (Motherboard) monitor
 */
public interface Mobo {

    /**
     * 
     * @return The Motherboard family
     */
    public String family();

    /**
     * 
     * @return Motherboard socket
     */
    public String socket();


    /**
     * 
     * @return Motherboard manufacture. 
     * 
     * If the information cannot be found, the default value is 'OEM'
     * 
     */
    public String manufacture();


}
