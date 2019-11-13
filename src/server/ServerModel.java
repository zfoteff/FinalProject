package server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerModel
{
    public static final String CLOSING = "closing";
    protected ServerController controller;
    protected static int portNum = 8080;
    protected static boolean listening = false;
    protected ServerSocket serverSocket;
    protected Socket clientSocket;

    public ServerModel(int portNum)
    {
        this.portNum = portNum;
    }

    public void setController(ServerController controller)
    {
        this.controller = controller;
    }

    public void startListening()
    {
        listening = true;
        clientSocket = new Socket();

        try {
            serverSocket = new ServerSocket(portNum);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (listening)
        {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopListening()
    {
        listening = false;

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(CLOSING);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
