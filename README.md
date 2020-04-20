# Ohjelmistotekniikka, harjoitustyö
## Sudoku

Sovelluksella on tarkoitus pelata klassista sudoku peliä. Pelissä on valmiina ratkaistavia pohjia ja peli itse osaa ratkaista pulmat.
  
## Dokumentaatio

[Vaativuusmäärittely](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/vaativuusmaarittely.md)  

[Työaikakirjanpito](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/tyoaikakirjanpito.md)  

[Arkkitehtuuri](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/arkkitehtuuri.md)  

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla  

´´´
mvn test
´´´

Testikattavuusraportti luodaan komennolla  

´´´
mvn jacoco:report
´´´

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston target/site/jacoco/index.html  

### Suoritettavan jarin generointi

´´´
mvn package  
´´´

generoi hakemistoon target suoritettavan jar-tiedoston SudokuSovellus-1.0-SNAPSHOT.jar  

### Checkstyle

Tiedostoon checkstyle.xml määrittelemäs tarkistukset suoritetaan komennolla  

´´´
mvn jxr:jxr checkstyle:checkstyle
´´´

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html
