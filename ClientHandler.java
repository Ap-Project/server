import models.Menu;
import models.RestaurantUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private DataInputStream dis;
    private DataOutputStream dos;
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
            String input = dis.readLine();
            System.out.println(input);
            String[] splitCommands = input.split("--");
            if (splitCommands[0].equals("restaurant")){
                switch (splitCommands[1]){
                    case "register" : restaurantRegistration(splitCommands,dos);
                    break;
                    case "getMenu":
                        break;
                    case "addMenu":
                }


            }else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    void restaurantRegistration(String[] splitCommands,DataOutputStream dos) throws IOException {
        RestaurantUser restaurantUser = new RestaurantUser(splitCommands);
        String response = restaurantUser.serverResponseToRegister();
        dos.writeBytes(response);
        System.out.println(response);
        dos.flush();
    }

}
