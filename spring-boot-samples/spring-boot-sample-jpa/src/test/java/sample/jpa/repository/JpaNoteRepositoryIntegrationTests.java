/*
 * Copyright 2012-2018 the original author or authors.
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

package sample.jpa.repository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import sample.jpa.domain.MyIpEntry;
import sample.jpa.domain.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sample.jpa.domain.User;

/**
 * Integration tests for {@link JpaNoteRepository}.
 *
 * h2的控制台
 * http://localhost:8080/h2-console
 *
 * @author Andy Wilkinson
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaNoteRepositoryIntegrationTests {


	@Autowired
	IUserRepository repository;

	@Before
    public void before(){
        User user = new User();
        user.setAddress("金水区");
        user.setCity("郑州");
        user.setName("张三");
        user.setAge(27);
        repository.save(user);
        User user1 = new User();
        user1.setAddress("金水区");
        user1.setCity("郑州");
        user1.setName("张三");
        user1.setAge(28);
        repository.save(user1);
    }

	@Test
	public void findsAllNotes() {
        List<User> all = repository.findAll();
        assert all.size() == 2;
        User user = all.get(0);
        assert user.getAge() == 27;
        User user1 = all.get(1);
        assert user1.getAge() == 28;
    }

}
