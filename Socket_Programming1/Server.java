import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(7000);
        System.out.println("The server runs in the port 7000\n");

        Socket socket2 = serverSocket.accept();
        DataOutputStream dos2 = new DataOutputStream(socket2.getOutputStream());
        DataInputStream dis2 = new DataInputStream(socket2.getInputStream());

        while(true){
            String data = dis2.readUTF();
            if(data.equalsIgnoreCase("HI")){
                StringBuilder s = new StringBuilder();
                for(int i=1;i<=9;i++){
                 s.append("Hello").append(i).append("\n");
                }
                dos2.writeUTF(s.toString());
            }
            else if(data.equalsIgnoreCase("Hello")){
                dos2.writeUTF("Hello Client\n");
            }
            else if(data.equalsIgnoreCase("Time")){
                String time = getTime();
                dos2.writeUTF(time);
            }
            else if(data.equalsIgnoreCase("QUIT")){
                dos2.writeUTF("BYE");
                break;
            }
            else{
                dos2.writeUTF("Invalid Input\n");
            }
        }
    }

    public static String getTime(){
        SimpleDateFormat f = new SimpleDateFormat("HH:MM:SS");
        Date date = new Date();
        return(f.format(date));
    }
}
