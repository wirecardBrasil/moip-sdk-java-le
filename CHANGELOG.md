<a name="v4.1.1"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v4.1.0...v4.1.1) (2018-03-02)


### Bug Fixes

* **Client**: fix a bug in method `doRequest()` ([]())


<a name="v4.1.0"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v4.0.0...v4.1.0) (2018-02-27)


### Features

* **Payment**: adds `getEscrowId()` and `getEscrow()` methods ([e51d6cc](https://github.com/moip/moip-sdk-java/commits/e51d6cc))
* **Entry**: adds entry feature and your own resources ([8cdb098](https://github.com/moip/moip-sdk-java/commits/8cdb098))
* **Balances**: adds feature to get Moip Account's Balances ([ff6f41b](https://github.com/moip/moip-sdk-java/commits/ff6f41b))
* **Refund**: adds list order refunds and payment refunds ([b3a0844](https://github.com/moip/moip-sdk-java/commits/b3a0844))

### Refactor

* **Client**:
  * adds a new get with new header ([41edb85](https://github.com/moip/moip-sdk-java/commits/41edb85))
  * adjust Accept values ([3fe45c7](https://github.com/moip/moip-sdk-java/commits/3fe45c7))
* **API**: fix imports ([817eae6](https://github.com/moip/moip-sdk-java/commits/817eae6))
* **Payment**: adds statementDescriptor ([15ff550](https://github.com/moip/moip-sdk-java/commits/15ff550))
* **RefundAPI**: change condition of `list()` method ([55ff9d0](https://github.com/moip/moip-sdk-java/commits/55ff9d0))
* **Order**: add missing response elements ([b8ba4bc](https://github.com/moip/moip-sdk-java/commits/b8ba4bc))

### Tests

* **Balances**: adds tests to balances ([4c8e251](https://github.com/moip/moip-sdk-java/commits/4c8e251))
* **Payment**/**Multipayment**: add tests to statement descriptor ([03d8f4f](https://github.com/moip/moip-sdk-java/commits/03d8f4f))
* **Refund**: adds tests to list refunds ([080fd10](https://github.com/moip/moip-sdk-java/commits/080fd10))
* **Order**: adds tests to cover all response attributes ([c47071f](https://github.com/moip/moip-sdk-java/commits/c47071f))


<a name="v4.0.0"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v3.4.0...v3.5.0) (2017-12-05)


### Features

* **Account:** added return accessToken and setPassword ([a078943](https://github.com/moip/moip-sdk-java/commits/a078943))
* **Account:** created AccountLinks class and added some account creation tests ([1e5632b](https://github.com/moip/moip-sdk-java/commits/1e5632b))
* **Order:** return checkout preferences and checkout links ([26e96de](https://github.com/moip/moip-sdk-java/commits/26e96de))
* **Order:** create alternatives methods to get the checkout links and add some tests ([d9b17ce](https://github.com/moip/moip-sdk-java/commits/a078943))
* **Transfer:** adds create and revert a transfer ([1f9357a](https://github.com/moip/moip-sdk-java/commits/1f9357a))
* **Transfer:** adds MoipAccountRequest, fix some parameters and fix Transfer examples ([5f274c5](https://github.com/moip/moip-sdk-java/commits/5f274c5))
* **Multipayment** adds Checkout instance to MultipaymentLinks ([dad95a2](https://github.com/moip/moip-sdk-java/commits/dad95a2))

### Refactor

* **Order:** fixed parameter `addiction` to `addition` ([42a08c3](https://github.com/moip/moip-sdk-java/commits/42a08c3))


<a name="v3.4.0"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v3.3.0...v3.4.0) (2017-11-08)


### Features

* **Order:** adding OrderStatus to Order object ([71a42d8](https://github.com/moip/moip-sdk-java/commit/71a42d8))
* **CreditCardRequest:** Add id property, getter and setter ([bb59c12](https://github.com/moip/moip-sdk-java/commit/bb59c12))
* **Amount:** Added fees, refunds, liquid, currency properties and getters for them ([e90fce0](https://github.com/moip/moip-sdk-java/commit/e90fce0))
* **BankAccount** Add method to delete a bank account. ([113ff51](https://github.com/moip/moip-sdk-java/commit/113ff51))
* **BankAccount** Add method to update a bank account. ([b99fd12](https://github.com/moip/moip-sdk-java/commit/b99fd12))


<a name="v3.3.0"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v3.2.0...v3.3.0) (2017-10-10)


### Features

* **Multipayment:** Added method 'cancelPreAuthorized' to cancel pre authorized payments ([be2fc6c](https://github.com/moip/moip-sdk-java/commit/be2fc6c))
* **Multipayment:** Added method 'capture' ([0a634c3](https://github.com/moip/moip-sdk-java/commit/0a634c3))
* **Order:** added method to get an order list ([8602c59](https://github.com/moip/moip-sdk-java/commit/8602c59))



<a name="v3.2.0"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v3.1.0...v3.2.0) (2017-09-28)

### Features

* **BankAccount:** Added accountCheckNumber property to BankAccount([8ab448b](https://github.com/moip/moip-sdk-java/commit/8ab448b))


<a name="v3.1.0"></a>
# [](https://github.com/moip/moip-sdk-java/compare/v3.0.0...v3.1.0) (2017-09-18)


### Bug Fixes

* **ConnectAPI:** Fix a bug in method to generate authorize URL ([851aa2a](https://github.com/moip/moip-sdk-java/commit/851aa2a))

### Features

* Create structure to HATEOAS links in Payment and fix toString methods to some Link Resources ([cf6c46f](https://github.com/moip/moip-sdk-java/commit/cf6c46f))


<a name="v3.0.0"></a>
# [3.0.0](https://github.com/moip/moip-sdk-java/compare/v2.0.0-RC6...v3.0.0) (2017-09-11)


### Bug Fixes

* **Client:** Adding charset UTF-8 to request ([2c4a2e0](https://github.com/moip/moip-sdk-java/commit/2c4a2e0))


### Features

* **Account:** Adding method to create account and to check if it exists ([81522d4](https://github.com/moip/moip-sdk-java/commit/81522d4))
* **API:** Add factories to new resources ([2f06486](https://github.com/moip/moip-sdk-java/commit/2f06486))
* **Client:** Changing method to send http request with content type x-www-form-urlencoded ([5c47570](https://github.com/moip/moip-sdk-java/commit/5c47570))
* **Connect:** Adding method to generate OAuth token ([6ee455c](https://github.com/moip/moip-sdk-java/commit/6ee455c))
* **Connect:** Adding methods to refresh OAuth Token ([5601b92](https://github.com/moip/moip-sdk-java/commit/5601b92))
* **ConnectAPI:** Adding method to request permissions to a Moip user ([2850a4d](https://github.com/moip/moip-sdk-java/commit/2850a4d))
* **Escrow:** Adding payment with escrow and method to release escrow ([bea4a97](https://github.com/moip/moip-sdk-java/commit/bea4a97))
* **Multiorder:** Adding method to create multiorder ([d68b4ed](https://github.com/moip/moip-sdk-java/commit/d68b4ed))
* **Multiorder:** Adding method to get multiorder ([24c3726](https://github.com/moip/moip-sdk-java/commit/24c3726))
* **Multipayment:** Adding method to create multipayment ([f46d6af](https://github.com/moip/moip-sdk-java/commit/f46d6af))
* **Multipayment:** Adding method to get a multipayment ([c5be232](https://github.com/moip/moip-sdk-java/commit/c5be232))
* **NotificationPreference:** Add method to delete a notification preference ([a16aa50](https://github.com/moip/moip-sdk-java/commit/a16aa50))
* **NotificationPreference:** Adding method to create notification preference ([b75a162](https://github.com/moip/moip-sdk-java/commit/b75a162))
* **NotificationPreference:** Adding method to get a notification preference ([ce90b0c](https://github.com/moip/moip-sdk-java/commit/ce90b0c))
* **NotificationPreferences:** Add method to list notification preferences ([a511ef2](https://github.com/moip/moip-sdk-java/commit/a511ef2))
* **Order:** Create structure to HATEOAS and get links from Order ([ad0e759](https://github.com/moip/moip-sdk-java/commit/ad0e759))
* **OrderRequest:** Adding 'amount' to OrderRequest ([beeb8db](https://github.com/moip/moip-sdk-java/commit/beeb8db))
* **Payment:** Added online bank debit payment ([59c05e0](https://github.com/moip/moip-sdk-java/commit/59c05e0))
* **Payment:** Adding get and capture methods to payment ([dbd8a7d](https://github.com/moip/moip-sdk-java/commit/dbd8a7d))
* **Payment:** Allow cancel a pre-authorized payment ([3df780d](https://github.com/moip/moip-sdk-java/commit/3df780d))
* **Payment:** Allow PCI payments ([71a11e9](https://github.com/moip/moip-sdk-java/commit/71a11e9))
* **Payment:** Create delayCapture attribute in Payment ([c9fc27d](https://github.com/moip/moip-sdk-java/commit/c9fc27d))
* **Refund:** Creating method to get a refund ([7d2c9df](https://github.com/moip/moip-sdk-java/commit/7d2c9df))
* **Refund:** Creating refund methods to order and payment ([2003276](https://github.com/moip/moip-sdk-java/commit/2003276))
* Add refund method to API and update docs ([5d1ae87](https://github.com/moip/moip-sdk-java/commit/5d1ae87))


## BREAKING CHANGES
The class `UnexpectecException` was renamed to `UnexpectedException`. Update your handlers accordingly.