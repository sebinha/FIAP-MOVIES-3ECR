
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MeuRadioGroup extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup group = new ButtonGroup();
	
	public String value;
	
	public String getValue() {
		return value;
	}

	private List<String> opcao;
	
	public MeuRadioGroup(List<String> opcao) {
		this.opcao = opcao;	 
		init();
		 		
	}

	private void init() {
		opcao.forEach(opcao ->{
			JRadioButton botao = new JRadioButton(opcao); 
			botao.setPreferredSize(new Dimension(110,15));
			botao.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					value=opcao;
				}
			});
			group.add(botao);
			this.add(botao);
			
		});
	}
	

}



