package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // read from a file and write in List
        String fileName = "person.txt";
        File file = new File(fileName);
        if (file.createNewFile()){
            System.out.println("Успешно: ");
        }else System.out.println("Файл созддан: ");
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                Person person = getPerson(reader.readLine());
                people.add(person);
            }
        }
        //Nested version
        //Sorted by firstName
        //Collections.sort(people, Person.getSortByFirstName());
        //Sorted by Age
        //Collections.sort(people,Person.getSortByAge());
        //Sorted by lastName
        //Collections.sort(people,Person.getByLastName());
        //Sorted by patronymic
       // Collections.sort(people,Person.getSortByPatronymic());
        //Sorted by priceJob
        Collections.sort(people,Person.getSortByPriceJob());

       //Write in file
        String fileNameWrite = "PersonSort.txt";
        File file1=new File(fileNameWrite);
        if (file1.createNewFile()){
            System.out.println("Успешно создан: ");
        }else System.out.println("Файд уже создан: ");
        FileWriter fw = new FileWriter(fileNameWrite);
        for (Person person : people) {
            fw.write(person.toString());
        }
        fw.close();
    }
    //create object a class Person
    public static Person getPerson(String reader){
        String[] strings=reader.split(" ");
        String firstName=strings[0];
        String lastName=strings[1];
        String patronymic=strings[2];
        int age=Integer.parseInt(strings[3]);
        int priceJob=Integer.parseInt(strings[4]);
        return new Person(firstName,lastName,patronymic,age,priceJob);
    }
}
