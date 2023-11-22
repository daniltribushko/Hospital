package org.example;

import org.example.services.interfaces.EmployeeDbService;
import org.example.services.EmployeeDbServiceImp;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        EmployeeDbService service = new EmployeeDbServiceImp();
        service.delete("a1", "b");
        System.out.println(service.get("a1","b"));
    }
}