/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

import CSV.CSV;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import logica.KNN;
import logica.Patron;

/**
 *
 * @author Hector
 */
public class panelClasificadorIndividual extends javax.swing.JPanel {

    /**
     * Creates new form panelClasificadorIndividual
     */
    private KNN knn;
    private CSV csv;

    public panelClasificadorIndividual(CSV csv) {
        if (csv != null) {
            this.csv = csv;
            initComponents();
        } else {
            do {

                try {
                    JFileChooser fc = new JFileChooser();
                    fc.setDialogTitle("Escoja el fichero que contenga los patrones de entrenamiento");
                    int reaccion = fc.showOpenDialog(null);
                    if (reaccion == JFileChooser.APPROVE_OPTION) {
                        this.csv = new CSV(fc);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe escojer los patrones de entrenamiento");
                        this.csv = null;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } while (csv == null);

            initComponents();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPatronesEntrenamiento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDistanciasClasifcadasOrdenadas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaFrecuenciasClasificacion = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        spinnerParam1 = new javax.swing.JSpinner();
        spinnerParam2 = new javax.swing.JSpinner();
        spinnerParam4 = new javax.swing.JSpinner();
        spinnerParam3 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spinnerK = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        lblClasificacionNueva = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setToolTipText("");

        Object[][] tablaPatronesEntrenamientoCSV = new Object[csv.getPatrones().size()][csv.getPatrones().get(0).getNumberOfParametters()+1];
        for(int i=0;i<csv.getPatrones().size();i++) {
            for(int j=0;j<csv.getPatrones().get(0).getNumberOfParametters()+1;j++) {
                if(j!=csv.getPatrones().get(0).getNumberOfParametters()) {
                    tablaPatronesEntrenamientoCSV[i][j] = csv.getPatrones().get(i).getParametros()[j];
                }else {
                    tablaPatronesEntrenamientoCSV[i][j] = csv.getPatrones().get(i).getClase();
                }
            }
        }
        tablaPatronesEntrenamiento.setModel(new javax.swing.table.DefaultTableModel(
            tablaPatronesEntrenamientoCSV,
            new String [] {
                "Longitud del sépalo", "Ancho del sépalo", "Longitud del pétalo", "Ancho del pétalo", "Clasificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPatronesEntrenamiento.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaPatronesEntrenamiento);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, 510, 420));

        jLabel1.setText("Patrones de entrenamiento");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        tablaDistanciasClasifcadasOrdenadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Distancias", "Clasificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDistanciasClasifcadasOrdenadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaDistanciasClasifcadasOrdenadas);
        if (tablaDistanciasClasifcadasOrdenadas.getColumnModel().getColumnCount() > 0) {
            tablaDistanciasClasifcadasOrdenadas.getColumnModel().getColumn(0).setResizable(false);
            tablaDistanciasClasifcadasOrdenadas.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 252, 420));

        jLabel2.setText("Distancias ordenadas");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        tablaFrecuenciasClasificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clasificación", "Frecuencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFrecuenciasClasificacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaFrecuenciasClasificacion);
        if (tablaFrecuenciasClasificacion.getColumnModel().getColumnCount() > 0) {
            tablaFrecuenciasClasificacion.getColumnModel().getColumn(0).setResizable(false);
            tablaFrecuenciasClasificacion.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 252, 420));

        jLabel3.setText("Frecuencias");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, -1, -1));

        spinnerParam1.setModel(new SpinnerNumberModel(new Double(0.0), new Double(0.0), null, new Double(0.1)));
        spinnerParam1.setToolTipText("Ingrese el valor del parámetro 1");
        add(spinnerParam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 80, -1));

        spinnerParam2.setModel(new SpinnerNumberModel(new Double(0.0), new Double(0.0), null, new Double(0.1)));
        spinnerParam2.setToolTipText("Ingrese el valor del parámetro 2");
        add(spinnerParam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 80, -1));

        spinnerParam4.setModel(new SpinnerNumberModel(new Double(0.0), new Double(0.0), null, new Double(0.1)));
        spinnerParam4.setToolTipText("Ingrese el valor del parámetro 4");
        add(spinnerParam4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 80, -1));

        spinnerParam3.setModel(new SpinnerNumberModel(new Double(0.0), new Double(0.0), null, new Double(0.1)));
        spinnerParam3.setToolTipText("Ingrese el valor del parámetro 3");
        add(spinnerParam3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 80, -1));

        jLabel4.setText("Patrón nuevo a clasificar");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("longitud del sépalo:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 120, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("anchura del sépalo:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 510, 120, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("longitud del pétalo:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 120, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ancho de pétalo:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 110, 20));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("         Valor K:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 80, 20));

        spinnerK.setModel(new javax.swing.SpinnerNumberModel(1, 1, csv.getPatrones().size(), 2));
        spinnerK.setToolTipText("Ingrese el valor K");
        add(spinnerK, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 80, -1));

        jButton1.setText("Clasificar");
        jButton1.setToolTipText("Tócame para clasificar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 104, -1));

        lblClasificacionNueva.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblClasificacionNueva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClasificacionNueva.setText("Clasificación");
        lblClasificacionNueva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lblClasificacionNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 162, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int reaccion = 0;
        if (((Integer) spinnerK.getValue()) < ((csv.getPatrones().size()) * (0.75))) {//esto lo pongo para advertir al usuario que tal vez está usando un k muy grande
            reaccion = JOptionPane.showConfirmDialog(null, "Desea realizar la clasificación con los parámetros establecidos.");
            if (reaccion == 0) {// si confirmó
                clasificacion();
            }
        } else {
            reaccion = JOptionPane.showConfirmDialog(null, "Desea realizar la clasificación a pesar de elegir un K muy grande \n Recomendación elija un valor de K pequeño.");
            if (reaccion == 0) {// si confirmó
                clasificacion();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblClasificacionNueva;
    private javax.swing.JSpinner spinnerK;
    private javax.swing.JSpinner spinnerParam1;
    private javax.swing.JSpinner spinnerParam2;
    private javax.swing.JSpinner spinnerParam3;
    private javax.swing.JSpinner spinnerParam4;
    private javax.swing.JTable tablaDistanciasClasifcadasOrdenadas;
    private javax.swing.JTable tablaFrecuenciasClasificacion;
    private javax.swing.JTable tablaPatronesEntrenamiento;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the knn
     */
    public KNN getKnn() {
        return knn;
    }

    /**
     * @return the csv
     */
    public CSV getCsv() {
        return csv;
    }

    private void clasificacion() {
        knn = new KNN((Integer) (spinnerK.getValue()), csv.getPatrones());
        //obtengo los valores de los parametros que están en los JSpinner
        double param1 = (Double) (spinnerParam1.getValue());
        double param2 = (Double) (spinnerParam2.getValue());
        double param3 = (Double) (spinnerParam3.getValue());
        double param4 = (Double) (spinnerParam4.getValue());

        double parametros[] = {param1, param2, param3, param4};//pasa los 4 parametros

        String nuevaClasificacion = knn.clasificaPatron(new Patron(parametros));

        lblClasificacionNueva.setText(nuevaClasificacion);
        /*actualizo la tabla de distancias*/
        Object[][] tabla = new Object[knn.getDistanciasInsertadasOrdenadas().size()][2];
        for (int i = 0; i < knn.getDistanciasInsertadasOrdenadas().size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    tabla[i][j] = knn.getDistanciasInsertadasOrdenadas().get(i).getDistance();
                } else {
                    tabla[i][j] = knn.getDistanciasInsertadasOrdenadas().get(i).getClase();
                }

            }
        }
        /*actualiza la tabla de distancias ordenadas descendentemente*/
        tablaDistanciasClasifcadasOrdenadas.setModel(new DefaultTableModel(tabla,
                new String[]{
                    "Distancia", "Clasificaci\u00F3n"
                }
        ));

        String[][] tabla2 = new String[3][2];

        HashMap<String, Integer> listadosFrecuencias = knn.getFrecuenciasClasificacion();
        //actualizo la tabla de frecuencias
        /*Como es una matriz de 3 * 2 voy a hacerlo manualmente*/
        String[] clasificaciones = {"Iris-virginica", "Iris-versicolor", "Iris-setosa"};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (j != 1) {
                    tabla2[i][j] = clasificaciones[i];
                } else {
                    tabla2[i][j] = listadosFrecuencias.get(clasificaciones[i]).toString();
                }

            }
        }
        /*actualizo la tabla de clasificaciones de vecinos*/
        tablaFrecuenciasClasificacion.setModel(new DefaultTableModel(
                tabla2,
                new String[]{
                    "Clasificaci\u00F3n", "Frecuencia"
                }
        ));

    }
}