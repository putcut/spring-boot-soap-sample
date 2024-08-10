# SpringBoot x SOAP
SpringBootでSOAP通信をやってみた。
お米の品種を取得するAPI。

## client
- server側で生成するwsdlを参照しているので、先にserver側を起動する

## server
- 認証機能設定済み (リクエスト要認証)
- サンプルリクエスト
    - `./request-with-authentication.xml` (認証有り)
    - `./request.xml`