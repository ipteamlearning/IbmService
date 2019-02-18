package com.training.ibm.service;

import java.util.List;

import com.training.ibm.response.model.TrainingInfoModel;

public interface ITrainingService {

	
	public List<TrainingInfoModel> findAllTrainingInfo();
	
	/**
	 * 
	 * @param id
	 */
    public TrainingInfoModel findTrainingInfoById(int id);
}
