import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;


public class PostXML {
	private static final String hostname = "windev.trollop.org"; // use this if testing remotely
	private static final int port = 3141;
	private static final String path = "/MLogger/MLService.asmx";
	

	/*
	 * Default constructor
	 */
	PostXML() {
	}
	
	public void PostMessage() {
		try {
			String xmldata = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<soap:Envelope " + 
			"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + 
			"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
			"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body>" +
					// This is the function we're calling
					"<PostMessage xmlns=\"http://virus-box/MLogger\">" +
						"<postContents>" +
							"<sessionID>1234567890</sessionID>" +
							"<title>Memo Title</title>" +
							"<message>Memo Descrioption</message>" +
							"<dataType>gif-image</dataType>" +
							"<data>R0lGODlhKAAeAIAAAHZ+5gAAACwAAAAAKAAeAAACIYSPqcvtD6Oc" +
								   "tNqLs968+w+G4kiW5omm6sq27gvH8kxzBQA7</data>" +
							"<dataType>gif-image</dataType>" +
							"<data>R0lGODlhKAAeAIAAAHZ+5gAAACwAAAAAKAAeAAACIYSPqcvtD6Oc" +
								   "tNqLs968+w+G4kiW5omm6sq27gvH8kxzBQA7</data>" +
						"</postContents>" +
					"</PostMessage>" +
				"</soap:Body>" +
			"</soap:Envelope>";

			InetAddress  addr = InetAddress.getByName(hostname);
			Socket sock = new Socket(addr, port);

			//Send header
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
	
	public void LoginTest(String userName, String password) {
		try {
			String xmldata = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<soap:Envelope " + 
			"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + 
			"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
			"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body>" +
					// This is the function we're calling
					"<UserLogin xmlns=\"http://virus-box/MLogger\">" +
						"<userName>" + userName + "</userName>" +
						"<password>" + password + "</password>" +
					"</UserLogin>" +
				"</soap:Body>" +
			"</soap:Envelope>";

			InetAddress  addr = InetAddress.getByName(hostname);
			Socket sock = new Socket(addr, port);

			//Send header
			BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
			// You can use "UTF8" for compatibility with the Microsoft virtual machine.
			wr.write("POST " + path + " HTTP/1.0\r\n");
			wr.write("Host: " + hostname + "\r\n");
			wr.write("Content-Length: " + xmldata.length() + "\r\n");
			wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
			wr.write("\r\n");
			
			System.out.println(xmldata);

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
