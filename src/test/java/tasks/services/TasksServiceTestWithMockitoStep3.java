package tasks.services;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.helper.ArrayTaskList;
import tasks.model.Task;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TasksServiceTestWithMockitoStep3 {
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
        Task task1 = new Task("Title1", new Date(100));
        Task task2 = new Task("Title2", new Date(200));
        Task task3 = new Task("Title3", new Date(300));

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.add(task3);
        ObservableList<Task> observableList = tasksService.getObservableList();

        // assert
        assertEquals(observableList.size(), 3);
        assertEquals(observableList.get(0).getTitle(), "Title1");
        assertEquals(observableList.get(1).getTitle(), "Title2");
        assertEquals(observableList.get(2).getTitle(), "Title3");
    }

    @Test
    void filterTasks() throws Exception {
        // arrange
        Task task1 = new Task("Title1", new Date(100), new Date(200), 1);
        task1.setActive(true);
        Task task2 = new Task("Title2", new Date(200));
        Task task3 = new Task("Title3", new Date(300));

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.add(task3);
        ArrayList<Task> tasks = (ArrayList<Task>) tasksService.filterTasks(new Date(1), new Date(150));

        // assert
        assertEquals(tasks.get(0).getTitle(), "Title1");
    }
}