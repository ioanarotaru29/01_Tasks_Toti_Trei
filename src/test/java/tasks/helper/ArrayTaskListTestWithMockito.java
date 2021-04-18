package tasks.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.Task;

import static org.mockito.Mockito.mock;

class ArrayTaskListTestWithMockito {
    private ArrayTaskList arrayTaskList;

    @BeforeEach
    void setUp() {
        arrayTaskList = new ArrayTaskList();
    }

    @Test
    void add() {
        // arrange
        Task task = mock(Task.class);

        // act
        arrayTaskList.add(task);

        // assert
        assert(arrayTaskList.size() == 1);
    }

    @Test
    void remove() {
        // arrange
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.remove(task1);

        // assert
        assert(arrayTaskList.size() == 1);
    }

    @Test
    void size() {
        // arrange
        Task task1 = mock(Task.class);

        // act
        arrayTaskList.add(task1);
        arrayTaskList.remove(task1);

        // assert
        assert(arrayTaskList.size() == 0);
    }
}