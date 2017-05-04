package pokecalculo.source;

public class Plain {
	public static double radius(int[] pos){
		int posX = pos[0];
		int posY = pos[1];
		int posZ = pos[2];
		double radius = (Math.pow((double)posX,2.0) + Math.pow((double)posY,2.0) + Math.pow((double)posZ,2.0));
		return radius;
	}
	
	public static double distance(int[] posOne, int[] posTwo){
		double pos = 0;
		for(int i = 0; i<3; i++){
			pos+= Math.pow((double)(posOne[i]-(double)posTwo[i]),2.0);
		}
		return Math.sqrt(pos);
	}
}
