package org.example;

public class Main {
    public static void main(String[] args) {
        Student leader = new Student("1", "Ivan", "Ivanov");
        StudentsGroup group = new StudentsGroup(leader);

        Student student2 = new Student("2", "Petro", "Petrov");
        Student student3 = new Student("3", "Olga", "Olgivna");

        group.addStudent(student2);
        group.addStudent(student3);

        group.addTask("Вивчити інкапсуляцію");
        group.addTask("Вивчити наслідування");

        group.markTaskAsCompleted(student2, "Вивчити інкапсуляцію");

        System.out.println("Староста групи: " + group.getLeader());
        System.out.println("Список студентів: " + group.getStudents());
        System.out.println("Список завдань: " + group.getTasks());
        System.out.println("Виконані завдання: " + group.getCompletedTasks());

        // Змінити старосту
        group.changeLeader(student2);
        System.out.println("Новий староста групи: " + group.getLeader());
    }
}