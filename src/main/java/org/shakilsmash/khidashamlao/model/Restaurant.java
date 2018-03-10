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

    @Column(name = "vat")
    private double vat;

    @Column(name = "service_charge")
    private double serviceCharge;

    @NotBlank
    @Length(max = 255)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Length(max = 255)
    @Column(name = "mobile", unique = true)
    private String mobile;

    @NotBlank
    @Length(max = 255)
    @Column(name = "branch")
    private String branch;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @NotBlank
    @Length(max = 255)
    @Column(name = "opening_time")
    private Timestamp openingTime;

    @NotBlank
    @Length(max = 255)
    @Column(name = "closing_time")
    private Timestamp closingTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "cuisine_specialty")
    private Cuisine cuisineSpecialty;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "environment_type")
    private Environment environmentType;

    @NotNull
    @Column(name = "advanced_booking")
    private boolean advancedBooking;

    @NotNull
    @Column(name = "delivery")
    private boolean delivery;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp modifiedAt;

    @Column(name = "deleted_at")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp deletedAt;

    public Restaurant() {
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
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
                ", branch='" + branch + '\'' +
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
                ", modifiedAt=" + modifiedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
