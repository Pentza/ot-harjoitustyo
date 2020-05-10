# Käyttöohje

Lataa uusin [tiedosto](https://github.com/Pentza/ot-harjoitustyo/releases/)

## Konfigurointi

Ohjelman käynnistyshakemistossa tulee olla tietokanta [sudoku.db](https://github.com/Pentza/ot-harjoitustyo/releases/download/kesken/sudoku.db), joka sisältää sudoku "tasoja".
Tietokannassa pitäisi olla pelaajan pisteet, mutta toiminnallisuus ei ole vielä valmis. 

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 
```
java -jar Sudoku.jar
```

## Pelaaminen

Ohjelman valikossa on vain nappula `pelaa` ja sen takana vaikeustasot. 
Valitsemalla vaikeustason, hakee ohjelma tietokannasta pelattavan pelin. Huomioi, että tällä hetkellä `hard` sisältää testipelin. 

Pelissä on ajastin, joka tallentaa aikasi tietokantaan, kun toiminnallisuus on valmis.

Painike `solve` ratkaisee pelin puolestasi, jokaisessa pelissä on uniikki ratkaisu. Solve-metodissa on muutamia bugeja. 
`Check` antaa ilmoituksen Confirmation jos peli on oikein ja Message jos väärin. 
`Clear` nappula tyhjentää pelialustan, jopa valmiit annetut numerot. 
`Back` vie sinut takaisin vaikeusastevalikkoon. 
