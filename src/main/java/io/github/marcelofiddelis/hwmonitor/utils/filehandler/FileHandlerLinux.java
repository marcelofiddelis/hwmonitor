package io.github.marcelofiddelis.hwmonitor.utils.filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

import io.github.marcelofiddelis.hwmonitor.storagememory.StorageUnit;
import io.github.marcelofiddelis.hwmonitor.storagememory.StorageUnitLinux;
import io.github.marcelofiddelis.hwmonitor.utils.PathsLinux;

public class FileHandlerLinux {

    private final List<String> FIELDNAMES = Arrays.asList("processor",
            "vendor_id",
            "cpu family",
            "model name",
            "cpu MHz",
            "cache size",
            "cpu cores");

    private int cpuCores;

    public Map<String, String> getCpuInfo() {
        try {
            BufferedReader reader = FileHandler.getFile(PathsLinux.CPU.getPath());
            String line;
            int processorCount = 0; // Contador de processadores

            Map<String, String> cpuInfoMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Se a linha estiver vazia, isso indica uma nova CPU
                    processorCount++;
                    continue;
                }

                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    if (FIELDNAMES.contains(key)) {
                        // Armazenar informações da CPU no mapa
                        cpuInfoMap.put("processor[" + processorCount + "] " + key, value);
                    }

                }
            }

            reader.close();
            this.cpuCores = processorCount;
            return cpuInfoMap;

        } catch (IOException e) {
            throw new RuntimeException();

        }

    }

    public int cpuCores() {
        return this.cpuCores;
    }

    public double getCpuTemp() {
        BufferedReader reader = FileHandler.getFile(PathsLinux.CPU_TEMP.getPath());
        double temperature;
        try {
            temperature = Double.parseDouble(reader.readLine()) / 1000.0;
            reader.close();
            return temperature;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();

        } catch (IOException e) {
            throw new RuntimeException();

        }

    }

    private String handleRam(int i) {
        try {
            Process process = Runtime.getRuntime().exec("free -h");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Mem:")) {
                    String[] parts = line.split("\\s+");
                    String ramInfo = parts[i];

                    ramInfo = ramInfo.replace("Gi", " Gb");
                    return ramInfo;
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTotalRAM() {
        return handleRam(1);
    }

    public String getRAMInUse() {
        return handleRam(2);
    }

    private BufferedReader commandHandler(String command) {

        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            return new BufferedReader(new InputStreamReader(process.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    public List<StorageUnit> getStorageUnits() {
        BufferedReader lines = commandHandler("lsblk -n -o MODEL,SERIAL,ROTA,TYPE,SIZE,FSUSED,FSUSE%,STATE,TRAN");
        String line;
        float usage = 0;
        String product = "";
        String vendor = "";
        String health = "";
        String storageInterface = "";
        String storageSerial = "";
        float capacity = 0;
        int disk = 0;
        int type = 0;
        List<StorageUnit> storageUnits = new ArrayList<>();
        try {
            while ((line = lines.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 8) {
                    if (disk > 0) {
                        StorageUnit storageUnit = new StorageUnitLinux(product, vendor, String.valueOf(capacity),
                                String.valueOf(usage), health, type, storageInterface, storageSerial);
                        storageUnits.add(storageUnit);
                        usage = 0;
                        capacity = 0;
                    }
                    disk += 1;
                    product = parts[0] + " " + parts[1];
                    vendor = parts[0];
                    health = parts[6];
                    storageInterface = parts[7];
                    storageSerial = parts[2];
                    type = Integer.valueOf(parts[3]);

                } else {
                    if (parts[3].endsWith("M")) {
                        usage += Float.valueOf(parts[3].substring(0, parts[3].length() - 1).replaceAll(",", "."))
                                / 1000;
                    } else {

                        usage += Float.valueOf(parts[3].substring(0, parts[3].length() - 1).replaceAll(",", "."));
                    }

                    if (parts[2].endsWith("M")) {
                        capacity += Float.valueOf(parts[2].substring(0, parts[2].length() - 1).replaceAll(",", "."))
                                / 1000;
                    } else {

                        capacity += Float.valueOf(parts[2].substring(0, parts[2].length() - 1).replaceAll(",", "."));
                    }

                }

            }
            StorageUnit storageUnit = new StorageUnitLinux(product, vendor, String.valueOf(capacity),
                    String.valueOf(usage), health, type, storageInterface, storageSerial);
            storageUnits.add(storageUnit);
            return storageUnits;

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getMoboSocket() {
        BufferedReader lines = commandHandler("cat /sys/class/dmi/id/board_name");

        try {

            return lines.readLine();

        } catch (IOException e) {

            throw new RuntimeException();
        }

    }

    public String getMoboManufacture() {
        BufferedReader lines = commandHandler("cat /sys/class/dmi/id/board_vendor");

        try {

            return lines.readLine();

        } catch (IOException e) {

            throw new RuntimeException();
        }
    }

    private String networkHandler(String paramQuery, boolean internal) {

        File netDir = new File("/sys/class/net/");
        File[] interfaces = netDir.listFiles();
        String info = "Not found";
        String interfaceName = null;

        if (!internal) {
            for (File interfaceFile : interfaces) {
                String name = interfaceFile.getName();
                if (!name.equals("lo")) {
                    if (!name.startsWith("docker")) {
                        interfaceName = name;
                        break;

                    }
                }
            }

        }else{
            interfaceName = "lo";
        }

        if (interfaceName != null) {

            BufferedReader reader = commandHandler("ip -h addr show " + interfaceName);
            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    if (line.contains(paramQuery)) {
                        String[] parts = line.trim().split("\\s+");
                        info = parts[1];
                        break;
                    }

                }

            } catch (IOException e) {

                throw new RuntimeException();
            }

        }
        return info;

    }

    public String getIpv4Adress() {
        return networkHandler("inet",false);

    }

    public String getInternalIp() {

        return networkHandler("inet",true);
    }

    public String getMac() {
        return networkHandler("link/ether",false);

    }

}
