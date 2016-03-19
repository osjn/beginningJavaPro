package socketexample;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try (
                // create a socket connecting to server
                Socket clientSocket = new Socket("localhost", 9000);
                // set up input stream reader to read keyboard input
                BufferedReader keyboardReader =
                    new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
                // set up input stream reader (from server)
                DataInputStream incoming =
                    new DataInputStream(clientSocket.getInputStream());
                // set up output stream writer (to server)
                DataOutputStream outgoing =
                    new DataOutputStream(clientSocket.getOutputStream());
            ) {
            // Read message from user
            System.out.println("Enter message to send to server: ");
            String message = keyboardReader.readLine();
            // send message to server
            outgoing.writeUTF(message + '\n');
            // read the reply form server
            System.out.println("Server replied: ");
            try {
                String reply = incoming.readUTF();
                System.out.print(reply);
            } catch (EOFException eof) {
                // do nothing... server has closed the connection
            }
            // close the connection
            clientSocket.close();
            System.out.println("Connection closed gracefully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
