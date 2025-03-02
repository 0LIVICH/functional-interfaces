import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Исходные данные (имена и фамилии)
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        // Генерация списка из 10_000_000 человек
        Collection<Person> persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(random.nextInt(names.size())),
                    families.get(random.nextInt(families.size())),
                    random.nextInt(100), // Возраст от 0 до 99
                    Sex.values()[random.nextInt(Sex.values().length)], // Случайный пол
                    Education.values()[random.nextInt(Education.values().length)] // Случайное образование
            ));
        }

        // 1️⃣ Количество несовершеннолетних (младше 18 лет)
        long countMinors = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + countMinors);

        // 2️⃣ Список фамилий призывников (мужчины от 18 до 27 лет)
        List<String> recruitFamilies = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN) // Только мужчины
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27) // Возраст 18-27
                .map(Person::getFamily) // Берем только фамилии
                .collect(Collectors.toList());

        System.out.println("Количество призывников: " + recruitFamilies.size());

        // 3️⃣ Список потенциально работоспособных людей с высшим образованием
        List<Person> workingPeople = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER) // Только с высшим образованием
                .filter(person -> (person.getSex() == Sex.WOMAN && person.getAge() >= 18 && person.getAge() <= 60)
                        || (person.getSex() == Sex.MAN && person.getAge() >= 18 && person.getAge() <= 65)) // Работоспособный возраст
                .sorted(Comparator.comparing(Person::getFamily)) // Сортировка по фамилии
                .collect(Collectors.toList());

        System.out.println("Количество работоспособных людей с высшим образованием: " + workingPeople.size());
    }
}
