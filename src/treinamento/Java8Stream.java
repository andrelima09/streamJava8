package treinamento;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Stream {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        //JAVA 8
        //STREAM = fluxo de dados que pode passar por várias operações
        lista.stream() //
                .skip(2) // "pular". ignora as 2 primeiras posições da lista.
                .limit(11) // limita quantos elementos eu quero processar.
                .distinct() // Não deixa repetir o elemento
                .filter(e -> e % 2 == 0) // constroi filtros mais específicos, no exemplo, retorna somente numeros pares
                .map(e -> e * 2) // NÃO É O HASHMAP, é uma transformação de dados. Nesse exemplo pra cada numero eu estou mutiplicando-o por 2. A lista original não é modificada.
                .forEach(e -> System.out.println(e));
    }
}
