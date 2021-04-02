package lk.sliit.itpmProject.business.custom;


import lk.sliit.itpmProject.business.SuperBO;
import lk.sliit.itpmProject.dto.AddStudentDTO;

public interface AddStudentBO extends SuperBO {
    boolean saveStudent(AddStudentDTO addStudentDTO) throws Exception;


    int getLastItemCode() throws Exception;
}
