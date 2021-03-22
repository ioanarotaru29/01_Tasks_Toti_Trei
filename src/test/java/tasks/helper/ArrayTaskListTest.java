package tasks.helper;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tasks.model.Task;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskListTest {
    private TaskList list;

    @BeforeEach
    void setUp() {
        list = new ArrayTaskList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ECP_BVA_Task_Null() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            list.add(null);
        });

        String expectedMessage = "Task shouldn't be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void ECP_BVA_Task_Empty(){
        int initialSize = list.size();

        assertDoesNotThrow(() ->{
            list.add(new Task());
        });

        assertEquals(initialSize+1,list.size());
    }

    //Test for title:String
    @Nested
    @DisplayName("Tests for title")
    @Tag("Task Title")
    class Title {

        @Test
        @DisplayName("Title is not empty Test")
        void ECP_Title_1() {
            Task t = new Task("Task 1", new Date());
            assertDoesNotThrow(() ->{
                list.add(t);
            });

            assertEquals(list.getTask(list.size()-1), t);
        }

        @Test
        @DisplayName("Title is empty Test")
        void ECP_BVA_Title_2() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                list.add( new Task("", new Date()));
            });

            String expectedMessage = "Title cannot be empty";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

    }

    //Test for time
    @Nested
    @DisplayName("Tests for time")
    @Tag("Task Time")
    class Time {

        @Test
        @DisplayName("Time is negative")
        void ECP_Time_1() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                list.add( new Task("Task", new Date(-1)));
            });

            assertEquals(exception.getMessage(), "Time cannot be negative");
        }

        @Test
        @DisplayName("Time is ok")
        void ECP_Time_2() {
            Task t = new Task("Task", new Date());
            assertDoesNotThrow(() -> {
                list.add(t);
            });

            assertEquals(t, list.getTask(list.size()-1));
        }

        @Test
        @DisplayName("Time is 0")
        void BVA_Time_1() {
            Task t = new Task("Task", new Date(0));
            assertDoesNotThrow(() -> {
                list.add(t);
            });

            assertEquals(t, list.getTask(list.size()-1));
        }

        @Test
        @DisplayName("Time is positive")
        void BVA_Time_2() {
            Task t = new Task("Task", new Date(1));
            assertDoesNotThrow(() -> {
                list.add(t);
            });

            assertEquals(t, list.getTask(list.size()-1));
        }

        @Test
        @DisplayName("Time is negative")
        void BVA_Time_3() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                list.add( new Task("Task", new Date(-1)));
            });

            assertEquals(exception.getMessage(), "Time cannot be negative");
        }
    }

    //Test for interval
    @Nested
    @DisplayName("Tests for interval")
    @Tag("Task Interval")
    class Interval {

        @DisplayName("Interval is < 1")
        @ParameterizedTest(name = "interval {0} is not supported")
        @ValueSource(ints = { -1, -4, 0 })
        void ECP_Interval_1(int interval) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                list.add( new Task("Task", new Date(), new Date(), interval));
            });

            assertEquals(exception.getMessage(), "interval should be > 1");
        }

        @DisplayName("Interval is > 1")
        @ParameterizedTest(name = "interval {0} is supported")
        @ValueSource(ints = { 1, 2, 3 })
        void ECP_Time_2() {
            Task t = new Task("Task", new Date(), new Date(), 1);
            assertDoesNotThrow(() -> {
                list.add(t);
            });

            assertEquals(t, list.getTask(list.size()-1));
        }

        @Test
        @DisplayName("Interval is 1")
        void BVA_Time_1() {
            Task t = new Task("Task", new Date(), new Date(), 1);
            assertDoesNotThrow(() -> {
                list.add(t);
            });

            assertEquals(t, list.getTask(list.size()-1));
        }

        @Test
        @DisplayName("Interval is 2")
        void BVA_Time_2() {
            Task t = new Task("Task", new Date(), new Date(), 2);
            assertDoesNotThrow(() -> {
                list.add(t);
            });

            assertEquals(t, list.getTask(list.size()-1));
        }

        @Test
        @DisplayName("Interval is 0")
        void BVA_Time_3() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                list.add( new Task("Task", new Date(), new Date(), 0));
            });

            assertEquals(exception.getMessage(), "interval should be > 1");
        }
    }

}