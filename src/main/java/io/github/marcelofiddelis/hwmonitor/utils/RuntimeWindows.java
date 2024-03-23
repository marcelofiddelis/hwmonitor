package io.github.marcelofiddelis.hwmonitor.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RuntimeWindows {
    private static final String CPU_COMMAND = Commands.CPU;
    private static final String CPU_TEMP_COMMAND = Commands.CPU_TEMP;
    private static final String RAM_CAPACITY_COMMAND = Commands.RAM_CAPACITY;
    private static final String STORAGE_COMMAND = Commands.STORAGE;
    private static final String GPU_COMMAND = Commands.GPU;
    private static final String MOBO_COMMAND = Commands.MOBO;

    //Run the runtime with the command received
    public static String[] executeCommand(String command) {
        List<String> output = new ArrayList<>();

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return output.toArray(new String[0]);
    }

    //call executeCommand and return CPU information
    public static String[] getCpuInfo() {
        return executeCommand(CPU_COMMAND);
    }

    //call executeCommand and return CPU Temperature information
    public static String[] getCpuTemperature() {
        return executeCommand(CPU_TEMP_COMMAND);//Kelvin
    }

    public static String[] getRamInfo() {
        return executeCommand(RAM_CAPACITY_COMMAND);
    }

    public static String[] getStorageInfo() {
        return executeCommand(STORAGE_COMMAND);
    }

    public static String[] getGpuInfo() {
        return executeCommand(GPU_COMMAND);
    }

    public static String[] getMoboInfo() {
        return executeCommand(MOBO_COMMAND);
    }

    private interface Commands {
        String CPU = "wmic cpu get /format:list";
        String CPU_TEMP = "wmic path Win32_PerfRawData_Counters_ThermalZoneInformation get Temperature";
        String RAM_CAPACITY = "wmic OS get /format:list";
        //String RAM = "wmic memorychip get /format:list";
        String STORAGE = "wmic diskdrive get /format:list";
        String GPU = "wmic path win32_videocontroller get /format:list";
        String MOBO = "wmic baseboard get /format:list";
    }
}

