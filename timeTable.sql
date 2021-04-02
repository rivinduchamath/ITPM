CREATE TABLE `WorkingDays` (
                        `id` varchar(10) NOT NULL,
                        `noOfDays` varchar(30) DEFAULT NULL,
                        `sunday` boolean  DEFAULT 0,
                        `monday` boolean  DEFAULT 0,
                        `tuesday` boolean  DEFAULT 0,
                        `wednesday` boolean  DEFAULT 0,
                        `thursday` boolean  DEFAULT 0,
                        `friday` boolean  DEFAULT 0,
                        `saturday` boolean  DEFAULT 0,
                        `workingTimeHours` int DEFAULT NULL,
                        `workingTimeMinutes` int DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `AddStudentSubGroups`(
                        `id` int NOT NULL,
                        `year` int DEFAULT NULL,
                        `semester` int  DEFAULT 1,
                        `programme` varchar(20) DEFAULT NULL,
                        `groupNo` int  DEFAULT NULL,
                        `subGroupNo` int DEFAULT NULL,
                        `groupId` varchar(100)  DEFAULT NULL,
                        `subGroupId` varchar(100)  DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;