package com.spring.cassandra.springCassandra.repository;

import com.spring.cassandra.springCassandra.model.Employee;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {

    @AllowFiltering
    List<Employee> findByEmail(String email);

    @AllowFiltering
    List<Employee> findByName(String name);
}
