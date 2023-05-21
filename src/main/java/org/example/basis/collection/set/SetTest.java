package org.example.basis.collection.set;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        List<Message> received = Arrays.asList(
            new Message(1, "Hello!"),
            new Message(2, "发工资了吗？"),
            new Message(2, "发工资了吗？"),
            new Message(3, "去哪吃饭？"),
            new Message(3, "去哪吃饭？"),
            new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> set = new TreeSet<>((m1,m2)-> m1.sequence - m2.sequence);
        set.addAll(received);
        return new ArrayList<>(set);

    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

}