// 4. Analise o trecho de código a seguir, assumindo que existem duas classes, Stack e Queue, que implementam,
// respectivamente, o TAD Pilha e o TAD Fila, ambos em suas versões sequenciais, e que armazenam valores
// do tipo float.


// public class Main {
//         public static void int main(String[] args) {
//         Stack s = new Stack();
//         Queue q = new Queue();
//         for (int i = 0; i < 5; ++i)
//         s.push(i * 1.5f);
//         for (int i = 0; i < 3; ++i)
//         q.enqueue(s.pop());
//         float r = q.dequeue() + q.dequeue();
//         System.out.println("Resultado: " + r);
//         }
//     }

// Quais valores são armazenados nas variáveis s, q e r após a última linha de código? Mostre como você chegou
// nesses valores. Para as variáveis s e q, indique qual valor está no topo e na frente, respectivamente.

-> valores da minha stack [0, 1.5, 3, 4.5, 6]

depois -> q.enqueue(s.pop());

nesse pedaço de codigo, esta sendo enfileirado na minha Queue, os valores retirados da stack

-> valores da minha queue [6, 4.5, 3]

depois -> float r = q.dequeue() + q.dequeue();

-> meu r vale 6 + 4.5 = 10.5 