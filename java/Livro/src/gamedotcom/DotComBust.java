package gamedotcom;
import java.util.ArrayList;
public class DotComBust{
	private GameHelper help = new GameHelper();
	private ArrayList<DotCom> dotcom = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame(int qDots, int sizeDots, int sizeTable){
		String[] names = {"Facebook.com","Pets.com","Amazon.com","AskMe.com","Nothing.com","Anything.com","ForgotAnythingElse.com","HueBrasil.com"};

		for(int i = 0; i<qDots; i++){
			DotCom dot = new DotCom(names[i]);
			dotcom.add(dot);
		}
		
		ArrayList<String> auxList = new ArrayList<String>();
		int nRand;
		for(DotCom c : dotcom){
			ArrayList<String> arrayPos = new ArrayList<String>();
			do{nRand = (int)(Math.random()*(sizeTable-sizeDots));}
			while(auxList.indexOf(Integer.toString(nRand)) != -1);
			for(int i = 0; i<sizeDots; i++){
				arrayPos.add(Integer.toString(nRand+i));
				auxList.add(Integer.toString(nRand+i));

			}
			for(int i = 0-sizeDots; i<0; i++){
				auxList.add(Integer.toString((nRand+i)+1));
			}
			c.setPosCells(arrayPos);
			//System.out.println(arrayPos);
		}		
		System.out.println("Seu Objetivo é eliminar as "+dotcom.size()+" dot coms.");
		for(int i = 0; i<dotcom.size(); i++){
			System.out.print(dotcom.get(i).name + " | ");
		}
		System.out.println();
	}
	
	private void playGame(){
		while(!dotcom.isEmpty()){
			String palpite = help.getUserInput("Digite a Posição: ");
			checkPlayerGuess(palpite);
		}
		finishGame();
		
	}
	
	public void checkPlayerGuess(String palpite){
		numOfGuesses++;
		byte result;
		for(DotCom c : dotcom){
			result = c.checkHit(palpite);
			if(result == 1 || result == 2){
				if(result == 1){
					System.out.println("Acertou");
					break;
				}else{
					System.out.println("Você matou: " + c.name);
					dotcom.remove(c);
					break;
				}
			}
		}
	}
	
	public void finishGame(){
		System.out.println("Parabéns, você terminou o jogo!");
		System.out.println("Sua Pontuação foi de: " + numOfGuesses + " palpites.");
	}
	public static void main(String[] args){
		DotComBust dot = new DotComBust();
		dot.setUpGame(8,3,200);
		dot.playGame();
		
	}
}