package com.training.ibm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ibm.response.model.TrainingInfoModel;

/**
 * 
 * @author saket
 *
 */
@RequestMapping("/ibm")
public interface ITrainingController {
	
	/**
	 * 
	 */
	@GetMapping("/get/info")
	public List<TrainingInfoModel> getAllTrainingInfo();
	
	/**
	 * 
	 * @param id
	 */
	@GetMapping("/get/info/{id}")
    public TrainingInfoModel getTrainingInfoById(@PathVariable("id") int id);
}
