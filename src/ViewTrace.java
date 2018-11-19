import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class ViewTrace extends JPanel {

	private ArrayList<String> trace;
	private JTextArea textArea;
	
	public ViewTrace() {
		this.trace = new ArrayList<String>();
		
		this.setLayout(new BorderLayout());
		JLabel titre = new JLabel("TRACE");
		titre.setBorder(new EmptyBorder(10,0,0,0));
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		textArea = new JTextArea(70, 30);
		//textArea.append("coucou");
		JScrollPane contenu = new JScrollPane(textArea);
				
		this.add(titre, BorderLayout.NORTH);
		this.add(contenu, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.white);
	}
	
	public ArrayList<String> getTrace() {
		return this.trace;
	}
	
	public void addToTrace(String str) {
		this.trace.add(str);
		for (String s : this.trace) {
			textArea.append(s + "\n");
		}
	}
	
	public void setTrace(ArrayList<String> trace) {
		this.textArea.setText("");
		this.trace = trace;
		for (String s : trace) {
			textArea.append(s + "\n");
		} 
	}
}
