package io.github.marcelofiddelis.hwmonitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.marcelofiddelis.hwmonitor.utils.RuntimeWindows;

public class HwmonitorTest {

    @Test
    public void shouldAnswerWithTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void Teste() {
        String test[] = RuntimeWindows.getCpuInfo();
        System.out.println(test[4]);
    }

}
