package com.indatacore.reast_api_indatacore.service;

import com.github.javafaker.Faker;
import com.indatacore.reast_api_indatacore.dto.StudentRequest;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;
import com.indatacore.reast_api_indatacore.entity.Student;
import com.indatacore.reast_api_indatacore.enumeration.GenderEnum;
import com.indatacore.reast_api_indatacore.mapper.StudentMapper;
import com.indatacore.reast_api_indatacore.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public static String PATH = "data/students.csv";
    public static String COMMA_DELIMITER = ",";
    private final StudentMapper studentMapper;

    @SneakyThrows
    @Override
    //--------------------------- Get and save students from Csv file : ---------------------------
    public List<StudentResponse> getAndSaveStudentsFromCsv() {
        log.info("get data from CSV and create all Students in CSV to DataBase");
        List<Student> records = new ArrayList<>();
        try{
            Resource resource = new ClassPathResource(PATH);
            File file = resource.getFile();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] values = line.split(COMMA_DELIMITER);
                Student studentRow = new Student();
                studentRow.setId(Long.valueOf(values[0]));
                studentRow.setFirstName(values[1]);
                studentRow.setLastName(values[2]);
                studentRow.setGender("Female".equals(values[3]) ? GenderEnum.FEMALE : GenderEnum.MALE);
                records.add(studentRow);
            }
        }catch (Exception e){
            log.error("File Exception");
            e.printStackTrace();
        }

        return studentMapper.StudenListToStudentResponseList(studentRepository.saveAll(records));
    }

    //---------------------------  Add new student : ---------------------------
    @Override
    public StudentResponse createStudent(StudentRequest student) {
        log.info("create new Student");
        Student student1 = studentRepository.save(studentMapper.StudentRequestToStudent(student));
        return studentMapper.StudentToStudentResponse(student1);
    }
    //---------------------------  Add new random student : ---------------------------
    @Override
    public StudentResponse createRandomStudent() {
        log.info("get students From StudentCSV");
        Random random = new Random();
        Faker faker = new Faker(new Locale("nl-NL"));
        Student student = new Student();
        student.setId(0L);
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setGender(random.nextInt(10) % 2 == 0 ? GenderEnum.MALE : GenderEnum.FEMALE);
        return studentMapper.StudentToStudentResponse(studentRepository.save(student));
    }
    //---------------------------  find all students : ---------------------------
    @Override
    public List<StudentResponse> findAllStudents() {
        log.info("get list students From DataBase");
        return studentMapper.StudenListToStudentResponseList(studentRepository.findAll());
    }
}
