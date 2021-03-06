package tasks.validator;

import tasks.model.Task;

public interface Validator {
    boolean validate(Task task);
}
