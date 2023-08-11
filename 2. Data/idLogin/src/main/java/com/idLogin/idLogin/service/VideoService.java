package com.idLogin.idLogin.service;

import com.idLogin.idLogin.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idLogin.idLogin.entity.Files;

@Service
public class VideoService {
    @Autowired
    VideoRepository filesRepository;

    public void save(Files files) {
        Files f = new Files();
        f.setFilename(files.getFilename());
        f.setFileOriName(files.getFileOriName());
        f.setFileUrl(files.getFileUrl());

        filesRepository.save(f);
    }

    public Files findByFno(int fno) {
        return filesRepository.findByFno(fno);
    }
}
