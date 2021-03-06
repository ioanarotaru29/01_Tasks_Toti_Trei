package tasks.validator;

import tasks.model.Task;

public class TaskValidator implements Validator {
    @Override
    public boolean validate(Task task) {
        return false;
    }
}
