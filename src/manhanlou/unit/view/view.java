package manhanlou.unit.view;

import manhanlou.common.User;
import org.testng.annotations.Test;

import java.util.Scanner;

public class view {
    public static void main(String[] args) {
        new view().view_();
    }
    @Test
    public void view_(){
        System.out.println("===========ÂúººÂ¥===========");
        System.out.println("1¡¢µÇÂ¼ÂúººÂ¥");
        System.out.println("2¡¢ÍË³öÂúººÂ¥");
        System.out.println("ÇëÊäÈëÄãµÄÑ¡Ôñ:");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        switch(key){
            case "1" :
                System.out.print("ÇëÊäÈëÔ±¹¤ºÅ:");
                String user = scanner.nextLine();
                System.out.println("ÇëÊäÈëÃÜ Âë:");
                String passwd = scanner.nextLine();
                User user1 = new User(user,passwd);
                break;
            case "2":
                System.out.println("==========ÍË³ö³É¹¦==========");
                break;
        }
    }
}
