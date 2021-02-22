package ventanas;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kevin
 */
public class Elegir extends javax.swing.JFrame implements ActionListener
{

    protected File carpetaGeneral = null;
    protected File[] lista = null;
    protected ArrayList<String> bottons = new ArrayList<>();
    protected ArrayList<File> nombrar = new ArrayList<>();
    protected ArrayList<String> directoriosFavoritos = new ArrayList<>();
    private ArrayList<JMenuItem> submenus = new ArrayList<>();

    protected ArrayList<File> webp = new ArrayList<>();
    protected ArrayList<File> gif = new ArrayList<>();
    protected ArrayList<File> mp4webm = new ArrayList<>();

    private int indexInicio = 0;
    private int indexFinal;

    /**
     * Creates new form Principal
     */
    public Elegir()
    {
        initComponents();

        try
        {
            ObjectInputStream directorios = new ObjectInputStream(new FileInputStream("dirFav.dat"));
            directoriosFavoritos = (ArrayList<String>) directorios.readObject();
            if (directoriosFavoritos == null)
            {
                directoriosFavoritos = new ArrayList<>();
            } else
            {
                for (int i = 0; i < directoriosFavoritos.size(); i++)
                {
                    JMenuItem menuItem = new JMenuItem(directoriosFavoritos.get(i));
                    menuItem.addActionListener(this);
                    jMenuFavoritos.add(menuItem);
                    submenus.add(menuItem);
                }
            }
            directorios.close();
        } catch (Exception e)
        {
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < submenus.size(); i++)
        {
            if (e.getSource() == submenus.get(i))
            {
                carpetaGeneral = new File(directoriosFavoritos.get(i));
                jTCarpeta.setText(carpetaGeneral.getAbsolutePath());
                lista = carpetaGeneral.listFiles();
                if (lista != null)
                {
                    SepararFormatos();
                    jTCarpeta.setText(carpetaGeneral.getAbsolutePath());
                    btnMostrar.setEnabled(true);
                    btnRenombrar.setEnabled(true);
                    btnAgregar.setEnabled(true);
                    int can = lista.length;
                    if (can > 21)
                    {
                        indexFinal = 21;
                    } else
                    {
                        indexFinal = can;
                    }
                }
                Actualizar();
                break;
            }
        }
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
        jLabel2 = new javax.swing.JLabel();
        jTCarpeta = new javax.swing.JLabel();
        btnElegir = new javax.swing.JButton();
        btnRenombrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        btnMostrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        ChecarOpcion = new javax.swing.JCheckBox();
        JMenu = new javax.swing.JMenuBar();
        jMenuFavoritos = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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
        btnRenombrar.setEnabled(false);
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

        btnMostrar.setText("Mostrar Imagenes");
        btnMostrar.setEnabled(false);
        btnMostrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMostrarActionPerformed(evt);
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

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSiguienteActionPerformed(evt);
            }
        });

        Atras.setText("Atras");
        Atras.setEnabled(false);
        Atras.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AtrasActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar a favoritos");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAgregarActionPerformed(evt);
            }
        });

        ChecarOpcion.setText("Todas las imagenes");
        ChecarOpcion.setToolTipText("Seleccione para nombrar todas las imagenes de la carpeta");

        jMenuFavoritos.setText("Carpetas Favoritas");
        jMenuFavoritos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuFavoritosActionPerformed(evt);
            }
        });
        JMenu.add(jMenuFavoritos);

        setJMenuBar(JMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElegir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRenombrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(ChecarOpcion))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnElegir)
                    .addComponent(jTCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(Atras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChecarOpcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRenombrar)
                    .addComponent(btnSalir))
                .addContainerGap())
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
            lista = carpetaGeneral.listFiles();
            if (lista != null)
            {
                SepararFormatos();
                jTCarpeta.setText(carpetaGeneral.getAbsolutePath());
                btnMostrar.setEnabled(true);
                btnRenombrar.setEnabled(true);
                btnAgregar.setEnabled(true);
                int can = lista.length;
                if (can > 21)
                {
                    indexFinal = 21;
                } else
                {
                    indexFinal = can;
                }
                Actualizar();
            }
        }

        if (lista != null)
        {
            Notificaciones("Imagenes de la carpeta " + carpetaGeneral.getName(), "Se cargaron un total de " + lista.length + " Imagenes");
        }

    }//GEN-LAST:event_btnElegirActionPerformed

    private void btnRenombrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRenombrarActionPerformed
    {//GEN-HEADEREND:event_btnRenombrarActionPerformed

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        if (ChecarOpcion.isSelected())
        {
            SepararFormatos();
            RenombrarImagenes1();
            webp = CrearCarpetas(webp, "Webp");
            gif = CrearCarpetas(gif, "Gif");
            mp4webm = CrearCarpetas(mp4webm, "Videos");
            RenombrarImagenes(gif);
            RenombrarImagenes(mp4webm);
            RenombrarImagenes(webp);
            Notificaciones("Renombre de imagenes en " + carpetaGeneral.getName(), "Se renombraron un total de " + lista.length);
        } else
        {
            crear(evt);
            RenombrarImagenes();
            lista = carpetaGeneral.getParentFile().listFiles();
            carpetaGeneral = carpetaGeneral.getParentFile();
            RenombrarImagenes1();
            Notificaciones("Renombre de imagenes en " + carpetaGeneral.getName(), "Se renombraron un total de " + nombrar.size());
        }
        bottons.clear();
        Actualizar();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_btnRenombrarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMostrarActionPerformed
    {//GEN-HEADEREND:event_btnMostrarActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Panel.removeAll();
        Actualizar();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        Notificaciones("Imagenes Visualizadas", "Se imprimieron un total de " + lista.length);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSalirActionPerformed
    {//GEN-HEADEREND:event_btnSalirActionPerformed

        try
        {
            ObjectOutputStream directorios = new ObjectOutputStream(new FileOutputStream("dirFav.dat"));
            directorios.writeObject(directoriosFavoritos);
            directorios.close();
        } catch (Exception e)
        {
        }

        dispose();
        System.exit(0);

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSiguienteActionPerformed
    {//GEN-HEADEREND:event_btnSiguienteActionPerformed
        Atras.setEnabled(true);
        indexInicio += 21;
        indexFinal += 21;
        if (indexFinal > lista.length)
        {
            indexFinal = lista.length;
            indexInicio = indexFinal - 21;
            btnSiguiente.setEnabled(false);
        }
        long inicio = System.currentTimeMillis();
        Actualizar();
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println(tiempo + " segundos");
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AtrasActionPerformed
    {//GEN-HEADEREND:event_AtrasActionPerformed
        btnSiguiente.setEnabled(true);
        indexInicio -= 21;
        indexFinal -= 21;
        if (indexInicio < 0)
        {
            indexInicio = 0;
            indexFinal = 21;
            Atras.setVisible(false);
        }
        long inicio = System.currentTimeMillis();
        Actualizar();
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println(tiempo + " segundos");
    }//GEN-LAST:event_AtrasActionPerformed

    private void jMenuFavoritosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuFavoritosActionPerformed
    {//GEN-HEADEREND:event_jMenuFavoritosActionPerformed


    }//GEN-LAST:event_jMenuFavoritosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAgregarActionPerformed
    {//GEN-HEADEREND:event_btnAgregarActionPerformed

        if (!directoriosFavoritos.contains(carpetaGeneral.getAbsolutePath()))
        {
            directoriosFavoritos.add(carpetaGeneral.getAbsolutePath());
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void SepararFormatos()
    {
        ArrayList<File> tmp = new ArrayList<>();
        for (int i = 0; i < lista.length; i++)
        {
            String extencion = FilenameUtils.getExtension(lista[i].getName());
            if ((extencion.compareTo("webp") == 0))
            {
                webp.add(lista[i]);
            } else
            {
                if ((extencion.compareTo("mp4") == 0) || (extencion.compareTo("webm") == 0))
                {
                    mp4webm.add(lista[i]);
                } else
                {
                    if (extencion.compareTo("gif") == 0)
                    {
                        gif.add(lista[i]);
                    } else
                    {
                        tmp.add(lista[i]);
                    }
                }
            }
        }

        lista = new File[tmp.size()];
        for (int i = 0; i < tmp.size(); i++)
        {
            lista[i] = tmp.get(i);
        }

    }

    private String RecortarNombre(String nombre)
    {
        String s = "";

        if (nombre.length() > 15)
        {
            int n = nombre.length() - FilenameUtils.getExtension(nombre).length() - 1;
            s = nombre.substring(0, 4) + "..." + nombre.substring(n - 2, n) + "." + FilenameUtils.getExtension(nombre);
        } else
        {
            s = nombre;
        }

        return s;
    }

    protected void crear(java.awt.event.ActionEvent evt)
    {
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
        }
    }

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

    protected void RenombrarImagenes()
    {
        String s = "";
        for (int i = 0; i < nombrar.size(); i++)
        {

            if (!nombrar.get(i).isDirectory())
            {
                File tmp;
                s = carpetaGeneral.getAbsolutePath() + "\\";
                String tam = String.valueOf(nombrar.size());
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
                String extencion = FilenameUtils.getExtension(nombrar.get(i).getName());
                s += "." + extencion;
                tmp = new File(s);
                nombrar.get(i).renameTo(tmp);
            }

        }
    }

    protected void RenombrarImagenes1()
    {
        String s = "";
        for (int i = 0; i < lista.length; i++)
        {

            if (!lista[i].isDirectory())
            {
                File tmp;
                s = carpetaGeneral.getAbsolutePath() + "\\";
                String tam = String.valueOf(lista.length);
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
                String extencion = FilenameUtils.getExtension(lista[i].getName());
                s += "." + extencion;
                tmp = new File(s);
                lista[i].renameTo(tmp);
            }
        }
        lista = carpetaGeneral.listFiles();
        Actualizar();
    }

    protected ArrayList CrearCarpetas(ArrayList<File> obj, String nombreCarpeta)
    {
        ArrayList<File> tm = new ArrayList<>();
        if (!obj.isEmpty())
        {
            String s;
            File directorio = new File(carpetaGeneral.getAbsolutePath() + "\\" + nombreCarpeta);
            if (!directorio.exists())
            {
                if (directorio.mkdir())
                {
                    for (int i = 0; i < obj.size(); i++)
                    {
                        File tmp;
                        s = directorio.getAbsolutePath() + "\\" + obj.get(i).getName();
                        tmp = new File(s);
                        obj.get(i).renameTo(tmp);
                        tm.add(tmp);
                    }
                }
            }
        }
        return tm;
    }

    public void Actualizar()
    {
        Panel.removeAll();
        if (lista != null)
        {
            for (int i = indexInicio; i < indexFinal; i++)
            {
                if (!lista[i].isDirectory())
                {
                    ImageIcon icono = new ImageIcon(lista[i].getAbsolutePath());
                    JButton imagen = new JButton();
                    imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                    imagen.setText(RecortarNombre(lista[i].getName()));
                    imagen.setHorizontalTextPosition(JLabel.CENTER);
                    imagen.setVerticalTextPosition(JLabel.BOTTOM);
                    if (bottons.contains(imagen.getText()))
                    {
                        imagen.setBackground(Color.green);
                    } else
                    {
                        imagen.setBackground(Color.red);
                    }
                    Panel.add(imagen);
                    File obj = lista[i];
                    imagen.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            if (!nombrar.contains(obj))
                            {
                                nombrar.add(obj);
                                bottons.add(imagen.getText());
                                imagen.setBackground(Color.GREEN);
                            } else
                            {
                                nombrar.remove(obj);
                                bottons.remove(imagen.getText());
                                imagen.setBackground(Color.red);
                            }
                        }
                    });
                }
            }
            Panel.updateUI();
        }
    }

    public void Actualizar2()
    {
        Panel.removeAll();
        lista = carpetaGeneral.listFiles();
        if (lista != null)
        {
            for (int i = 0; i < lista.length; i++)
            {
                if (!lista[i].isDirectory())
                {
                    ImageIcon icono = new ImageIcon(lista[i].getAbsolutePath());
                    JLabel imagen = new JLabel();
                    imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                    imagen.setText(lista[i].getName());
                    imagen.setHorizontalTextPosition(JLabel.CENTER);
                    imagen.setVerticalTextPosition(JLabel.BOTTOM);
                    Panel.add(imagen);
                }
            }
        }
        Panel.updateUI();
    }

    public boolean IsIncluido(String Label)
    {
        if (!bottons.isEmpty())
        {
            if (bottons.contains(Label))
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
            Logger.getLogger(Elegir.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Elegir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Elegir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Elegir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Elegir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Elegir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JCheckBox ChecarOpcion;
    private javax.swing.JMenuBar JMenu;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRenombrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuFavoritos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTCarpeta;
    // End of variables declaration//GEN-END:variables
}
