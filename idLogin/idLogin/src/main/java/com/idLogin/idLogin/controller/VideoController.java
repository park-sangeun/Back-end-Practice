package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.entity.Files;
import com.idLogin.idLogin.service.VideoService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class VideoController {
    @Autowired
    VideoService filesService;

    @GetMapping("/video/")
    @ResponseBody
    public String videoForm() {
        return "video";
    }

    @GetMapping("/video/insert")
    public String insert() {
        return "insert";
    }

    @RequestMapping("video/fileinsert")
    public String fileinsert(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
        String sourceFileName = files.getOriginalFilename();
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
        File destinationFile;
        String destinationFileName;
        String fileUrl = "C:\\Users\\박상은\\IdeaProjects\\Back-end-Exercise-main\\Back-end-Exercise-main\\idLogin\\idLogin\\src\\main\\resources\\static\\images\\";

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

    @RequestMapping("video/index1")
    public String index1(Model model) {
        model.addAttribute("file", filesService.findByFno(2));
        return "video/index1";
    }
}
