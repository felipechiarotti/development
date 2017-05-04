package gamedotcom;
import java.util.ArrayList;
public class DotCom{
	String name;
	private ArrayList<String> posCells;
	
	public DotCom(String name){
		this.name = name;
	}
	
	public void setPosCells(ArrayList<String> array){
		this.posCells = array;
	}
	public byte checkHit(String userInput){
		byte result;
		int index = posCells.indexOf(userInput);
		if(index >= 0){
			posCells.remove(index);
			if(posCells.isEmpty()){
				result = 2;
			}else{
				result = 1;
			}
		}else{
			result = 0;
		}
		return result;
	}
}