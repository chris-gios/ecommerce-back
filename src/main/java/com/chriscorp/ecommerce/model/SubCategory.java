package com.chriscorp.ecommerce.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sub_categorys")
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

}
