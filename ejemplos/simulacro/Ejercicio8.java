//Escribe un programa en Java que calcule la media de los elementos de un array.
public class Ejercicio8 {
  public void prom(double[] array) {
    double prom = 0;
    for (int i = 0; i < array.length; i++) {
      prom+= array[i];
    }
    System.out.println(prom/array.length);
  }
}
