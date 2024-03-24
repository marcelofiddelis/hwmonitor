package io.github.marcelofiddelis.hwmonitor.storagememory;

public class StorageUnitLinux implements StorageUnit {
    private String product;
    private String vendor;
    private String capacity;
    private String usage;
    private String health;
    private int type;
    private String storageInterface;
    private String storageSerial;

    public StorageUnitLinux(String product, String vendor, String capacity, String usage, String health, int type, String storageInterface,String storageSerial) {

        this.product = product;
        this.vendor = vendor;
        this.capacity = capacity;
        this.usage = usage;
        this.health = health;
        this.type = type;
        this.storageInterface = storageInterface;
        this.storageSerial = storageSerial;
    }

    @Override
    public String product() {

        return this.product;
    }

    @Override
    public String vendor() {

        return this.vendor;
    }

    @Override
    public String capacity() {
        return this.capacity;
    }

    @Override
    public String usage() {
        return this.usage;
    }

    @Override
    public String health() {
        return this.health.equals("running")? "good" : "bad";
            
        
        
    }

    @Override
    public String type() {
        return this.type == 1 ? "hdd":"ssd";
        
    }

    @Override
    public String storageInterface() {
        
        return this.storageInterface;
    }

    @Override
    public String storageSerial() {
        
        return this.storageSerial;
    }

    @Override
    public String toString() {
        return String.format("""
                nome: %s
                vendor: %s
                capacity: %s
                usage: %s
                health : %s
                type: %s
                storage interface: %s
                storage serial: %s

                """, this.product, this.vendor, this.capacity, this.usage,health(),type(),this.storageInterface,this.storageSerial);
    }

}
