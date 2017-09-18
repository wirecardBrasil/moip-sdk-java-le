<a name="v3.1.0"></a>
# [](https://github.com/caiogaspar/moip-sdk-java/compare/v3.0.0...v3.1.0) (2017-09-18)


### Bug Fixes

* **ConnectAPI:** Fix a bug in method to generate authorize URL ([851aa2a](https://github.com/caiogaspar/moip-sdk-java/commit/851aa2a))


### Features

* Create structure to HATEOAS links in Payment and fix toString methods to some Link Resources ([cf6c46f](https://github.com/caiogaspar/moip-sdk-java/commit/cf6c46f))



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