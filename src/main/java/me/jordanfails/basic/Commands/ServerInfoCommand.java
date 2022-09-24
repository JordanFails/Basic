package me.jordanfails.basic.Commands;

import lombok.Getter;
import org.bukkit.ChatColor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class ServerInfoCommand {

    private static final ExecutorService EXECUTOR;

    @Getter
    private InetSocketAddress address;

    @Getter
    private final AtomicInteger maximumOnline, currentOnline;

    @Getter
    private final AtomicReference<String> status;

    public ServerInfoCommand(InetSocketAddress address) {
        this.address = address;
        this.maximumOnline = new AtomicInteger();
        this.currentOnline = new AtomicInteger();
        this.status = new AtomicReference<>("OFFLINE");
    }

    @Override
    public String toString() {
        return currentOnline.get() + "/" + maximumOnline.get();
    }

    public void ping(boolean async) {
        Consumer<Runnable> executor = async ? (runnable) -> EXECUTOR.execute(runnable) : Runnable::run;
        executor.accept(() -> {
            try (Socket socket = new Socket(address.getAddress(), address.getPort());
                 DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                 DataInputStream input = new DataInputStream(socket.getInputStream())) {
                output.write(0xFE);
                int next = -1;
                String result = "";
                while ((next = input.read()) != -1) {
                    if (next != 0 && next != 16 && next != 255 && next != 23 && next != 24) {
                        result += (char) next;
                    }
                }
                String[] data = result.split("§");
                String predictedStatus = data[0].toLowerCase().contains("whitelisted")
                        ? ChatColor.YELLOW + "Whitelisted"
                        : ChatColor.GREEN + "Online";
                status.set(predictedStatus);
                currentOnline.set(Integer.valueOf(data[1]));
                maximumOnline.set(Integer.valueOf(data[2]));
            } catch (IOException exception) {
                status.set(ChatColor.RED + "Offline");
            }
        });
    }

    static {
        EXECUTOR = Executors.newFixedThreadPool(2);
    }
}
