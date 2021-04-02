package lk.sliit.itpmProject.dao.custom;

import lk.sliit.itpmProject.dao.CrudDAO;
import lk.sliit.itpmProject.entity.AddStudent;


public interface AddStudentDAO extends CrudDAO<AddStudent, String> {

    int getLastStudentID() throws Exception;
}
