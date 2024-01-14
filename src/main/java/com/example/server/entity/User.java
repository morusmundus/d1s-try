package com.example.server.entity;

import com.example.server.entity.enm.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("false")
    private boolean isBlocked;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Receipt> receipts;

    public User(Long id) {
        super(id);
    }
}
