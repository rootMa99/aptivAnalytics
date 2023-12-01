package com.aptiv.dataAnalytics.service;

import com.aptiv.dataAnalytics.domaine.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DataService {

    void saveDataToDataBase(MultipartFile file) throws IllegalAccessException;
    List<Data> getData();
}
