package ru.zss;
import rzp.generics.stack.StackException;

public class Stack<T> implements rzp.generics.stack.Stack {
    private int maxSize;
    private T[] data;
    int c = 0;
    int top = -1;

    public Stack() {
    }

    public void StackException(String message) {
        System.out.println(message);
    }

    public void init(int maxSize) throws StackException {
        if (this.c == 0) {
            this.maxSize = maxSize;
            this.data = (T[])new Object[maxSize];
            ++this.c;
        } else {
            throw new StackException("Инициализация уже прошла");
        }
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.maxSize-2;
    }

    public int size() {
        int j = this.top + 1;
        return j;
    }

    public boolean contains(Object item) {
        ++this.top;

        for(int i = 0; i < this.top; ++i) {
            if (this.data[i].equals(item)) {
                return true;
            }
        }

        return false;
    }

    public Object peek() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Cтек пуст");
        } else {
            return this.data[this.top];
        }
    }

    public Object pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Cтек пуст");
        } else {
            return this.data[this.top--];
        }
    }

    public void push(Object item) throws StackException {
        if (this.isFull()) {
            throw new StackException("Cтек переполнен");
        } else {
            this.data[++this.top] = (T)item;
        }
    }
}
