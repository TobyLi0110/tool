package com.nan.thread.Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

    private List<String> buffer;

    private Exchanger<List<String>> exchange;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchange) {
        super();
        this.buffer = buffer;
        this.exchange = exchange;
    }


    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);
            try {
                buffer = exchange.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + buffer.size());
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }

    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<String>();
        List<String> buffer2 = new ArrayList<String>();

        Exchanger<List<String>> exchange = new Exchanger<List<String>>();

        Producer producer = new Producer(buffer1, exchange);
        Consumer consumer = new Consumer(buffer2, exchange);

        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();
    }

}
