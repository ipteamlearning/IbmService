package com.training.ibm.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.ibm.controller.ITrainingController;
import com.training.ibm.response.model.TrainingInfoModel;
import com.training.ibm.service.ITrainingService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author saket
 *
 */
@RestController
@Slf4j
public class TrainingControllerImpl implements ITrainingController {

	@Autowired
	ITrainingService trainingService;
	/**
	 * Get All Training info for every trainer
	 */
	public List<TrainingInfoModel> getAllTrainingInfo() {
		return trainingService.findAllTrainingInfo();
	}

	/**
	 * Get Training info of a specific trainer by id
	 */
	public TrainingInfoModel getTrainingInfoById(int id) {
       log.debug("getting training info by id");
		return trainingService.findTrainingInfoById(id);
	}

}
