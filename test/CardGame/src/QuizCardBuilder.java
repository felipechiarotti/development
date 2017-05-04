import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class QuizCardBuilder {
	private JFrame frame;
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	
	public static void main(String[] args){
		QuizCardBuilder gui = new QuizCardBuilder();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame("Quiz Card Builder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();

		question = new JTextArea(7,30);
		question.setLineWrap(true);
		//question.setFont(new Font("sanserif",Font.BOLD,24));
		question.setWrapStyleWord(true);
		JScrollPane qScroller = new JScrollPane(question);
		
		answer = new JTextArea(7,30);
		answer.setLineWrap(true);	
		JScrollPane aScroller = new JScrollPane(answer);
		
		JButton nextButton = new JButton("Próxima Carta");
		
		cardList = new ArrayList<QuizCard>();
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Arquivo");
		JMenuItem newMenuItem = new JMenuItem("Novo");
		JMenuItem saveMenuItem = new JMenuItem("Salvar");
		
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		mainPanel.add(new JLabel("Questão: "));
		mainPanel.add(qScroller);
		mainPanel.add(new JLabel("Resposta: "));
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(mainPanel);
		frame.setSize(350,365);
		frame.setVisible(true);
	}
	
	private class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			QuizCard card = new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	
	private class SaveMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(question.getText().length() > 0 && answer.getText().length() > 0){
					QuizCard card = new QuizCard(question.getText(),answer.getText());
					cardList.add(card);
					clearCard();
			}
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}
	
	private class NewMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardList.clear();
			clearCard();
		}
	}
	
	private void saveFile(File file){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(QuizCard card : cardList){
				writer.write(card.getQuestion()+"/");
				writer.write(card.getAnswer()+"\n");
			}
			writer.close();
		}catch(IOException ex){
			System.out.println("Não foi possível gravar");
			ex.printStackTrace();
		}
	}
	
	private void clearCard(){
		answer.setText("");
		question.setText("");
		question.requestFocus();
	}
}
