package manhanlou.unit.view;

import manhanlou.common.User;
import manhanlou.unit.mysqlUtil.SqlProgram;
import manhanlou.unit.service.check;
import org.testng.annotations.Test;
import java.io.*;
import java.util.Scanner;

public class view {
    check check = new check();
    public static void main(String[] args) {
        new view().view_();
    }
    @Test
    public void view_(){

        System.out.println("===========����¥===========");
        System.out.println("1����¼����¥");
        System.out.println("2���˳�����¥");
        System.out.println("���������ѡ��:");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String key = scanner.nextLine();
            switch(key){
                case "1" :
                    System.out.print("������Ա����:");
                    String user = scanner.nextLine();
                    System.out.println("�������� ��:");
                    String passwd = scanner.nextLine();
                    User user1 = new User(user,passwd);

                    break;
                case "2":
                    System.out.println("==========�˳��ɹ�==========");
                    flag = false;
                    break;
            }
        }
    }
}
