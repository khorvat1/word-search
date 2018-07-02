# word-search

## tehnologije:
postgresql 10 <br/>
maven 3.5.4 <br/>
java 10.0.1 <br/>
tomcat 8.5.32 <br/>

## pokretanje
Klonirati projekt s githuba
Instalirati potrebne verzije softvera (gore navedene)
Otvoriti projekt u IDE-u kao maven projekt
Napraviti maven update

Izvršiti databse skripte iz ws-database 
1. db/word_search.sql
2. model/db_objects.sql

Provjeriti postavke baze u jdbc.properties
Buildati aplikaciju
Pokrenuti aplikaciju na tomcatu 8.5.5 ili novijem -> za starije verzije treba dodatvati spring-instrument zbog load time weavinga
Provjeriti context-path projekta u IDE-u, podešeno je za eclipse da se postavlja za /


## Primjer korištenja
Dovoljno je u pregledniku pokrenuti naredbu http://localhost:8080/rest/score?term=test
Rezultat se vraća u JSON obliku {"term":"test","score":"0.33"}
