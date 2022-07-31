package manhanlou.unit.MySqlDqmo;

import manhanlou.common.User;

import javax.xml.transform.Result;
import java.sql.*;

public class MySql_staff_login {

        // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/de02";

        // 数据库的用户名与密码，需要根据自己的设置
        static final String USER = "root";
        static final String PASS = "jpy150790";

        public  boolean mysqlSelect(String SelectSql, User usr) {
            Connection conn = null;
            //可以向数据库发送 sql语句 的 Statement 对象
            Statement stmt = null;
            try{
                // 注册 JDBC 驱动
                Class.forName(JDBC_DRIVER);

                // 打开链接
                System.out.println("连接数据库");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                // 执行查询
                System.out.println("实例化对象...");
                stmt = conn.createStatement();

                ResultSet rs = null;
                if (SelectSql == SqlProgram.select_staff) {
                    String sql = SelectSql;
                    rs = stmt.executeQuery(sql);

                    // 展开结果集数据库
                    while(rs.next()){
                        // 通过字段检索
                        String id = rs.getString("staff_name");
                        String pass = rs.getString("staff_passwd");
                        if(id == usr.getUsername() && pass == usr.getPassed()){
                            return true;
                        }
                    }
                }
                // 完成后关闭
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                // 处理 JDBC 错误
                se.printStackTrace();
            }catch(Exception e){
                // 处理 Class.forName 错误
                e.printStackTrace();
            }finally{
                // 关闭资源
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){
                }// 什么都不做
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
            return false;
        }

}

