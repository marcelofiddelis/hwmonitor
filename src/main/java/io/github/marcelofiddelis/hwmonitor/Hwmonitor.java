package io.github.marcelofiddelis.hwmonitor;

import io.github.marcelofiddelis.hwmonitor.utils.Getter;
import io.github.marcelofiddelis.hwmonitor.utils.OSIdentifier;
import io.github.marcelofiddelis.hwmonitor.utils.PlataformHandler;

/**
 * Entrypoint for the application, identifing the host Operational System and
 * instantiating the
 * features needed.
 * 
 * @author Marcelo Fidelis
 * 
 * 
 * 
 */

public class Hwmonitor {
    private String os;
    private Getter system;

    public Hwmonitor() {
        setOs();
        setSystem(this.os);
    }

    /**
     * Set the OS in the os String variable using the
     * <code>{@Link OSIdentifier}</code> class
     */
    private void setOs() {
        this.os = OSIdentifier.getOs();

    }

    private void setSystem(String os) {
        try {
            this.system = PlataformHandler.getGetter(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
