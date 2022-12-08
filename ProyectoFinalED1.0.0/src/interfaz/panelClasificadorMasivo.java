/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

import CSV.CSV;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import logica.KNN;

/**
 *
 * @author Hector
 */
public class panelClasificadorMasivo extends javax.swing.JPanel {

    /**
     * Creates new form panelClasificadorMasivo
     */
    private CSV CsvPatronesNoCLasificados;
    private CSV patronesDeEntrenamiento;
    private KNN knn;
    public panelClasificadorMasivo(CSV patronesEntrenamiento) {
        /*Esto es para escojer el archivo */
       
        actualizarTablaPatronesNoClasificados();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPatronesNoClasificados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClasificacionesNuevas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinnerK = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        botonEscojerPatronesNoCLasificados = new javax.swing.JButton();
        botonClasificar = new javax.swing.JButton();

        tablaPatronesNoClasificados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parámetro 1", "Parámetro 2", "Parámetro 3", "Parámetro 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPatronesNoClasificados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaPatronesNoClasificados);
        if (tablaPatronesNoClasificados.getColumnModel().getColumnCount() > 0) {
            tablaPatronesNoClasificados.getColumnModel().getColumn(0).setResizable(false);
            tablaPatronesNoClasificados.getColumnModel().getColumn(1).setResizable(false);
            tablaPatronesNoClasificados.getColumnModel().getColumn(2).setResizable(false);
            tablaPatronesNoClasificados.getColumnModel().getColumn(3).setResizable(false);
        }

        tablaClasificacionesNuevas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clasificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClasificacionesNuevas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaClasificacionesNuevas);
        if (tablaClasificacionesNuevas.getColumnModel().getColumnCount() > 0) {
            tablaClasificacionesNuevas.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setText("Patrones sin clasificar");

        jLabel2.setText("Nueva clasificación");

        spinnerK.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 2));
        spinnerK.setToolTipText("Ingrese el valor K");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("         Valor K:");

        botonEscojerPatronesNoCLasificados.setText("Escojer patrones sin clasificar");
        botonEscojerPatronesNoCLasificados.setToolTipText("Abre un selector de archivos para escojer un fichero de texto que contenga patrones nuevos sin clasificar");
        botonEscojerPatronesNoCLasificados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEscojerPatronesNoCLasificados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEscojerPatronesNoCLasificadosActionPerformed(evt);
            }
        });

        botonClasificar.setText("Clasificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spinnerK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botonEscojerPatronesNoCLasificados)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonClasificar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(483, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(spinnerK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonEscojerPatronesNoCLasificados))
                    .addComponent(botonClasificar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEscojerPatronesNoCLasificadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEscojerPatronesNoCLasificadosActionPerformed
         actualizarTablaPatronesNoClasificados();
    
    }//GEN-LAST:event_botonEscojerPatronesNoCLasificadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonClasificar;
    private javax.swing.JButton botonEscojerPatronesNoCLasificados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spinnerK;
    private javax.swing.JTable tablaClasificacionesNuevas;
    private javax.swing.JTable tablaPatronesNoClasificados;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the csv
     */
    public CSV getCsvPatronesNoCLasificados() {
        return CsvPatronesNoCLasificados;
    }

    /**
     * @return the knn
     */
    public KNN getKnn() {
        return knn;
    }

    /**
     * @return the patronesDeEntrenamiento
     */
    public CSV getPatronesDeEntrenamiento() {
        return patronesDeEntrenamiento;
    }
    private void actualizarTablaPatronesNoClasificados(){
         try {
                    JFileChooser fc = new JFileChooser();
                        fc.setDialogTitle("Escoja un fichero que contenga los patrones no clasificados");
			fc.showOpenDialog(null);
                        
			CsvPatronesNoCLasificados = new CSV(fc);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
         Object[][] patronesNoCLasificados = new Object[CsvPatronesNoCLasificados.getPatrones().size()][CsvPatronesNoCLasificados.getPatrones().get(0).getNumberOfParametters()]; 
			for(int i=0;i<CsvPatronesNoCLasificados.getPatrones().size();i++) {
				for(int j=0;j<CsvPatronesNoCLasificados.getPatrones().get(0).getNumberOfParametters();j++) {
                                    patronesNoCLasificados[i][j] = CsvPatronesNoCLasificados.getPatrones().get(i).getParametros()[j];
				}
			}
         tablaPatronesNoClasificados.setModel(new javax.swing.table.DefaultTableModel(
        patronesNoCLasificados,
        new String [] {
        "Parámetro 1", "Parámetro 2", "Parámetro 3", "Parámetro 4"
        }   
        ) {
        boolean[] canEdit = new boolean [] {
        false, false, false, false
        };
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
        }
        });
        }
}