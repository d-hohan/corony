package com.arenchf.corony.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    //@NotNull
    private Labor labor;

    @OneToOne
    //@NotNull
    private Person person;

    @NotNull
    private Timestamp testDatum;
    @NotNull
    private Boolean resultat;
    private String type;
}
