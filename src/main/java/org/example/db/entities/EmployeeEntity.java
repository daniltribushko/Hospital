package org.example.db.entities;

import jakarta.persistence.*;
import org.example.models.enums.EmployeeType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String sureName;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PatientEntity> patients = new HashSet<>();

    public EmployeeEntity(String sureName, String name, Integer age, EmployeeType type){
        this.sureName = sureName;
        this.name = name;
        this.age = age;
        this.type = type;
    }
    public EmployeeEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Set<PatientEntity> getPatients() {
        return patients;
    }


    public void addPatient(PatientEntity patient){
        patient.setDoctor(this);
        patients.add(patient);
    }
    public void deletePatient(PatientEntity patient){
        patient.setDoctor(null);
        patients.add(patient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity employee = (EmployeeEntity) o;
        return Objects.equals(id, employee.id) && Objects.equals(sureName, employee.sureName) && Objects.equals(name, employee.name) && Objects.equals(age, employee.age) && type == employee.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sureName, name, age, type);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", sureName='" + sureName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
