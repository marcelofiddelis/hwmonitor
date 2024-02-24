package io.github.marcelofiddelis.hwmonitor;

import io.github.marcelofiddelis.hwmonitor.utils.OSIdentifier;

/**
 * Entrypoint for the application, identifing the host Operational System and instantiating the
 * features needed.
 * 
 * @author Marcelo Fidelis
 * 
 * 
 * 
 */

public class Hwmonitor {
    private String os;

    public Hwmonitor() {
        setOs();
    }

    /**
     * Set the OS in the  os String variable using the <code>{@Link OSIdentifier}</code> class
     */
    private void setOs() {
        this.os = OSIdentifier.getOs();
    }

}
