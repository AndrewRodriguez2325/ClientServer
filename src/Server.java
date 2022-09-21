import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            System.out.println("S: Starting Server");
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("S: Waiting for Connection...");
            Socket s = ss.accept();
            System.out.println("S: Connection is Established");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String testServer = br.readLine();
            System.out.println(testServer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
