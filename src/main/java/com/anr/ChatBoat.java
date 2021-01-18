package com.anr;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChatBoat extends TelegramLongPollingBot {

   public String  msg = "Hello from Ashwarth Reddy";

    @Override
    public String getBotToken() {
        return "1547674237:AAFd2mY7yuNGccXggonfjd-4xvDI8M90EbQ";
    }

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println("messge recevied "+update.getMessage().getText());
        System.out.println("messge recevied "+update);

        sendMsg(String.valueOf(update.getMessage().getChatId()), msg);
        System.out.println("message send :" + update.getMessage().getChatId());



    }

    @Override
    public String getBotUsername() {
        return "Ashwarth Reddy ";
    }

    /**
     * Method for creating a message and sending it.
     * @param chatId chat id
     * @param s The String that you want to send as a message.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("exception while response thor user");
        }


    }
}
