package com.aptiv.dataAnalytics.service.impl;

import com.aptiv.dataAnalytics.domaine.*;
import com.aptiv.dataAnalytics.model.DataFromExcel;
import com.aptiv.dataAnalytics.repository.*;
import com.aptiv.dataAnalytics.service.DataService;
import com.aptiv.dataAnalytics.service.UploadExcelAndExtractData;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {

    ActualDataRepo actualDataRepo;
    DataTargetRepo dataTargetRepo;
    DataRepo dataRepo;
    CoordinatorRepo coordinatorRepo;
    ShiftLeaderRepo shiftLeaderRepo;
    TeamLeaderRepo teamLeaderRepo;
    ProjectRepo projectRepo;
    FamilyRepo familyRepo;
    CrewRepo crewRepo;


    @Override
    public List<Data> getData() {

        return dataRepo.findAll();
    }

    @Override
    public void saveDataToDataBase(MultipartFile file) throws IllegalAccessException {
        ModelMapper mp = new ModelMapper();
        mp.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (UploadExcelAndExtractData.isValidFormat(file)) {
            try {
                List<DataFromExcel> dataFromExcels = UploadExcelAndExtractData.getDataFromEXcelFile(file.getInputStream());
                List<Data>dataList=new ArrayList<>();
                for (DataFromExcel dfe : dataFromExcels) {
                    Data data = new Data();
                    data.setPlant(dfe.getPlant());
                    data.setArea(dfe.getArea());
                    data.setMonth(dfe.getMonth());
                    data.setWeek(dfe.getWeek());
                    data.setDate(dfe.getDate());
                    data.setFilter(dfe.getFilter());
                    System.out.println("getActData"+ dfe.getActDataExcel().getOutput());
                    ActualData actualData = mp.map(dfe.getActDataExcel(), ActualData.class);
                    actualData=actualDataRepo.save(actualData);
                    data.setActualData(actualData);
                    DataTarget dataTarget=mp.map(dfe.getDataTargetExcel(), DataTarget.class);
                    dataTarget=dataTargetRepo.save(dataTarget);
                    data.setDataTarget(dataTarget);
                    Coordinator coordinator=coordinatorRepo.findCoordinatorByName(dfe.getCoordinator());
                    if (coordinator==null){
                        Coordinator coordinator1=new Coordinator();
                        coordinator1.setName(dfe.getCoordinator());
                        coordinator= coordinatorRepo.save(coordinator1);
                    }
                    ShiftLeader shiftLeader= shiftLeaderRepo.findShiftLeaderByName(dfe.getShiftLeader());
                    if(shiftLeader==null){
                        ShiftLeader shiftLeader1= new ShiftLeader();
                        shiftLeader1.setName(dfe.getShiftLeader());
                        shiftLeader1.setCoordinatorDetails(coordinator);
                        shiftLeader= shiftLeaderRepo.save(shiftLeader1);
                    }
                    TeamLeader teamLeader= teamLeaderRepo.findTeamLeaderByName(dfe.getTeamLeader());
                    if (teamLeader==null){
                        TeamLeader teamLeader1= new TeamLeader();
                        teamLeader1.setName(dfe.getTeamLeader());
                        teamLeader1.setShiftLeaderDetails(shiftLeader);
                        teamLeader= teamLeaderRepo.save(teamLeader1);
                    }
                    Project project= projectRepo.findProjectByName(dfe.getProject());
                    if (project==null){
                        Project project1= new Project();
                        project1.setName(dfe.getProject());
                        project = projectRepo.save(project1);
                    }
                    data.setProject(project);
                    Family family = familyRepo.findFamillyByName(dfe.getFamily());
                    if (family ==null){
                        Family family1 = new Family();
                        family1.setName(dfe.getFamily());
                        family1.setProjectDetails(project);
                        family = familyRepo.save(family1);
                    }
                    Crew crew= crewRepo.findCrewByName(dfe.getCrew());
                    if (crew==null){
                        Crew crew1= new Crew();
                        crew1.setName(dfe.getCrew());
                        crew1.setFamilyDetails(family);
                        crew1.setTeamLeaderDetails(teamLeader);
                        crewRepo.save(crew1);
                    }
                    //dataRepo.save(data);
                    dataList.add(data);
                }
                dataRepo.saveAll(dataList);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
