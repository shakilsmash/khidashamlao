package org.shakilsmash.khidashamlao.domain;

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
@Table(name = "sustenance")
public class Sustenance {

    public enum SustenanceType {FOOD, BEVERAGE}
    public enum FoodType {UNDEFINED, BURGER, PASTA, PIZZA, SETMENU, SHWARMA, KABAB, CURRY, RICE}
    public enum BeverageType {UNDEFINED, COFFEE, TEA, SOFTDRINK, MOJITO, LASSI, CRUSHER, JUICE}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Value("${some.key:0}")
    @Column(name = "id", unique = true)
    private long id;

    @NotBlank
    @Length(max = 255)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Length(max = 1000)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "restaurantID")
    private long restaurantID;

    @Enumerated(EnumType.STRING)
    @Column(name = "sustenance_type")
    private SustenanceType sustenanceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "food_type")
    private FoodType foodType;

    @Enumerated(EnumType.STRING)
    @Column(name = "beverage_type")
    private BeverageType beverageType;

    @NotNull
    @Column(name = "unitPrice")
    private double unitPrice;

    @NotNull
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

    public Sustenance() {
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

    public long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public SustenanceType getSustenanceType() {
        return sustenanceType;
    }

    public void setSustenanceType(SustenanceType sustenanceType) {
        this.sustenanceType = sustenanceType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
        return "Sustenance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", restaurantID=" + restaurantID +
                ", sustenanceType=" + sustenanceType +
                ", foodType=" + foodType +
                ", beverageType=" + beverageType +
                ", unitPrice=" + unitPrice +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", lastModifiedAt='" + lastModifiedAt + '\'' +
                ", deletedAt='" + deletedAt + '\'' +
                '}';
    }
}
