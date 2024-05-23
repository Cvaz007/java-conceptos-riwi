import java.util.Arrays;
//Escribe un programa en Java que ordene los elementos de un array en orden ascendente.
public class Ejercicio9 {
  // Suponniendo que es un array de numeros
  public void sort(int[] array) {
    Arrays.sort(array);
    for (int i : array) {
      System.out.print(i+ ", ");
    }
    System.out.println();
  }

}
