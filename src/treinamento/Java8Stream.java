package treinamento;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Stream {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9,11);

        //JAVA 8
        //STREAM = fluxo de dados que pode passar por várias operações
        lista.stream() //
                .skip(2) // "pular". ignora as 2 primeiras posições da lista.
                .limit(11) // limita quantos elementos eu quero processar.
                .distinct() // Não deixa repetir o elemento
                .filter(e -> e % 2 == 0) // constroi filtros mais específicos, no exemplo, retorna somente numeros pares
                .map(e -> e * 2) // NÃO É O HASHMAP, é uma transformação de dados. Nesse exemplo pra cada numero eu estou mutiplicando-o por 2. A lista original não é modificada.
                .forEach(e -> System.out.println(e));

        List<Integer> novaLista =  lista.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList()); //Retorna o resultado para uma nova lista.

        System.out.println(novaLista); //[8, 4, 6, 6]

        Map<Boolean, List<Integer>> mapa =  lista.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0)); //groupBy retorna agrupado em um paga seguindo uma determinada regra

        System.out.println(mapa);//{false=[3, 15, 27, 3, 21, 27, 27, 33], true=[24, 12, 18, 18]}

        Map<Integer, List<Integer>> mapa2 =  lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3)); //Nesse caso é agrupodo pelo resto da divisão por 3, ou seja
                                                            //Ex: 5 / 3, sobra 2, e 11 % 3, tbm sobra 2, então esse 2 números se agrupariam na mesma chave do mapa

        System.out.println(mapa2); //{0=[9, 6, 6, 9, 9], 1=[1, 1, 4, 7], 2=[5, 8, 11]}

        String joinOfStrings =  lista.stream()
                .map(e -> String.valueOf(e)) //transforma o inteiros em Strings
                .collect(Collectors.joining()); //Joining concatena todas as strings

        System.out.println(joinOfStrings); // 1589147669911

        String joinOfStrings2 =  lista.stream()
                .map(e -> String.valueOf(e)) //transforma o inteiros em Strings
                .collect(Collectors.joining(";")); //Joining concatena todas as strings separando-as por ";"

        System.out.println(joinOfStrings2); //1;5;8;9;1;4;7;6;6;9;9;11
    }


}
