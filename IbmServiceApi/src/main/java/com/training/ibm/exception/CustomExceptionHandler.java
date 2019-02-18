package com.training.ibm.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.ibm.response.model.ErrorModel;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value 
		      = {TrainingInfoNotFound.class })
	public ErrorModel handleRuntimeException( RuntimeException ex)
	{
		ErrorModel model = new ErrorModel();
		model.setErrorCode("500");
		model.setErrorMessage(ex.getMessage());
        return model;
	}
}
