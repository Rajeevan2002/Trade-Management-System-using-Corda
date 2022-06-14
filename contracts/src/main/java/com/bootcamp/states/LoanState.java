package com.bootcamp.states;

import com.bootcamp.contracts.LoanContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
/* Our state, defining a shared fact on the ledger.
 * See src/main/java/examples/ArtState.java for an example. */
@BelongsToContract(LoanContract.class)

public class LoanState implements ContractState
{
    private final Party sender;
    private final Party receiver;
    private final int amount;
    private List<AbstractParty> participants;

    public LoanState(Party sender,Party receiver,int amount)
    {
        this.sender=sender;
        this.receiver=receiver;
        this.amount=amount;

    }

    public int getAmount()
    {
        return amount;
    }

    public Party getReceiver() {
        return receiver;
    }

    public Party getSender() {
        return sender;
    }


    @NotNull
    @Override

    public List<AbstractParty> getParticipants()
    {
        return Arrays.asList(sender,receiver);
    }
}