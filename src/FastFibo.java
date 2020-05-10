import java.math.BigInteger;

public class FastFibo {
    final static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {
        double timeStart = System.nanoTime();
        BigInteger erg = fib(45);
        double timeEnd = System.nanoTime() - timeStart;
        System.out.println("Das Ergebnis ist: "+ erg + " Zeit: "+ timeEnd/1000000 +" Millisekunden");
    }

        public static BigInteger fib(int value) {
            BigInteger n = BigInteger.valueOf(value);
            if (n.compareTo(BigInteger.ONE) <= 0) {
                return n;
            }
            BigInteger x = BigInteger.ONE;
            BigInteger y = BigInteger.ZERO;

            for (int k = n.bitLength() - 2; k >= 0; k--) {
                BigInteger xx = x.pow(2);
                x = xx.add(TWO.multiply(x).multiply(y));
                y = xx.add(y.pow(2));
                if (n.testBit(k)) {
                    BigInteger temp = x;
                    x = x.add(y);
                    y = temp;
                }
            }
            return x;
    }


}

