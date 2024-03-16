package io.github.marcelofiddelis.hwmonitor.utils;

import io.github.marcelofiddelis.hwmonitor.utils.plataforms.LinuxGetter;
import io.github.marcelofiddelis.hwmonitor.utils.plataforms.WindowsGetter;

public class PlataformHandler {

    public static Getter getGetter(String os) throws Exception {
        switch (os) {
            case "Linux":
                return new LinuxGetter();
            case "Windows":
                return new WindowsGetter();

            default:
                throw new Exception("Os not identify or not suported");

        }
    }
}
