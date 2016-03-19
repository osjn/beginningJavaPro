package socketexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        // listen to incoming connections at port 9000
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            String message = null;
            while (!"STOP".equals(message)) {
                // accept incoming client
                System.out.println("Waiting for connection...");
                try (
                        // set up socket for connection with client
                        Socket connectionSocket = serverSocket.accept();
                        // set up input stream reader (from client)
                        DataInputStream incoming =
                                new DataInputStream(connectionSocket.getInputStream());
                        // set up output stream writer (to client)
                        DataOutputStream outgoing =
                                new DataOutputStream(connectionSocket.getOutputStream())
                    )
                {
                    // get the message the client sent
                    System.out.println("Waiting for message...");
                    message = incoming.readUTF().trim();
                    System.out.println("CLIENT SAID: " + message);
                    // Send message back
                    outgoing.writeUTF("MESSAGE RECEIVED\n");
                    if ("STOP".equals(message)) {
                        // send additional line
                        outgoing.writeUTF("SERVER CLOSING DOWN\n");
                    }
                    // close output stream to indicate that no more data is to be sent
                    outgoing.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
