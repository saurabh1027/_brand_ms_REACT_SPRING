package com.neutrux.BrandMS.controller;

import com.neutrux.BrandMS.model.request.CreateUserRequestModel;
import com.neutrux.BrandMS.model.response.UsersResponseModel;
import com.neutrux.BrandMS.service.UsersService;
//import com.neutrux.BrandMS.service.UsersService;
import com.neutrux.BrandMS.shared.UserDto;

//import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UsersService usersService;
	
	@Autowired
	public UserController(
			UsersService usersService
			) {
		this.usersService = usersService;
	}

    @PostMapping
    public ResponseEntity<UsersResponseModel> createUser(
//            @Valid 
            @RequestBody CreateUserRequestModel requestModel) throws Exception{
    	ModelMapper mapper = new ModelMapper();
    	UsersResponseModel userResponseModel = null;
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    	UserDto user = mapper.map(requestModel, UserDto.class);
    	
		user = usersService.createUser(user);
    	
		userResponseModel = mapper.map(user, UsersResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);
    }

}
