package com.vti.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IFileService {
    String uploadImage(MultipartFile image, short id) throws IOException;

    File dowwnloadImage(String nameImage) throws IOException;

    String getImgNameByID(short id);

}
