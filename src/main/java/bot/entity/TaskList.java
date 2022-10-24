package bot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.PriorityQueue;

@Getter
@AllArgsConstructor
public class TaskList {
    private String listName;
    private PriorityQueue<Task> tasks;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("**").append(listName).append("**\n");
        for (Task task : tasks) {
            builder.append(task).append("\n");
        }

        return builder.toString();
    }
}
