package app.dao;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.sql.DataSource;
import java.util.Properties;

public class DBCPDataSourcePool {

    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "1234");

        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory("jdbc:postgresql://localhost/insurance_service", properties);

        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);

        GenericObjectPoolConfig config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(25);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        ObjectPool connectionPool = new GenericObjectPool<>(poolableConnectionFactory, config);
        poolableConnectionFactory.setPool(connectionPool);

        dataSource = new PoolingDataSource<>(connectionPool);
    }
}
