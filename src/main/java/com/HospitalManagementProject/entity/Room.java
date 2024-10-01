package com.HospitalManagementProject.entity;
import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String roomType;  // E.g., "General", "ICU", "Private", etc.
    private Integer capacity;
    private Double dailyCharges;
    private Boolean isOccupied;

    // Constructors
    public Room() {}

    public Room(String roomNumber, String roomType, Integer capacity, Double dailyCharges, Boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.dailyCharges = dailyCharges;
        this.isOccupied = isOccupied;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(Double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    public Boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}



