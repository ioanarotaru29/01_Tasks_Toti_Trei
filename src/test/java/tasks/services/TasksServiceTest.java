package tasks.services;

import org.junit.jupiter.api.*;
import tasks.helper.ArrayTaskList;
import tasks.model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {

    String END_TIME_BEFORE_START = "";
    String NO_RESULTS = "";

    @BeforeEach
    void setUp() {
        END_TIME_BEFORE_START = "End time cannot be before start time";
        NO_RESULTS = "No results found";
    }

    @AfterEach
    void tearDown() {
    }

    TasksService tasksService;

    @Test
    @DisplayName("Test: start > end (throws exception)")
    void F02_TC01() {
        Task task = new Task("Task1", new Date(1000));
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            tasksService.filterTasks(new Date(1000), new Date(900));
        });

        assertEquals(exception.getMessage(), END_TIME_BEFORE_START);
//        try {
//            tasksService.filterTasks(new Date(1000), new Date(900));
//            assert (false);
//        }
//        catch (Exception e) {
//            assert(e.getMessage().equals(END_TIME_BEFORE_START));
//        }
    }

    @Test
    @DisplayName("Test: no results (throws exception)")
    void F02_TC02() {
        Task task = new Task("Task1", new Date(500));
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);

        Exception exception = assertThrows(Exception.class, () -> {
            tasksService.filterTasks(new Date(1000), new Date(2000));
        });
        assertEquals(exception.getMessage(), NO_RESULTS);

//        try {
//            tasksService.filterTasks(new Date(1000), new Date(2000));
//            assert (false);
//        }
//        catch (Exception e) {
//            assert(e.getMessage().equals(NO_RESULTS));
//        }
    }

    @Test
    @DisplayName("Test: 1 result (nextTime before end)")
    void F02_TC03() {
        Task task = new Task("Task1", new Date(1500));
        task.setActive(true);
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);
        assertDoesNotThrow(()->{
            ArrayList<Task>taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
            assertEquals(taskIterable.size(), 1);
        });

//        try {
//            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
//            assert (taskIterable.size() == 1);
//        }
//        catch (Exception e) {
//            assert(false);
//        }
    }

    @Test
    @DisplayName("Test: 1 result (nexTime == end)")
    void F02_TC04() {
        Task task = new Task("Task1", new Date(2000));
        task.setActive(true);
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);

        assertDoesNotThrow(() ->{
            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
            assertEquals(taskIterable.size(), 1);
        });

//        try {
//            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
//            assert (taskIterable.size() == 1);
//        }
//        catch (Exception e) {
//            assert(false);
//        }
    }

    @Test
    @DisplayName("Test: 1 result (nexTime == end but with size > 1)")
    void F02_TC05() {
        Task task1 = new Task("Task1", new Date(500));
        task1.setActive(true);
        Task task2 = new Task("Task1", new Date(2000));
        task2.setActive(true);
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        tasksService = new TasksService(arrayTaskList);
        assertDoesNotThrow(()->{
            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
            assertEquals(taskIterable.size(), 1);
        });

//        try {
//            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
//            assert (taskIterable.size() == 1);
//        }
//        catch (Exception e) {
//            assert(false);
//        }
    }
}