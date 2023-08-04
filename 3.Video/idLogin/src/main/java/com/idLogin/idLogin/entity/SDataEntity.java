package com.idLogin.idLogin.entity;

import com.idLogin.idLogin.dto.SDataDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "sRobot_info")
public class SDataEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long sRobot_info_id;

    @Column
    @NotNull
    private Float sHumidity;

    @Column
    @NotNull
    private Float sTemp;

    @Column
    private Double sLocate;

    public static SDataEntity toSDataEntity(SDataDTO sdataDTO) {
        SDataEntity sdataEntity = new SDataEntity();
        sdataEntity.setSHumidity(sdataDTO.getSHumidity());
        sdataEntity.setSTemp(sdataDTO.getSTemp());
        sdataEntity.setSLocate(sdataDTO.getSLocate());
        return sdataEntity;
    }

    public static SDataEntity toUpdateSDataEntity(SDataDTO sdataDTO) {
        SDataEntity sdataEntity = new SDataEntity();
        sdataEntity.setSRobot_info_id(sdataDTO.getSRobot_info_id());
        sdataEntity.setSHumidity(sdataDTO.getSHumidity());
        sdataEntity.setSTemp(sdataDTO.getSTemp());
        sdataEntity.setSLocate(sdataDTO.getSLocate());
        return sdataEntity;
    }
}
