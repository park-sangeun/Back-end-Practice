package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.entity.MRobotEntity;
import com.idLogin.idLogin.entity.SRobotEntity;
import com.idLogin.idLogin.repository.MRobotRepository;
import com.idLogin.idLogin.repository.SRobotRepository;
import com.idLogin.idLogin.service.RobotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
@RequiredArgsConstructor // final 객체를 Constructor Injection 해줌. (Autowired 역할)
@RequestMapping
public class RobotController {
    private final RobotService robotService;
    private final SRobotRepository srobotRepository;
    private final MRobotRepository mrobotRepository;

    @GetMapping("/robot")
    public String dataForm() {
        return "robot";
    }


    @GetMapping("/robot/sRobot")
    List<SRobotEntity> prints2() {
        return srobotRepository.findAll();
    }

    @GetMapping("/robot/mRobot")
    List<MRobotEntity> printm2() {
        return mrobotRepository.findAll();
    }

}
