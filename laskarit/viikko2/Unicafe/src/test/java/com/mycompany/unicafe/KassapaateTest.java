
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(420);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaRahanOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void konstruktoriAsettaaEdullisetLounaatOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void konstruktoriAsettaaMaukkaatLounaatOikein() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKateisellaLisaaKassanSaldoa() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKateisellaVaihtorahaOk() {
        assertEquals(1, kassa.syoEdullisesti(241));
    }
    
    @Test
    public void syoEdullisestiKateisellaKasvattaaMyytyja() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKateisellaEiLisaaKassanSaldoa() {
        kassa.syoEdullisesti(239);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKateisellaEiVaihtorahaOk() {
        assertEquals(239, kassa.syoEdullisesti(239));
    }
    
    @Test
    public void syoEdullisestiKateisellaEiKasvattaaMyytyja() {
        kassa.syoEdullisesti(239);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKateisellaLisaaKassanSaldoa() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKateisellaVaihtorahaOk() {
        assertEquals(1, kassa.syoMaukkaasti(401));
    }
    
    @Test
    public void syoMaukkaastiKateisellaKasvattaaMyytyja() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKateisellaEiLisaaKassanSaldoa() {
        kassa.syoMaukkaasti(239);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKateisellaEiVaihtorahaOk() {
        assertEquals(239, kassa.syoMaukkaasti(239));
    }
    
    @Test
    public void syoMaukkaastiKateisellaEiKasvattaaMyytyja() {
        kassa.syoMaukkaasti(239);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortillaRahaaVeloitetaanEdullisesti() {
        kassa.syoEdullisesti(kortti);
        assertEquals(180, kortti.saldo());
    }
    
    @Test
    public void kortillaRahaaVeloitetaanEdullisestiTrue() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void kortillaRahaaMyydytEdullisetKasvaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortillaEiRahaaEiVeloitetaEdullisesti() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(180, kortti.saldo());
    }
    
    @Test
    public void kortillaEiRahaaEiVeloitetaEdullisestiFalse() {
        kassa.syoEdullisesti(kortti);
        assertEquals(false, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void kortillaEiRahaaMyydytEdullisetKasvaa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortillaRahaaVeloitetaanMaukkaasti() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void kortillaRahaaVeloitetaanMaukkaastiTrue() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kortillaRahaaMyydytMaukkaatKasvaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortillaEiRahaaEiVeloitetaMaukkaasti() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void kortillaEiRahaaEiVeloitetaMaukkaastiFalse() {
        kassa.syoEdullisesti(kortti);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kortillaEiRahaaMyydytMaukkaatasvaa() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanSaldoEiMuutuKortillaOstaessa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausKasvattaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 80);
        assertEquals(500, kortti.saldo());
    }
    
    @Test
    public void kortinLatausKasvattaaKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, 80);
        assertEquals(100080, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausEiNegariivisella() {
        kassa.lataaRahaaKortille(kortti, -80);
        assertEquals(420, kortti.saldo());
    }
}
