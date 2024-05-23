//Escribe un programa en Java que multiplique dos matrices.
public class Ejercicio10 {
  public void matriz(int[][] matrizA, int[][] matrizB) {
    int filasA = matrizA.length;
    int columnasA = matrizA[0].length;
    int filasB = matrizB.length;
    int columnasB = matrizB[0].length;

    // Comprobamos si las matrices se pueden multiplicar
    if (columnasA == filasB) {
      // Creamos la matriz resultante
      int[][] resultado = new int[filasA][columnasB];

      // Multiplicamos las matrices
      for (int i = 0; i < filasA; i++) {
        for (int j = 0; j < columnasB; j++) {
          for (int k = 0; k < columnasA; k++) {
            resultado[i][j] += matrizA[i][k] * matrizB[k][j];
          }
        }
      }
      // Imprimimos la matriz resultante
      for (int i = 0; i < resultado.length; i++) {
        for (int j = 0; j < resultado[i].length; j++) {
          System.out.print(resultado[i][j] + " ");
        }
        System.out.println();
      }
    } else
      System.out.println("Las matrices no se pueden multiplicar.");

  }
}
