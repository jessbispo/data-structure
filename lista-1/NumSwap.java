import java.util.Scanner;

public class NumSwap {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro numero: ");
        byte firstNum = scanner.nextByte();

        System.out.println("Digite o segundo numero: ");
        byte secondNum = scanner.nextByte();

        System.out.println("Primeiro num: " + firstNum + " Segundo num: " + secondNum);

        byte temp = firstNum;
        firstNum = secondNum;
        secondNum = temp;

        System.out.println("Primeiro num: " + firstNum + " Segundo num: " + secondNum );

        scanner.close();
    }
   
}

//https://www.w3schools.com/java/java_variables.asp#:~:text=Declaring%20(Creating)%20Variables&text=type%20variableName%20%3D%20value%3B,assign%20values%20to%20the%20variable.