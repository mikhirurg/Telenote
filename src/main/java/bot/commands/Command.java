package bot.commands;

import bot.entity.TaskList;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;
import java.util.Map;

public class Command implements Runnable {

    private final Message commandMessage;

    private final TelegramLongPollingBot bot;

    private final Map<Long, List<TaskList>> data;

    public Command(Message commandMessage, TelegramLongPollingBot bot, Map<Long, List<TaskList>> data) {
        this.commandMessage = commandMessage;
        this.bot = bot;
        this.data = data;
    }

    public Message getCommandMessage() {
        return commandMessage;
    }

    public TelegramLongPollingBot getBot() {
        return bot;
    }

    public Map<Long, List<TaskList>> getData() {
        return data;
    }

    @Override
    public void run() {

    }
}
