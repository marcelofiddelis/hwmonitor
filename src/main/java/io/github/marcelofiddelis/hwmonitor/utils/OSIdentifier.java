package io.github.marcelofiddelis.hwmonitor.utils;
/**
 * Identify the Operational System in which the code is running
 * @author Marcelo Fidelis
 */
public class OSIdentifier {
    public static String getOs(){
        return System.getProperty("os.name");
    }
}
