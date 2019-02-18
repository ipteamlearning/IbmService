package com.training.ibm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.ibm.exception.TrainingInfoNotFound;
import com.training.ibm.response.model.TrainingInfoModel;
import com.training.ibm.service.ITrainingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrainingServiceImpl implements ITrainingService {

	
	List<TrainingInfoModel> trainingList = new ArrayList<>();
	public TrainingServiceImpl()
	{
		TrainingInfoModel model = new TrainingInfoModel();
		model.setId(1);
		model.setAge("36");
		model.setName("Vinod");
		model.setDesignation("Team lead");
		
		
		TrainingInfoModel model1 = new TrainingInfoModel();
		model1.setId(3);
		model1.setAge("46");
		model1.setName("Shankar");
		model1.setDesignation("Team lead");

		
		
		TrainingInfoModel model2 = new TrainingInfoModel();
		model2.setId(2);
		model2.setAge("26");
		model2.setName("Vikrant");
		model2.setDesignation("Developer");

		trainingList.add(model);
		trainingList.add(model1);
		trainingList.add(model2);
		
	}
	
	public List<TrainingInfoModel> findAllTrainingInfo() {
		
		log.info("get All training info");
		return trainingList;
	}

	
	public TrainingInfoModel findTrainingInfoById(int id) {
		log.info("get All training info for an id");
		TrainingInfoModel newInfoModel = new TrainingInfoModel();
		trainingList.forEach(trainingModel ->{
			if(id == trainingModel.getId())
			{
				newInfoModel.setAge(trainingModel.getAge());
				newInfoModel.setDesignation(trainingModel.getDesignation());
				newInfoModel.setId(id);
				newInfoModel.setName(trainingModel.getName());
			}
		});
		if(newInfoModel.getId()==0)
		{
			throw new TrainingInfoNotFound("no info found for id::"+id);
		}
		return newInfoModel;
	}

}
