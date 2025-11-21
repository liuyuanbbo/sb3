package org.zmz.sb3.newfeatures.spi.impl;

import org.zmz.sb3.newfeatures.spi.MyDriver;

public class PostgreSqlMyDriverImpl implements MyDriver {
    @Override
    public String ping() {
        return ">>> Postgresql Ping >>>";
    }
}
