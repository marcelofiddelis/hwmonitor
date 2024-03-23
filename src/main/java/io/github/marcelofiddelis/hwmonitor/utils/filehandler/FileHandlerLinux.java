package io.github.marcelofiddelis.hwmonitor.utils.filehandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public double getCpuTemp() 
    {
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
                                                                             // Celsius
        
        
    }
}
