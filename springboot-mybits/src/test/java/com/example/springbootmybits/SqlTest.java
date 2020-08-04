package com.example.springbootmybits;

import com.example.springbootmybits.jpa.entity.Address;
import com.example.springbootmybits.jpa.entity.People;
import com.example.springbootmybits.jpa.repository.AddressRepository;
import com.example.springbootmybits.jpa.repository.PeopleRepository;
import com.example.springbootmybits.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void testUserMap() {
        Address address = new Address();
        address.setAddress("不知道是什么地方");
        address.setPhone("18523954512");
        address.setZipcode("000000");
        People people = new People();
        people.setAddress(address);
        people.setBirthday(LocalDateTime.now());
        people.setName("abc");
        people.setSex("1");
        peopleRepository.save(people);

      /*  List<Map> a = peopleRepository.findAllDetail("a");
        System.out.println(a);*/
    }

    @Test
    public void testQuery() {

        Object a = peopleRepository.findAllDetail("a");

        System.out.println(a);
    }

    @Test
    public void testQuery2() {
        List<Map<String, Object>> a = peopleRepository.getUserByRealName("a");
        System.out.println(a);
    }

    @Test
    public void testQuery3() {
        //   List<Map<String, Object>> abc = peopleRepository.getUserByRealName1("abc");
        ///  System.out.println(abc);
    }
}
