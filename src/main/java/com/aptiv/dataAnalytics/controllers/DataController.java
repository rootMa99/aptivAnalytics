package com.aptiv.dataAnalytics.controllers;

import com.aptiv.dataAnalytics.domaine.Data;
import com.aptiv.dataAnalytics.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/data")
@AllArgsConstructor
public class DataController {
    private DataService dataService;

    @PostMapping(path="/uploadData")
    public void saveDataToDataBase(MultipartFile file) throws IllegalAccessException {
        dataService.saveDataToDataBase(file);
    }
    @GetMapping(path="/uploadData")
    public List<Data> getAllRecords(){
        List<Data>dataList= dataService.getData();
        System.out.println(dataList.size());
        for (Data data:dataList){
            System.out.println(data.getActualData().getOutput()+" "+ data.getDataTarget().getDtTarget()
                    +" "+data.getProject().getName()+" familly "+data.getProject().getFamily().size());
        }
        return null;
    }
}
