package io.github.marcelofiddelis.hwmonitor.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing Class for the <code>{@Link OSIdentifier}</code> class
 */
public class OSIdentifierTest {
    

    @Test
    // @Disabled
    public void shoultReturnTheOsNameLinux(){
        Assertions.assertEquals("Linux", OSIdentifier.getOs());
    }

}
