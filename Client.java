import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;

    public Client(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}

class MessageListener implements Runnable {
    private DataInputStream dis;

    public MessageListener(DataInputStream dis) {
        this.dis = dis;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String serverMsg = dis.readUTF();
                System.out.println(serverMsg);
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    dis.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
    }
}
