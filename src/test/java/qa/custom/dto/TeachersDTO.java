package qa.custom.dto;

import lombok.Data;
import qa.custom.entity.model.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class TeachersDTO {

    private static List<Teacher> teacherList = Collections.synchronizedList(new ArrayList<>());

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }

}