import controll.DBConnect;

/**
 * Created by Marc100 on 02.12.2018.
 * https://openflights.org/data.html
 */
public class Main {

    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();

        dbConnect.getData();
        System.out.println("adsfsd");
    }
}
