package util;
public class Matrix {
	public static double[][] escalona(double[][] matriz, int offset){
			int totalLine = matriz.length;
			int totalCol = matriz[0].length-offset;
			for(int j = 0; j<totalCol; j++){
				for(int i=0; i<totalLine; i++){
					if((i==j)){
						if(matriz[i][j] != 1){
							double aux = matriz[i][j];
							for(int x = j; x<totalCol; x++){
								matriz[i][x]/=aux;
							}
						}
					}else if(i==0){
						if(j<totalLine){
							double aux = matriz[i+j][j];
							if(matriz[i+j][j] != 1){
								for(int x = j; x<totalCol; x++){
									matriz[i+j][x]/=aux;
								}
							}
						}
					}
					if(i!=j){
						if(matriz[i][j]!=0){
							if(j<totalLine){
								int pos = j;

								double aux = matriz[i][j];
								for(int x = j; x<totalCol; x++){
									matriz[i][x] = (matriz[i][x]+(matriz[pos][x]*aux)) == 0 ? (matriz[i][x]+(matriz[pos][x]*aux)) : (matriz[i][x]-(matriz[pos][x]*aux));
								}	
							}
						}
					}
				}
			}
			return matriz;
		}
	
	public static double[][] escalona(double[][] matriz){
		return escalona(matriz,1);
	}
	
	public static double[][] inverse(double[][] matriz){
		int lineInverse = matriz.length;
		int colInverse = matriz[0].length*2;
		double[][] inverseMatrix = new double[lineInverse][colInverse];
		
		for(int i = 0; i<lineInverse; i++){
			for(int j = 0; j<matriz[0].length; j++){
				inverseMatrix[i][j] = matriz[i][j];
			}
		}
		
		for(int i = 0; i<lineInverse; i++){
			for(int j = colInverse/2; j<colInverse; j++){
				if(i==j-(colInverse/2)){
					inverseMatrix[i][j] = 1;
				}else{
					inverseMatrix[i][j] = 0;
				}
			}
		}
		
		escalona(inverseMatrix,0);
		double[][] im = new double[lineInverse][colInverse/2];
		for(int i = 0; i<lineInverse; i++){
			for(int j = 0; j<colInverse/2; j++){
				im[i][j] = inverseMatrix[i][j+(colInverse/2)];
			}
		}
		return im;
	}
	
	public static double[][] multiply(double[][] m1, double[][] m2){

		double[][] matrix = new double[m1.length][m2[0].length];
		for(int i = 0; i<m1.length; i++){
			for(int j = 0; j<m2[0].length; j++){
				double result=0;
				for(int x = 0; x<m2.length; x++){
					result+=m1[i][x]*m2[x][j];
				}
                    matrix[i][j] = Math.round(result); 
			}
		}
		return matrix;
	}
	
	public static boolean isSquare(double[][] m){
		if(m.length==m[0].length){
			return true;
		}
		return false;
	}
}
