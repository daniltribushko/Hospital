package org.example;

import org.example.db.entities.EmployeeEntity;
import org.example.db.entities.PatientEntity;
import org.example.models.enums.EmployeeType;
import org.example.services.PatientDbServiceImp;
import org.example.services.interfaces.EmployeeDbService;
import org.example.services.EmployeeDbServiceImp;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeDbService service = new EmployeeDbServiceImp();
        PatientDbServiceImp serviceImp2 = new PatientDbServiceImp();
        service.save(new EmployeeEntity("e1", "e1", 18, EmployeeType.DOCTOR));
        service.save(new EmployeeEntity("e2", "e2", 19, EmployeeType.DOCTOR));
        service.save(new EmployeeEntity("e3", "e3", 25, EmployeeType.NURSE));
        service.save(new EmployeeEntity("e4", "e4", 54, EmployeeType.NURSE));
        service.save(new EmployeeEntity("e5", "e5", 78, EmployeeType.DOCTOR));
        var e1 = service.get("e1", "e1").orElse(null);
        var e2 = service.get("e2", "e2").orElse(null);
        var e3 = service.get("e3", "e3").orElse(null);
        var e4 = service.get("e4", "e4").orElse(null);
        var e5 = service.get("e5", "e5").orElse(null);
        var ps1 = new PatientEntity("p1","p1",23, "ffff");
        var ps2 = new PatientEntity("p2","p2",20, "aa");
        var ps3 = new PatientEntity("p3","p3",18, "e5gyeg546");
        var ps4 = new PatientEntity("p4","p4",15, "vgyv46");
        var ps5 = new PatientEntity("p5","p5",12, "rgcgwrg");
        e1.addPatient(ps1);
        e1.addPatient(ps2);
        e1.addPatient(ps3);
        e2.addPatient(ps4);
        e3.addPatient(ps5);
        service.update(e1);
        service.update(e2);
        service.update(e3);
    }
}