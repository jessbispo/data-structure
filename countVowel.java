import java.util.Scanner;

public class countVowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a palavra: ");
        String word = scanner.nextLine();
        String wordLowerCase = word.toLowerCase();

        char[] arr = wordLowerCase.toCharArray();

        int amount = 0;

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for(int i=0; i < arr.length; i++){
            for(int j=0; j < vowels.length; j++){
                if( arr[i] == vowels[j]) {
                    amount += 1;
                }
            }
        }

        System.out.println("Na palavra: " + word + " a quantidade de vogais são: " + amount);
    scanner.close();
    }
}

//existem jeitos muito mais efetivos de fazer essa verificação, ao meu ver o time complexity desse é de O(n2)
