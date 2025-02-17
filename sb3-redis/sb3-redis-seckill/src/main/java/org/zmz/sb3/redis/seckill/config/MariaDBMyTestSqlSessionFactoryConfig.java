package org.zmz.sb3.redis.seckill.config;

/*
@Configuration
@MapperScan(basePackages = "org.zmz.sb3.redis.seckill.mapper",
        sqlSessionTemplateRef = "mariadbMyTestSqlSessionTemplate")
public class MariaDBMyTestSqlSessionFactoryConfig {

    @Autowired
    @Qualifier("mariaMyTestDataSource")
    private DataSource mariaMyTestDataSource;

    @Bean(name = "mariadbMyTestSqlSessionFactory")
    @Primary
    public SqlSessionFactory mariadbMyTestSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mariaMyTestDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mariadbMyTestTransactionManager")
    @Primary
    public DataSourceTransactionManager mariadbMyTestTransactionManager() {
        return new DataSourceTransactionManager(mariaMyTestDataSource);
    }

    @Bean(name = "mariadbMyTestSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate eqbSqlSessionTemplate(@Qualifier("mariadbMyTestSqlSessionFactory") SqlSessionFactory mariadbMyTestSqlSessionFactory) {
        return new SqlSessionTemplate(mariadbMyTestSqlSessionFactory);
    }

}*/
