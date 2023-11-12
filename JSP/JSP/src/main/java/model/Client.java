package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clientes")
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String document;
    @Column
    private Date birthDate;

    public Client(String name, String surname, String email, String document, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.document = document;
        this.email = email;
    }
}
