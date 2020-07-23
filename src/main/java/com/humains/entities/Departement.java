package com.humains.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name="departements")
public class Departement implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name="nom", nullable = false, unique = true, length = 150 )
    @NotBlank(message = "Vous devez indiquer le nom de ce departememt !")
    @Size(min=3, message = "minimum 3 lettre")
    @NotNull
    String nom;

    @Column(name="type", nullable = false, unique = true, length = 150 )
    @NotBlank(message = "Vous devez indiquer le type de ce departememt !")
    @Size(min=3, message = "minimum 3 lettre")
    @NotNull
    String type;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    Date modified;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="departement_id ")
    List<Employee> employees;


    public Departement(long id) {
        this.id=id;
    }


}
