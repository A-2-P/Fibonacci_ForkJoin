import java.util.concurrent.ForkJoinPool;

public class Fibonacci {

        public static void main(String[] args) {
            final int wert = 45;
            //ForkJoin - Parallel
            //Benötigte Instanzen erstellen
            FibonacciTask fibonacci = new FibonacciTask(wert);
            ForkJoinPool pool = new ForkJoinPool();
            //Startzeit speichern
            double timeStart = System.currentTimeMillis();
            //invoken --> compute()
            long erg = pool.invoke(fibonacci);
            //Endzeit speichern
            double timeEnd = System.currentTimeMillis()- timeStart;
            //Ausgabe
            System.out.println("Die "+ wert + "te Fibonacci-Folge ist: "+ erg +
                    ". Parallele Berechnung. \tZeit: "+timeEnd/1000+" Sekunden");

            //SINGLE CORE
            timeStart = System.currentTimeMillis();
            erg = fibonacci_singleCore(wert);
            timeEnd = System.currentTimeMillis()- timeStart;
            System.out.println("Die "+ wert + "te Fibonacci-Folge ist: "+ erg +
                    ". SingleCore. \t\t\t\tZeit: "+timeEnd/1000+" Sekunden");
        }

        public static int fibonacci_singleCore(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci_singleCore(n - 1) + fibonacci_singleCore(n - 2);

            }
        }
}
