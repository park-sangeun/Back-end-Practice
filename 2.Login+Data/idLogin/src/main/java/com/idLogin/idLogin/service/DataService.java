package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.MDataDTO;
import com.idLogin.idLogin.entity.MDataEntity;
import com.idLogin.idLogin.repository.MDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    private final MDataRepository mDataRepository;

    public DataService(MDataRepository mDataRepository) {
        this.mDataRepository = mDataRepository;
    }

    public List<MDataDTO> getLatestTemperatureHumidityData() {
        List<MDataEntity> mDataEntities = mDataRepository.findTop7ByOrderByMrobotinfoidDesc();
        return mDataEntities.stream()
                .map(MDataDTO::toMDataDto)
                .collect(Collectors.toList());
    }
}
