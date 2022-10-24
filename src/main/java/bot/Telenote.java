package bot;

import bot.commands.Command;
import bot.commands.StartCommand;
import bot.commands.UnknownCommand;
import bot.entity.TaskList;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Telenote extends TelegramLongPollingBot {

    private final String START_COMMAND = "/start";
    private final Map<Long, List<TaskList>> data;

    public Telenote() {
        super();
        data = new HashMap<>();
    }

    @Override
    public String getBotUsername() {
        return App.getBotName();
    }

    @Override
    public String getBotToken() {
        return App.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            Command command = null;

            if (START_COMMAND.equals(update.getMessage().getText())) {
                command = new StartCommand(update.getMessage(), this, data);
            }

            if (command != null) {
                command.run();
            } else {
                new UnknownCommand(update.getMessage(), this, data).run();
            }
        }
    }
}
