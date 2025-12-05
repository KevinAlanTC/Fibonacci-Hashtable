/**
Tema: Clase Hashtable<k,v>

Curso: MCA1 2026-1

Objetivo: Ver uso de Hashtable para posteriormente simular
   el diccionario que utilizamos en el programa
                  fibonacci-MemDic1.py

 Acciones: Crear: la tabla hash (fiboSuc = Suceción de fibonacci)
           Obtener datos dada una llave: método get(key)
           Modificar datos: método replace(key, valor)
           Recorrer la tabla hash mediante: foreach

Referencias:
* https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Hashtable.html
* https://www.geeksforgeeks.org/java/hashtable-foreach-method-in-java-with-examples/


Software: Java 25
          IDE IntelliJ 2025.2.4

Editor: Roberto Méndez Méndez
Created 1 Nov 2025
**/

void main() {

    IO.println(String.format("Uso de la clase Hashtable<k, v>"));

    Hashtable<Integer, Integer> fiboSuc
            = new Hashtable<Integer, Integer>();
    fiboSuc.put(0, 0);
    fiboSuc.put(1, 1);
    fiboSuc.put(2, 1);

    // Forma 1  de recorrer la tabla hash
    // mediante foreach
    for (int key : fiboSuc.keySet()) {
        int val = fiboSuc.get(key);
        System.out.printf("El valor de fibonacci en la posición %d es %d %n",
                           key, val);
    }

    // Forma 2  de recorrer la tabla hash
    // mediante foreach
    fiboSuc.forEach((key, value) ->
            System.out.println("Key: " + key + ", Value: " + value));

    // Forma 2  de recorrer la tabla hash
    // y alterar el valor del registro
    System.out.println("Soy fibonacci + 100");
    fiboSuc.forEach((k, v) -> {
        v = v + 100;
        fiboSuc.replace(k, v);
        System.out.println("Key: " + k + ", Value: " + v);
    });
}
