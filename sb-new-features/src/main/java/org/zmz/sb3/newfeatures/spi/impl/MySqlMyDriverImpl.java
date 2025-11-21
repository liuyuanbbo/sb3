package org.zmz.sb3.newfeatures.spi.impl;

import org.zmz.sb3.newfeatures.spi.MyDriver;

public class MySqlMyDriverImpl implements MyDriver {
    @Override
    public String ping() {
        return ">>> MySql Ping >>>";
    }
}
