/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.carpa.metodos;

import mx.itson.carpa.enumeradores.Sexo;

/**
 * Metodos del proyecto
 * @author hector
 */
public class Curp {
    
    /**
     * Recibe los datos de la curp
     * @return  Los datos de la primera vocal interna, primera letra del segundo apellido,
       primera letra del primer nombre, fecha de nacimiento, código de estado y la primer
       consonante interna del segundo apellido
     * @param nombres, apellidoP, apellidoM, diaNacimiento, anioNacimiento, sexo, estado, 
     */      
    public String sacarCurp(
            String nombres,
            String apellidoP,
            String apellidoM,
            String diaNacimiento,
            String mesNacimineto,
            int anioNacimiento,
            Sexo sexo,
            String estado) {
        
        nombres = formato(nombres);
        apellidoP = formato(apellidoP);
        apellidoM = formato(apellidoM);

        String nombreCompuesto = nombresCompuestos(nombres);
        
        String curp = letraYVocal(apellidoP)
                + letraApellidoM(apellidoM)
                + letraNombre(nombreCompuesto)
                + fechaNacimiento(diaNacimiento, mesNacimineto, anioNacimiento)
                + sexo(sexo)
                + claveEstado(estado)
                + consonanteApellidoP(apellidoP)
                + consonanteApellidoM(apellidoM)
                + primerConsonanteApellido(nombres)
                + penultimoDigitoAnio(anioNacimiento)
                + '1'
                ;

        return curp;
    }
    
    /**
    * Le da formato a las palabras, les quita espacios, reemplaza también los acentos de cada vocal haciendo que se conviertan en mayuscula.
    * @param  palabra, 
    * @return la palabra sin espacios al inicio ni al final, removiendo los acentos y en mayuscula
     */
    
    static String formato(String palabra) {
        return palabra.trim()
                .replace('á', 'a')
                .replace('é', 'e')
                .replace('í', 'i')
                .replace('ó', 'o')
                .replace('ú', 'u').toUpperCase();
    }
    
    /**
* Recibe la primera vocal de la palabra, empezando por la primera posición de caracteres saltando posiciónes que no cumplan con las caracteristicas 
* hasta llegar a la vocal
* @param  palabra, vocales
* @return el caracter que sea la primera vocal interna del nombre.
 */
    
    static char vocalApellido(String palabra) {
        String vocales = "AEIOU";

        for (int i = 1; 0 <= palabra.length(); i++) {
            if (vocales.contains(String.valueOf(palabra.charAt(i)))) {
                return palabra.charAt(i);
            }
        }

        return ' ';
    }
    
    /**
* Recibe el primer caracter consonante del nombre o la palabra ingresada
*@param  palabra, vocales,
 *@return  el caracter de la palabra que sea la primer consonante del nombre o palabra ingresada.
 */
    static char primerConsonanteApellido(String palabra) {
        String vocales = "BCDFGHJKLMÑPQRSTVWXYZ";

        for (int i = 1; 0 <= palabra.length(); i++) {
            if (vocales.contains(String.valueOf(palabra.charAt(i)))) {
                return palabra.charAt(i);
            }
        }

        return ' ';
    }
/**
* Recibe la primer letra y la vocal del apellido paterno separándola con arreglo de caracteres, dependiendo la posición, la primera posición (0) se recorre.
* @param  palabra,
* @return la primera vocal interna de palabra
 */

    static String letraYVocal(String palabra) {
        char[] letras = {palabra.charAt(0), vocalApellido(palabra)};

        return new String(letras);
    }
/**
* Recibe la primera letra del apellido paterno
 @param apellidoPaterno, 
 @return Un caracter que es la primera letra del primer apellido
 */
    static public char letraApellidoP(String apellidoPaterno) {
        return apellidoPaterno.charAt(0);
    }
/**
* Recibe la primera letra del apellido materno
 @param segundoApellido,
 @return Un caracter que es la primera letra del segundo apellido
 */

    static char letraApellidoM(String segundoApellido) {
        return segundoApellido.charAt(0);
    }
/**
* Recibe la primera letra del primer nombre
 @param  nombrePila,
 @return  el caracter que se encuentra en la primera posición del primer nombre
 */
    static char letraNombre(String primerNombre) {
        return primerNombre.charAt(0);
    }
    
/**
* Recibe la primer consonante del apellido paterno
 @param primerApellido,
 @return la primera consonante del apellido paterno.
 */
    static char consonanteApellidoP(String primerApellido) {
        return primerConsonanteApellido(primerApellido);
    }
    
    /**
     * Recibe la primer consonante del apellido materno 
     * @param  segundoApellido, 
     * @return la primer letra consonante dentro del apellido materno.
     */
    static char consonanteApellidoM(String segundoApellido) {
        if (segundoApellido.equals("X")) {
            return 'X';
        } else {
            return primerConsonanteApellido(segundoApellido);
        }
    }
    
/**
* Recibe la fecha de nacimiento el dia, mes, año
* @param dia, mes, anio
* @return dos dígitos para el día, mes y año correspondientes de los datos ingresados.
 */
    public static String fechaNacimiento(String dia, String mes, int anio) {
        String anioString = "" + anio;
        
        return anioString.charAt(2) + "" + anioString.charAt(3) + mes + dia;
    }
/**
* Establece cada clave de cada estado corresponde a la entidad de nacimiento.
* @param estado
* @return la clave hecho en dos cifras para determinar la pertenencia del individuo.
 */
    public static String claveEstado(String estado) {
        switch (estado) {
            case "Aguascalientes":
                return "AS";
            case "Baja California":
                return "BC";
            case "Baja California Sur":
                return "BS";
            case "Campeche":
                return "CC";
            case "Coahuila de Zaragoza":
                return "CL";
            case "Colima":
                return "CM";
            case "Chiapas":
                return "CS";
            case "Chihuahua":
                return "CH";
            case "Distrito Federal":
                return "DF";
            case "Durango":
                return "DG";
            case "Guanajuato":
                return "GT";
            case "Guerrero":
                return "GR";
            case "Hidalgo":
                return "HG";
            case "Jalisco":
                return "JC";
            case "México":
                return "MC";
            case "Michoacán de Ocampo":
                return "MN";
            case "Morelos":
                return "MS";
            case "Nayarit":
                return "NT";
            case "Nuevo León":
                return "NL";
            case "Oaxaca":
                return "OC";
            case "Puebla":
                return "PL";
            case "Querétaro":
                return "QT";
            case "Quintana Roo":
                return "QR";
            case "San Luis Potosí":
                return "SP";
            case "Sinaloa":
                return "Sl";
            case "Sonora":
                return "SR";
            case "Tabasco":
                return "TC";
            case "Tamaulipas":
                return "TS";
            case "Tlaxcala":
                return "TL";
            case "Veracruz":
                return "VZ";
            case "Yucatán":
                return "YN";
            case "Zacatecas":
                return "ZS";
            case "Nacido en el Extranjero":
                return "NE";
            default:
                return " ";
        }
    }
    
    /**
     * Recibimos los enumeradores para determinar el caracter del sexo
     * @param sexo,
     * @return el sexo en forma de caracter
     */
    static char sexo(Sexo sexo){
        switch (sexo) {
            case HOMBRE:
                return 'H';
            case MUJER:
                return 'M';
            default:
                throw new AssertionError();
        }
    }
    /**
     * Recibimos el año para determinar el penultimo valor de la CURP
     * @param anio,
     * @return el penultimo valor de la curp dependiendo del año nacido
     */
    static char penultimoDigitoAnio(int anio){
        if(anio >= 2000){
            return 'A';
        } else {
            return '0';
        }
    }
   
    /**
     * Se dividen los nombres y si uno de los dos empieza por maria o jose se salta al segundo nombre
     * @param nombres,
     * @return el salto de nombre al segundo si cumple con la condicion
     */
    static String nombresCompuestos(String nombres) {
        String[] arrayNombres = nombres.split(" ");

        if (arrayNombres.length == 2) {
            if (arrayNombres[0].equals("JOSE") || arrayNombres[0].equals("MARIA")) {
                return arrayNombres[1];
            } else {
                return arrayNombres[0];
            }
        } else {
            if(arrayNombres[0].equals("JOSE") || arrayNombres[0].equals("MARIA")){
                return arrayNombres[arrayNombres.length-1];
            } else {
             return arrayNombres[0];
            }
        }

    }
    
}