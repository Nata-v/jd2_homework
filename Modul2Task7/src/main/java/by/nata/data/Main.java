package by.nata.data;

import by.nata.entity.Expense;
import by.nata.entity.Receiver;

import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        Dao dao = ListExpensesDaoImpl.getINSTANCE();

        System.out.println("Получение получателя по id: ");

        Receiver receiver = dao.getReceiver(2);
        System.out.println("Receiver: " + receiver.getId() + " " + receiver.getName());

        System.out.println("Получение всех получателей: ");

        ArrayList<Receiver> receivers = dao.getReceivers();
        for (Receiver r : receivers) {
            System.out.println("Receiver: " + r.getId() + " " + r.getName());
        }


        System.out.println("Получение расхода по id: ");
        Expense expense = dao.getExpense(1);
        System.out.println("Expense: " + expense.getId() + " " + expense.getPaymentDate() + " " + expense.getReceiverId() + " " + expense.getAmount());


        System.out.println("Получение всех расходов: ");
        ArrayList<Expense> expenses = dao.getExpenses();
        for (Expense e : expenses) {
            System.out.println("Expense: " + e.getId() + " " + e.getPaymentDate() + " " + e.getReceiverId() + " " + e.getAmount());
        }
        System.out.println("Добавления получателя: ");

        Receiver newReceiver = new Receiver(5, "SAT-TV");
        int newReceiverId = dao.addReceiver(newReceiver);
        System.out.println("New Receiver ID: " + newReceiverId);


        System.out.println("Добавление нового расхода: ");

        Expense newExpense = new Expense(6, "2024-01-23", newReceiverId, 50000.00);
        int newExpenseId = dao.addExpense(newExpense);
        System.out.println("New Expense ID: " + newExpenseId);
    }

    }
