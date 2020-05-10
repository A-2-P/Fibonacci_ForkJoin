import java.util.concurrent.*;

class FibonacciTask extends RecursiveTask<Long> {
    final long n;

    FibonacciTask(long n) {
        this.n = n;
    }

    public Long compute() {

        //if (n<=1) {
        if(n<=10){
            return do_fibonacci(n);
            //return n;
        }
        ForkJoinTask<Long> subTask1 = new FibonacciTask(n-1).fork();
        ForkJoinTask<Long> subTask2 = new FibonacciTask(n-2).fork();
        return subTask1.join() + subTask2.join();
        //return new FibonacciTask(n-2).compute() + new FibonacciTask(n-1).compute();
    }

    static long do_fibonacci(long n) {
        if ( n<=1 ) return n;
        return do_fibonacci(n-1) + do_fibonacci(n-2);
    }
}

