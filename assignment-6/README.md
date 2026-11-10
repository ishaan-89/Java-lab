# Java Lab Assignment 6

## Programs
1. **FileHandling.java** — copies a binary file with `FileInputStream` / `FileOutputStream`, then writes and reads student records using character streams.
2. **LogAnalyzer.java** — counts log entries, identifies `ERROR` and `WARNING` lines, and writes them to `filtered.log`.
3. **Employee.java** and **SerializationDemo.java** — serialize multiple employee objects to `employees.dat` and deserialize them.

## Run
Install JDK 8 or later. Open a terminal in this folder:

```bash
javac FileHandling.java
java FileHandling

javac LogAnalyzer.java
java LogAnalyzer

javac Employee.java SerializationDemo.java
java SerializationDemo
```

`FileHandling` expects an `input.bin` file in this folder to demonstrate byte-stream copying. Create one, or place any binary file there, before running it. The program creates `copy.bin` and `students.txt`.

`LogAnalyzer` uses the included `application.log` and creates `filtered.log`.

`SerializationDemo` creates `employees.dat`.

All programs use try-with-resources so streams are closed automatically, and include basic exception handling.
