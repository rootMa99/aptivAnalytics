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
    public void saveDataToDataBase(MultipartFile file) throws IllegalAccessException {
        ModelMapper mp = new ModelMapper();
        mp.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (UploadExcelAndExtractData.isValidFormat(file)) {
            try {
                List<DataFromExcel> dataFromExcels = UploadExcelAndExtractData.getDataFromEXcelFile(file.getInputStream());
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
                    Familly familly= familyRepo.findFamillyByName(dfe.getFamily());
                    if (familly==null){
                        Familly familly1= new Familly();
                        familly1.setName(dfe.getFamily());
                        familly1.setProjectDetails(project);
                        familly= familyRepo.save(familly1);
                    }
                    Crew crew= crewRepo.findCrewByName(dfe.getCrew());
                    if (crew==null){
                        Crew crew1= new Crew();
                        crew1.setName(dfe.getCrew());
                        crew1.setFamilyDetails(familly);
                        crew1.setTeamLeaderDetails(teamLeader);
                        crewRepo.save(crew1);
                    }
                    dataRepo.save(data);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
