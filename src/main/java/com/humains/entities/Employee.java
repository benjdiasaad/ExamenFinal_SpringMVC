package com.humains.entities;

import com.humains.validators.PasswordConf;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name = "employees")
@PasswordConf(message = "Les deux password non identique !" ) //I made this validator to verifiy the password and confirmation pass are the same for inscription needs
public class Employee implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name="nom", nullable = false, unique = true, length = 150 )
    @NotBlank(message = "Vous devez indiquer votre nom !")
    @Size(min=3, message = "minimum 3 lettre")
    @NotNull
    String nom;

    @Column(name="prenom", nullable = false, unique = true, length = 150 )
    @NotBlank(message = "Vous devez indiquer votre prenom !")
    @Size(min=3, message = "minimum 3 lettre")
    @NotNull
    String prenom;

    @Size(min=3, message = "minimum 3 lettre")
    @NotBlank(message = "Vous devez indiquer votre carte id!")
    @Column(name = "cin", length = 150 )
    String cin;


    @Size(min=3, message = "minimum 6 lettre")
    @NotBlank(message = "Vous devez indiquer votre numero telephone!")
    @Column(name = "tel", length = 150 )
    String tel;


    @Column(name="email", nullable = false, unique = true)
    @NotBlank(message = "Vous devez indiquer votre email !")
    @Email
    @NotNull
    String email;

    @Column(name="password", nullable = false, length = 150 )
    @NotBlank(message = "Vous devez indiquer votre mot de passe !")
    @Size(min=6, message = "minimum 6 lettre")
    @NotNull
    String password;

    @Transient
    @Size(min=6, message = "Les deux password non identique !")
    String confirmedPassword;


    @Column(name="grade",  length = 150 )
    private String grade;

    @Column(name="salaire",  length = 150 )
    @NotNull(message = "Specifier lui leur salaire")
    double salaire;

    @Column(name = "hire_date" )
    private Date hireDate;


    @Column(name = "image")
    String image;

    @Column(name="role", nullable = false, length = 150 )
    String role;

    @Column(name="extraPerformance", length = 150 )
    String extraPerformance;

//_____________________________LIASON TABLE___________________
    @ManyToOne
    Departement departement;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
    Employee manager;

    @OneToMany(mappedBy="manager")
    Set<Employee> sous_jacents = new HashSet<>();

    @ManyToOne
    Remuneration remuneration;








    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    Date modified;

    public Employee(long id) {
        this.id=id;
    }

}
