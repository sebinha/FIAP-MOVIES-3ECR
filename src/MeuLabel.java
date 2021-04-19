import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MeuLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	private int size = 14;
	private Color cor = new Color(0, 0,0);
	
	public MeuLabel(String texto) {
		super(texto);
		init();
	}
	
	public MeuLabel(String texto, Color cor) {
		super(texto);
		this.cor = cor;
		init();
	}
	
	private void init() {
		this.setForeground(cor);
		this.setPreferredSize(new Dimension(60, 20));
		this.setFont(new Font(null, Font.BOLD, size));
	}
	
	

}
