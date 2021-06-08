package com.arenchf.corony.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Regelung regelung;

    @OneToOne
    @NotNull
    private Bundesland bundesland;
    @NotNull
    private String name;
    private Integer einwohner;
    private Integer flaeche;

}
