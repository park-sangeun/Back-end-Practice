package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.FilesDTO;
import com.idLogin.idLogin.dto.MemberDTO;
import com.idLogin.idLogin.entity.MemberEntity;
import com.idLogin.idLogin.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idLogin.idLogin.entity.Files;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    VideoRepository filesRepository;

    public void save(Files files) {
        Files f = new Files();
        f.setFilename(files.getFilename());
        f.setFileOriName(files.getFileOriName());
        f.setFileUrl(files.getFileUrl());
        f.setUploadDate(files.getUploadDate()); // 업로드 날짜도 설정

        filesRepository.save(f);
    }

    public Files findByFno(int fno) {
        return filesRepository.findByFno(fno);
    }

    public List<Files> videoAll() {
        return filesRepository.findAll();
    }

    public List<FilesDTO> getAllFiles() {
        List<FilesDTO> filesList = new ArrayList<>();

        // 파일 리스트를 데이터베이스에서 조회하는 로직
        List<Files> fileEntities = filesRepository.findAll(); // FileEntity는 실제 데이터베이스 테이블과 매핑되는 엔티티 클래스

        // FileEntity를 FileDTO로 변환하여 filesList에 추가하는 로직
        for (Files fileEntity : fileEntities) {
            FilesDTO fileDTO = new FilesDTO();
            fileDTO.setFno(fileEntity.getFno());
            fileDTO.setFilename(fileEntity.getFilename());
            fileDTO.setUploadDate(fileEntity.getUploadDate());
            filesList.add(fileDTO);
        }

        return filesList;
    }
}
