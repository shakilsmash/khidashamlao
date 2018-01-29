package model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    public enum Cuisine { BENGALI, INDIAN, THAI, CHINESE, ITALIAN, FASTFOOD, COFFEESHOP, DESSERTSHOP }
    public enum Environment { LOUNGE, FAMILY, PARTY, KARAOKE, STALL}

    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Value("${some.key:0}")
    @Column(name = "id", unique = true)
    private long id;

    @NotBlank
    @Length(max = 255)
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank
    @Length(max = 1000)
    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "vat")
    private double vat;

    @NotBlank
    @Length(max = 255)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Length(max = 255)
    @Column(name = "mobile", unique = true)
    private String mobile;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipCode")
    private String zipCode;

    @NotBlank
    @Length(max = 255)
    @Column(name = "openingTime")
    private String openingTime;

    @NotBlank
    @Length(max = 255)
    @Column(name = "closingTime")
    private String closingTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "cuisineSpecialty")
    private Cuisine cuisineSpecialty;

    @Enumerated(EnumType.STRING)
    @Column(name = "environmentType")
    private Environment environmentType;

    @Column(name = "advancedBooking")
    private boolean advancedBooking;

    @Column(name = "delivery")
    private boolean delivery;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull
    @Column(name = "createdAt")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "lastModifiedAt")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp lastModifiedAt;

    @NotNull
    @Column(name = "deletedAt")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp deletedAt;


}
