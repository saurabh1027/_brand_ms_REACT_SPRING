package com.neutrux.BrandMS.service.implementation;

import com.mysql.cj.exceptions.MysqlErrorNumbers;
import com.neutrux.BrandMS.model.UserEntity;
import com.neutrux.BrandMS.repository.UsersRepository;
import com.neutrux.BrandMS.service.UsersService;
import com.neutrux.BrandMS.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
    @Autowired
    public UsersServiceImpl(
            UsersRepository usersRepository
//            ,BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.usersRepository = usersRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

    @Override
    public UserDto createUser(UserDto userDetails) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        String encryptedPassword = 
//        		encryptPassword(
        		userDetails.getPassword()
//        		)
        		;
        userDetails.setEncryptedPassword(encryptedPassword);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setRoles("ROLE_CUSTOMER");

//        try {
            userEntity = usersRepository.save(userEntity);
//        } catch (DataIntegrityViolationException e) {
//            // Exception Handling for Duplicate Entry of Email
//            if (e.getRootCause() != null
//                    && e.getRootCause().getClass().equals(SQLIntegrityConstraintViolationException.class)) {
//                SQLIntegrityConstraintViolationException ex = (SQLIntegrityConstraintViolationException) e
//                        .getRootCause();
//                if (ex.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
//                    throw new Exception("Email already exists!");
//                }
//            }
//
//        }
        
        UserDto createdUser = modelMapper.map(userEntity, UserDto.class);
        
        String userId = encryptUserId(userEntity.getId());
		createdUser.setUserId(userId);
        
        return createdUser;
    }

//    public String encryptPassword( String password ) {
//        return bCryptPasswordEncoder.encode(password);
//    }
    
    private String encryptUserId(long id) {
		return (id * 673926356) + "";
	}

//	private long decryptUserId(String userId) {
//		long id = 0;
//		id = Long.parseLong(userId);
//		id = id / 673926356;
//		return id;
//	}

}
