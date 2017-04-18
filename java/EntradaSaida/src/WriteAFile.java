import java.io.*;
public class WriteAFile {
	public static void main(String[] args){
		try{
			FileWriter w = new FileWriter("Foo.txt");
			w.write("Teste EOQ\n");
			w.write("Teste2");
			w.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
