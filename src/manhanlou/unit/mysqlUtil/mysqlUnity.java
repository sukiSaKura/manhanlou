package manhanlou.unit.mysqlUtil;

import manhanlou.common.User;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class mysqlUnity {

      static Properties pros = null;

      static {
          pros = new Properties();
          try {
              pros.load(mysqlUnity.class.getClassLoader().getResourceAsStream("db.properties"));// 获取配置文件
          } catch (IOException e) {
              throw new RuntimeException(e);
          }

      }
      // 连接
      public static Connection connect(){
          //获取驱动
          try {
              Class.forName(pros.getProperty("mysqlDriver"));
              return DriverManager.getConnection(
                      pros.getProperty("mysqlURL"),
                      pros.getProperty("mysqlUser"),
                      pros.getProperty("mysqlPwd")
              );
          } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }



        public static void close(Connection con,PreparedStatement ps,ResultSet rs ){
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


}

