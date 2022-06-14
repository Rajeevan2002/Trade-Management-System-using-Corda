package com.bootcamp.contracts;

import com.bootcamp.states.TokenState;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;

public class TokenContract implements Contract{
    public static String ID = "com.bootcamp.contracts.TokenContract";


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
        if(!(tx.getOutput(0) instanceof TokenState))
            throw new IllegalArgumentException("Token State Expected");
        if(!(tx.getCommand(0).getValue() instanceof Commands.Issue))
            throw new IllegalArgumentException("Issue Command Expected");

        TokenState tokenState= (TokenState) tx.getOutput(0);
        if(!(tokenState.getAmount()>0))
            throw new IllegalArgumentException("Positive Amount Required");

        if(!(tx.getCommand(0).getSigners().contains(tokenState.getSupplier().getOwningKey())))
            throw new IllegalArgumentException("Supplier Signature Received");


    }


    public interface Commands extends CommandData {
        class Issue implements Commands { }
    }
}