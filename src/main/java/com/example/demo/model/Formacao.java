package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instituicao;
    private String curso;
    private String areaEstudo;
    private String AnoI;
    private String AnoF;

    public Formacao(Long id, String instituicao, String curso, String areaEstudo, String AnoI, String AnoF) {
        this.id = id;
        this.instituicao = instituicao;
        this.curso = curso;
        this.areaEstudo = areaEstudo;
        this.AnoI = AnoI;
        this.AnoF = AnoF;
    }

    public Formacao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String institution) {
        this.instituicao = institution;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String degree) {
        this.curso = degree;
    }

    public String getAreaEstudo() {
        return areaEstudo;
    }

    public void setAreaEstudo(String fieldOfStudy) {
        this.areaEstudo = fieldOfStudy;
    }

    public String getAnoI() {
        return AnoI;
    }

    public void setAnoI(String startDate) {
        this.AnoI = startDate;
    }

    public String getAnoF() {
        return AnoF;
    }

    public void setAnoF(String endDate) {
        this.AnoF = endDate;
    }

    // Getters and setters
}
