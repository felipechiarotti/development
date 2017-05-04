package simulator.mem;

public class Assistente {
	public static String fillAddress(String address, int sizeAddress){
		String result="";
		for(int i = 0; i<sizeAddress-address.length(); i++){result+="0";}
		return result.concat(address);
	}
	public static int calculateTotalBits(int size){
		int result=0;
		int i = 0;
		while(size != result){ result = (int)Math.pow(2, i); i++;}
		return i-1;
	}
	
	public static int toByteConvert(int mode, int val) throws Exception{
		int result = 0;
		switch(mode){
			case 0:
				result = val;
			break;
			
			case 1:
				result =  val*1024;
			break;
			
			case 2:
				result = val*1024*1024;
			break;
			
			case 3:
				result =  val*1024*1024*1024;
			break;
			
			default:
				throw new Exception();
		}
		return result;
	}
}
