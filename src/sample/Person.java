package sample;

import java.util.Comparator;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private int priceJob;
    public Person(String firstName, String lastName, String patronymic, int age, int priceJob){
        this.firstName=firstName;
        this.lastName=lastName;
        this.patronymic=patronymic;
        this.age=age;
        this.priceJob=priceJob;
    }

    public int getAge() {
        return age;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getPriceJob() {
        return priceJob;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s %d %d \n",getFirstName(),getLastName(),getPatronymic(),getAge(),getPriceJob());
    }

    //===========================Nested class sorted==============================

    private static class SortByFirstName implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
    public static SortByFirstName getSortByFirstName(){
        return new SortByFirstName();
    }
    private static class SortByLastName implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }
    public static SortByLastName getByLastName(){
        return new SortByLastName();
    }
    private static class SortByAge implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge()-o2.getAge();
        }
    }
    public static SortByAge getSortByAge(){
        return new SortByAge();
    }
    private static class SortByPatronymic implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getPatronymic().compareTo(o2.getPatronymic());
        }
    }
    public static SortByPatronymic getSortByPatronymic(){
        return new SortByPatronymic();
    }
    private static class SortByPriceJob implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getPriceJob()- o2.getPriceJob();
        }
    }
    public static SortByPriceJob getSortByPriceJob(){
        return new SortByPriceJob();
    }

}
