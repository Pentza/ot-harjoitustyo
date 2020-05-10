# Testausdokumentti

Ohjelma sisältää JUnit yksikkötestejä. Ohjelmaa on toki testattu manuaalisin syöttein pelaamalla itse peliä. 

## Testaus

### Sovelluslogiikka

Sovelluslogiikkaa testaa pääsääntöisesti automaattiset yksikkötestit. Testit testaavat suurinta osaa metodeista, mukaanlukien mahdolliset haarautumiset. 

Sekä Solver, että Sudoku luokan testaus sisältää tekaistuja pelipohjia, joihin testit vertaavat tuloksia. 

### DAO-luokat

Dao-luokkia on testattu vain yhden testin verran. 

LevelDao-luokkaa on testattu Hard-vaikeusateen pelialustalla. Testi hakee tietokannasta pelipohjan ja vertaa sitä testissä olevaan pohjaan.
Tämän pitäisi onnistua sillä tietokanta sisältää vain yhden hard pohjan. 

## Järjestelmätestaus

Ohjelmaa on suoritettu manuaalisesti pelkästään Linux-ympäristössä. Ohjelma on haettu useita kertoja github-repositoriosta ja kokeilu toimintoja.
Tämä toki aina vaatii tietokannan olemassaolon käynnistyshakemistossa [käyttöohjeen](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/kayttoohje.md) mukaisesti
