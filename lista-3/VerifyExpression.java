package 

public class VerifyExpression {
    public static boolean VExpression(){
        StackN st = new StackN();
        String str = "(Hello([{W}o]r))ld!";
        // char[] charArray = str.toCharArray();

        // for (char c : charArray) {
        //     if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '<' || c == '>') {
        //         st.push(c);
        //     }
        // }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Verifica se é um símbolo de abertura
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                st.push(c);
            } 
            // Verifica se é um símbolo de fechamento
            else if (c == ')' || c == ']' || c == '}' || c == '>') {
                // Verifica se a st está vazia
                if (st.isEmpty()) {
                    return false; // Há um símbolo de fechamento sem correspondência
                }

                // Obtém o símbolo de abertura correspondente
                char topo = (char) st.pop();

                // Verifica se os símbolos correspondem
                if ((c == ')' && topo != '(') ||
                    (c == ']' && topo != '[') ||
                    (c == '}' && topo != '{') ||
                    (c == '>' && topo != '<')) {
                    return false; // Os símbolos não correspondem
                }
            }
        }

        // Verifica se a st está vazia no final
        return st.isEmpty();
        }

        public static void main(String[] args) {
            VExpression();
        }
    
}
