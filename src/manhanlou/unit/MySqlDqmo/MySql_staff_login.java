package manhanlou.unit.MySqlDqmo;

import javax.xml.transform.Result;
import java.sql.*;

public class MySql_staff_login {

        // MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/de02";

        // ���ݿ���û��������룬��Ҫ�����Լ�������
        static final String USER = "root";
        static final String PASS = "jpy150790";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try{
                // ע�� JDBC ����
                Class.forName(JDBC_DRIVER);

                // ������
                System.out.println("�������ݿ�");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                // ִ�в�ѯ
                System.out.println("ʵ��������...");
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT * FROM staff";
                ResultSet rs = stmt.executeQuery(sql);

                // չ����������ݿ�
                while(rs.next()){
                    // ͨ���ֶμ���
                    String id = rs.getString("staff_name");
                    System.out.println(id);
                }
                // ��ɺ�ر�
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                // ���� JDBC ����
                se.printStackTrace();
            }catch(Exception e){
                // ���� Class.forName ����
                e.printStackTrace();
            }finally{
                // �ر���Դ
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){
                }// ʲô������
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }

}

