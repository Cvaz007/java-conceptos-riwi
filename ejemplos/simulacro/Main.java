public class Main {
  public static void main(String[] args) {
    // Se instancias objectos de las clases correspondientes
    Ejercicio1 exercise1 = new Ejercicio1();
    Ejercicio2 exercise2 = new Ejercicio2();
    Ejercicio3 exercise3 = new Ejercicio3();
    Ejercicio4 exercise4 = new Ejercicio4();
    Ejercicio5 exercise5 = new Ejercicio5();
    Ejercicio6 exercise6 = new Ejercicio6();
    Ejercicio7 exercise7 = new Ejercicio7();
    Ejercicio8 exercise8 = new Ejercicio8();
    Ejercicio9 exercise9 = new Ejercicio9();
    Ejercicio10 exercise10 = new Ejercicio10();

    // Se hace el llamado a los metodos
    exercise1.sayHelloWorld();
    exercise2.sum(77, 23);
    exercise3.isPair(3);
    exercise4.factorial(10);
    exercise5.reverseText("Hola");
    exercise6.isPrimo(7);
    exercise7.fibonacci(10);
    double[] array = { 2.1, 2, 6 };
    exercise8.prom(array);
    int[] array2 = { 2, 5, 3, 4, 6 };
    exercise9.sort(array2);
    int[][] matrizA = {
        { 1, 2, 3 },
        { 4, 5, 6 }
    };

    int[][] matrizB = {
        { 7, 8 },
        { 9, 10 },
        { 11, 12 }
    };
    exercise10.matriz(matrizA, matrizB);
  }
}
