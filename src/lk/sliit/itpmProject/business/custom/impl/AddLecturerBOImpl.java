package lk.sliit.itpmProject.business.custom.impl;

import lk.sliit.itpmProject.business.custom.AddLecturerBO;
import lk.sliit.itpmProject.dao.DAOFactory;
import lk.sliit.itpmProject.dao.DAOTypes;
import lk.sliit.itpmProject.dao.custom.AddLecturerDAO;
import lk.sliit.itpmProject.dto.AddLecturerDTO;
import lk.sliit.itpmProject.entity.AddLecturer;

public class AddLecturerBOImpl implements AddLecturerBO {
    private final AddLecturerDAO addLecturerDAO = DAOFactory.getInstance().getDAO(DAOTypes.AddLecturer);
    @Override
    public Boolean saveLecturer(AddLecturerDTO addLecturerDTO) throws Exception {
        return addLecturerDAO.save(new AddLecturer(
                addLecturerDTO.getId(),
                addLecturerDTO.getEmpId(),
                addLecturerDTO.getlName(),
                addLecturerDTO.getDepartment(),
                addLecturerDTO.getFaculty(),
                addLecturerDTO.getCenter(),
                addLecturerDTO.getBuildingNo(),
                addLecturerDTO.getLevel(),
                addLecturerDTO.getRank()
        ));
    }

    @Override
    public int getLastItemCode() throws Exception {
        return addLecturerDAO.getLastLecturerID();
    }

}
