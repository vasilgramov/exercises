package softUni.interview.EventManager.app;

import softUni.interview.EventManager.io.Reader;
import softUni.interview.EventManager.io.Writer;

import java.io.IOException;
import java.text.ParseException;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private CommandManger commandManger;

    public Engine(Writer writer, Reader reader, CommandManger commandManger) {


        this.reader = reader;
        this.writer = writer;
        this.commandManger = commandManger;
    }

    @Override
    public void run() {
        while (true) {
            this.writer.writeLine("For reading all events press: 1");
            this.writer.writeLine("For creating a new event press: 2");
            this.writer.writeLine("For updating a event press: 3");
            this.writer.writeLine("For deleting a event press: 4");

            this.writer.writeLine("For exit: 5");

            this.writer.writeLine("####################################################");

            // TODO: IF USER GIVES US A STRING OR INVALID COMMAND - HANDLE EXCEPTION
            try {
                int command = Integer.parseInt(this.reader.readLine());

                if (this.commandManger.manageCommand(command)) {
                    this.writer.writeLine("Thank you for using our Event Manage System!");
                    return;
                }
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
