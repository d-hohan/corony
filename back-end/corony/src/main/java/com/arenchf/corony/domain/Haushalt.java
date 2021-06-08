package com.arenchf.corony.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Haushalt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @NotNull
    private Ort ort;

    @OneToOne
    @NotNull
    private Amt amt;

    @NotNull
    private String strasse;
    private Long festnetznummer;

}
