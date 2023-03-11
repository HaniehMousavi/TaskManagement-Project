package com.example.authentication.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
@Table(name = "roles", schema = "user_management")
public class Role {
    @Id
    @GeneratedValue(generator = "id")
    private Integer id;

    private String name;

    public Role(int id) {
        this.id=id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Role) obj).getId();
    }
}