package org.example.db.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "patients")
public class PatientEntity {
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
    private boolean isHealthy;
    private String address;
    @ManyToOne
    @JoinColumn(name = "ward_id")
    private WardEntity ward;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private EmployeeEntity doctor;

    public PatientEntity(String sureName, String name, Integer age, String address) {
        this.sureName = sureName;
        this.name = name;
        this.age = age;
        this.address = address;
        isHealthy = false;
    }

    public PatientEntity(){}

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

    public EmployeeEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(EmployeeEntity doctor) {
        this.doctor = doctor;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public WardEntity getWard() {
        return ward;
    }

    public void setWard(WardEntity ward) {
        this.ward = ward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", sureName='" + sureName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isHealthy=" + isHealthy +
                ", ward=" + ward.getId() +
                ", doctor=" + doctor.getId() +
                '}';
    }
}
