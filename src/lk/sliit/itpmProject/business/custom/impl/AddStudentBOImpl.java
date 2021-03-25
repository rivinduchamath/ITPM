package lk.sliit.itpmProject.business.custom.impl;

import lk.sliit.itpmProject.business.custom.AddStudentBO;
import lk.sliit.itpmProject.dao.DAOFactory;
import lk.sliit.itpmProject.dao.DAOTypes;
import lk.sliit.itpmProject.dao.custom.AddStudentDAO;
import lk.sliit.itpmProject.dao.custom.AddWorkingDaysDAO;
import lk.sliit.itpmProject.dto.AddStudentDTO;
import lk.sliit.itpmProject.entity.AddStudent;
import lk.sliit.itpmProject.entity.AddWorkingDaysAndHours;

public class AddStudentBOImpl implements AddStudentBO {
    private final AddStudentDAO addStudentDAO = DAOFactory.getInstance().getDAO(DAOTypes.AddStudent);
    @Override
    public boolean saveStudent(AddStudentDTO addStudentDTO) throws Exception {
        return addStudentDAO.save(new AddStudent(
                addStudentDTO.getAcademicYear(),
                addStudentDTO.getProgramme(),
                addStudentDTO.getGroupNumber(),
                addStudentDTO.getsGroup(),
                addStudentDTO.getGroup()));
    }
}
