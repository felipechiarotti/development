package util;

public class Criptografy {
	private double[][] primaryKey;
	private double[][] phrase;
	private boolean status;
	
	public boolean encrypt(){	
		if(primaryKey.length>0 && this.phrase.length>0){
			this.phrase = Matrix.multiply(primaryKey, this.phrase);
			this.status = true;
			return true;
		}
		return false;
	}
	
	public boolean status(){
		return this.status;
	}
	public boolean decrypt(){
		if(primaryKey.length>0 && this.phrase.length>0){
			double[][] InversePrimaryKey = Matrix.inverse(primaryKey);
			this.phrase = Matrix.multiply(InversePrimaryKey, this.phrase);
			this.status = false;
			return true;
		}
		return false;
	}
	public boolean setPrimaryKey(double[][] primaryKey){
		if(Matrix.isSquare(primaryKey)){
			this.primaryKey = primaryKey;		
			return true;
		}
		return false;

	}
	
	public void setPhrase(String phrase){
		int sizePhrase = phrase.length();
		if(sizePhrase%2!=0){
			phrase+=" ";
			sizePhrase = phrase.length();
		}
		int control= 0;
		this.phrase = new double[primaryKey[0].length][sizePhrase/primaryKey[0].length];
		for(int i = 0; i<primaryKey[0].length; i++){
			for(int j = 0; j<sizePhrase/primaryKey[0].length; j++){
				this.phrase[i][j] = phrase.charAt(control);
				control++;
			}
		}
	}
	
	public double[][] getPrimaryKey(){
		return this.primaryKey;
	}
	
	public double[][] getPhrase(){
		return this.phrase;
	}
	
	public String getStringPhrase(boolean b){

			String result = "";
			for(int i = 0; i<phrase.length;i++){
				for(int j = 0; j<phrase[0].length; j++){
					if(b){
						result+=Integer.toHexString((int)phrase[i][j])+" ";
					}else{
						result+=(char)phrase[i][j];
					}
				}
			}
		return result;
	}
}