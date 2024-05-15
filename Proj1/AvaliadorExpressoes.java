import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AvaliadorExpressoes {
    
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String expressaoInfixa = "";
        String expressaoPosfixa = "";
        HashMap<Character, Double> valores = new HashMap<>();
        double resultado;

        int opcao; 
        do {
            System.out.println("Menu:");
            System.out.println("1. Entrada da expressao aritmetica na notação infixa.");
            System.out.println("2. Entrada dos valores numericos associados as variaveis.");
            System.out.println("3. Conversao da expressao para notacao posfixa e exibicao.");
            System.out.println("4. Avaliacao da expressao.");
            System.out.println("5. Encerramento do programa.");
            System.out.print("Escolha uma opção: ");
            opcao = scann.nextInt();
            
            //(A+B)/(C-D)*E -> infixa/aritmetica
            //AB+CD-/E* -> notação posfixa

            switch (opcao) {
                case 1:
                    System.out.print("Digite a expressao aritmetica na notacao infixa: ");
                    expressaoInfixa = scann.next();
                    break;
                case 2: //Aqui usamos HashMaps que sao os + faceis p associar uma variavel (A, ex) com um valor (7, ex) e dps reutilizar no resto do codigo, com array ficava muito complicado para iterar ja que nao conseguiamos ter um par de key -> value
                        
                    for (int i = 0; i < expressaoInfixa.length(); i++) {
                        char caractere = expressaoInfixa.charAt(i);

                        if (Character.isLetter(caractere) && !valores.containsKey(caractere)) {
                            System.out.println("Digite o valor associado ao caractere " + caractere + ":");
                            double valor = scann.nextDouble();
                            valores.put(caractere, valor);
                        }
                    }
                    //apenas para fins esteticos estou printando todos os par de key, value para garantirmos o valor associado
                    System.out.println("map: ");
                    for (Map.Entry<Character, Double> entry : valores.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                    break;
                    
                case 3: 
                    expressaoPosfixa = converterParaPosfixa(expressaoInfixa);
                    System.out.println("Expressão na notação posfixa: " + expressaoPosfixa);
                    break;
                case 4:
                 resultado = avaliarExpressao(expressaoPosfixa, valores);
                    System.out.println("Resultado da expressão: " + resultado);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 5);
        scann.close();
    }

    // posfixa é uma notação matematica em que o operador segue o operando (AB+)
	// em contraste com a infixa, em que o operador precede o operando (A+B)
    //aqui o algoritmo funciona assim, temos uma Stack pilha e uma String expressaoPosfixa, iteramos por toda a expressao infixa e caso encontremos uma letra, adicionamos na expressaoPosfixa, caso seja um parenteses de abertura '( ', ja se o parenteses for o de fechamento, desempilha até encontrar o parenteses que corresponde. Parenteses aberto são removidos da pilha mas não são add a expressaoPosfixa. Agora se o caractere for um operador, verifica-se a prioridade, se houver operadores de igual ou maior prioridade na pilha, desempilha e adiciona a expressaoPosfixa, isso é feito ate que a pilha esteja vazia ou um operador de prioridade menor seja encontrado.
    public static String converterParaPosfixa(String expressaoInfixa) {
        String expressaoPosfixa = "";
        StackJ<Character> pilha = new StackJ<>(expressaoInfixa.length());

        for (int i = 0; i < expressaoInfixa.length(); i++) {
            char caractere = expressaoInfixa.charAt(i);

            if (Character.isLetter(caractere)) {
                expressaoPosfixa += caractere;
            } else if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                while (!pilha.isEmpty() && pilha.top() != '(') {
                    expressaoPosfixa += pilha.pop();
                }
                pilha.pop(); // remove '(' da stack
            } else {
                while (!pilha.isEmpty() && prioridade(caractere) <= prioridade(pilha.top())) {
                    expressaoPosfixa += pilha.pop();
                }
                pilha.push(caractere);
            }
        }

        while (!pilha.isEmpty()) {
            expressaoPosfixa += pilha.pop();
        }

        return expressaoPosfixa;
    }

    public static double avaliarExpressao(String expressaoPosfixa, HashMap<Character, Double> valores) {
        expressaoPosfixa = expressaoPosfixa.replaceAll("\\s+", ""); // isso é ~programação defensiva?, as chances de expressaoPosfixa retornaram um valor vazio sao relativamente baixas mas pode acontecer

        StackJ<Double> pilhaEx = new StackJ<>(expressaoPosfixa.length()); // usei expressaoPosfixa.length() como capacidade ao inves de uma var capacity que o usuario poderia colocar manualmente  

  
    //esse algoritmo nao foi tao facil de aplicar porque as fontes eram meio estranhas, iteramos na expressao por fixa e verificamos se o caractere é letra, se sim empurramos para a pilha, se nao verificamos se é um operador, tratamos alguns erros e começamos o processo de desempilhar as variaveis (aqui, o valor associado a elas) para realizamos a operação (com switch case, desempilhamos os dois itens no topo (ou ultimos add a pilha) e calculamos com base no operador daquela iteração), finalizamos com algumas verificações de erros e uma ultima desempilhada para limpar a stack
        for (int i = 0; i < expressaoPosfixa.length(); i++) {
            char caractere = expressaoPosfixa.charAt(i);
            if (Character.isLetter(caractere)) {
                Double valor = valores.get(caractere); 
                if (valor == null) {
                    throw new IllegalArgumentException("Valor para a variável " + caractere + " não foi definido.");
                }
                pilhaEx.push(valor);
            } else if (isOperador(caractere)) {
                if (pilhaEx.size() < 2) {
                    throw new IllegalArgumentException("Expressão posfixa inválida.");
                }
                double b = pilhaEx.pop();
                double a = pilhaEx.pop();
                switch (caractere) {
                    case '+':
                        pilhaEx.push(a + b);
                        break;
                    case '-':
                        pilhaEx.push(a - b);
                        break;
                    case '*':
                        pilhaEx.push(a * b);
                        break;
                    case '/':
                        pilhaEx.push(a / b);
                        break;
                    case '^':
                        pilhaEx.push(Math.pow(a, b));
                        break;
                }
            } else {
                throw new IllegalArgumentException("Expressão posfixa inválida: caractere desconhecido.");
            }
        }
        if (pilhaEx.count() != 1) {
            throw new IllegalArgumentException("Expressão posfixa inválida: número incorreto de operandos.");
        }

        return pilhaEx.pop();
    }

    
    // Método auxiliar para verificar se um caractere é um operador
    public static boolean isOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }    
    

    private static int prioridade(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; 
        }
    }
}

// -> maioria das fontes pra esse trabalho
//https://hetalrachh.home.blog/2020/01/23/evaluating-a-reverse-polish-notation-using-stack-data-structure/ --> explica detalhadamente o processo de conversao de infix pra posfix usando stack
//https://www.baeldung.com/cs/infix-prefix-postfix
//https://stackoverflow.com/questions/1133730/catching-emptystackexception-vs-testing-is-stack-is-empty
//https://www.geeksforgeeks.org/evaluate-the-value-of-an-arithmetic-expression-in-reverse-polish-notation-in-java
//https://www.devmedia.com.br/a-classe-stringbuilder-em-java/25609
//https://stackoverflow.com/questions/1540673/java-equivalent-to-python-dictionaries
//https://www.geeksforgeeks.org/hashmap-get-method-in-java/

