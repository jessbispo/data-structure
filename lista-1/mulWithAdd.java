public class mulWithAdd {
    public static void main(String[] args) {
        System.out.println("Resultado: " + multi(35.5, 5));
    }

    public static double multi(double a, int b) {
        double result = 0;
        for (int i = 0; i < b; i++){
            result += a;
        }
    
        return result;
    }
}
