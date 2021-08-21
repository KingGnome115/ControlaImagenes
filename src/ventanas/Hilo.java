package ventanas;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kevin
 */
public class Hilo extends Thread
{

    protected File[] Lista;
    protected ArrayList<File> nombrar;
    protected File carpetaGeneral;
    protected ServicioAgregar vtn;

    public void valores(File[] Lista, ArrayList<File> nombrar, File carpetaGeneral, ServicioAgregar vtn)
    {
        this.Lista = Lista;
        this.nombrar = nombrar;
        this.carpetaGeneral = carpetaGeneral;
        this.vtn = vtn;
    }

    public void pausar()
    {

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run()
    {
        while (!isInterrupted())
        {
            Lista = carpetaGeneral.listFiles();
            if (Lista != null)
            {
                Lista = carpetaGeneral.listFiles();
                for (int i = 0; i < Lista.length; i++)
                {
                    if (!nombrar.contains(Lista[i]))
                    {
                        String extension = FilenameUtils.getExtension(Lista[i].getName());
                        if (!Lista[i].isDirectory() 
                                && extension.compareTo("jpg")==0
                                && extension.compareTo("gif")==0
                                && extension.compareTo("png")==0
                                && extension.compareTo("jpeg")==0)
                        {
                            nombrar.add(Lista[i]);
                            vtn.Actualizar();
                        }
                    }
                }
            }
        }
    }

}
