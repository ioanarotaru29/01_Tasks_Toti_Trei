package tasks.services;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.helper.ArrayTaskList;
import tasks.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TasksServiceTestWithMockitoStep2 {
    ArrayTaskList arrayTaskList;
    TasksService tasksService;

    @BeforeEach
    void setUp() {
        arrayTaskList = new ArrayTaskList();
        tasksService = new TasksService(arrayTaskList);
    }

    @Test
    void getObservableList() {
        // arrange
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        Task task3 = mock(Task.class);
        Mockito.when(task1.getTitle()).thenReturn("Titlu1");

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.add(task3);
        ObservableList<Task> observableList = tasksService.getObservableList();

        // assert
        assertEquals(observableList.size(), 3);
        assertEquals(observableList.get(0).getTitle(),"Titlu1");
    }

    @Test
    void getTaskListSize() {
        // arrange
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        Task task3 = mock(Task.class);

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.add(task3);

        // assert
        assertEquals(tasksService.getTaskListSize(), 3);
    }
}