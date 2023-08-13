package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.dto.FilesDTO;
import com.idLogin.idLogin.dto.MemberDTO;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        Files file = new Files();
        file.setFilename(destinationFileName);
        file.setFileOriName(sourceFileName);
        file.setFileUrl(fileUrl);

        file.setUploadDate(new Date());
        System.out.println("Upload Date: " + file.getUploadDate()); // 업로드 날짜 로그로 출력

        filesService.save(file);
        return "redirect:/video/insert";
    }

    @GetMapping("/list")
    public String videoAll(Model model) {
        List<Files> filesList = filesService.videoAll();

        // 엔티티를 DTO로 변환하여 리스트에 담기
        List<FilesDTO> fileDTOList = filesList.stream()
                .map(file -> new FilesDTO(file.getFno(), file.getFilename(), file.getUploadDate()))
                .collect(Collectors.toList());

        // DTO 리스트를 모델에 추가하여 화면으로 전달
        model.addAttribute("filesList", fileDTOList);
        return "videodata";
    }

    @GetMapping("/getFilesList")
    public String getFilesList(Model model) {
        List<FilesDTO> filesList = filesService.getAllFiles(); // 서비스 레이어에서 파일 리스트 가져오기
        model.addAttribute("filesList", filesList); // Thymeleaf 템플릿에서 사용할 모델에 추가

        return "filesListTemplate"; // Thymeleaf 템플릿 페이지로 이동
    }
}

