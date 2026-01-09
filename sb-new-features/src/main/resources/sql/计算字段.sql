select
    round(
            IFNULL(
                    (
                        case
                            when SUM(t1.kxb_hb_zhsq_amt_sum) = 0 then 0
                            else SUM(t1.zdbt1_sum) / SUM(t1.kxb_hb_zhsq_amt_sum)
                            end
                        ),
                    0
            ),
            6
    ) as calculate53
/**计算字段53*/
from
    (
        select
            tb2.zdbt1_sum as zdbt1_sum,
            tb2.kxb_hb_zhsq_amt_sum as kxb_hb_zhsq_amt_sum
        from
            (
                select
                    0 as zdbt1_sum,
                    ROUND(
                            COALESCE(
                                    SUM(CAST(tb1.KXB_HB_ZHSQ_AMT AS decimal(22, 6))),
                                    0
                            ),
                            6
                    ) as kxb_hb_zhsq_amt_sum
                from
                    test_db.APP_ZBKYS_RPT_CORE_PROD_INCOME_NEWTYPE_DTL_M1 tb1
                where
                    (tb1.MON_ID = '202512')
            ) tb2
        union all
        select
            tb4.zdbt1_sum as zdbt1_sum,
            tb4.kxb_hb_zhsq_amt_sum as kxb_hb_zhsq_amt_sum
        from
            (
                select
                    ROUND(
                            COALESCE(SUM(CAST(tb3.ZDBT1 AS decimal(22, 6))), 0),
                            6
                    ) as zdbt1_sum,
                    0 as kxb_hb_zhsq_amt_sum
                from
                    test_db.APP_ZBKYS_RPT_CORE_PROD_INCOME_NEWTYPE_DTL_M2 tb3
                where
                    (tb3.MON_ID = '202512')
            ) tb4
    ) t1