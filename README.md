# Ohjelmistotekniikka, harjoitustyö
## Sudoku

Sovelluksella on tarkoitus pelata klassista sudoku peliä. Pelissä on valmiina ratkaistavia pohjia ja peli itse osaa ratkaista pulmat.
Pelissä on paljon keskeneräisiä toimintoja, joita en saanut korjattua. Kurssin päätyttyä pyrin jatkamaan tämän parissa. 
  
## Dokumentaatio

[Vaativuusmäärittely](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/vaativuusmaarittely.md)  

[Käyttöohje](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/kayttoohje.md)  

[Testausdokumentti](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/testaus.md)  

[Työaikakirjanpito](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/tyoaikakirjanpito.md)  

[Arkkitehtuuri](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/arkkitehtuuri.md)  

## Releaset
[Loppupalautus](https://github.com/Pentza/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoiminnot

Ohjelman suoritus
```
mvn compile exec:java -Dexec.mainClass=ui.Main
```

### Testaus

Testit suoritetaan komennolla  

```
mvn test
```

Testikattavuusraportti luodaan komennolla  

```
mvn test jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston target/site/jacoco/index.html  

Javadoc
```
mvn javadoc:javadoc
```
Javadocia voi tarkastella hakemistosta `target/site/apidocs/index.html`

### Suoritettavan jarin generointi

```
mvn package  
```

generoi hakemistoon target suoritettavan jar-tiedoston SudokuSovellus-1.0-SNAPSHOT.jar  

### Checkstyle

Tiedostoon checkstyle.xml määrittelemäs tarkistukset suoritetaan komennolla  

```
mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html
