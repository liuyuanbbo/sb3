package io.jcz.creator;


import io.jcz.propterties.DataSourceProperty;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.List;

public class DefaultDataSourceCreator {

    private List<DataSourceCreator> dataSourceCreators;

    public DefaultDataSourceCreator(List<DataSourceCreator> dataSourceCreators) {
        this.dataSourceCreators = dataSourceCreators;
    }

    public DataSource createDataSource(DataSourceProperty dataSourceProperty) {
        if (CollectionUtils.isEmpty(dataSourceCreators)) {
            throw new RuntimeException("当前没有创建数据源的执行器");
        }
        for (DataSourceCreator creator : dataSourceCreators) {
            if (creator.support(dataSourceProperty)) {
                return creator.createDataSource(dataSourceProperty);
            }
        }
        throw new RuntimeException(String.format("当前没有合适 %s 的创建数据源的执行器", dataSourceProperty.getType()));
    }
}