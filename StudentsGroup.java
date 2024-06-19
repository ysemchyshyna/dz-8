package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentsGroup {
    private Student leader;
    private final List<Student> students;
    private final List<String> tasks;
    private final List<String> completedTasks;

    public StudentsGroup(Student leader) {
        if (leader == null) {
            throw new IllegalArgumentException("Group must have a leader.");
        }
        this.leader = leader;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.students.add(leader); // leader is also a part of the group
    }

    public Student getLeader() {
        return leader;
    }

    public void changeLeader(Student newLeader) {
        if (newLeader == null) {
            throw new IllegalArgumentException("New leader cannot be null.");
        }
        if (!students.contains(newLeader)) {
            throw new IllegalArgumentException("New leader must be a member of the group.");
        }
        this.leader = newLeader;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student student) {
        if (student == null || students.contains(student)) {
            return;
        }
        students.add(student);
    }

    public void removeStudent(Student student) {
        if (student == null || student.equals(leader)) {
            throw new IllegalArgumentException("Cannot remove the leader from the group.");
        }
        students.remove(student);
    }

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty.");
        }
        tasks.add(task);
    }

    public void markTaskAsCompleted(Student student, String task) {
        if (student == null || !students.contains(student)) {
            throw new IllegalArgumentException("Student must be a member of the group.");
        }
        if (task == null || !tasks.contains(task)) {
            throw new IllegalArgumentException("Task must be a valid task for the group.");
        }
        completedTasks.add(task + " (completed by " + student.getFirstName() + " " + student.getLastName() + ")");
    }

    public List<String> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<String> getCompletedTasks() {
        return Collections.unmodifiableList(completedTasks);
    }
}

