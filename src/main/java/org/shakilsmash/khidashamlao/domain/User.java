package org.shakilsmash.khidashamlao.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
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
@Table(name = "user")
public class User {
	//ekhane ekta break thakbe always
    public enum Gender {MALE, FEMALE, OTHER}

    public enum Role {UNDEFINED, USER, RESTAURANTADMIN, ADMIN}

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Value("${some.key:0}")
    @Column(name = "id", unique = true)
    private long id;

    @NotBlank
    @Length(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Length(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotBlank
    @Length(max = 255)
    @Column(name = "username", unique = true)
    private String username;

    @NotEmpty
    @Length(max = 255)
    @Column(name = "password")
    private String password;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @NotNull
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

    public User() {
        this.role = Role.UNDEFINED;
        this.status = Status.PENDING;
        this.createdAt = new Timestamp(new Date().getTime());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
