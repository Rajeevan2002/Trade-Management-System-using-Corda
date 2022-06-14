package com.bootcamp.contracts;

import com.bootcamp.states.PaymentState;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;

public class PaymentContract implements Contract{
    public static String ID = "com.bootcamp.contracts.PaymentContract";


    public void verify(LedgerTransaction tx) throws IllegalArgumentException
    {
        if(tx.getInputStates().size()!=0)
        {
            throw new IllegalArgumentException("Zero Inputs");
        }
        if(tx.getOutputStates().size()!=1)
            throw new IllegalArgumentException("One ouTpuT ExpecTed");

        if(tx.getCommands().size()!=1)
            throw new IllegalArgumentException("one command Expected");
        if(!(tx.getOutput(0) instanceof PaymentState))
            throw new IllegalArgumentException("Payment State Expected");
        if(!(tx.getCommand(0).getValue() instanceof Commands.Issue))
            throw new IllegalArgumentException("Issue Command Expected");

        PaymentState paymentState= (PaymentState) tx.getOutput(0);
        if(!(paymentState.getAmount()>0))
            throw new IllegalArgumentException("Positive Amount Required");

        if(!(tx.getCommand(0).getSigners().contains(paymentState.getSender().getOwningKey())))
            throw new IllegalArgumentException("Sender Signature Received");


    }


    public interface Commands extends CommandData {
        class Issue implements Commands { }
    }
}