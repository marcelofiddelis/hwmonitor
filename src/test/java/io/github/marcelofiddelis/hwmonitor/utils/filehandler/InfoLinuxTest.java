package io.github.marcelofiddelis.hwmonitor.utils.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.github.marcelofiddelis.hwmonitor.utils.PathsLinux;

public class InfoLinuxTest {
    
    @Test
    public void test(){
        FileHandlerLinux lfh = new FileHandlerLinux();
        Map<String, String> test = lfh.getCpuInfo();
        System.out.println(test.toString());
    }

    @Test
    public void testCpu(){

        
    }
}
