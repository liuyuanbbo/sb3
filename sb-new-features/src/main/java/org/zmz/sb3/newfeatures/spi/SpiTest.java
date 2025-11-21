package org.zmz.sb3.newfeatures.spi;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<MyDriver> myDrivers = ServiceLoader.load(MyDriver.class);

        for (MyDriver myDriver : myDrivers) {
            System.out.println(myDriver.ping());
        }
    }
}
