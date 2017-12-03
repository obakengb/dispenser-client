# dispenser-client

I have uploaded the client and server war snapshots. The files are roughly 5Mb each
Client -> https://www.datafilehost.com/d/41664a92
Server -> https://www.datafilehost.com/d/46ab5b00

There war files can be both deployed on the same wildfly or Jboss EAP server. They have different context roots, so there won't be a collision. There are also no external resource dependencies (e.g. db dependencies), so the deployments should be smooth

Once deployed, the client is available on http://localhost:8080/dispenser-client/pages/login.xhtml

Username is, fnbconnect. Password is, connectfnb

After entering correct credentials, the system will navigate to the dispensing page. Select a product, and an amont, and the denominations will be displayed

Clicking "Get Change" will make a rest call to the server to get the denominations

Source code is downloadable from

https://github.com/obakengb/dispenser-client.git and
https://github.com/obakengb/dispenser-server.git

Apologies for not including unit tests. I had underestimated the effort of this assessment ;(
