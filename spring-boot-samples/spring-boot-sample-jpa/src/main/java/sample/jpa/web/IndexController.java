/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jpa.web;

import java.util.List;

import com.alibaba.fastjson.JSON;
import sample.jpa.domain.Note;
import sample.jpa.domain.User;
import sample.jpa.repository.IUserRepository;
import sample.jpa.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	private IUserRepository userRepository;

	@GetMapping("/")
	public String index() {

		User user = new User();
		user.setId(1);
		user.setAge(19);
		user.setName("张三");
		user.setCity("郑州");
		user.setAddress("金水区");
		userRepository.save(user);

		List<User> notes = userRepository.findAll();
		/*ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("notes", notes);*/

		System.out.println("********* "+notes.size() +" **********");

		String json = JSON.toJSONString(notes);
		System.out.println(json);
		return json;
	}

}
