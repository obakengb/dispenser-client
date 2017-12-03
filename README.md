# dispenser-client

I have uploaded the client and server war snapshots 

There war files can be both deployed on the same wildfly or Jboss EAP server. There are no external resource dependencies (e.g. db dependencies), so the deployment should be smooth

Once deployed, the client is available on http://localhost:8080/dispenser-client/pages/login.xhtml

Username is, fnbconnect. Password is, connectfnb

After entering correct credentials, the system will navigate to the dispensing page. Select a product, and an amont, and the denominations will be displayed

Clicking "Get Change" will make a rest call to the server to get the denominations
