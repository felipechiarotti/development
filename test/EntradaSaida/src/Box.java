import java.io.*;
public class Box implements Serializable{
	private int width;
	private int height;
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public static void main(String[] args){
		Box myBox = new Box();
		myBox.setHeight(200);
		myBox.setWidth(300);
		try{
			FileOutputStream fs = new FileOutputStream("foo.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{
		FileInputStream fileStream = new FileInputStream("foo.ser");
		ObjectInputStream is = new ObjectInputStream(fileStream);
		Box one = (Box)is.readObject();
		is.close();
		System.out.println(one.height);
		System.out.println(one.width);
		}catch(Exception ex) {
			ex.getStackTrace();
		}
	}
}
