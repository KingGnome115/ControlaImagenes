package ventanas;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kevin
 */
public class ServicioAgregar extends javax.swing.JFrame
{

    protected File carpetaGeneral = null;
    protected File[] Lista = null;
    protected ArrayList<File> nombrar = new ArrayList<>();
    protected ArrayList<String> label = new ArrayList<>();
    protected Hilo nuevo;

    /**
     * Creates new form Principal
     */
    public ServicioAgregar()
    {
        initComponents();
        nuevo = new Hilo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTCarpeta = new javax.swing.JLabel();
        btnElegir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Carpeta Actual.- ");

        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnElegirActionPerformed(evt);
            }
        });

        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagenes de la carpeta"));
        Panel.setLayout(new java.awt.GridLayout(0, 3, 50, 30));
        jScrollPane1.setViewportView(Panel);

        btnAgregar.setText("Iniciar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAgregarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear carpeta");
        btnCrear.setEnabled(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCrearActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElegir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrear)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnElegir)
                    .addComponent(jTCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnFinalizar))
                .addGap(4, 4, 4)
                .addComponent(btnSalir))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnElegirActionPerformed
    {//GEN-HEADEREND:event_btnElegirActionPerformed

        JFileChooser carpeta = new JFileChooser();
        carpeta.setCurrentDirectory(new File("."));
        carpeta.setDialogTitle("Seleccione la carpeta para trabajar");
        carpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        carpeta.setAcceptAllFileFilterUsed(false);
        int seleccion = carpeta.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            carpetaGeneral = carpeta.getSelectedFile();
            jTCarpeta.setText(carpetaGeneral.getAbsolutePath());
            btnAgregar.setEnabled(true);
            btnFinalizar.setEnabled(true);
            btnCrear.setEnabled(true);
        }

    }//GEN-LAST:event_btnElegirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAgregarActionPerformed
    {//GEN-HEADEREND:event_btnAgregarActionPerformed
        nuevo.valores(Lista, nombrar, carpetaGeneral, this);
        nuevo.start();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFinalizarActionPerformed
    {//GEN-HEADEREND:event_btnFinalizarActionPerformed

        nuevo.interrupt();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RenombrarImagenes(nombrar);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        Notificaciones("Renombre de imagenes en " + carpetaGeneral.getName(), "Se renombraron un total de " + nombrar.size());
        Actualizar2();
        btnAgregar.setEnabled(false);
        btnFinalizar.setEnabled(false);

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCrearActionPerformed
    {//GEN-HEADEREND:event_btnCrearActionPerformed

        if (carpetaGeneral == null)
        {
            btnElegirActionPerformed(evt);
        }
        String nombre = JOptionPane.showInputDialog("Nombre de la carpeta");
        File directorio = new File(carpetaGeneral.getAbsolutePath() + "\\" + nombre);
        if (!directorio.exists())
        {
            directorio.mkdir();
            carpetaGeneral = directorio;
            jTCarpeta.setText(carpetaGeneral.getAbsolutePath());
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSalirActionPerformed
    {//GEN-HEADEREND:event_btnSalirActionPerformed
        new Menu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    protected void RenombrarImagenes(ArrayList<File> obj)
    {
        String s = "";
        for (int i = 0; i < obj.size(); i++)
        {
            File tmp;
            s = obj.get(i).getParent() + "\\";
            String tam = String.valueOf(obj.size());
            String ii = String.valueOf(i);
            String ceros = "";
            int t = tam.length() - ii.length();
            if (t == 0 && ii.length() == 1)
            {
                t = 1;
            }
            for (int j = 0; j < t; j++)
            {
                ceros += "0";
            }
            s += ceros + i;
            String extencion = FilenameUtils.getExtension(obj.get(i).getName());
            s += "." + extencion;
            tmp = new File(s);
            obj.get(i).renameTo(tmp);
        }
    }

    public void Actualizar()
    {
        nuevo.pausar();
        if (!nombrar.isEmpty())
        {
            for (int i = 0; i < nombrar.size(); i++)
            {
                if (!IsIncluido(nombrar.get(i).getName()))
                {
                    ImageIcon icono = new ImageIcon(nombrar.get(i).getAbsolutePath());
                    JLabel imagen = new JLabel();
                    imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                    imagen.setText(nombrar.get(i).getName());
                    imagen.setHorizontalTextPosition(JLabel.CENTER);
                    imagen.setVerticalTextPosition(JLabel.BOTTOM);
                    Panel.add(imagen);
                    label.add(imagen.getText());
                }
            }
        }
        Panel.updateUI();
    }

    public void Actualizar2()
    {
        Panel.removeAll();
        Lista = carpetaGeneral.listFiles();
        if (Lista != null)
        {
            for (int i = 0; i < Lista.length; i++)
            {
                ImageIcon icono = new ImageIcon(Lista[i].getAbsolutePath());
                JLabel imagen = new JLabel();
                imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                imagen.setText(Lista[i].getName());
                imagen.setHorizontalTextPosition(JLabel.CENTER);
                imagen.setVerticalTextPosition(JLabel.BOTTOM);
                Panel.add(imagen);
            }
        }
        Panel.updateUI();
    }

    public boolean IsIncluido(String Label)
    {
        if (!label.isEmpty())
        {
            if (label.contains(Label))
            {
                return true;
            }
        }
        return false;
    }

    protected void Notificaciones(String titulo, String mensaje)
    {
        try
        {
            SystemTray tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");

            TrayIcon trayicon = new TrayIcon(image, "Java AWT Tray Demo");

            trayicon.setImageAutoSize(true);

            trayicon.setToolTip("System tray icon demo");

            tray.add(trayicon);

            trayicon.displayMessage(titulo, mensaje, TrayIcon.MessageType.INFO);
        } catch (AWTException ex)
        {
            Logger.getLogger(ServicioAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ServicioAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ServicioAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ServicioAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ServicioAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ServicioAgregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTCarpeta;
    // End of variables declaration//GEN-END:variables
}
