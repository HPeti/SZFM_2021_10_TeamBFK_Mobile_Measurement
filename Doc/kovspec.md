# Mobile Measurement

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


## 4. Igényelt üzleti folyamatok


## 5. A rendszerre vonatkozó szabályok


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