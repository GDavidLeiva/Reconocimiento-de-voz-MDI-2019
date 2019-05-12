import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*; 
import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

public class Reconocedor extends JFrame implements ActionListener{

	public JButton btn;
	public Image fondo;
	public ImageIcon MicrophoneIcon;
	static Recognizer oreja;
	String palabra;

	public static void main (String[] args){
		Reconocedor Reconocedor = new Reconocedor();
		Reconocedor.setVisible(true);
		
	}
	public Reconocedor() {
		
		setLayout(null);
		setSize(135,155);
		setResizable(false);
		setLocation(900,100);
		setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		Inicio();
		Image microImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/micro.png"));

		MicrophoneIcon = new ImageIcon( microImage );		

		Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		btn = new JButton(MicrophoneIcon);
		btn.setBounds(0,0,130,130);
		btn.setFocusable(false);	//El botón no atrae el foco
		btn.setBorder(null);	//Botón sin borde
		btn.setBorderPainted(false);	//Botón sin borde pintado
		btn.setOpaque(false);	//Fondo del bóton transparente
		btn.setContentAreaFilled(false);	//Botón sin relleno
		btn.setCursor(cursor);	//Establece el cursor para el botón
		btn.setFocusPainted(false); //El foco no esta pintado
		btn.addActionListener(this);	//Añade un ActionListener al botón
		add(btn);
	}

	public void Inicio() {
	setVisible(false);
		JOptionPane.showMessageDialog(null, " Prepare su Microfono!! ","Bienvenido",JOptionPane.INFORMATION_MESSAGE);
	return;
	}

	public void iniciarRec() {
  
		JOptionPane.showMessageDialog(null, "Pronuncie Aplicacion a Ejecutar");
		
			try{
			//Se configura al reconocedor para que entienda el idioma inglés
			oreja = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
			oreja.allocate();
			FileReader grammar1 =new FileReader("Programas.txt"); //ruta donde esta el archivo con las Frases
			RuleGrammar rg = oreja.loadJSGF(grammar1);//Establece la forma en que debe de estar estructurado el archive grammar 
			rg.setEnabled(true); //accesa al archivo
			oreja.addResultListener(new Programas());  //Se hace referencia a la clase de escucha del reconocedor
 
			for(int i=0;i<=23;i++){
				System.out.println("");
			}
			System.out.println("Pronuncia un programa");
			oreja.commitChanges();
			oreja.requestFocus();
			oreja.resume();
		} catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}	
	return;
	}

	public void salir() {	
       	JOptionPane.showMessageDialog(null, "GRACIAS POR PROBAR NUESTRO SISTEMA!!");
		System.exit(0);
	}

	public void actionPerformed(ActionEvent event) { 

		if ( (event.getSource() == btn)) {
			//activ = true;
			iniciarRec();
		return;
		}
		/*else {
			salir();	
		} */
    }//Termina ActionPerformed
}