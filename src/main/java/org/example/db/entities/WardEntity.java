package org.example.db.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "wards")
public class WardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer countHospitalBed;
    @Column(nullable = false)
    private boolean isFull;

    @OneToMany(mappedBy = "ward", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PatientEntity> patients = new HashSet<>();

    public WardEntity(Integer countHospitalBed){
        this.countHospitalBed = countHospitalBed;
        isFull = false;
    }
    public WardEntity(){}

    public void addPatient(PatientEntity patient){
        if (patients.size() < countHospitalBed){
            patient.setWard(this);
            patients.add(patient);
            if (patients.size() == countHospitalBed){
                isFull = true;
            }
        } else {
            System.out.println("ward if full");
        }
    }

    public void deletePatient(PatientEntity patient){
        patient.setWard(null);
        patients.remove(patient);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCountHospitalBed() {
        return countHospitalBed;
    }

    public void setCountHospitalBed(Integer countHospitalBed) {
        this.countHospitalBed = countHospitalBed;
    }

    public Set<PatientEntity> getPatients() {
        return patients;
    }

    public boolean isFull() {
        return isFull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WardEntity that = (WardEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WardEntity{" +
                "id=" + id +
                ", countHospitalBed=" + countHospitalBed +
                '}';
    }
}
