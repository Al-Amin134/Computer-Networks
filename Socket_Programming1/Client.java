import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)throws Exception {
        Socket socket = new Socket("Localhost",7000);
        System.out.println("The client is running on the port 7000\n");

       DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
       DataInputStream dis = new DataInputStream(socket.getInputStream());

       Scanner scanner = new Scanner(System.in);

       while(true){
        String message = scanner.nextLine();
        dos.writeUTF(message);

        String res = dis.readUTF();
        System.out.println(res);
        if(res.equalsIgnoreCase("BYE")){
            break;
        }
       }
    }
}
