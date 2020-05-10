![Pakkauskaavio](https://github.com/Pentza/ot-harjoitustyo/blob/master/documentation/photos/arkkitehturi)

# Arkkitehtuurikuvaus

## Käyttöliittymä

Käyttöliittymässä on valikko ja pelinäkymä

Käyttöliittymä on eritelty sovelluslogiikasta. 

Käyttöliittymä on toistaiseksi purkkaa. 

## Sovelluslogiikka

Sovelluuslogiikka koostuu luokista Sudoku ja SudokuSolver.  
Sudoku sisältää kaiken pelattavasta sudokusta ja sen toiminnallisuuksista.   
Solver on apuolio, jolla toteutetaan pelin ratkominen. 

Sudoku luokka sisältää muunmuassa metodit:
- setNumber() ja getNumber(), joilla asetetaan tai luetaan tietystä kohtaa numero
- getGrid(), jolla luetaan koko "grid"
- setGridFromDatabase(String difficulty), tällä metodilla haetaan tietokannasta parametrin mukainen peli ja tehdään String muotoisesta numerosarjasta int[][] grid-pelialusta

SudokuSolver sisältää muutaman tärkeän metodin:
- checkRow(), checkColumn() ja checkSubsection(), jolla tarkistetaan onko numero jo tällä rivillä, sarakkeella tai vieressä. 
- isValid(), tarkistaa toteutuuko kaikki yllä olevat tarkistukset
- solve() käy läpi peruuttavalla haulla voiko tietyyn kohtaan laittaa numero. Se käy rekursiivisesti läpi kaikki kohdat ja päätyy ratkaisuun tai "umpikujaan". Umpikujassa  metodi palaa aiempaan ja kokeilee uudella numerolla. Peruuttavaan hakuun perustuva metodi. 



## Tietojen pysyväistallennus

ScoreDao toimintoja ei ole rakennettu, mutta sillä on tarkoitus tallentaa sudokun ratkaisemiseen tarvittu aika paikalliseen tiedostoon. 
LevelDao sisältää toistaiseksi kolme helppoa, kolme keskitasoista ja yhden vaikean sudokun. Huomioi, että vaikea sudoku on testisudoku, sisältäen 80 numeroa. 

