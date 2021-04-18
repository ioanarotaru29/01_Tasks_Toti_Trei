package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskWithMockito {
    private Task t1,t2;

    @BeforeEach
    void setUp(){
        t1 = new Task("Task 1", new Date());
        t1.setActive(true);

        t2 = new Task("Task 2", new Date(0), new Date(1), 10);
    }

    @Test
    public void testIsActive(){
        assertTrue(t1.isActive());
        assertFalse(t2.isActive());
    }

    @Test
    public void testIsRepeated(){
        assertTrue(t2.isRepeated());
        assertFalse(t1.isRepeated());
    }
}
