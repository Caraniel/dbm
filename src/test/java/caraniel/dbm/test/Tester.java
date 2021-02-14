package caraniel.dbm.test;

import caraniel.dbm.DBMUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Tester
{
  private void start()
    throws Exception
  {
    DataSource dataSource = DBMUtil.getDataSource();


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
      new Tester().start();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
