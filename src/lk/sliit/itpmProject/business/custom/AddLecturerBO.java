package lk.sliit.itpmProject.business.custom;

import lk.sliit.itpmProject.business.SuperBO;
import lk.sliit.itpmProject.dto.AddLecturerDTO;

public interface AddLecturerBO extends SuperBO {
    Boolean saveLecturer (AddLecturerDTO addLecturerDTO) throws Exception;

    int getLastItemCode() throws Exception;
}
