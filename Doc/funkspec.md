# Mobile Measurement funkcióspecifikáció

## 1. Jelenlegi helyzet
A megrendelőnk egy bútorfuvarozással foglalkozó cég, akik kicsit modernizálni szeretnék a munkafolyamataikat az új technológiai vívmányok felhasználásával. A megrendelővel való konzultáció során kiderült, hogy jelenleg a távolságot hagyományos eszközökkel mérik (vonalzó, mérőszalag). 

A megrendelő jó ötletnek tartotta, hogy modernizáljunk kicsit ezen a folyamaton azzal, hogy a kijáró kollégáik mobiltelefonjaira egy alkalmazást telepítsünk.

Ezzel a lépéssel egy eszközre cserélnék az eddig használt korábbi eszközöket és anyagi ráfordítást is csak addig jelent, ameddig az alkalmazást fejlesztjük, utána külön ráfordítást nem igényel, hiszen minden munkatársuknak van okostelefonja.

## 2. Vágyott rendszer
A mérések során a mérni kívánt távolságot a mobiltelefon szenzoraival végezzük. A távolságot a mobil elmozdításával tudják mérni (a kezdőponttól a végpontik kell elmozdítani a telefont).

Különböző távolságok mérése egészen 5 méterig.

Az alkalmazás egyszerű használata, könnyű telepíthetősége.

Kizárólag Android operációs rendszeren működő, Android 6.0 verzióig (Marshmallow) visszanyúló támogatás.

Függőleges és vízszintes irányú mérések is legyenek végrehajthatóak.

A mérések legyenek eltárolva vagy helyileg vagy egy szerveren.

## 3. Jelenlegi üzleti folyamatok
* 3.1 Vonalzók, mérőszallagok, méterbotok beszerzése és pótlása éves szinten
* 3.2 Az adott bútor méretének mintavételezése:
     * 3.2.1 A bútor több szemszögből történő lemérése
     * 3.2.2 A kapott méretek azonos mértékegységekbe való átváltása.
* 3.3 A megfelelő tároló eszköz kiválasztása
* 3.4 A szállító eszköz rakterének a lemérése, hogy a bútor valóban befér-e
* 3.5 A bútor megrendelőhöz való elszállítása
* 3.6 A bútor átadása.


## 4. Igényelt üzleti folyamatok
* 4.1 A szoftver telepítése a munkások készülékére ami lehet a saját vagy a cég által biztosított készülék.
* 4.2 A szoftver működésének elmagyarázása a dolgozoknak.
* 4.3 A szoftver mükédésének bemutatása a gyakroltaban
* 4.4 Az adott bútor méretének mintavételezése:
* 4.5 A bútor több szemszögből történő lemérése
* 4.6 A megfelelő tároló eszköz kiválasztása
* 4.7 A szállító eszköz rakterének a lemérése, hogy a bútor valóban befér-e
* 4.8 A bútor megrendelőhöz való elszállítása
* 4.8 A bútor átadása.

## 5. A rendszerre vonatkozó szabályok

* Az alkalmazás működjön Android telefonokon (legalább Android 6.0 és fölötte)
* A mérésekből több típust hajtsunk végre, ami megnyílvánul a távolság, orientáció, szög és a mintavételezés gyakoriságának változásában is.
* A méréseknél a gravitációs gyorsulás kiszűréséhez használjunk Kálmán-szűrőt vagy lassú szűrőt.
* A méréseket tároljuk el offline vagy online módon.
     * Offline tárolás esetén mentsük el egy CSV fájlba a méréseket az adataival együtt. Ezt később manuálisan vagy automatizálva töltsük fel egy adatbázisba.
     * Online tárolás esetén töltsük fel egy adatbázisba a mérések eredményeit.
* A mérések legyenek beazonosíthatók valami alapján, csv esetén a telefon azonosítójával/típusával, dátumával és esetleges megnevezésével a mérésnek.
* Több telefonon is teszteljük a méréseket, amelyek alapján megfigyelhetjük az egyes telefonok pontosságát egyes területeken elvégzett mérésekkel. (Esetleg az adatok összességén egy statisztikát fogunk létrehozni az adatok vizualizálásával.)

## 6. Követelménylista

| ID | Név | Kifejtés|
| :-: | :-- | :-- |
| K01 | Android rendszer | Egyenlőre Android operációs rendszerre készül el a program, várhatóan Android 6.0 (Marshmallow) verzióig visszamenőleg lesz kompatibilis az alkalmazás |
| K02 | Telefon azonosítása | Az elvégzett mérések eltárolásához szükséges, hogy valami alapján be tudjuk azonosítani azt, hogy melyik telefonon lett elvégezve a mérés|
| K03 | Mérések tárolása offline | Ha nincs internet elérés, akkor tárolja el az alkalmazás az eddigi méréseket egy CSV állományba. Ezt vagy manuálisan feltöltjük az adatbázisba később, vagy automatizáljuk.|
| K04 | Mérések tárolása online | Ha van internetelérés és megvalósítjuk az adatbázist hozzá, akkor az alkalmazás töltse fel az eddig elvégzett méréseket az adatbázisba. |
| K05 | Adatbázis normalizálása | Ha adatbázist használunk, akkor legalább 3. normálformába hozzuk. |
| K06 | Mérések részletei | Az alkalmazásba az elvégzett mérésekhez több infót is el kell tárolni az adatbázisba, ezeket ideális lenne egy listából kiválasztani vagy valami más interaktív módon a felhasználónak. |
| K07 | Mérés nagysága | A felhasználó kiválasztja, hogy mekkora mérést végez el. Ez lehet 40 centiméter, 1 méter, 2 méter, 5 méter. |
| K08 | Mintavételezés gyakorisága | A felhasználó kiválasztja, hogy milyen mintavételezési gyakoriságot akar használni az adott mérés során. Ez akár lehet 10 Hz, 1 MHz, 1 KHz. (Például rövid távolságon nagy mintavételezés, de nagy távolságon akár kisebb mintavételezési gyakoriság)  |
| K09 | Telefon orientációja | Fel kell készíteni az alkalmazást, hogy tudjon a telefon síkba és állítva is tudjon mérni viszonylag pontosan a telefon. |
| K10 | Telefon szöge | Nézzük meg, hogy melyik pontosabb az adott telefonon, hogyha egy síkon más-más szögbe mérjük meg a távolságot. |
| K11 | Szűrők alkalmazása | A gravitációs gyorsulás kiszűréséhez használjunk kálmán szűrőt a mérések eredményéhez. |
| K12 | Tesztelés | Az alkalmazást tesztelni kell több telefonon is, mindegyik méréssel és mintavételezési gyakorisággal is, több orientációban. Ezeket egy adatbázisban összegyűjtük. Mindegyik telefonon körülbelül 3-5 mérést végezzünk el! |

## 7. Használati esetek


## 8. Képernyőtervek
Az alap kinézete az alkalmazásunknak:


![Képernyőterv az alkalmazásról](./Pictures/SABLONtelefon.png)

A menü gomb megnyomása után hasonló eredményt kapunk majd:


![Képernyőterv az alkalmazásról](./Pictures/hamburger_menu.png)


Az alkalmazás tárolni fogja a mérési eredményeket, ezeket külön menüpontban érhetjük majd el:


![Képernyőterv az alkalmazásról](./Pictures/previous_measures.png)

GitHub elérése a [képeknek](https://github.com/HPeti/SZFM_2021_10_TeamBFK_Mobile_Measurement/tree/master/Doc/Pictures).

## 9. Forgatókönyvek


## 10. Fogalomszótár
