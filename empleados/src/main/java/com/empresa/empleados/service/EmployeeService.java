package com.empresa.empleados.service;
import com.empresa.empleados.dto.EmployeeDTO;
import com.empresa.empleados.mapper.EmployeeMapper;
import com.empresa.empleados.model.Employee;
import com.empresa.empleados.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository repo;
public EmployeeService(EmployeeRepository repo) {
this.repo = repo;
}
public List<Employee> findAllEntities() {
return repo.findAll();
}
public List<EmployeeDTO> findAllDTOs() {
return repo.findAll().stream()
.map(EmployeeMapper::toDTO)
.toList();
}
public EmployeeDTO findDTOById(Long id) {
return repo.findById(id).map(EmployeeMapper::toDTO).orElse(null);
}
public void saveFromDTO(EmployeeDTO dto) {
Employee e = EmployeeMapper.toEntity(dto);
repo.save(e);
}
public void delete(Long id) {
repo.deleteById(id);
}
}

