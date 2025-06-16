package org.zmz.flink.basic.wc;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class SocketWordCountDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment streamEnv = StreamExecutionEnvironment.getExecutionEnvironment();
        streamEnv.socketTextStream("192.168.110.121", 9999).flatMap((String s, Collector<Tuple2<String, Integer>> out) -> {
                    String[] items = s.split(" ");
                    for (String item : items) {
                        Tuple2<String, Integer> tuple2 = Tuple2.of(item, 1);
                        out.collect(tuple2);
                    }
                })
                .returns(Types.TUPLE(Types.STRING, Types.INT))
                .keyBy(t -> t.f0)
                .sum(1)
                .print();

        streamEnv.execute();
    }
}
