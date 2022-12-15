package CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.swing.JFileChooser;

import logica.Patron;

/**
 * Con esta clase se manipulan los archivos .csv
 *
 * @author Cesar Fernandez
 */
public class CSV {

    LinkedList<Patron> patrones;

    public CSV(JFileChooser fc) throws Exception {
        patrones = new LinkedList<>();
        leer(fc);
    }

    public void leer(JFileChooser fc) throws Exception {

        File archivo = fc.getSelectedFile();

        try ( FileReader fr = new FileReader(archivo);  BufferedReader buffer = new BufferedReader(fr);) {
            String[] texto = null;
            String linea = "";//recibe la linea de cada fila
            while ((linea = buffer.readLine()) != null && linea.length() != 1) {
                texto = linea.split(",");//lee la linea de texto
                if (texto != null && texto.length != 1) {
                    Patron patron = new Patron();
                    ArrayList<Double> parametros = new ArrayList<>();

                    if (texto.length == 5) {
                        patron.setClase(texto[texto.length - 1]);//si hay 5 elementos en el array significa que hay una clasificación entonces la ultima debe ser esta
                        for (int i = 0; i < texto.length - 1; i++) {//asigna los valores de los parametros
                            parametros.add(Double.valueOf(texto[i]));//agrega el parametro correspondiente
                        }
                    } else if (texto.length == 4) {
                        for (int i = 0; i < texto.length; i++) {//asigna los valores de los parametros
                            parametros.add(Double.valueOf(texto[i]));//agrega los valores
                        }
                    }

                    patron.setParametros(CSV.toArray(parametros));
                    patrones.add(patron);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("No se encontró el archivo");
        } catch (NullPointerException e) {
            throw new NullPointerException("Se intenta acceder a un archivo null");
        }

    }

    public LinkedList<Patron> getPatrones() {
        return patrones;
    }

    public void setPatrones(LinkedList<Patron> patrones) {
        this.patrones = patrones;
    }

    /**
     * Convierte una lista de Doubles a array de double
     */
    private static double[] toArray(List<Double> lista) {
        double[] retorno = new double[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            retorno[i] = lista.get(i);
        }
        return retorno;
    }
}
