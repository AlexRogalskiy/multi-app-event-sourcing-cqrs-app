package com.progressivecoder.accountsservice.aggregates;

import com.progressivecoder.accountsservice.commands.CreateAccountCommand;
import com.progressivecoder.accountsservice.commands.CreditMoneyCommand;
import com.progressivecoder.accountsservice.commands.DebitMoneyCommand;
import com.progressivecoder.accountsservice.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class Account {

    @AggregateIdentifier
    private String id;

    private BigDecimal accountBalance;

    private String currency;

    private String status;

    public Account() {
    }

    @CommandHandler
    public Account(CreateAccountCommand createAccountCommand){
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance, createAccountCommand.currency));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent){
        this.id = accountCreatedEvent.id;
        this.accountBalance = accountCreatedEvent.accountBalance;
        this.currency = accountCreatedEvent.currency;
        this.status = "CREATED";
    }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent){
        this.status = String.valueOf(accountActivatedEvent.status);
    }

    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand){
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount, creditMoneyCommand.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent){

        if (this.accountBalance.doubleValue() < 0 & (this.accountBalance.doubleValue() + moneyCreditedEvent.creditAmount.doubleValue()) >= 0){
            AggregateLifecycle.apply(new AccountActivatedEvent(this.id, "ACTIVATED"));
        }

        this.accountBalance = BigDecimal.valueOf(this.accountBalance.doubleValue() + moneyCreditedEvent.creditAmount.doubleValue());
    }

    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand){
        AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent){

        if (this.accountBalance.doubleValue() >= 0 & (this.accountBalance.doubleValue() - moneyDebitedEvent.debitAmount.doubleValue()) < 0){
            AggregateLifecycle.apply(new AccountHeldEvent(this.id, "HOLD"));
        }

        this.accountBalance = BigDecimal.valueOf(this.accountBalance.doubleValue() - moneyDebitedEvent.debitAmount.doubleValue());

    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent){
        this.status = String.valueOf(accountHeldEvent.status);
    }

}
