package org.zmz.sb3.redis.seckill.config;

/*
@Configuration
@MapperScan(basePackages = "org.zmz.sb3.redis.seckill.mapper",
        sqlSessionTemplateRef = "mySqlSessionTemplate")
public class MySqlSessionFactoryConfig {

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDataSource;

    @Bean(name = "mySqlSessionFactory")
    @Primary
    public SqlSessionFactory mySqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "myTransactionManager")
    @Primary
    public DataSourceTransactionManager myTransactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource);
    }

    @Bean(name = "mySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mySqlSessionTemplate(@Qualifier("mySqlSessionFactory") SqlSessionFactory mySqlSessionFactory) {
        return new SqlSessionTemplate(mySqlSessionFactory);
    }

}*/
