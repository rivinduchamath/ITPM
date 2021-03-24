package lk.sliit.itpmProject.business.custom.impl;

import lk.sliit.itpmProject.business.custom.AddWorkingDaysAndHoursBO;
import lk.sliit.itpmProject.dao.DAOFactory;
import lk.sliit.itpmProject.dao.DAOTypes;
import lk.sliit.itpmProject.dao.custom.AddWorkingDaysDAO;
import lk.sliit.itpmProject.dto.AddWorkingDaysAndHoursDTO;
import lk.sliit.itpmProject.entity.AddWorkingDaysAndHours;

import java.util.ArrayList;
import java.util.List;

public class AddWorkingDaysAndHoursBOImpl implements AddWorkingDaysAndHoursBO {

    private final AddWorkingDaysDAO workingDaysDAO = DAOFactory.getInstance().getDAO(DAOTypes.AddWorkingDaysDAO);

    @Override
    public boolean saveWorkingDaysAndHours(AddWorkingDaysAndHoursDTO andHoursDTO) throws Exception {
        return workingDaysDAO.save(new AddWorkingDaysAndHours(
                andHoursDTO.getId(),
                andHoursDTO.getNoOfWorkingDays(),
                andHoursDTO.isSunday(),andHoursDTO.isMonday(),
                andHoursDTO.isTuesday(),andHoursDTO.isWednesday(),
                andHoursDTO.isThursday(),andHoursDTO.isFriday(),andHoursDTO.isSaturday(),
                andHoursDTO.getHours(),andHoursDTO.getMinutes()));
    }

    @Override
    public boolean updateWorkingDaysAndHours(AddWorkingDaysAndHoursDTO andHoursDTO) throws Exception {
        return workingDaysDAO.update(new AddWorkingDaysAndHours(
                andHoursDTO.getId(),
                andHoursDTO.getNoOfWorkingDays(),
                andHoursDTO.isSunday(),andHoursDTO.isMonday(),
                andHoursDTO.isTuesday(),andHoursDTO.isWednesday(),
                andHoursDTO.isThursday(),andHoursDTO.isFriday(),andHoursDTO.isSaturday(),
                andHoursDTO.getHours(),andHoursDTO.getMinutes()
        ));
    }

    @Override
    public List<AddWorkingDaysAndHoursDTO> findAllWorkingDays() throws Exception {
        List<AddWorkingDaysAndHours> all = workingDaysDAO.findAll();
        List<AddWorkingDaysAndHoursDTO> dtos = new ArrayList<>();
        for (AddWorkingDaysAndHours addWorkingDaysAndHours : all) {
            dtos.add(new AddWorkingDaysAndHoursDTO(
                    addWorkingDaysAndHours.getId(),
                    addWorkingDaysAndHours.getNoOfWorkingDays(),
                    addWorkingDaysAndHours.isSunday(),
                    addWorkingDaysAndHours.isMonday(),
                    addWorkingDaysAndHours.isTuesday(),
                    addWorkingDaysAndHours.isWednesday(),
                    addWorkingDaysAndHours.isThursday(),
                    addWorkingDaysAndHours.isFriday(),
                    addWorkingDaysAndHours.isSaturday(),
                    addWorkingDaysAndHours.getHours(),
                    addWorkingDaysAndHours.getMinutes()
            ));
        }
        return dtos;
    }

}
