package lk.sliit.itpmProject.business.custom;

import lk.sliit.itpmProject.business.SuperBO;
import lk.sliit.itpmProject.dto.AddWorkingDaysAndHoursDTO;

public interface AddWorkingDaysAndHoursBO extends SuperBO {
    void saveWorkingDaysAndHours(AddWorkingDaysAndHoursDTO andHoursDTO);
}
