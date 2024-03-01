import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Digite o numero: ");
            int num = scanner.nextInt();
            arr[i] = num;
        }

        for (int i = arr.length; i > 0; i--){
            System.out.println(i);
        }

        scanner.close();
    }
}
