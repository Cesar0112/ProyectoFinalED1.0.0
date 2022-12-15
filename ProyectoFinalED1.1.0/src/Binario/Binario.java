/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Binario;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author César Fernández García
 * Esta clase es para manejar archivos binarios
 */
public class Binario {

    public static void escribir(Object element) {
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Escoja el archivo que desea escribir");
            fc.showOpenDialog(null);
            File fichero = fc.getSelectedFile();

            FileOutputStream fos = new FileOutputStream(fichero);
            //para poder escribir utilizo el objeto de tipo ObjectOutputStream y le paso por parámetro el FileOutputStream que cree anteriormente
            ObjectOutputStream escribir = new ObjectOutputStream(fos);
            //escribo el objeto
            escribir.writeObject(element);
            escribir.close();//cerrar para no consumir recursos
            fos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al escribir en el archivo binario");
        }

    }
}
