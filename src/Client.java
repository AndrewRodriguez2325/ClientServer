import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String ip = "localhost";
        int port = 9999;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What number would you like to see factors for");
            int choice = scanner.nextInt();

            Socket s = new Socket(ip, port);

            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            PrintWriter os = new PrintWriter(out, true);
            ArrayList factors = new ArrayList();

            if (choice > 0) {
                for (int i = 1; i <= choice; ++i) {
                    if (choice % i == 0) {
                        factors.add(i);
                    }
                }
            } else {
                for (int i = choice; i <= Math.abs(choice); ++i) {
                    if (i == 0) {
                        continue;
                    } else {
                        if (choice % i == 0) {
                            factors.add(i);
                        }
                    }
                }
            }

            String output = factors.toString();
            os.println(output);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
