package com.idLogin.idLogin.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fno;

    String filename;
    String fileOriName;
    String fileUrl;
}

