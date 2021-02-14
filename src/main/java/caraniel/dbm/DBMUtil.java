package caraniel.dbm;

import caraniel.dbm.bean.DBConfig;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;

public class DBMUtil
{
  public static DataSource getDataSource(DBConfig dbConfig)
    throws Exception
  {
    return getDataSource(dbConfig.getDriver(), dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword());
  }

  public static DataSource getDataSource(String driver, String url, String user, String password)
    throws Exception
  {
    Class.forName(driver);
    ObjectPool connectionPool = new GenericObjectPool(null);
    ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, user, password);
    new PoolableConnectionFactory(connectionFactory, connectionPool, null, null, false, true);
    return new PoolingDataSource(connectionPool);
  }
}
