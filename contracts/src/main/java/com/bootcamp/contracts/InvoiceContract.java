package com.bootcamp.contracts;

import com.bootcamp.states.InvoiceState;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;

public class InvoiceContract implements Contract{
    public static String ID = "com.bootcamp.contracts.InvoiceContract";


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
        if(!(tx.getOutput(0) instanceof InvoiceState))
            throw new IllegalArgumentException("Invoice State Expected");
        if(!(tx.getCommand(0).getValue() instanceof Commands.Issue))
            throw new IllegalArgumentException("Issue Command Expected");

        InvoiceState invoiceState= (InvoiceState) tx.getOutput(0);
        if(!(invoiceState.getAmount()>0))
            throw new IllegalArgumentException("Positive Amount Required");

        if(!(tx.getCommand(0).getSigners().contains(invoiceState.getSender().getOwningKey())))
            throw new IllegalArgumentException("Sender Signature Received");


    }


    public interface Commands extends CommandData {
        class Issue implements Commands { }
    }
}