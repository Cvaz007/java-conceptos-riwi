
import java.util.ArrayList;
import java.util.List;

//Escribe un programa en Java que genere la serie de Fibonacci hasta un número dado.
public class Ejercicio7 {
  public void fibonacci(int number){
    List<Integer> serie = new ArrayList<>();
    serie.add(1);
    serie.add(1);
    for (int i = 2; i < number; i++) {
      int current = serie.get(i-1) + serie.get(i-2);
      serie.add(current);
    }
    System.out.println(serie.toString());
  }
}
