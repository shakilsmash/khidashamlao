package org.shakilsmash.khidashamlao.model;

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
import java.util.Date;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    public enum Cuisine { UNDEFINED, BENGALI, BAKERY, INDIAN, THAI, CHINESE, ITALIAN, FASTFOOD, COFFEESHOP, DESSERTSHOP }
    public enum Environment { UNDEFINED, LOUNGE, FAMILY, PARTY, KARAOKE, STALL}

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
    private Timestamp openingTime;

    @NotBlank
    @Length(max = 255)
    @Column(name = "closingTime")
    private Timestamp closingTime;

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

    public Restaurant() {
        this.name = "Default Name";
        this.description = "Default Description";
        this.vat = 0.0;
        this.email = "default@default.com";
        this.mobile = "0000000";
        this.street = "Default Street";
        this.city = "Default City";
        this.state = "Default State";
        this.zipCode = "0000";
        this.openingTime = new Timestamp(new Date().getTime());
        this.closingTime = new Timestamp(new Date().getTime());
        this.cuisineSpecialty = Cuisine.UNDEFINED;
        this.environmentType = Environment.UNDEFINED;
        this.advancedBooking = false;
        this.delivery = false;
        this.status = Status.PENDING;
        this.createdAt = new Timestamp(new Date().getTime());
    }

    public Restaurant(String name, String description, double vat, String email, String mobile, String street, String city, String state, String zipCode, Timestamp openingTime, Timestamp closingTime, Cuisine cuisineSpecialty, Environment environmentType, boolean advancedBooking, boolean delivery) {
        this.name = name;
        this.description = description;
        this.vat = vat;
        this.email = email;
        this.mobile = mobile;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.cuisineSpecialty = cuisineSpecialty;
        this.environmentType = environmentType;
        this.advancedBooking = advancedBooking;
        this.delivery = delivery;
        this.status = Status.PENDING;
        this.createdAt = new Timestamp(new Date().getTime());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Timestamp getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Timestamp openingTime) {
        this.openingTime = openingTime;
    }

    public Timestamp getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Timestamp closingTime) {
        this.closingTime = closingTime;
    }

    public Cuisine getCuisineSpecialty() {
        return cuisineSpecialty;
    }

    public void setCuisineSpecialty(Cuisine cuisineSpecialty) {
        this.cuisineSpecialty = cuisineSpecialty;
    }

    public Environment getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(Environment environmentType) {
        this.environmentType = environmentType;
    }

    public boolean isAdvancedBooking() {
        return advancedBooking;
    }

    public void setAdvancedBooking(boolean advancedBooking) {
        this.advancedBooking = advancedBooking;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Timestamp lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vat=" + vat +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", cuisineSpecialty=" + cuisineSpecialty +
                ", environmentType=" + environmentType +
                ", advancedBooking=" + advancedBooking +
                ", delivery=" + delivery +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
