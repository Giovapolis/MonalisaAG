package Ventanas;

import AG.Figura;
import AG.Monalisa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends javax.swing.JFrame {

    ImageIcon imagen;

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        origen = new javax.swing.JLabel();
        resultado = new javax.swing.JPanel();
        btn_carga = new javax.swing.JButton();
        btn_inicio = new javax.swing.JButton();
        btn_parar = new javax.swing.JButton();
        lbl_aptitud = new javax.swing.JLabel();
        btn_reinicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AG");
        setResizable(false);

        origen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        resultado.setBackground(new java.awt.Color(0, 0, 0));
        resultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout resultadoLayout = new javax.swing.GroupLayout(resultado);
        resultado.setLayout(resultadoLayout);
        resultadoLayout.setHorizontalGroup(
            resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        resultadoLayout.setVerticalGroup(
            resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_carga.setText("CARGAR IMAGEN");
        btn_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargaActionPerformed(evt);
            }
        });

        btn_inicio.setText("INICIAR ALGORITMO");
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });

        btn_parar.setText("PARAR");

        lbl_aptitud.setText("Aptitud: ");

        btn_reinicio.setText("REINICIAR");
        btn_reinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reinicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btn_carga))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btn_parar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_aptitud)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addComponent(btn_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_reinicio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(origen, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_carga)
                    .addComponent(lbl_aptitud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_inicio)
                    .addComponent(btn_reinicio)
                    .addComponent(btn_parar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargaActionPerformed
        JFileChooser f = new JFileChooser();
        f.setDialogTitle("Selecciona una imagen");

        if (f.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagen = new ImageIcon(f.getSelectedFile().toString());
            String ruta = f.getSelectedFile().toString();
            rsscalelabel.RSScaleLabel.setScaleLabel(origen, ruta);
        }
    }//GEN-LAST:event_btn_cargaActionPerformed

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        try {
            Monalisa ag = new Monalisa(imagen, 10, resultado);//iteraciones
            ag.start();
            ag.join();
            pintar(resultado.getGraphics(), ag);
            CreateImage(resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron dibujar las figuras\n" + e);
        }

    }//GEN-LAST:event_btn_inicioActionPerformed

    private void btn_reinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reinicioActionPerformed
    }//GEN-LAST:event_btn_reinicioActionPerformed

    private void pintar(Graphics g, Monalisa ag) {
        for (int i = 0; i < 1; i++) {
            System.out.println(ag.getPoblacion().get(i));
            for (Figura figura : ag.getPoblacion().get(i).getCromo()) {
                g.setColor(new Color(figura.getRojo(), figura.getVerde(), figura.getAzul(), figura.getAlpha()));
                g.fillOval(
                        figura.getCoordenadas().x,
                        figura.getCoordenadas().y,
                        figura.getLargo(),
                        figura.getAlto()
                );
            }
        }
    }

    void CreateImage(JPanel panel) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_carga;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_parar;
    private javax.swing.JButton btn_reinicio;
    private javax.swing.JLabel lbl_aptitud;
    private javax.swing.JLabel origen;
    private javax.swing.JPanel resultado;
    // End of variables declaration//GEN-END:variables
}
