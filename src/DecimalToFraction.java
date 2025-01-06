import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalToFraction {
    public static String decimalToFraction(double decimal) {
        // 입력된 소수를 문자열로 변환
        String decimalStr = String.valueOf(decimal);
        int decimalPlaces = 0;

        if(decimalStr.contains(".")) {
            decimalPlaces = decimalStr.length() - decimalStr.indexOf(".") - 1;
        }

        long bunmo = (long) Math.pow(10, decimalPlaces);
        long bunja = (long) (decimal * bunmo);

        long gcd = gcd(bunmo, bunja);
        bunmo /= gcd;
        bunja /= gcd;

        return bunja + "/" + bunmo;
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(br.readLine());
        System.out.println(decimalToFraction(a));
    }

}
