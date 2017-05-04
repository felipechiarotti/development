/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcarol;

public class AppCarol {

    int des[][];
    int base[][] = new int[2][2];
    int matrix[][] = new int[2][2];
    int vec[] ;
    int[][] cript;
    int[][] result;

    public AppCarol(String texto) {

        //matriz original
        base[0][0] = 2;
        base[0][1] = 5;
        base[1][0] = 1;
        base[1][1] = 3;
        //inversa
        matrix[0][0] = 3;
        matrix[0][1] = -5;
        matrix[1][0] = -1;
        matrix[1][1] = 2;

        des = new int [2][texto.length()/2];
        result = new int[2][texto.length() / 2];
        cript = new int[2][texto.length() / 2];
    }

    public void Criptografar(String texto) {

        int p = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < texto.length() / 2; j++) {
                cript[i][j] = alfabeto.Letra(texto.charAt(p));
                p++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < texto.length() / 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = matrix[i][k] * cript[k][j];
                    
                }
            }
        }

    }

    public String mostrar(String texto) {
        String x = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < texto.length() / 2; j++) {
                x += result[i][j] + " ";
            }

        }
        return x;

    }
    public void Multiplicar(){
        
    result = new int [2][vec.length/2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < vec.length/2; j++) 
            {
                for (int k = 0; k < 2; k++) 
                    result[i][j] += (base[i][k] * des[k][j]);
            }

        }
        

    
    
    }
    public String Mostrar1(){
        String texto = "";
        for (int i = 0; i < 2; i++) 
        {
            for (int j =0;j<vec.length/2;j++){
            texto +=alfabeto.Charlie(result[i][j]);            
            
            }               
      }
       
        return texto;
    
    
    }

    public void Descriptografar(String texto) {
        
        des = new int[2][texto.length()/2];
        int[] vetor = new int[256];
        int inicio = 0;
        int fim = 0;
        int v = 0;
        int id = 0;
        int space = 0;
        String t1 = "";
        for (inicio = 0; inicio < texto.length(); inicio++) {
            if (texto.charAt(inicio) == ' ') {
                for (v = fim; v < inicio; v++) {
                    t1 += texto.charAt(v);
                }
                space++;
                fim = inicio +1;
                vetor[id] = Integer.parseInt(t1);
                t1="";
                id++;
                   
            }
        }
            if (space % 2 != 0) {
                space++;
                
            }
            vec = new int[space];
            for (int i = 0; i < vec.length; i++) {
                vec[i] = vetor[i];
            }              
    
        vetor=null;
    int k1 = 0;
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < vec.length/2; j++){
            des[i][j] = vec[k1];
            k1++;
        }
    }
    for(int i =0;i<vec.length;i++){
        System.out.println(vec[i]);
    }
    }
    

    public static void main(String[] args) {

    }

}
