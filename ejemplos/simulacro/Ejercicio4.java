//Escribe un programa en Java que calcule el factorial de un número dado.
public class Ejercicio4 {
  public void factorial(int number){
    int factorial = 1;
    for (int i = 1; i < number; i++) {
      factorial += factorial * i;
    }
    System.out.println(factorial);
  }
}
