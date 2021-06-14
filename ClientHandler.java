import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private DataInputStream dis;
    private DataOutputStream dos;
    private String username;
    public ClientHandler(Socket socket){
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            String input = dis.readUTF();
            String[] splitCommands = input.split("-");
            if (splitCommands[0].equals("restaurant")){
                if (splitCommands[1].equals("register")){

                }

            }else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
