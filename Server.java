import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    static Map<String, ClientHandler> users;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(207);
        users = new ConcurrentHashMap<>();
        Database.getInstance().add("restaurantRegister",new Table("E:\\class online\\term 2\\barnamenevisi pishrafte\\SnapFood\\data_storage\\restaurant_register.txt"));
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
