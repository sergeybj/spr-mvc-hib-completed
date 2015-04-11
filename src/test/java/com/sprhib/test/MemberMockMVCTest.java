package com.sprhib.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sprhib.init.BaseTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=BaseTestConfig.class)
public class MemberMockMVCTest {
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testMembersPage() throws Exception {
		mockMvc.perform(get("/member/list.html"))
			.andExpect(status().isOk())
			.andExpect(view().name("list-of-members"));;
	}
	
	@Test
	public void testAddMembersPage() throws Exception {
		mockMvc.perform(get("/member/add.html"))
			.andExpect(status().isOk())
			.andExpect(view().name("add-member-form"));;
	}
}
