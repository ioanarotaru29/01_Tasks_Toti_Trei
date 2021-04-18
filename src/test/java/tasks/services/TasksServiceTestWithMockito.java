package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.helper.ArrayTaskList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TasksServiceTestWithMockito {
    ArrayTaskList arrayTaskList;
    TasksService tasksService;

    @BeforeEach
    void setUp() {
        arrayTaskList = mock(ArrayTaskList.class);
        tasksService = new TasksService(arrayTaskList);
    }

    @Test
    @DisplayName("Test - time unit")
    void formTimeUnit() {
        assert (tasksService.formTimeUnit(30).equals("30"));
    }

    @Test
    @DisplayName("Test - parse string into seconds")
    void parseFromStringToSeconds() {
        assert (tasksService.parseFromStringToSeconds("00:02") == 120);
    }
}