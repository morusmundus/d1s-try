package com.example.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
public class Receipt extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @CurrentTimestamp
    private Date creationTime;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Orders> positions;
    public Receipt() {
    }

    public Receipt(User user) {
        this.user = user;
    }
}
