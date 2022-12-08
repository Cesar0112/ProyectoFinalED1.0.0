package CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import javax.swing.JFileChooser;

import logica.Patron;

/**Con esta clase se manipulan los archivos .csv
 * @author Cesar Fernandez*/
public class CSV {
	LinkedList<Patron> patrones;
	public CSV(JFileChooser fc) throws Exception {
		patrones = new LinkedList<>();
		leer(fc);
	}

	public void leer(JFileChooser fc) throws Exception {
		File archivo = fc.getSelectedFile();
		
		try (FileReader fr = new FileReader(archivo);BufferedReader buffer = new BufferedReader(fr);) {
			String[] texto = null;
			String linea="";//recibe la linea de cada fila
			while((linea=buffer.readLine()) !=null && linea.length()!=1) {
				texto = linea.split(",");
				if (texto != null&&texto.length!=1) {//ese 4 es la cantidad de parametros que debe tener el patron
					Patron patron = new Patron();
                                        
					double parametros[] = new double[texto.length-1];
                                        //si hay una 5ta columna esto es para el caso de la clasificacion que en los patrones no clasificados no v
                                                                            //a haber clasificacion para que no de una exception
                                        if(texto.length==5)
                                        patron.setClase(texto[texto.length-1]);
					
					for(int i=0;i<texto.length-1;i++) {//asigna los valores de los parametros
						parametros[i]=Double.valueOf(texto[i]);
					}

					patron.setParametros(parametros);
					patrones.add(patron);
				}
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No se encontró el archivo");
		}catch (NullPointerException e) {
			throw new NullPointerException("Se intenta acceder a un archivo null");
		}catch(Exception e) {
			throw new Exception("Ocurrió una excepción desconocida");
		}
	}
	public LinkedList<Patron> getPatrones() {
		return patrones;
	}
	public void setPatrones(LinkedList<Patron> patrones) {
		this.patrones = patrones;
	}
        private int numParametros(String[] texto){
            int retorno =0;
            for(int i=0;i<texto.length;i++){
                //me falta agregar para saber si es un double              
            }
            return retorno;
        }
}

