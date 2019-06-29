import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.*;

public class MessageClient{
	public static String DEFAULT_SERVER_HOST = "localhost";
	

	public static void main(String[] args) throws Exception, IOException{
		// Argumentos do programa: <IP do servidor> <Porta do servidor>
		String serverHost = args.length > 0 ? args[0] : DEFAULT_SERVER_HOST;
		int serverPort = args.length > 1 ? Integer.parseInt(args[1]) : MessageServer.DEFAULT_PORT;

		try {
			Socket client = new Socket(args[0], serverPort); //instanciando socket
			DataInputStream in = new DataInputStream(client.getInputStream()); //Cria o fluxo de entrada no canal servidor-cliente
			DataOutputStream out = new DataOutputStream(client.getOutputStream()); //Cria o fluxo de saída no canal de comunicação cliente-servidor
			out.writeUTF("Jorge e José Leonardo"); //Escreve a mensagem no fluxo de saída
			String variavel = in.readUTF(); //Lê o fluxo de entrada
			out.writeUTF(variavel); //Fluxo de saída para armazenar a variável mandada pelo servidor
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
