package com.example.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class AuthorsRef extends BaseEntity {
   private String fName;
   private String sName;
   private String tName;
   private String bioDescription;
   private Date bornDate;

   @ManyToMany(mappedBy = "authors")
   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @JsonIgnore
   private List<Book> books;
}
