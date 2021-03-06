package com.tavant.restapi.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.restapi.errorresponse.ErrorResponse;
import com.tavant.restapi.exception.EmployeeNotFoundException;
import com.tavant.restapi.exception.NoDataFoundException;

@ControllerAdvice
public class EmployeeRestControllerAdvice {
	@ExceptionHandler(EmployeeNotFoundException.class)
	
	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e, WebRequest request){
		List<String> details=new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
@ExceptionHandler(NoDataFoundException.class)
	
	public final ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException e, WebRequest request){
		List<String> details=new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
