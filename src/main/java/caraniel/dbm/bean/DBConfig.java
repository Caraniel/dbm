package caraniel.dbm.bean;

public class DBConfig
{
  private String driver;
  private String url;
  private String user;
  private String password;

  public DBConfig(String driver, String url, String user, String password)
  {
    this.driver = driver;
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public String getDriver()
  {
    return driver;
  }

  public String getUrl()
  {
    return url;
  }

  public String getUser()
  {
    return user;
  }

  public String getPassword()
  {
    return password;
  }
}
