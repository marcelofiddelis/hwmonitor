package io.github.marcelofiddelis.hwmonitor.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RuntimeWindows {
    private static final String CPU_COMMAND = Commands.CPU;
    private static final String CPU_TEMP_COMMAND = Commands.CPU_TEMP;

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
        return executeCommand(CPU_TEMP_COMMAND);//Fahrenheit
    }

    private interface Commands {
        String CPU = "wmic cpu get Manufacturer, Family, Name, MaxClockSpeed, L3CacheSize, NumberOfCores /format:list";
        String CPU_TEMP = "wmic path Win32_PerfRawData_Counters_ThermalZoneInformation get Temperature";
    }
}

