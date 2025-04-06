package com.meals.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mealevaluation")
public class RefeicaoEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_meal")
    public Long idRefeicao;
    public int evaluation;
    public String comment;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIdRefeicao(Long idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public Long getIdRefeicao() {
        return idRefeicao;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
