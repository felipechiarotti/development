package gamedotcom;
import java.io.*;
public class GameHelper{
	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.print(prompt);
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			do{inputLine = is.readLine();}
			while(inputLine.length() == 0);
		}catch(IOException e){
			System.out.println(e);
		}
		return inputLine;
	}
}