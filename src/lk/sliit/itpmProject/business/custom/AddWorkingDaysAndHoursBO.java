package lk.sliit.itpmProject.business.custom;

import lk.sliit.itpmProject.business.SuperBO;
import lk.sliit.itpmProject.dto.AddWorkingDaysAndHoursDTO;

import java.util.List;

public interface AddWorkingDaysAndHoursBO extends SuperBO {
    boolean saveWorkingDaysAndHours(AddWorkingDaysAndHoursDTO andHoursDTO) throws Exception;
    boolean updateWorkingDaysAndHours(AddWorkingDaysAndHoursDTO andHoursDTO) throws Exception;
    List<AddWorkingDaysAndHoursDTO> findAllWorkingDays() throws Exception;

}
