package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.MRobotDTO;
import com.idLogin.idLogin.dto.SRobotDTO;
import com.idLogin.idLogin.entity.MRobotEntity;
import com.idLogin.idLogin.entity.SRobotEntity;
import com.idLogin.idLogin.repository.MRobotRepository;
import com.idLogin.idLogin.repository.SRobotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ComponentScan
public class RobotService {
    private final SRobotRepository srobotRepository;
    private final MRobotRepository mrobotRepository;
    public List<SRobotDTO> prints2() {
        List<SRobotEntity> srobotEntityList = srobotRepository.prints2();
        return srobotEntityList.stream()
                .map(SRobotDTO::tosrobotDTO)
                .collect(Collectors.toList());
    }

    public List<MRobotDTO> printm2() {
        List<MRobotEntity> mrobotEntityList = mrobotRepository.printm2();
        return mrobotEntityList.stream()
                .map(MRobotDTO::tomrobotDTO)
                .collect(Collectors.toList());
    }
}
