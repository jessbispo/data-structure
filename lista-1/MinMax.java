public class MinMax {
    public static void main(String[] args) {
        
        int a = 25;
        int b = 2;

        System.out.println("O menor numero entre " + a + " e " + b + " é " + min(a, b));
        System.out.println("O maior numero entre " + a + " e " + b + " é " + max(a, b));
    }

    public static int min(int a, int b){
        return Math.min(a, b);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }
}

//menor entre eles ou contando com eles??? 