import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
import java.io.*; 

public class Programas extends ResultAdapter {
	static Recognizer oreja;
	String Programa;
 
	public void resultAccepted(ResultEvent e){
		try {
			Result res = (Result)(e.getSource());
			ResultToken tokens[] = res.getBestTokens();
			String Frase[]= new String[1];
			Frase[0]="";

			for (int i=0; i < tokens.length; i++){
				Programa = tokens[i].getSpokenText();
				Frase[0]+=Programa+" "; 
				System.out.print(Programa + " ");
			}
			System.out.println();
			
			if(Programa.equals("Fin")){
				oreja.deallocate();
				Frase[0]="Hasta la proxima!";
				System.out.println(Frase[0]);
				System.exit(0);
			}
			else if(Programa.equals("Facebook")) {
				try { 
					System.out.println("Abriendo Facebook...");
					// Se lanza el ejecutable. 
					Process p=Runtime.getRuntime().exec ("cmd.exe /c start Chrome www.facebook.com"); 
             
					// Se obtiene el stream de salida del programa 
					InputStream is = p.getInputStream(); 
             
					/* Se prepara un bufferedReader para poder leer la salida más comodamente. */ 
					BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
             
					// Se lee la primera linea 
					String aux = br.readLine(); 
            
				    while (aux!=null) { 
						System.out.println (aux); 
						aux = br.readLine(); 
					} 
				} catch (Exception es) { 
					es.printStackTrace(); 
				} 
			}

			else if(Programa.equals("Reproductor")){
				try { 
					System.out.println("Abriendo Windows Media Player...");
					// Se lanza el ejecutable. 
					Process p=Runtime.getRuntime().exec ("cmd.exe /c start wmplayer"); 
             
					// Se obtiene el stream de salida del programa 
					InputStream is = p.getInputStream(); 
             
					/* Se prepara un bufferedReader para poder leer la salida más comodamente. */ 
					BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
             
					// Se lee la primera linea 
					String aux = br.readLine(); 
            
				    while (aux!=null) { 
						System.out.println (aux); 
						aux = br.readLine(); 
					} 
				} catch (Exception es) { 
					es.printStackTrace(); 
				} 
			}

			else if(Programa.equals("Chrome")){
				try { 
					System.out.println("Abriendo Chrome...");
					// Se lanza el ejecutable. 
					Process p=Runtime.getRuntime().exec ("cmd.exe /c start Chrome"); 
             
					// Se obtiene el stream de salida del programa 
					InputStream is = p.getInputStream(); 
             
					/* Se prepara un bufferedReader para poder leer la salida más comodamente. */ 
					BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
             
					// Se lee la primera linea 
					String aux = br.readLine(); 
            
				    while (aux!=null) { 
						System.out.println (aux); 
						aux = br.readLine(); 
					} 
				} catch (Exception es) { 
					es.printStackTrace(); 
				} 
			}

			else if(Programa.equals("Paint")){
				try { 
					System.out.println("Abriendo Paint Brush...");
					// Se lanza el ejecutable. 
					Process p=Runtime.getRuntime().exec ("cmd.exe /c start pbrush"); 
             
					// Se obtiene el stream de salida del programa 
					InputStream is = p.getInputStream(); 
             
					/* Se prepara un bufferedReader para poder leer la salida más comodamente. */ 
					BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
             
					// Se lee la primera linea 
					String aux = br.readLine(); 
            
				    while (aux!=null) { 
						System.out.println (aux); 
						aux = br.readLine(); 
					} 
				} catch (Exception es) { 
					es.printStackTrace(); 
				} 
			}

			else {
				getPrograma();
				oreja.suspend();
				oreja.resume();
			}
		}catch(Exception ex) {
		}
	}

	public String getPrograma(){
		return Programa;
	}
}