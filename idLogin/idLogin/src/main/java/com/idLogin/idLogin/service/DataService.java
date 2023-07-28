package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.MDataDTO;
import com.idLogin.idLogin.dto.SDataDTO;
import com.idLogin.idLogin.entity.MDataEntity;
import com.idLogin.idLogin.entity.SDataEntity;
import com.idLogin.idLogin.repository.MDataRepository;
import com.idLogin.idLogin.repository.SDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ComponentScan
public class DataService {
    private final SDataRepository sdataRepository;
    private final MDataRepository mdataRepository;
    public List<SDataDTO> prints() {
        List<SDataEntity> sdataEntityList = sdataRepository.prints();
        return sdataEntityList.stream()
                .map(SDataDTO::tosdataDTO)
                .collect(Collectors.toList());
    }

    public List<MDataDTO> printm() {
        List<MDataEntity> mdataEntityList = mdataRepository.printm();
        return mdataEntityList.stream()
                .map(MDataDTO::tomdataDTO)
                .collect(Collectors.toList());
    }

    public void saveSensormData(float mTemp, float mHumidity, double mLocate) {
        MDataDTO mDataDTO = new MDataDTO();
        mDataDTO.setMTemp(mTemp);
        mDataDTO.setMHumidity(mHumidity);
        mDataDTO.setMLocate(mLocate);

        // MDataDTO를 MDataEntity로 변환하여 데이터베이스에 저장
        MDataEntity mDataEntity = MDataEntity.toMDataEntity(mDataDTO);
        mdataRepository.save(mDataEntity);
    }
    public void saveSensorsData(float sTemp, float sHumidity, double sLocate) {
        SDataDTO sDataDTO = new SDataDTO();
        sDataDTO.setSTemp(sTemp);
        sDataDTO.setSHumidity(sHumidity);
        sDataDTO.setSLocate(sLocate);

        // SDataDTO를 SDataEntity로 변환하여 데이터베이스에 저장
        SDataEntity sDataEntity = SDataEntity.toSDataEntity(sDataDTO);
        sdataRepository.save(sDataEntity);
    }

}
