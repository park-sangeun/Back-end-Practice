package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.SDataEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SDataDTO {
    private Long SRobotInfoId;
    private Float sHumidity;
    private Float sTemp;
    private Double sLocate;

    public static SDataDTO tosdataDTO(SDataEntity sdataEntity) {
        SDataDTO sdataDTO = new SDataDTO();
        sdataDTO.setSRobotInfoId(sdataEntity.getSRobotInfoId());
        sdataDTO.setSHumidity(sdataEntity.getSHumidity());
        sdataDTO.setSTemp(sdataEntity.getSTemp());
        sdataDTO.setSLocate(sdataEntity.getSLocate());
        return sdataDTO;
    }

}
