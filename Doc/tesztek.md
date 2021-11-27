# Tesztelési jegyzőkönyv a számtan gyakorló oldalhoz

Ezeken az eszközönön teszteltük az alkalmazást jelenleg (tesztelés alatt bővítjük a listát!):
* Samsung Galaxy A70 - Android 11 ([HPeti](https://github.com/HPeti))
* Asus Zenfone ZE500KL ([HPeti](https://github.com/HPeti))

## Menü (MainActivity)

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 13:56  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: Menü megjelenése  
**Várt eredmény**:              A menü elemek betöltenek ikonokkal.  
**Kapott eredmény**:            A menü elemek betöltöttek, megfelelő és hozzátartozó ikonokkal &#9989;   

---

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:51 
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: Menü megjelenése   
**Várt eredmény**:              A jelenleg kiválasztott elem külön kiemelve megjelenik a menüben.    
**Kapott eredmény**:            A jelenleg kiválasztott menüpont kiemelve megjelenik, menüváltások esetén megváltozik. &#9989;   

---

## Főoldal (HomeFragment)

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:02  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: Főoldal megjelenése  
**Várt eredmény**:              A főoldal elemei betöltenek, képpel, szöveggel és gombbal.  
**Kapott eredmény**:            A főoldal elemei betöltöttek, megfelelő pozíciókban. &#9989;  

---

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:02  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: Főoldal navigációja  
**Várt eredmény**:              A 'Mérés indítása' gomb átvisz a 'Mérés' oldalra  
**Kapott eredmény**:            A gomb megnyomása után átnavigál az alkalmzás a Mérés menüpontra. &#9989;  

---

## Mérés (MeasureStartFragment, MeasureStopFragment)

---

## Mérési eredmények (ResultsFragment)

---

## Beállítások (OptionsFragment)

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:05  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: Night mode működése  
**Várt eredmény**:              A Night mode kapcsoló átkapcsol világos és sötét téma között
**Kapott eredmény**:            A gomb megnyomása után az applikáció betölti a sötét és világos módot is, miután ráfrissített az alkalmazás kinézetére &#9989;  

---

## Információ (InfoFragment)

---

## Adatbázis tesztelés (databaseFragment)

---

## CSV tesztelés (CsvTestFragment)


**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:51  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: CSV kiírása 
**Várt eredmény**:              Ki tudunk írni egy fájlba tetszőleges szöveget  
**Kapott eredmény**:            A legenerált fájlba kiíródik a beadott tartalom a példamezőkkel együtt. &#9989;  

---

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:54  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: CSV olvasása  
**Várt eredmény**:              Be tudunk olvasn egy fájlból tetszőleges szöveget  
**Kapott eredmény**:            A visszaolvasott fájl tartalma olvasható és megjeleníthető az alkalmazásban. &#9989;  

---

**Tesztelést elvégezte**:       [HPeti](https://github.com/HPeti)  
**App verziója**:               v0.0.3  
**Tesztelés ideje**:            2021. 11. 27. 14:56  
**Telefon modellje**:           Samsung Galaxy A70 (SM-A705FN/DS)  
**Android verziója**:           Android 11 (Honeycomb)  
**Tesztelt komponens leírása**: CSV mentési helye  
**Várt eredmény**:              A generált CSV fájl az \Android\data\hu.unideb.inf.mobilemeasurement\files\csvs\csv_test_output.csv helyen található meg.
**Kapott eredmény**:            A generált fájl megfelelő helyen lett eltárolva. &#9989;  

---