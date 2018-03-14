package br.com.moip.examples;

import br.com.moip.resource.Balances;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;

public class BalanceExamples {

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
    public void getBalances() {

        Balances balances = api.balance().get();
    }
}
