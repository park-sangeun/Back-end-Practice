package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.MDataEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MDataDTO {
    private Long mRobot_info_id;
    private Float mHumidity;
    private Float mTemp;
    private Double mLocate ;

    public static MDataDTO tomdataDTO(MDataEntity mdataEntity) {
        MDataDTO mdataDTO = new MDataDTO();
        mdataDTO.setMRobot_info_id(mdataEntity.getMRobot_info_id());
        mdataDTO.setMHumidity(mdataEntity.getMHumidity());
        mdataDTO.setMTemp(mdataEntity.getMTemp());
        mdataDTO.setMLocate(mdataEntity.getMLocate());
        return mdataDTO;
    }
}
