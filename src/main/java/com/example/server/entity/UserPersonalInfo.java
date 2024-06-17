package com.example.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
public class UserPersonalInfo extends BaseEntity{

    @ManyToOne
    //@JoinColumn(name = "user_id")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    private String name;
    private String surname;
    private String patronymic;
    private String addressCity;
    private String addressStreet;
    private String addressHouse;
    private String addressFlat;

    public UserPersonalInfo() {}

    public UserPersonalInfo(User user) {
        this.user = user;
    }
}
