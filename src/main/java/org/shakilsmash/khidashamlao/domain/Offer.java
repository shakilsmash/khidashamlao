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
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @Column(name = "discount_percentage")
    private double discountPercentage;

    @NotNull
    @Column(name = "start_date")
    private Timestamp startDate;

    @NotNull
    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "food_id")
    private long foodID;

    @NotNull
    @Column(name = "restaurant_id")
    private long restaurantID;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "modified_at")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp modifiedAt;

    @NotNull
    @Column(name = "deleted_at")
    @DateTimeFormat(pattern = "hh:mm - dd/MM/yyyy")
    private Timestamp deletedAt;

    public Offer() {
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

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public long getFoodID() {
        return foodID;
    }

    public void setFoodID(long foodID) {
        this.foodID = foodID;
    }

    public long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(long restaurantID) {
        this.restaurantID = restaurantID;
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
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", foodID=" + foodID +
                ", restaurantID=" + restaurantID +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
