package io.jcz.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderLineTest {

    public static final Logger LOG = LoggerFactory.getLogger(BufferReaderLineTest.class);

    public static void main(String[] args) throws IOException {
        String json = """
                {
                    "pageIndex": 1,
                    "pageSize": 10,
                    "ssoType": "PASSWD_TOKEN"
                }
                """;
        ByteArrayInputStream bais = new ByteArrayInputStream(json.getBytes());
        BufferedReader buf = new BufferedReader(new InputStreamReader(bais));

        String line;

        StringBuilder sb = new StringBuilder();
        while ((line = buf.readLine()) != null) {
            sb.append(line);
        }

        LOG.info("{}", sb);
    }
}
