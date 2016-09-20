import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client 
{
	public static void main(String[] args) {
	    Socket smtpSocket = null;  
        DataOutputStream os = null;
        DataInputStream is = null;

        try 
        {
            smtpSocket = new Socket("localhost", 9999);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
        } 
        catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } 
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
        
        if (smtpSocket != null && os != null && is != null) 
        {
            try 
            {
            	Scanner scanner = new Scanner(System.in);
            	
            	String command = scanner.nextLine();
            	
            	os.writeBytes(command + "\n");
            	
            	Scanner inputScanner = new Scanner(is);
            	String response;
               
            	while ((response = inputScanner.nextLine()) != null)
                {
                    System.out.println("Server: " + response);
                }
            	
            	os.close();
                is.close();
                scanner.close();
                inputScanner.close();
                smtpSocket.close();   
            } 
            catch (UnknownHostException e)
            {
                System.err.println("Trying to connect to unknown host: " + e);
            } 
            catch (IOException e)
            {
                System.err.println("IOException:  " + e);
            }
        }
    } 
}
