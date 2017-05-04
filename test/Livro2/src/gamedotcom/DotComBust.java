package gamedotcom;
import java.util.ArrayList;
public class DotComBust{
	private GameHelper help = new GameHelper();
	private ArrayList<DotCom> dotcom = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame(){
		String[] names = {"Facebook.com","Pets.com","Amazon.com","AskMe.com"};

		DotCom dot1 = new DotCom(names[0]);
		DotCom dot2 = new DotCom(names[1]);
		DotCom dot3 = new DotCom(names[2]);
		
		dotcom.add(dot1);
		dotcom.add(dot2);
		dotcom.add(dot3);
		
		System.out.println("Seu Objetivo é eliminar três dot coms.");
		for(int i = 0; i<dotcom.size();){
			System.out.println(dotcom.get(i));
		}
	}
	
	private void playGame(){
		while(!dotcom.isEmpty()){
			String palpite = help.getUserInput("Digite a Posição: ");
			checkPlayerGuess(palpite);
		}
		finishGame();
		
	}
	
	public void placeDotCom(int sizeDotCom){
		for(DotCom c : dotcom){
			ArrayList<String> pos = new ArrayList<String>();
			int place = (int)(Math.random())*50;
			for(int i = 0; i<sizeDotCom; i++){
				pos.add(Integer.toString(place+i));
			}
			c.setPosCells(pos);
		}
		
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
					System.out.print("Você matou: " + c.name);
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
		dot.setUpGame();
		dot.playGame();
		
	}
}