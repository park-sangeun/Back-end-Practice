package com.idLogin.idLogin.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fno;

    String filename;
    String fileOriName;
    String fileUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
}

