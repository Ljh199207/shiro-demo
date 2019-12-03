package com.example.springredis.mapstruct;

import com.example.springredis.mapStruct.dto.PersonDTO;
import com.example.springredis.mapStruct.mapper.PersonConverter;
import com.example.springredis.mapStruct.pojo.Person;
import com.example.springredis.mapStruct.pojo.User;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ljh
 * @date 2019-11-28 09:22
 */
@SpringBootTest
public class PersonConverterTest {


    @Test
    public void pensonTest() {
        Person person = new Person(1L, "zhige", "zhige.me@gmail.com", new Date(), new User(1));
        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);

        assertNotNull(personDTO);
        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirth(), person.getBirthday());
        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
        assertEquals(personDTO.getBirthDateFormat(), format);
        assertEquals(personDTO.getBirthExpressionFormat(), format);
        List<Person> people = new ArrayList<>();
        people.add(person);
        List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(people);
        assertNotNull(personDTOs);
    }
}
