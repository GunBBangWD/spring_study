package test2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    static class Person{
        String name;
        int age;
        public Person(String name, int age) {
            this.name=name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("bob",34),new Person("bob",43)
        ,new Person("mary",84),new Person("john",12),new Person("bob",22));

        System.out.println(personList);
        //스트림 생성
        Stream<Person> personStream = personList.stream();
        //리스트
        Function<Person,String> classifier = Person->Person.name;
        Collector<Person, ?, Map<String, List<Person>>> collector = Collectors.groupingBy(classifier);
        Map<String, List<Person>> result = personStream.collect(collector);

        //맵핑까지
        Stream<Person> personStream2 = personList.stream();
        Function<Person,Integer> classifier2 = Person->Person.age;

        Collector<Person, ?, Set<Integer>> collector2 = Collectors.mapping(classifier2,
                Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

        Collector<Person,?,Map<String,Set<Integer>>> collector3 = Collectors.groupingBy(classifier,collector2);
        Map<String, Set<Integer>> result2 = personStream2.collect(collector3);

//        result2 = personList.stream().collect(Collectors.groupingBy(p -> p.name,
//                Collectors.mapping(e -> e.age,
//                Collectors.collectingAndThen(
//                        Collectors.toSet(), Collections::unmodifiableSet))));
        System.out.println(result);
        System.out.println();
        System.out.println(result2);
    }
}
