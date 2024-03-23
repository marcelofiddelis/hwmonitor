package io.github.marcelofiddelis.hwmonitor.utils.filehandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.marcelofiddelis.hwmonitor.utils.RuntimeWindows;

public class FileHandlerWindows {
    
    private final List<String> FIELDNAMES_CPU = Arrays.asList("Manufacturer",
            "Family",
            "Name",
            "MaxClockSpeed",
            "L3CacheSize",
            "NumberOfCores");

    public Map<String, String> getCpuInfo() {
        String[] cpuInfoLines = RuntimeWindows.getCpuInfo();
        Map<String, String> cpuInfoMap = new HashMap<>();

        for (String line : cpuInfoLines) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                if (FIELDNAMES_CPU.contains(key)) {
                    cpuInfoMap.put(key, value);
                }
            }
        }

        return cpuInfoMap;
    }

    public double getCpuTemp() {
        String[] cpuTempLines = RuntimeWindows.getCpuTemperature();
        try {
            double kelvin = Double.parseDouble(cpuTempLines[2]);
            double celsius = kelvin - 273.15; //Kelvin to Celsius conversion
            return celsius;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private final List<String> FIELDNAMES_RAM = Arrays.asList("FreePhysicalMemory",
            "TotalVisibleMemorySize");

    public Map<String, String> getRamInfo() {
        String[] ramInfoLines = RuntimeWindows.getRamInfo();
        Map<String, String> ramInfoMap = new HashMap<>();

        for (String line : ramInfoLines) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                if (FIELDNAMES_RAM.contains(key)) {
                    ramInfoMap.put(key, value);
                }
            }
        }

        return ramInfoMap;
    }
}