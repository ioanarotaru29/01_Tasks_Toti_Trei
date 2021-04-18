package tasks.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ArrayTaskListTestWithMockito {
    private ArrayTaskList arrayTaskList;

    @BeforeEach
    void setUp() {
        arrayTaskList = new ArrayTaskList();
    }

    @Test
    @DisplayName("Test add")
    void add() {
        Task task = mock(Task.class);

        arrayTaskList.add(task);

        assert(arrayTaskList.size() == 1);
    }

    @Test
    @DisplayName("Test - remove (only one removed)")
    void remove() {
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);

        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.remove(task1);

        assertEquals(arrayTaskList.size(), 1);
    }


    @Test
    @DisplayName("Test - size")
    void size() {
        Task task1 = mock(Task.class);

        arrayTaskList.add(task1);
        arrayTaskList.remove(task1);

        assertEquals(arrayTaskList.size(), 0);
    }
}