package clases;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Datos implements Serializable
{
    private String pathPrimero;
    private String pathUltimo;

    public Datos()
    {
    }

    public Datos(String pathPrimero, String pathUltimo)
    {
        this.pathPrimero = pathPrimero;
        this.pathUltimo = pathUltimo;
    }

    /**
     * @return the pathPrimero
     */
    public String getPathPrimero()
    {
        return pathPrimero;
    }

    /**
     * @param pathPrimero the pathPrimero to set
     */
    public void setPathPrimero(String pathPrimero)
    {
        this.pathPrimero = pathPrimero;
    }

    /**
     * @return the pathUltimo
     */
    public String getPathUltimo()
    {
        return pathUltimo;
    }

    /**
     * @param pathUltimo the pathUltimo to set
     */
    public void setPathUltimo(String pathUltimo)
    {
        this.pathUltimo = pathUltimo;
    }
    
    
    
}
