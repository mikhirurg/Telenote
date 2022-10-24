package bot.entity;

import com.vdurmont.emoji.EmojiParser;

import java.time.LocalDateTime;

public class Task {
    private String caption;
    private String body;
    private LocalDateTime deadline;

    @Override
    public String toString() {
        return "**" + caption + "**\n" +
                EmojiParser.parseToUnicode(":clock3: " + deadline.toString()) + "\n" +
                body;
    }
}
