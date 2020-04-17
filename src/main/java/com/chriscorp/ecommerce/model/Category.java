package com.chriscorp.ecommerce.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<SubCategory> subCategory;

}
