package ventanas;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kevin
 */
public class Principal extends javax.swing.JFrame
{

    protected File carpetaGeneral = null;
    protected File[] Lista = null;

    /**
     * Creates new form Principal
     */
    public Principal()
    {
        initComponents();
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
        btnRenombrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();

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

        btnRenombrar.setText("Renombrar");
        btnRenombrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRenombrarActionPerformed(evt);
            }
        });

        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagenes de la carpeta"));
        Panel.setLayout(new java.awt.GridLayout(0, 3, 50, 30));
        jScrollPane1.setViewportView(Panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElegir))
                    .addComponent(jLabel2)
                    .addComponent(btnRenombrar))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRenombrar)
                .addGap(62, 62, 62))
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

            Lista = carpetaGeneral.listFiles();

            jTCarpeta.setText(carpetaGeneral.getAbsolutePath());
        }
        Actualizar();
        Notificaciones("Imagenes de la carpeta " + carpetaGeneral.getName(), "Se cargaron un total de " + Lista.length + " Imagenes");

    }//GEN-LAST:event_btnElegirActionPerformed

    private void btnRenombrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRenombrarActionPerformed
    {//GEN-HEADEREND:event_btnRenombrarActionPerformed

        String s = "";
        for (int i = 0; i < Lista.length; i++)
        {
            File tmp;
            s = Lista[i].getParent() + "/";
            if (s.compareTo("") == 0)
            {
                s += "00";
            } else
            {
                if (i > 0 && i <= 9)
                {
                    s += "0" + i;
                } else
                {
                    s += i + "";
                }
            }
            s += "." + FilenameUtils.getExtension(Lista[i].getName());
            System.out.println(s);
            tmp = new File(s);
            Lista[i].renameTo(tmp);
        }

        Lista = carpetaGeneral.listFiles();
        Notificaciones("Renombre de imagenes en " + carpetaGeneral.getName(), "Se renombraron un total de " + Lista.length);

    }//GEN-LAST:event_btnRenombrarActionPerformed

    private void Actualizar()
    {
        Panel.removeAll();

        for (int i = 0; i < Lista.length; i++)
        {
            ImageIcon icono = new ImageIcon(Lista[i].getAbsolutePath());
            JLabel imagen = new JLabel();
            imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            Panel.add(imagen);
            System.out.println(Lista[i].getName());
        }
        Panel.updateUI();
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
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnRenombrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTCarpeta;
    // End of variables declaration//GEN-END:variables
}
