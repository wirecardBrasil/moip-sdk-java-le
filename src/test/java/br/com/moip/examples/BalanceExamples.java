package br.com.moip.examples;

import br.com.moip.resource.Balances;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;

public class BalanceExamples {

    /**
     * The Moip balance is the composition of current values available,
     * unavailable (blocked) and futures, of a Moip Account.
     *
     * This API uses [application/json;version=2.1].
     * For more information, check the fallowing link:
     * https://dev.moip.com.br/v2/reference#saldo-moip-1
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * This method allows you to get all balances of a Moip account.
     * TIP: you can get only the balance you want:
     *      -> unavailable by getUnavailable()
     *      -> future by getFuture()
     *      -> current by getCurrent()
     */
    public void getBalances() {

        Balances balances = api.balance().get();
    }
}
