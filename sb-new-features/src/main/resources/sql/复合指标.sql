select round(
               IFNULL(
                       (
                           case
                               when SUM(t1.SUM_KXB_HB_ZHSQ_AMT) = 0 then 0
                               else SUM(t1.SUM_ZDBT1) / SUM(t1.SUM_KXB_HB_ZHSQ_AMT)
                               end
                           ),
                       0
               ),
               2
       ) as composite701_sum
/**复合指标701_202601091348*/
from (select tb2.SUM_ZDBT1           as SUM_ZDBT1,
             tb2.SUM_KXB_HB_ZHSQ_AMT as SUM_KXB_HB_ZHSQ_AMT
      from (select 0 as SUM_ZDBT1,
                   ROUND(
                           COALESCE(
                                   SUM(CAST(tb1.KXB_HB_ZHSQ_AMT AS decimal(15, 3))),
                                   0
                           ),
                           3
                   ) as SUM_KXB_HB_ZHSQ_AMT
            from test_db.APP_ZBKYS_RPT_CORE_PROD_INCOME_NEWTYPE_DTL_M1 tb1
            where (tb1.MON_ID = '202511')) tb2
      union all
      select tb4.SUM_ZDBT1           as SUM_ZDBT1,
             tb4.SUM_KXB_HB_ZHSQ_AMT as SUM_KXB_HB_ZHSQ_AMT
      from (select ROUND(
                           COALESCE(SUM(CAST(tb3.ZDBT1 AS decimal(15, 3))), 0),
                           3
                   ) as SUM_ZDBT1,
                   0 as SUM_KXB_HB_ZHSQ_AMT
            from test_db.APP_ZBKYS_RPT_CORE_PROD_INCOME_NEWTYPE_DTL_M2 tb3
            where (tb3.MON_ID = '202511')) tb4) t1;