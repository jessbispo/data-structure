import java.util.Scanner;

public class findMaxAndMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        float[] arr = new float[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Digite o numero: " + i);
            float num = scanner.nextFloat();
            arr[i] = num;
        }
        
        float max = arr[0];
        float min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }

            if (arr[i] < min){
                min = arr[i];
            }
        }

        System.out.println("Maior valor: " + max);
        System.out.println("Menor valor : " + min);
        
    scanner.close();   
    }
}

//aparentemente a time complexity é O(n)