package com.aptiv.dataAnalytics.service.impl;

import com.aptiv.dataAnalytics.model.DataFromExcel;
import com.aptiv.dataAnalytics.service.DataService;
import com.aptiv.dataAnalytics.service.UploadExcelAndExtractData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Override
    public void saveDataToDataBase(MultipartFile file) throws IllegalAccessException {

        if (UploadExcelAndExtractData.isValidFormat(file)){
            try {
                List<DataFromExcel>dataFromExcels=UploadExcelAndExtractData.getDataFromEXcelFile(file.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
