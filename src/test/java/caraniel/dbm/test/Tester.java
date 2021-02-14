package caraniel.dbm.test;

import caraniel.dbm.DBMUtil;
import caraniel.dbm.bean.DBConfig;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Properties;

public class Tester
{
  private void start(DBConfig dbConfig)
    throws Exception
  {
    DataSource dataSource = DBMUtil.getDataSource(dbConfig);

    Connection connection = dataSource.getConnection();
    DatabaseMetaData metaData = connection.getMetaData();

    ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
    System.out.println("Printing TABLE_TYPE \"TABLE\" ");
    System.out.println("----------------------------------");
    while(resultSet.next())
    {
      //Print
      System.out.println(resultSet.getString("TABLE_NAME"));


    }

    int i = 0;
  }

  public static void main(String[] args)
  {
    try
    {
      Properties properties = new Properties();
      properties.load(new FileInputStream("dbconfig.properties"));

      new Tester().start(new DBConfig(properties.getProperty("source.driver"), properties.getProperty("source.url"), properties.getProperty("source.user"),
        properties.getProperty("source.password")));
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
