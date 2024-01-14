package com.example.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class GenreRef extends BaseEntity {

   @Column(unique = true)
   private String name;

   @ManyToMany(mappedBy = "genres")
   @JsonIgnore
   @ToString.Exclude
   @EqualsAndHashCode.Exclude
   private List<Book> books;
}
