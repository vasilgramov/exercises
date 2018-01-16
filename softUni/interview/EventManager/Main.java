package softUni.interview.EventManager;

import softUni.interview.EventManager.app.CommandManger;
import softUni.interview.EventManager.app.Engine;
import softUni.interview.EventManager.io.ConsoleReader;
import softUni.interview.EventManager.io.ConsoleWriter;
import softUni.interview.EventManager.io.Reader;
import softUni.interview.EventManager.io.Writer;

import java.io.IOException;

import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws ParseException, IOException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        CommandManger commandManger = new CommandManger(writer, reader);

        Runnable engine = new Engine(writer, reader, commandManger);
        engine.run();
    }
}
