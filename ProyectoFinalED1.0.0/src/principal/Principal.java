package principal;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import interfaz.VentanaPrincipal;
/**Esta clase es la iniciadora principal
 * @César Fernández García*/
public class Principal {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//usado para maximizar el tamanio
					frame.setVisible(true);
					
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Ocurrió una excepción");
				}
			}
		});

	}

}
