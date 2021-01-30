package ventanas;

import java.io.File;
import java.util.ArrayList;

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

    public void run()
    {
        System.out.println("Empece hilo");
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
                        nombrar.add(Lista[i]);
                        vtn.Actualizar();
                    }
                }
            }
            
        }
        System.out.println("Hilo muerto");
    }

}
