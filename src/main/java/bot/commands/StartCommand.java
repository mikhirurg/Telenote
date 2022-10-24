package bot.commands;

import bot.entity.TaskList;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StartCommand extends Command {

    public StartCommand(Message commandMessage, TelegramLongPollingBot bot, Map<Long, List<TaskList>> data) {
        super(commandMessage, bot, data);
    }

    @Override
    public void run() {
        SendMessage message = new SendMessage();
        message.setChatId(getCommandMessage().getChatId());
        if (!getData().containsKey(getCommandMessage().getChatId())) {
            message.setText("Welcome, newcomer!");
            getData().put(getCommandMessage().getChatId(), new ArrayList<>());
        } else {
            message.setText("Hello, hello! My old friend!");
        }

        try {
            getBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
