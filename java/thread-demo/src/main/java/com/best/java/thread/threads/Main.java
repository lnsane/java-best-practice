package com.best.java.thread.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<User> task = new FutureTask<User>(new Callabes());
        task.run();
         FutureTask<User> task2 = new FutureTask<User>(new Callabes());
        task2.run();
        System.out.println(task.get());
        System.out.println(task2.get());
    }
}
