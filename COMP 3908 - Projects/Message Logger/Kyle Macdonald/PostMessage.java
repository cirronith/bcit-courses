import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;


public class PostMessage {
	private static final String hostname = "mlogger.trollop.org"; // use this if testing remotely
	//private static final String hostname = "windev.trollop.org";
	private static final int port = 3141; // use this if testing remotely
	//private static final int port = 80;


	/*
	 * Default constructor
	 */
	PostMessage() {
	}

	public void PostNewMessage(long sessionID, String title, String message,
								String data, String type) {
		try {
			String xmldata =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<soap:Envelope " + 
			"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + 
			"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
			"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body>" +
					// This is the function we're calling
					"<PostNewMessage xmlns=\"http://virus-box/MLogger\">" +
						"<sessionID>" + sessionID + "</sessionID>" +
						"<title>" + title + "</title>" +
						"<message>" + message + "</message>" +
					"</PostNewMessage>" +
					"<PostMsgAttachment xmlns=\"http://virus-box/MLogger\">" +
						"<sessionID>" + sessionID + "</sessionID>" +
						"<data>" + data + "</data>" +
						"<type>" + type + "</type>" +
					"</PostMsgAttachment>" +
				"</soap:Body>" +
			"</soap:Envelope>";
			
			InetAddress  addr = InetAddress.getByName(hostname);
			Socket sock = new Socket(addr, port);

			//Send header
			String path = "/MLogger/MLService.asmx";
			BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
			// You can use "UTF8" for compatibility with the Microsoft virtual machine.
			wr.write("POST " + path + " HTTP/1.0\r\n");
			wr.write("Host: " + hostname + "\r\n");
			wr.write("Content-Length: " + xmldata.length() + "\r\n");
			wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
			wr.write("\r\n");

			//Send data
			wr.write(xmldata);
			wr.flush();

			// Response
			BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String line;
			while((line = rd.readLine()) != null)
				System.out.println(line);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PostTest() {
		try {
			String xmldata = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<soap:Envelope " + 
			"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + 
			"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
			"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body>" +
					// This is the function we're calling
					"<PostTestOne xmlns=\"http://virus-box/MLogger\">" +
					"</PostTestOne>" +
				"</soap:Body>" +
			"</soap:Envelope>";

			InetAddress  addr = InetAddress.getByName(hostname);
			Socket sock = new Socket(addr, port);

			//Send header
			String path = "/MLogger/MLService.asmx";
			BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
			// You can use "UTF8" for compatibility with the Microsoft virtual machine.
			wr.write("POST " + path + " HTTP/1.0\r\n");
			wr.write("Host: " + hostname + "\r\n");
			wr.write("Content-Length: " + xmldata.length() + "\r\n");
			wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
			wr.write("\r\n");

			//Send data
			wr.write(xmldata);
			wr.flush();

			// Response
			BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String line;
			while((line = rd.readLine()) != null)
				System.out.println(line);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
