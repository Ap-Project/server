import database.Database;
import database.Table;
import models.Menu;
import models.RestaurantUser;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(208);
        Database.getInstance().add("restaurantRegister",new Table(RestaurantUser.file));
        Database.getInstance().add("menu",new Table(Menu.menuFile));
        try {
            while (true) {
                Socket socket = ss.accept();
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            ss.close();
        }
    }
}
