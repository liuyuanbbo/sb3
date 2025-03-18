update dc_sql
set dc_sql.dc_sql = 'SELECT \'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_TOTAL_COUNT\' code, \'标签总数\' name, COUNT(1) count, 1 seq ,\'iconicon_biaoqian\' as icon,\'purple\' as \'bgClass\',\'#5E6CFC\' as \'color\' FROM injection_label a where a.status_cd not in (\'1300\',\'1900\') '
where dc_name = 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_TOTAL_COUNT';
-- 在用
delete
from dc_sql
where dc_name = 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_INUSE_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题标签在用', 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_INUSE_COUNT',
        'SELECT \'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_INUSE_COUNT\' AS code, \'在用\' AS name, COUNT(1) AS count, 1 AS seq,\'iconicon_biaoqian\' AS icon,\'purple\' AS bgClass,\'#5E6CFC\' AS color FROM injection_label a WHERE a.status_cd NOT IN (\'1100\', \'1300\', \'1700\', \'1900\')',
        '重庆标签库首页标题标签在用', NOW(), 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_INUSE_COUNT',
        '重庆标签库首页标题标签在用', NULL, NULL, NULL);
-- 下线
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题标签下线', 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_COUNT\' code, \'下线\' name, COUNT(1) count, 1 seq ,\'iconicon_biaoqian\' as icon,\'purple\' as \'bgClass\',\'#5E6CFC\' as \'color\' FROM injection_label a where a.status_cd = \'1100\'',
        '重庆标签库首页标题标签下线', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_COUNT',
        '重庆标签库首页标题标签下线', NULL, NULL, NULL); ;
-- 冻结
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_FREEZE_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题标签冻结', 'INJECTION_LABEL_HOME_PAGE_TITLE_FREEZE_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_FREEZE_COUNT\' code, \'冻结\' name, COUNT(1) count, 1 seq ,\'iconicon_biaoqian\' as icon,\'purple\' as \'bgClass\',\'#5E6CFC\' as \'color\' FROM injection_label a where a.status_cd = \'1700\'' ,
        '重庆标签库首页标题标签冻结', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_FREEZE_COUNT',
        '重庆标签库首页标题标签冻结', NULL, NULL, NULL);
-- 失效
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_INVALID_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题标签失效', 'INJECTION_LABEL_HOME_PAGE_TITLE_INVALID_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_INVALID_COUNT\' code, \'失效\' name, COUNT(1) count, 1 seq ,\'iconicon_biaoqian\' as icon,\'purple\' as \'bgClass\',\'#5E6CFC\' as \'color\' FROM injection_label a where a.status_cd = \'1900\'' ,
        '重庆标签库首页标题标签失效', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_INVALID_COUNT',
        '重庆标签库首页标题标签失效', NULL, NULL, NULL);

-- 本年新增
delete
from dc_sql
where dc_name = 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_YEAR_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本年新增', 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_YEAR_COUNT',
        'SELECT \'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_YEAR_COUNT\' code, \'本年新增\' name, COUNT(DISTINCT a.injection_label_id) count, 4 seq,\'icona-192fundbeifen34\' as icon,\'green\' as \'bgClass\',\'#29D491\' as \'color\'   FROM injection_label a  WHERE a.status_cd not in (\'1300\',\'1900\') and   DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 0 YEAR),\'%Y\')=DATE_FORMAT(a.create_date ,\'%Y\')' ,
        '重庆标签库首页标题本年新增', NOW(), 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_YEAR_COUNT',
        '重庆标签库首页标题本年新增', NULL, NULL, NULL);

-- 本月新增
delete
from dc_sql
where dc_name = 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_MONTH_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本月新增', 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_MONTH_COUNT',
        'SELECT \'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_MONTH_COUNT\' code, \'本月新增\' name, COUNT(DISTINCT a.injection_label_id) count, 4 seq,\'icona-192fundbeifen34\' as icon,\'green\' as \'bgClass\',\'#29D491\' as \'color\'   FROM injection_label a  WHERE a.status_cd not in (\'1300\',\'1900\') AND DATE_FORMAT(a.create_date, \'%Y%m\') = DATE_FORMAT(CURDATE(), \'%Y%m\')' ,
        '重庆标签库首页标题本月新增', NOW(), 'CHONGQING_INJECTION_LABEL_HOME_PAGE_TITLE_CREATE_MONTH_COUNT',
        '重庆标签库首页标题本月新增', NULL, NULL, NULL);
-- 本年下线
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本年下线', 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT\' code, \'本年下线\' name, COUNT(DISTINCT a.injection_label_id ) count, 5 seq,\'icona-192fundbeifen35\' as icon,\'orange\' as \'bgClass\',\'#FF6549\' as \'color\'  FROM injection_label a WHERE  a.status_cd = \'1100\' and  DATE_FORMAT(a.status_date, \'%Y\') = DATE_FORMAT(CURDATE(),\'%Y\')' ,
        '重庆标签库首页标题本年下线', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT',
        '重庆标签库首页标题本年下线', NULL, NULL, NULL);
-- 本月下线
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_MONTH_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本年下线', 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT\' code, \'本年下线\' name, COUNT(DISTINCT a.injection_label_id ) count, 5 seq,\'icona-192fundbeifen35\' as icon,\'orange\' as \'bgClass\',\'#FF6549\' as \'color\'  FROM injection_label a WHERE  a.status_cd = \'1100\' and  DATE_FORMAT(a.status_date, \'%Y%m\') = DATE_FORMAT(CURDATE(),\'%Y%m\')' ,
        '重庆标签库首页标题本年下线', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_OFFLINE_YEAR_COUNT',
        '重庆标签库首页标题本年下线', NULL, NULL, NULL);
-- 本年冻结
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_FREEZE_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本年冻结', 'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_FREEZE_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_FREEZE_COUNT\' code, \'本年冻结\' name, COUNT(DISTINCT a.injection_label_id ) count, 5 seq,\'icona-192fundbeifen35\' as icon,\'orange\' as \'bgClass\',\'#FF6549\' as \'color\'  FROM injection_label a WHERE  a.status_cd = \'1700\' and  DATE_FORMAT(a.status_date, \'%Y\') = DATE_FORMAT(CURDATE(),\'%Y\')' ,
        '重庆标签库首页标题本年冻结', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_FREEZE_COUNT',
        '重庆标签库首页标题本年冻结', NULL, NULL, NULL);
-- 本月冻结
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_FREEZE_COUNT';


-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本月冻结', 'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_FREEZE_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_FREEZE_COUNT\' code, \'本年月结\' name, COUNT(DISTINCT a.injection_label_id ) count, 5 seq,\'icona-192fundbeifen35\' as icon,\'orange\' as \'bgClass\',\'#FF6549\' as \'color\'  FROM injection_label a WHERE  a.status_cd = \'1700\' and  DATE_FORMAT(a.status_date, \'%Y%m\') = DATE_FORMAT(CURDATE(),\'%Y%m\')' ,
        '重庆标签库首页标题本月冻结', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_FREEZE_COUNT',
        '重庆标签库首页标题本月冻结', NULL, NULL, NULL);
-- 本年失效
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_INVALID_COUNT';

-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本年失效', 'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_INVALID_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_INVALID_COUNT\' code, \'本年失效\' name, COUNT(DISTINCT a.injection_label_id ) count, 5 seq,\'icona-192fundbeifen35\' as icon,\'orange\' as \'bgClass\',\'#FF6549\' as \'color\'  FROM injection_label a WHERE  a.status_cd = \'1900\' and  DATE_FORMAT(a.status_date, \'%Y\') = DATE_FORMAT(CURDATE(),\'%Y\')' ,
        '重庆标签库首页标题本年失效', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_YEAR_INVALID_COUNT',
        '重庆标签库首页标题本年失效', NULL, NULL, NULL);
-- 本月失效
delete
from dc_sql
where dc_name = 'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_INVALID_COUNT';
-- udal
INSERT INTO dc_sql(dc_sql_id, DC_SQL_NAME, dc_name, DC_SQL, DC_DESC, create_date, DC_SQL_CODE, DC_SQL_DESC, DC_SQL_INFO,
                   FROM_TYPE, dc_datasource_code)
VALUES (SEQ_DC_SQL.NEXTVAL, '重庆标签库首页标题本月失效', 'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_INVALID_COUNT',
        'SELECT \'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_INVALID_COUNT\' code, \'本月失效\' name, COUNT(DISTINCT a.injection_label_id ) count, 5 seq,\'icona-192fundbeifen35\' as icon,\'orange\' as \'bgClass\',\'#FF6549\' as \'color\'  FROM injection_label a WHERE  a.status_cd = \'1900\' and  DATE_FORMAT(a.status_date, \'%Y%m\') = DATE_FORMAT(CURDATE(),\'%Y%m\')' ,
        '重庆标签库首页标题本月失效', NOW(), 'INJECTION_LABEL_HOME_PAGE_TITLE_MONTH_INVALID_COUNT',
        '重庆标签库首页标题本月失效', NULL, NULL, NULL);