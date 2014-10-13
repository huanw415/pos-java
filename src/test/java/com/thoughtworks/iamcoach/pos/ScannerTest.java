package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ScannerTest {
    @Test
    public void can_getInputs(){
        Scanner scanner = new Scanner();

        assertThat(scanner.getInputs().size()).isEqualTo(9);
        assertThat(scanner.getInputs().get(0)).isEqualTo("ITEM000001");
    }
}
