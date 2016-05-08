Selenium test targeting the site www.systembolaget.se
(Netbeans project files included)


Seleniumtestet automatiserar följande steg:
-------------------------------------------

1. Navigera till "http://http://www.systembolaget.se/"
2. I dialogrutan för ålderskontroll, klicka på den högra knappen (20 år eller äldre)
3. Klicka på menyn "Öppettider"
4. Sök efter "Kiruna"
5. Verifiera att det blev en träff på butik med adress "Geologgatan 7 B" 


Obs: När man öppnar Systembolagets hemsida första gången visas en dialogruta där användaren 
bekräftar att hen är minst 20 år gammal. (Ålderskontroll). Om hen svarar ja sparas denna information 
som en cookie. Selenium webdriver verkar däremot inte spara cookies mellan sessionerna, därför
måste det automatiserade testet svara ja på denna fråga varje gång. 
