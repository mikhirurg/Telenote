package bot.commands;

import bot.entity.TaskList;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;

public class UnknownCommand extends Command {
    public UnknownCommand(Message commandMessage, TelegramLongPollingBot bot, Map<Long, List<TaskList>> data) {
        super(commandMessage, bot, data);
    }

    @Override
    public void run() {
        SendMessage message = new SendMessage();
        message.setChatId(getCommandMessage().getChatId().toString());
        message.enableMarkdown(true);
        message.setText(EmojiParser.parseToUnicode(":exclamation: Unknown command :exclamation:"));
        try {
            getBot().execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}