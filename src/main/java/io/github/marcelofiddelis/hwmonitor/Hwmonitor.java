package io.github.marcelofiddelis.hwmonitor;

import io.github.marcelofiddelis.hwmonitor.cpu.Cpu;
import io.github.marcelofiddelis.hwmonitor.mobo.Mobo;
import io.github.marcelofiddelis.hwmonitor.network.Network;
import io.github.marcelofiddelis.hwmonitor.principalmemory.Ram;
import io.github.marcelofiddelis.hwmonitor.storagememory.Storage;
import io.github.marcelofiddelis.hwmonitor.utils.OSIdentifier;
import io.github.marcelofiddelis.hwmonitor.utils.plataforms.Getter;
import io.github.marcelofiddelis.hwmonitor.utils.plataforms.PlataformHandler;

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

    public Cpu getCpu(){
        return this.system.getCpu();
    }

    public Mobo getMobo(){
        return this.system.getMobo();
    }

    public Ram getRam(){
        return this.system.getRam();
    }

    public Storage getStorage(){
        return this.system.getStorage();
    }

    public Network getNetwork(){
        return this.system.getNetwork();
    }

    public String getOs(){
        return this.os;
    }



}
