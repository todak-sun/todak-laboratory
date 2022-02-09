package io.todak.study.laboratory.cleanarchitecture.application.service.port.in;

import io.todak.study.laboratory.cleanarchitecture.domain.AccountId;
import io.todak.study.laboratory.cleanarchitecture.domain.Money;
import lombok.Getter;

@Getter
public class SendMoneyCommand {

    private final AccountId sourceAccountId;
    private final AccountId targetAccountId;
    private final Money money;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money money){
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
    }

}
