import java.util.Scanner;

/**
 * IsVowal
 */
public class IsVowal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a letra: ");
        char letter = scanner.next().charAt(0);
        char ltLower = Character.toLowerCase(letter);

        char arr[] = {'a', 'e', 'i', 'o', 'u'};
        boolean IsVowel = false;

      for(int i = 0; i < arr.length; i++){
            if(ltLower == arr[i]){
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


//https://www.w3schools.com/java/ref_string_tolowercase.asp
// https://www.tutorialspoint.com/java/lang/character_tolowercase.htm