package io.jcz.antlr4;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Antlr4Example02 {

    private static final Logger LOG = LoggerFactory.getLogger(Antlr4Example01.class);

    public static void main(String[] args) {
        String s = "select UPDATE_DATE,com_acct_id,index_inf_man,COLUMN_ID,DEFAULT_VALUE,index_source_sys,cycle_id,TAR_TABLE_CODE,DIM_INDEX_UNIT,index_code,DIM_INDEX_ID,GEN_TIME,COMMON_RESTRICT_ID,DIM_INDEX_BUSI_DESC,EXP_DATE,CREATE_STAFF_NAME,DIM_INDEX_NAME,EFF_DATE,pro_restrict_id,meta_table_id,DATASOURCE_ID,status_open,DIM_INDEX_DESC,STATE,FIELD_DATA_TYPE,object_id,CREATE_DATE,order_no,out_put_mode,FIELD_CODE,TABLE_CODE,pro_index_id,pro_cycle_id,VERSION,DIM_INDEX_TECH_DESC,src_type,CREATE_STAFF,CAT_ID,INDEX_CYCLE,pro_table_id,DIM_INDEX_SRC,SUBJECT_CODE,project_id,UPDATE_STAFF from dim_index_info where DIM_INDEX_ID = 1104701";

        System.out.println(s.hashCode());

        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //t1();
        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        t2();
        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public static void t1() {
        String hexString = ByteUtils.toHexString("1q2w3e4r5t6y7u8i".getBytes());
        LOG.info("{}", hexString);
        byte[] bytes = ByteUtils.fromHexString(hexString);
        for (byte b : bytes) {
            LOG.info("{}", (char) b);
        }
    }

    public static void t2() {
        byte[] bytes = ByteUtils.fromHexString("7203166a448904be1297f4c90c42087a");
        for (byte b : bytes) {
            LOG.info("{}", (char) b);
        }
    }
}
