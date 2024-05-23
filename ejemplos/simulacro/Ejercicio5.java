//Escribe un programa en Java que invierta una cadena de texto.
public class Ejercicio5 {

  public void reverseText(String text){
    StringBuilder revertText = new StringBuilder(text);
    System.out.println(revertText.reverse());
  }
}
