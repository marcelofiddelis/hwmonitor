package io.github.marcelofiddelis.hwmonitor.utils.filehandler;


import java.util.Map;

import org.junit.jupiter.api.Test;


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
