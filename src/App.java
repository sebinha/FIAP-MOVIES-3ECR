import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class App {
	
	public static void main(String[] args) {

	JFrame frame = new JFrame("Fiap Movies");
	JPanel content = new JPanel(new BorderLayout(20,0));

	JPanel imagem = new JPanel();
	JPanel janela = new JPanel(new GridLayout(0,1,0,0));
	JPanel selecao = new JPanel (new GridLayout(0,1,0,0));
	selecao.setPreferredSize(new Dimension(130,400));
	
	JLabel imgBox=new JLabel(new ImageIcon("Imagem/breakingbad.jpg"));
	
	imgBox.setPreferredSize(new Dimension(200,300));
	imagem.add(imgBox);
	
	
	MeuLabel title = new MeuLabel("Título");
	janela.add(title);
	
	MeuTextField nameTextField = new MeuTextField();
	janela.add(nameTextField);
	
	MeuLabel sinopse = new MeuLabel("Sinopse");
	
	janela.add(sinopse);
	
	MeuTextField sinopsesBox = new MeuTextField();
	janela.add(sinopsesBox);
	
	MeuLabel genero2 = new MeuLabel("Gênero");
	janela.add(genero2);
	
	String[] generos = {"Ação","Aventura","Cinema de arte","Chanchada","Comédia","Comédia de ação","Comédia de terror","Comédia dramática","Comédia romântica","Dança","Documentário","Docuficção","Drama","Espionagem","Faroeste","Fantasia","Fantasia científica","Ficção científica","Filmes com truques","Filmes de guerra","Musical","Filme policial","Romance","Seriado","Suspense","Terror","Thriller"};
	JComboBox genero= new JComboBox<String>(generos);
	janela.add(genero);
	
	
	JButton BotaoDeSalvar = new JButton("Salvar");
	JButton BotaoDeCancelar = new JButton("Fechar");

	JPanel painelBotao = new JPanel();
	painelBotao.add(BotaoDeSalvar);
	painelBotao.add(BotaoDeCancelar);
	janela.add(painelBotao);
	
	
	MeuLabel onde = new MeuLabel("Onde assistir");
	selecao.add(onde);

	List<String> listoptions = List.of("Netflix","Prime Vídeo","Pirate Bay"); 
	MeuRadioGroup group = new MeuRadioGroup(listoptions);
	selecao.add(group);
	JCheckBox assistido=new JCheckBox("Assistido");
	selecao.add(assistido);

	MeuLabel LabelNota = new MeuLabel("Nota");
	selecao.add(LabelNota);
	StarRater nota=new StarRater(5);
	selecao.add(nota);

	
	content.add(imagem, BorderLayout.WEST);
	content.add(janela, BorderLayout.CENTER);
	content.add(selecao, BorderLayout.EAST);
	
	
	JTabbedPane abas = new JTabbedPane();
	abas.add("Cadastro", content);
	abas.add("Lista", new JPanel());
	frame.add(abas);	
	
	frame.setSize(600,420);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//                                	EVENTOS
	
	nota.addStarListener(new StarRater.StarListener() {
		
		@Override
		public void handleSelection(int selection) {
			nota.setRating(selection);
			
		}
	});
	
	
	BotaoDeSalvar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(nameTextField.getText() + " | Nota: "+ nota.getRating() + " | Sinopse: " + sinopsesBox.getText() + " | Pode ser assistido em: "+ group.getValue()+ " | Gênero: "+genero.getSelectedItem());
			if(assistido.isSelected()) {
				System.out.println("Foi assistido");
			}else {
				System.out.println("Não foi assistido");
			}
			
		}
	});
	  }

}