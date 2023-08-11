package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.entity.Files;
import com.idLogin.idLogin.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService filesService;

    @GetMapping("/")
    public String videoForm() {
        return "videodata";
    }

    @GetMapping("/insert")
    public String insert() {
        return "insert";
    }

    @PostMapping("/fileinsert")
    public String fileinsert(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
        String sourceFileName = files.getOriginalFilename();
        // 소문자로 확장자 추출
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();

        // MIME 타입 확인
        String contentType = files.getContentType();
        System.out.println("MIME 타입: " + contentType);

        File destinationFile;
        String destinationFileName;
        String fileUrl = "C:\\Users\\박상은\\IdeaProjects\\Back-end-Exercise-main\\Back-end-Exercise-main\\idLogin\\idLogin\\src\\main\\resources\\static\\videos\\";

        do {
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
            destinationFile = new File(fileUrl + destinationFileName);
        } while (destinationFile.exists());

        destinationFile.getParentFile().mkdirs();
        files.transferTo(destinationFile);

        Files file = new Files(); // 또는 VideoFile file = new VideoFile(); 또는 다른 이름의 클래스를 사용

        file.setFilename(destinationFileName);
        file.setFileOriName(sourceFileName);
        file.setFileUrl(fileUrl);
        filesService.save(file);
        return "redirect:/video/insert";
    }

}

