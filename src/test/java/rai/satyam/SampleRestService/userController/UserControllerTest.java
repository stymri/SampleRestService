package rai.satyam.SampleRestService.userController;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import rai.satyam.SampleRestService.controller.UserController;
import rai.satyam.SampleRestService.entity.User;
import rai.satyam.SampleRestService.repositories.UserRepository;

@WebMvcTest(UserController.class)
@ActiveProfiles("test") 
public class UserControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	public void getAllTest() throws Exception {
		
		// creating data for test
		User v_arrUser[] = new User[1];
		v_arrUser[0] = new User();
		v_arrUser[0].setEmail("test@user.com");
		v_arrUser[0].setFname("first");
		v_arrUser[0].setLname("last");
		
		Iterable<User> v_lUser = Arrays.asList(v_arrUser);
		// mocking function
		Mockito.when(userRepository.findAll()).thenReturn(v_lUser);
		
		// executing function call
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/Users").contentType(MediaType.APPLICATION_JSON));
		
		System.out.println(result);
		
		result.andExpect(status().isOk());
		//result.andExpect(jsonPath("$.*", hasSize(2)));
		result.andExpect(jsonPath("$[0].email", is("test@user.com")));
		result.andExpect(jsonPath("$[0].fname", is("first")));
		result.andExpect(jsonPath("$[0].lname", is("last")));
		
		
		
	}
	
	@Test
	public void getUserByEmail() throws Exception {
		
		// creating data for test
		User v_objUser ;
		v_objUser = new User();
		v_objUser.setEmail("test@user.com");
		v_objUser.setFname("first");
		v_objUser.setLname("last");
		//Optional<User> user = Optional.of(v_objUser);
		Mockito.when(userRepository.findById("test@user.com")).thenReturn(Optional.of(v_objUser));
		
		// executing function call
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/User/test@user.com").contentType(MediaType.APPLICATION_JSON));
		
		System.out.println(result.andReturn().getResponse().getContentAsString());
		
		result.andExpect(status().isOk());
		//result.andExpect(jsonPath("$.*", hasSize(2)));
		result.andExpect(jsonPath("$.email", is("test@user.com")));
		result.andExpect(jsonPath("$.fname", is("first")));
		result.andExpect(jsonPath("$.lname", is("last")));
	}
	
	
}
