package com.humains.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="remunerations")
public class Remuneration implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name="type", nullable = false, unique = true, length = 150 )
    @NotBlank(message = "Vous devez indiquer le type de ce remunerations !")
    @Size(min=3, message = "minimum 3 lettre")
    @NotNull
    String type;


    @Column(name="montant", nullable = false, unique = true, length = 150 )
    @Size(min=3, message = "minimum 2 chiffre en DH")
    double montant;



    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="remuneration_id ")
    List<Employee> employees;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    Date modified;

    public Remuneration(long id) {
        this.id=id;
    }
}
