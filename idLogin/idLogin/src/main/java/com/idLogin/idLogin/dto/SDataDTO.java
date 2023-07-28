package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.SDataEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SDataDTO {
    private Long sRobot_info_id;
    private Float sHumidity;
    private Float sTemp;
    private Double sLocate;

    public static SDataDTO tosdataDTO(SDataEntity sdataEntity) {
        SDataDTO sdataDTO = new SDataDTO();
        sdataDTO.setSRobot_info_id(sdataEntity.getSRobot_info_id());
        sdataDTO.setSHumidity(sdataDTO.getSHumidity());
        sdataDTO.setSTemp(sdataDTO.getSTemp());
        sdataDTO.setSLocate(sdataDTO.getSLocate());
        return sdataDTO;
    }

}
