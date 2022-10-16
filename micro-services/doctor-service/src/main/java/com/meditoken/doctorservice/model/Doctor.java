package com.meditoken.doctorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Doctor")
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long docId;
    private String docName;
    private String docDesignation;
    private String docDept;
    private String hospital;
    private String location;
    private String dayStart;
    private String dayEnd;
    private String timeStart;
    private String timeEnd;



}
