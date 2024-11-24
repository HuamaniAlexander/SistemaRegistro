package Controlador;

import Modelo.LenguajeProgramacion;

public class GestionLenguaje {

    //ATRIBUTOS
    private LenguajeProgramacion[] arregloLenguajes;
    private int contadorLenguajes;
    private static final int FACTOR_CRECIMIENTO = 2;

    //CONSTRUCTOR
    public GestionLenguaje() {
        this.arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
        this.contadorLenguajes = 0;
    }
    
    //METODO PARAMETRIZADO
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        // Si el arreglo esta lleno, se crea uno nuevo con mayor tamaño
        if (contadorLenguajes == arregloLenguajes.length) {
            LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length * FACTOR_CRECIMIENTO];
            System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
            arregloLenguajes = nuevoArreglo;
        }
        
        // Se agrega el nuevo lenguaje y se incrementa el contador
        arregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion,
                caracteristicaPrincipal, nombre, utilizacion);
        System.out.println("Lenguaje agregado exitosamente.");
    }

    //METODO PARAMETRIZADO
    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            //Compara el nombre sin diferenciar entre mayúsculas y minúsculas
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null;
    }
    
    //METODO PARAMETRIZADO
    public boolean eliminarLenguaje(String nombre) {
        // Recorre el arreglo de lenguajes y si encuentra el lenguaje, lo elimina
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                System.arraycopy(arregloLenguajes, i + 1, arregloLenguajes, i, contadorLenguajes - i - 1);
                contadorLenguajes--;
                return true;
            }
        }
        return false;
    }

    //METODO VACIO
    public LenguajeProgramacion[] getArregloLenguajes() {
        //Crea un nuevo arreglo con el tamaño correcto
        LenguajeProgramacion[] resultado = new LenguajeProgramacion[contadorLenguajes];
        // Copia los elementos del arreglo original al nuevo arreglo
        System.arraycopy(arregloLenguajes, 0, resultado, 0, contadorLenguajes);
        return resultado;
    }
 /* 
    //METODO VACIO
    public void imprimirLenguajes() {
        // Si no hay lenguajes registrados, muestra un mensaje y sale del método
        if (contadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
            return;
        }
        
        // Recorre e imprime todos los lenguajes registrados
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(arregloLenguajes[i].toString());
        }
    }
*/
 
    //METODO PARAMETRIZADO
    //Método para imprimir el formato de cada lenguaje
    public void formatoLenguajes(LenguajeProgramacion formato) {
        System.out.printf("| %-15s | %-25s | %-16d | %-24s | \n", 
                formato.getNombre(),
                formato.getCaracteristicaPrincipal(),
                formato.getAnioCreacion(),
                formato.getUtilizacion()
        );
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    //METODO VACIO
    public void imprimirLenguajes() {
        // Si no hay lenguajes registrados, muestra un mensaje y sale del método
        if (contadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
            return;
        }
        
        // Imprime el encabezado con formato
        System.out.println("=============================================================================================");
        System.out.println("                                     IMPRESION LENGUAJES                                         ");
        System.out.println("=============================================================================================");
        System.out.printf("| %-15s | %-25s | %-16s | %-24s | \n", 
                          "LENGUAJE", "CARACTERISTIA PRINCIPAL", "AÑO DE CREACION", "UTILIZACION");
        System.out.println("---------------------------------------------------------------------------------------------");
        
        // Llama al método formatoLenguajes para imprimir cada lenguaje
        for (int i = 0; i < contadorLenguajes; i++) {
            formatoLenguajes(arregloLenguajes[i]);
        }
    }

    
}
