package com.aptiv.dataAnalytics.service;

import org.springframework.web.multipart.MultipartFile;

public interface DataService {

    public void saveDataToDataBase(MultipartFile file) throws IllegalAccessException;
}
