package com.indatacore.reast_api_indatacore.mapper;
import com.indatacore.reast_api_indatacore.dto.StudentRequest;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;
import com.indatacore.reast_api_indatacore.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentMapperImpl implements StudentMapper{

    private final ModelMapper modelMapper;
    @Override
    public Student StudentRequestToStudent(StudentRequest studentRequest) {
        if(studentRequest == null){
            return null;
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
        return modelMapper.map(studentRequest,Student.class);
    }

    @Override
    public StudentResponse StudentToStudentResponse(Student student) {
        if(student == null){
            return null;
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
        return modelMapper.map(student,StudentResponse.class);
    }

    @Override
    public Student StudentToStudentResponse(StudentRequest studentRequest) {
        if(studentRequest == null){
            return null;
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
        return modelMapper.map(studentRequest,Student.class);
    }

    @Override
    public List<StudentResponse> StudenListToStudentResponseList(Collection<Student> students) {
        if(students == null)
            return Collections.emptyList();
        return students.stream().map(entity -> StudentToStudentResponse(entity)).collect(Collectors.toList());
    }
}
