# Hvat er Folk Java API
Folk Java API er eitt savnsforrit til vevtænastur í [Fólkayvirlitsskipanini](http://us.fo/Default.aspx?ID=13792) hjá [Umhvørvisstovuni](http://us.fo). Hesar vevtænastur eru tøkar umvegis [Heldina](https://www.talgildu.fo/heldin/heldin/).

Endamálið við Folk Java API er at tað skal verða skjótt og lætt hjá virkjum og stovnum at brúka hesar vevtænastur í egnum kt-skipanum, uttan at skula hugsa um vevtænastur og Heldina.

Vevtænasturnar eru býttar sundur í einfaldar tænastur og meira samansettar tænastur. Tær einføldu eru ætlaðaðar til smærri brúkarar, ið bert hava tørv á, ella heimild til, avmarkaða atgongd. Í fystu útgávuni eru bara tær einfaldu vevtænasturnar við.

:exclamation: Allar persónsupplýsingar her á síðuni eru tilgjørdar royndarupplýsingar frá [Umhvørvisstovuni](http://us.fo)!

# Kom í gongd

## Fortreytir
Áðrenn tú kann byrja at brúka Folk Java API skal virkið ella stovnurin [knýta í Heldina](https://www.talgildu.fo/heldin/knyt-i-heldina/) við at [stovna ein vevtænastubrúkara](https://www.talgildu.fo/heldin/knyt-i-heldina/vevtaenastubrukari/). Í Heldini verður ein vevtænastubrúkari eisini nevndur ein **consumer**.

Dømini her snúgva seg um Java-útgávuna og krevja at tú hevur [Git](https://git-scm.com/) og [Java 11](https://openjdk.java.net/projects/jdk/11/) á telduni.

Ókeypis útgávur av OpenJDK finnast her:
- [AdoptOpenJDK](https://adoptopenjdk.net/)
- [Azul](https://www.azul.com/downloads/zulu/)
- [Amazon](https://aws.amazon.com/corretto/)
- [RedHat](https://developers.redhat.com/products/openjdk/download)

## Tak niður
Koyr hetta frá har ið projekt-faldarin skal stovnast:
```bash
git clone https://github.com/folk-api/folk-v3-api.git
```

## Bygg
[Gradle](https://gradle.org/) verður brúkt at byggja við. Um tørvur er á at byggja Folk Java API fyri seg sjálvt, so koyr hetta frá `folk-v3-java` faldaranum:
```bash
gradlew build
```

## Royndarprojekt
Eitt royndarprojekt við dømun um brúk av [Folk Java API](https://github.com/folk-api/folk-v3-api) er her: [Folk Java API Sample](https://github.com/folk-api/folk-v3-api-sample). Hetta projekt kann væl brúkast, sum byrjanarstøði undir einum nýggjum projekti.

## Dømi
### Klientar
Fyrst verður ein klientur gjørdur. Hesir klientar eru býttir sundur í **Small** og **Medium** eftir brúkarans tørvi. Eitt privat virki kann bara brúka **Small**-útgávuna, ímeðan almennir stovnar kunnu brúka báðar útgávurnar í mun til givin loyvi.

Her er eitt dømi til eitt privat virki:

```java
var client = FolkClient.personSmall("{heldin-consumer-host}", "{heldin-consumer-name}");
```

Her er eitt dømi til ein almennan stovn:
```java
var client = FolkClient.personMedium("{heldin-consumer-host}", "{heldin-consumer-name}");
```

Hattar var tað - klienturin er klárur at brúka!

### Leita eftir persónum
Tá ið leitað veråur eftir persónum er tað klienturin, sum avgerð slagið á persóninum, ið brúkarin fær aftur.
Ein **Small**-klientur gevur `PersonSmall` og ein **Medium**-klientur `PersonMedium`.

Her verður leitað eftir einum persóni við P-tali:
```java
var person = client.getPerson(Ptal.of("300408559"));
// or
var person = client.getPerson(Ptal.of("300408-559"));
```

Soleiðis ber til at leita eftir einum persóni við navni og bústaði:
```java
var person = client.getPerson(
    NameParam.of("Karius", "Davidsen"),
    AddressParam.of("Úti í Bø", HouseNumber.of(16), "Syðrugøta")
    );
```

Ella við navni og føðingardegi:

```java
var person = client.getPerson(
    NameParam.of("Karius", "Davidsen"),
    LocalDate.of(2008, 4, 30)
    );
```

Almennir stovnar kunnu eisini leita eftir einum persóni við navni og bústaði, sum víst omanfyri.

## Royndarprojekt
Eitt royndarprojekt við dømun um brúk av [Folk Java API](https://github.com/folk-api/folk-v3-api) er her: [Folk Java API Sample](https://github.com/folk-api/folk-v3-api-sample). Hetta projekt kann væl brúkast, sum byrjanarstøði undir einum nýggjum projekti.

# Community
Ein skipanarbrúkari í FOLK hevur atgongd til eina ávísa mongd av persónum í skipanini. Hetta uppbýti er skipað í trý sløg soleiðis:
 - **All** - allir persónar í skipanini
 - **Municipality** - allir persónar í ávísari kommunu
 - **Ids** - ein partmongd av persónum, sum er umsitin av brúkaranum

Allmennir brúkarar eru vanliga av sløgunum **All** ella **Municipality**, meðan privat virki hava brúkarar av slagnum **Ids**.
Brúkarar av slagnum **Ids**, hava atgongd til nakrar serligar funkur til at umsita eina partmongd av persónum. Ein sovorin partmongd vil vanliga umboða eina virkiskundaskrá.

## Klientar
Sum áður so verður fyrst ein klientur gjørdur. Her er munur á klientinum eftir brúkaraslagi.

Her er eitt dømi til ein brúkara av slagnum **Ids**:

```java
var client = FolkClient.privateCommunity("{heldin-consumer-host}", "{heldin-consumer-name}");
```

Her er eitt dømi til ein brúkara av slagnum **All** ella **Municipality**:
```java
var client = FolkClient.publicCommunity("{heldin-consumer-host}", "{heldin-consumer-name}");
```

## Stovna persón
Bara brúkarar av slagnum **Ids** kunnu stovna persónar í sína egnu partmongd.
Fyri at stovna ein persón, verður ein leiting gjørd. Um júst ein persónur verður funnin,
so verður hann stovnaður. Eitt svar við einum `communityPerson` kemur altíð aftur,
sum hevur fleiri upplýsingar um úrslitið.

Tað er eitt gott hugskot, at royna [Folk Java API Sample](https://github.com/folk-api/folk-v3-api-sample)
fyri at síggja hvussu hetta hongur saman.

Við navni og bústaði:

```java
var communityPerson = client.addPersonToCommunity(
    NameParam.of("Karius", "Davidsen"),
    AddressParam.of("Úti í Bø", HouseNumber.of(16), "Syðrugøta")
    );
```

Ella navni og føðingardegi:

```java
var communityPerson = client.addPersonToCommunity(
    NameParam.of("Karius", "Davidsen"),
    LocalDate.of(2008, 4, 30)
    );
```

Tá ið ein persónur verður stovnaður kemur m.a. ein eyðmerking aftur av slagnum `PrivateId` í fyrr nevnda `communityPerson`.
Henda eymerking er serstøk fyri hvønn brúkara og verður brúkt til at leita eftir persónum og at strika persónar við.

## Strika persónar
Strika ein í senn:
```java
var removedId = client.removePersonFromCommunity(
    PrivateId.of(123)
    );
```
Um persónurin var funnin og strikaður, so kemur `PrivateId` `123` aftur, annars `null`.

Strika fleiri í senn:
```java
var removedId = client.removePersonsFromCommunity(
    PrivateId.list(123, 234, 345)
    );
```

Ein listi av `PrivateId` `123` hjá funnum og strikaðum persónum kemur aftur.

# Eyðmerking av persónum
Allir persónar í skipanini hava eina eyðmerking av slagnum `PublicId`.
Tað eru bara brúkarar av slagnum **All** ella **Municipality**, sum kunnu brúka og fáa hesa eyðmerking, og bara um loyvi er givið til tess.
Persónar sum eru stovnaðir av einum brúkara av slagnum **Ids** fáa harumframt eina eyðmerking av slagnum `PrivateId`.

Hesar eyðmerkingar kunnu eisini brúkast til at leita eftir einum persóni við:
```java
var person = client.getPerson(
    PrivateId.of(123)
    );
// or
var person = client.getPerson(
    PublicId.of(123)
    );
```

Slagið `PersonSmall` kann bara hava `PrivateId`, meðan `PersonMedium` kann hava antin `PrivateId` ella `PublicId` í mun til brúkaraslag og loyvi.
