package com.alexspoonner.utils.config;

import com.alexspoonner.service.impl.AcademicGroupFormatter;
import com.alexspoonner.service.impl.SubjectFormatter;
import com.alexspoonner.service.impl.TeacherFormatter;
import com.alexspoonner.service.impl.StudentFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by spoonner on 7/8/17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = {"com.alexspoonner"})
public class WebConfig extends WebMvcConfigurerAdapter {

    private AcademicGroupFormatter academicGroupFormatter;
    private StudentFormatter studentFormatter;
    private SubjectFormatter subjectFormatter;
    private TeacherFormatter teacherFormatter;

    @Autowired
    public void setStudentFormatter(StudentFormatter studentFormatter) {
        this.studentFormatter = studentFormatter;
    }

    @Autowired
    public void setSubjectFormatter(SubjectFormatter subjectFormatter) {
        this.subjectFormatter = subjectFormatter;
    }

    @Autowired
    public void setTeacherFormatter(TeacherFormatter teacherFormatter) {
        this.teacherFormatter = teacherFormatter;
    }

    @Autowired
    public void setAcademicGroupFormatter(AcademicGroupFormatter academicGroupFormatter) {
        this.academicGroupFormatter = academicGroupFormatter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(academicGroupFormatter);
        registry.addFormatter(studentFormatter);
        registry.addFormatter(subjectFormatter);
        registry.addFormatter(teacherFormatter);
    }
}
