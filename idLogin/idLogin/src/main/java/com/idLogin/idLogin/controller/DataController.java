package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.dto.MDataDTO;
import com.idLogin.idLogin.dto.SDataDTO;
import com.idLogin.idLogin.entity.MDataEntity;
import com.idLogin.idLogin.entity.SDataEntity;
import com.idLogin.idLogin.repository.MDataRepository;
import com.idLogin.idLogin.repository.SDataRepository;
import com.idLogin.idLogin.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
@RequiredArgsConstructor // final 객체를 Constructor Injection 해줌. (Autowired 역할)
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;
    private final SDataRepository sDataRepository;
    private final MDataRepository mDataRepository;

    @GetMapping
    public String dataForm() {
        return "data";
    }

    @GetMapping("/sRobot")
    List<SDataEntity> prints() {
        return sDataRepository.findAll();
    }

    @PostMapping("/sRobot/save")
    public ResponseEntity<String> saveSensorsData(@RequestBody SDataDTO sdataDTO) {
        try {
            // 온습도 센서 데이터를 데이터베이스에 저장
            dataService.saveSensorsData(sdataDTO.getSTemp(), sdataDTO.getSHumidity(), sdataDTO.getSLocate());
            return ResponseEntity.ok("Sensor data saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save sensor data.");
        }
    }

    @GetMapping("/mRobot")
    List<MDataEntity> printm() {
        return mDataRepository.findAll();
    }


    @PostMapping("/mRobot/save")
    public ResponseEntity<String> saveSensormData(@RequestBody MDataDTO dataDTO) {
        try {
            // 온습도 센서 데이터를 데이터베이스에 저장
            dataService.saveSensormData(dataDTO.getMTemp(), dataDTO.getMHumidity(), dataDTO.getMLocate());
            return ResponseEntity.ok("Sensor data saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save sensor data.");
        }
    }

}
