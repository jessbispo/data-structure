import java.util.Scanner;

/**
 * IsVowal
 */
public class IsVowal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a letra: ");
        char letter = scanner.next().charAt(0);

        char arr[] = {'a', 'e', 'i', 'o', 'u'};
        boolean IsVowel = false;

      for(int i = 0; i < arr.length; i++){
            if(letter == arr[i]){
               IsVowel = true;
            } 
      }
      
      if (IsVowel) {
        System.out.println("É vogal");
      } else {
        System.out.println("Não é vogal");
      }

      scanner.close();
    }
    
}

//falta obrigar letter to be lowercase