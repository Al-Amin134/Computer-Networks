import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Base64;

class AZ{
    private static DataOutputStream dos;
    private static BufferedReader br;

    public static void main(String[] args)throws Exception{
        String user = "s2110676134@ru.ac.bd";
        String pass ="";
        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocket s = (SSLSocket)SSLSocketFactory.getDefault().createSocket("smtp.gmail.com",465);
        dos= new DataOutputStream(s.getOutputStream());
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));

       send("EHLO smtp.gmail.com \r\n");
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());

        send("AUTH LOGIN\r\n");
        System.out.println("SERVER: "+ br.readLine());
        send(username+"\r\n");
        System.out.println("SERVER: "+ br.readLine());
        send(password+"\r\n");
        System.out.println("SERVER: "+ br.readLine());

        send("MAIL FROM:<s2110676134@ru.ac.bd>"+"\r\n");
        System.out.println("SERVER: "+ br.readLine());
        send("RCPT TO:<mdalaminbabu.210@gmail.com>"+"\r\n");
        System.out.println("SERVER: "+ br.readLine());
        send("DATA \r\n");
        System.out.println("SERVER: "+ br.readLine());


        send("FROM:s2110676134@ru.ac.bd \r\n");
        send("TO:mdalaminbabu.210@gmail.com\r\n");
        send("SUBJECT: 3Y1S2023\r\n");
        send("Roll 2110676134 \r\n");
//        send("Time is "+ LocalDateTime.now());
        send(".\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send("QUIT\r\n");
        System.out.println("SERVER: "+ br.readLine());



    }
private static void send(String s)throws Exception{
        dos.writeBytes(s);
        Thread.sleep(1000);
    System.out.println("CLIENT: \r\n"+s);
}
}

