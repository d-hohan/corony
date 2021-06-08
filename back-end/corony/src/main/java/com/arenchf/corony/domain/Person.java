package com.arenchf.corony.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @NotNull
    private Haushalt haushalt;

    @OneToOne
    private Regelung regelung;

    private String nachname;
    private String vorname;
    private Timestamp geburtsdatum;
    @NotNull
    private Integer geburtsjahr;
    private Long mobilnummer;
}
