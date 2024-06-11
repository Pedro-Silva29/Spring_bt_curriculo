package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String cargo;
    private String AnoI;
    private String AnoF;
    private String descricao;


    public Experiencia(Long id, String Empresa, String Cargo, String AnoI, String AnoF, String descricao) {
        this.id = id;
        this.empresa = Empresa;
        this.cargo = Cargo;
        this.AnoI = AnoI;
        this.AnoF = AnoF;
        this.descricao = descricao;
    }

    public Experiencia() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAnoI() {
        return AnoI;
    }

    public void setAnoI(String anoi) {
        this.AnoI = anoi;
    }

    public String getAnoF() {
        return AnoF;
    }

    public void setAnoF(String anof) {
        this.AnoF = anof;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
