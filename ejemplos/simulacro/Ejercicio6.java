//Escribe un programa en Java que determine si un número es primo.
public class Ejercicio6 {
  public boolean isPrimo(int number){
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        System.out.println("No es Primo");
        return false;
      }
    }
    System.out.println("Es Primo");
    return true;
  }
}
