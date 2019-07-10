package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Student;
import org.springframework.core.convert.converter.Converter;

public class StudentConverterForRate implements Converter<Student, StudentDTO> {
    @Override
    public StudentDTO convert(Student source) {
        return new StudentDTO(source.getId(),source.getFirstName(),source.getLastName(),source.getPatronymic(),source.getPassportID());
    }
}
