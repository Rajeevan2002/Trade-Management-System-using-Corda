package com.bootcamp.states;

import com.bootcamp.contracts.TokenContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
/* Our state, defining a shared fact on the ledger.
 * See src/main/java/examples/ArtState.java for an example. */
@BelongsToContract(TokenContract.class)

public class TokenState implements ContractState
{
    private final Party supplier;
    private final Party consumer;
    private final int amount;
    private final String name;
    private final int quantity;

    public TokenState(Party supplier,Party consumer,int amount,String name,int quantity)
    {
        this.supplier=supplier;
        this.consumer=consumer;
        this.amount=amount;
        this.name=name;
        this.quantity=quantity;
    }

    public int getAmount()
    {
        return amount;
    }

    public Party getConsumer() {
        return consumer;
    }

    public Party getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    @NotNull
    @Override

    public List<AbstractParty> getParticipants()
    {
        return Arrays.asList(supplier,consumer);
    }
}