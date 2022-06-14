package com.bootcamp.states;

import com.bootcamp.contracts.InvoiceContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
/* Our state, defining a shared fact on the ledger.
 * See src/main/java/examples/ArtState.java for an example. */
@BelongsToContract(InvoiceContract.class)

public class InvoiceState implements ContractState
{
    private Party sender;
    private Party recipient;
    private int amount;
    private List<AbstractParty> participants;


    public InvoiceState(Party sender,Party recipient,int amount)
    {
        this.sender=sender;
        this.recipient=recipient;
        this.amount=amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSender(Party sender) {
        this.sender = sender;
    }

    public void setRecipient(Party recipient) {
        this.recipient = recipient;
    }

    public int getAmount()
    {
        return amount;
    }

    public Party getSender() {
        return sender;
    }

    public Party getRecipient() {
        return recipient;
    }

    @NotNull
    @Override

    public List<AbstractParty> getParticipants()
    {
        return Arrays.asList(sender,recipient);
    }
}