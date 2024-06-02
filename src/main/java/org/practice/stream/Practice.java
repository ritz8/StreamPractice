package org.practice.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male",
                        "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male",
                        "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female",
                        "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male",
                        "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male",
                        "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male",
                        "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male",
                        "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male",
                        "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female",
                        "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male",
                        "Instrumentation Engineering", 2017, "Mumbai", 98));

        //studentFirstNameStartsWithA(list);
        //groupDepartmentByStudentName(list);
        //totalStudent(list);
        //maxAge(list);
        //departmentList(list);
        //countStudentsByDepartment(list);
        //ageLessThan30(list);
        //rankBetween50And100(list);
        //averageAgeAsPerGender(list);
        //departmentWithMaxNumberOfStudents(list);
        //sortStudentsByNamesStaysInDelhi(list);
        //averageRankAsPerDepartment(list);
        //highestRankAsPerDepartment(list);
        //sortStudentAsPerRank(list);
        lastSecondRank(list);
    }

    private static void printList(List<Student> list){
        list.forEach(System.out::println);
    }

    private static void printMap(Map<String, List<Student>> mapList){
        System.out.println(mapList);
    }

    private static void studentFirstNameStartsWithA(List<Student> list){
        List<Student> studentList = list.stream().filter(n -> n.getFirstName().startsWith("A"))
                .toList();
        printList(studentList);
    }

    private static void groupDepartmentByStudentName(List<Student> list) {
        Map<String, List<Student>> listMap = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName));
        printMap(listMap);
    }

    private static void totalStudent(List<Student> list) {
        long count = list.stream().count();
        System.out.println(count);
    }

    private static void maxAge(List<Student> list) {
        OptionalInt age = list.stream().mapToInt(Student::getAge).max();
        System.out.println(age.getAsInt());
    }

    private static void departmentList(List<Student> list) {
        List<String> departments = list.stream().map(Student::getDepartmentName)
                .distinct().toList();
        departments.forEach(System.out::println);
    }

    private static void countStudentsByDepartment(List<Student> list) {
        Map<String, Long> stringLongMap = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        stringLongMap.forEach((d, num) -> System.out.println(d + " => " + num));
    }

    private static void ageLessThan30(List<Student> list) {
        List<Student> studentList = list.stream().filter(s -> s.getAge() < 30).toList();
        studentList.forEach(System.out::println);
    }

    private static void rankBetween50And100(List<Student> list) {
        List<Student> studentList = list.stream()
                .filter(s -> s.getRank() > 50 && s.getRank() < 100).toList();
        studentList.forEach(System.out::println);
    }

    private static void averageAgeAsPerGender(List<Student> list) {
        Map<String, Double> stringDoubleMap = list.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.averagingDouble(Student::getAge)));
        stringDoubleMap.forEach((g, a) -> System.out.println(g + " => " + a));
    }

    private static void departmentWithMaxNumberOfStudents(List<Student> list) {
        String department = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName,
                        Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println(department);
    }

    private static void sortStudentsByNamesStaysInDelhi(List<Student> list) {
        list.stream().filter(s -> s.getCity().equalsIgnoreCase("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList().forEach(System.out::println);
    }

    private static void averageRankAsPerDepartment(List<Student> list) {
        Map<String, Double> stringDoubleMap = list.stream()
                .collect(Collectors.groupingBy((Student::getDepartmentName),
                        Collectors.averagingInt(Student::getRank)));
        stringDoubleMap.forEach((d,r) -> System.out.println(d + " => " +r));
    }

    private static void highestRankAsPerDepartment(List<Student> list) {
        Map<String, Optional<Student>> stringDoubleMap = list.stream()
                .collect(Collectors.groupingBy((Student::getDepartmentName),
                        Collectors.minBy(Comparator.comparing(Student::getRank))));
        stringDoubleMap.forEach((d,r) -> System.out.println(d + " => " +
                r.stream().map(Student::getRank).findFirst().get()));
    }

    private static void sortStudentAsPerRank(List<Student> list) {
        list.stream().sorted(Comparator.comparing(Student::getRank))
                .toList().forEach(System.out::println);
    }

    private static void lastSecondRank(List<Student> list) {
        Student student = list.stream()
                .sorted(Comparator.comparing(Student::getRank).reversed())
                .skip(1).findFirst().get();
        System.out.println(student);
    }
}
