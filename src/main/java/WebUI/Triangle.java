package WebUI;

public class Triangle {
    public static double TriangleSquare (int a, int b, int c) throws Exception {
        if ( a<= 0 | b<= 0 | c<= 0) throw new Exception();
        int sum = a + b + c;
        double p = sum/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
