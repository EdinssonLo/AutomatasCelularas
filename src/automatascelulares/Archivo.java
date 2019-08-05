package automatascelulares;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Archivo 
{

    //Atributos
    private BufferedWriter archivoEscritura;
    private BufferedReader archivoLectura;

    //Metodos
    public void abrirArchivo(String nombre, boolean escritura) throws IOException{
            if(escritura == true){
                    this.archivoEscritura = new BufferedWriter(new FileWriter(nombre,true ));
            }
            else{
                    this.archivoLectura = new BufferedReader(new FileReader(nombre));
            }	}

    public void escribirArchivo(String datos) throws IOException{
            archivoEscritura.write(datos);
            archivoEscritura.newLine();	
    }

    public String leerArchivo() throws IOException{
            return archivoLectura.readLine();
    }

    public void cerrarArchivo() throws IOException{
            if(archivoEscritura!= null)	archivoEscritura.close();
            if(archivoLectura!= null) archivoLectura.close();
    }

    public boolean puedeLeer() throws IOException{
            return archivoLectura.ready();
    }
    public String[] LeerPalabras(int cantidad){
            String[] palabras= new String[cantidad];
            int i=0;
            try {
                    while(this.puedeLeer() && i < cantidad){
                            palabras[i] =  this.leerArchivo();
                            i ++;
                    }
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return palabras;
    }
    //cuenta la cantidad de lineas que tiene el archivo
    public int contarLineas(String nombre) throws IOException
    {
            abrirArchivo(nombre, false); 
             int lineas = 0;
             while(puedeLeer()){
                     leerArchivo();
                     lineas ++; 
             }		 
             cerrarArchivo();
            return lineas;
    }

    public void modificarNomArchivo(String nuevo, String antiguo) throws IOException{
        File ant=new File(antiguo);
        File nuev=new File(nuevo);
        nuev.delete();
        if(ant.renameTo(nuev)){
            //System.out.println("Se renombro el archivo exitosmente");
        }
        else{
            //System.out.println("No se pudo renombrar el archivo");
        }
    }
    public void EliminarArchivo(String nombre){
        File archivo=new File(nombre);
        archivo.delete();
    }
   
    public boolean Exite(String nombre){
        File archivo=new File(nombre);
        return archivo.exists();
    }
}
