package com.example

data class ExampleSentence(val german: String, val english: String)

data class VocabularyWord(
    val german: String,
    val english: String,
    val pronunciation: String,
    val examples: List<ExampleSentence>,
    val systemData: String,
    val level: String = "A1"
)

val a1VocabularyData = listOf(
    // Core Vocabulary
    VocabularyWord("Hallo", "Hello", "HAH-lo", listOf(ExampleSentence("Hallo, wie geht es dir?", "// Hello, how are you? (informal)")), "Type: Interjection | Category: Greetings | IPA: /ˈhalo/", "A1"),
    VocabularyWord("Guten Morgen", "Good morning", "GOO-ten MOR-gen", listOf(ExampleSentence("Guten Morgen, Herr Müller.", "// Good morning, Mr. Müller.")), "Type: Phrase | Category: Greetings | IPA: /ˈɡuːtn̩ ˈmɔʁɡn̩/", "A1"),
    VocabularyWord("Guten Tag", "Good day", "GOO-ten tahk", listOf(ExampleSentence("Guten Tag, was kann ich für Sie tun?", "// Good day, what can I do for you?")), "Type: Phrase | Category: Greetings | IPA: /ˈɡuːtn̩ ˈtaːk/", "A1"),
    VocabularyWord("Tschüss", "Bye", "CHOOS", listOf(ExampleSentence("Tschüss, bis morgen!", "// Bye, see you tomorrow!")), "Type: Interjection | Category: Greetings | IPA: /tʃʏs/", "A1"),
    VocabularyWord("Auf Wiedersehen", "Goodbye", "owf VEE-der-zay-en", listOf(ExampleSentence("Auf Wiedersehen, Frau Schmidt.", "// Goodbye, Mrs. Schmidt.")), "Type: Phrase | Category: Greetings | IPA: /aʊ̯f ˈviːdɐˌzeːən/", "A1"),
    VocabularyWord("Ja", "Yes", "yah", listOf(ExampleSentence("Ja, ich verstehe.", "// Yes, I understand.")), "Type: Adverb | Category: Essentials | IPA: /jaː/", "A1"),
    VocabularyWord("Nein", "No", "nine", listOf(ExampleSentence("Nein, danke.", "// No, thank you.")), "Type: Adverb | Category: Essentials | IPA: /naɪ̯n/", "A1"),
    VocabularyWord("Bitte", "Please / You're welcome", "BIT-teh", listOf(ExampleSentence("Bitte schön!", "// You're welcome!")), "Type: Adverb | Category: Essentials | IPA: /ˈbɪtə/", "A1"),
    VocabularyWord("Danke", "Thank you", "DAHN-keh", listOf(ExampleSentence("Danke für Ihre Hilfe.", "// Thank you for your help.")), "Type: Adverb | Category: Essentials | IPA: /ˈdaŋkə/", "A1"),
    VocabularyWord("Entschuldigung", "Excuse me / Sorry", "ent-SHOOL-dee-goong", listOf(ExampleSentence("Entschuldigung, wo ist der Bahnhof?", "// Excuse me, where is the station?")), "Type: Noun (f) | Category: Essentials | IPA: /ɛntˈʃʊldɪɡʊŋ/", "A1"),

    VocabularyWord("Null", "Zero", "nool", listOf(ExampleSentence("Die Nummer ist null.", "// The number is zero.")), "Type: Number | Category: Numbers | IPA: /nʊl/", "A1"),
    VocabularyWord("Eins", "One", "eyens", listOf(ExampleSentence("Ich habe ein Buch.", "// I have one book.")), "Type: Number | Category: Numbers | IPA: /aɪ̯ns/", "A1"),
    VocabularyWord("Zwei", "Two", "tsveye", listOf(ExampleSentence("Wir sind zu zweit.", "// We are two.")), "Type: Number | Category: Numbers | IPA: /tsvaɪ̯/", "A1"),
    VocabularyWord("Drei", "Three", "drye", listOf(ExampleSentence("Drei Personen.", "// Three people.")), "Type: Number | Category: Numbers | IPA: /dʁaɪ̯/", "A1"),
    VocabularyWord("Zehn", "Ten", "tseyn", listOf(ExampleSentence("Ich habe zehn Euro.", "// I have ten euros.")), "Type: Number | Category: Numbers | IPA: /tseːn/", "A1"),
    VocabularyWord("Hundert", "Hundred", "HOON-dert", listOf(ExampleSentence("Einhundert Tage.", "// One hundred days.")), "Type: Number | Category: Numbers | IPA: /ˈhʊndɐt/", "A1"),
    VocabularyWord("Tausend", "Thousand", "TOW-zent", listOf(ExampleSentence("Eintausend Kilometer.", "// One thousand kilometers.")), "Type: Number | Category: Numbers | IPA: /ˈtaʊ̯zn̩t/", "A1"),
    VocabularyWord("Uhr", "O'clock / Clock", "oor", listOf(ExampleSentence("Es ist zwei Uhr.", "")), "Type: Noun (f) | Category: Time | IPA: /uːɐ̯/", "A1"),
    VocabularyWord("Minute", "Minute", "mi-NOO-teh", listOf(ExampleSentence("Fünf Minuten.", "")), "Type: Noun (f) | Category: Time | IPA: /miˈnuːtə/", "A1"),
    VocabularyWord("Stunde", "Hour", "SHTOON-deh", listOf(ExampleSentence("Eine Stunde lang.", "")), "Type: Noun (f) | Category: Time | IPA: /ˈʃʊndə/", "A1"),

    VocabularyWord("Montag", "Monday", "MON-tahk", listOf(ExampleSentence("Am Montag arbeite ich.", "// On Monday I work.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈmoːntaːk/", "A1"),
    VocabularyWord("Dienstag", "Tuesday", "DEENS-tahk", listOf(ExampleSentence("Dienstag ist frei.", "// Tuesday is off.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈdiːnsˌtaːk/", "A1"),
    VocabularyWord("Mittwoch", "Wednesday", "MIT-vokh", listOf(ExampleSentence("Wir treffen uns am Mittwoch.", "// We meet on Wednesday.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈmɪtˌvɔx/", "A1"),
    VocabularyWord("Donnerstag", "Thursday", "DON-ners-tahk", listOf(ExampleSentence("Donnerstag ist mein Geburtstag.", "// Thursday is my birthday.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈdɔnɐsˌtaːk/", "A1"),
    VocabularyWord("Freitag", "Friday", "FRYE-tahk", listOf(ExampleSentence("Am Freitag feiern wir.", "// On Friday we celebrate.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈfʁaɪ̯ˌtaːk/", "A1"),
    VocabularyWord("Samstag", "Saturday", "ZAMs-tahk", listOf(ExampleSentence("Samstag ist Wochenende.", "// Saturday is the weekend.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈzamsˌtaːk/", "A1"),
    VocabularyWord("Sonntag", "Sunday", "ZON-tahk", listOf(ExampleSentence("Heute ist Sonntag.", "// Today is Sunday.")), "Type: Noun (m) | Category: Calendar | IPA: /ˈzɔnˌtaːk/", "A1"),
    VocabularyWord("Januar", "January", "ya-NOO-ar", listOf(ExampleSentence("Im Januar ist es kalt.", "// In January it is cold.")), "Type: Noun (m) | Category: Months | IPA: /ˈjanuaːɐ̯/", "A1"),
    VocabularyWord("Februar", "February", "FEB-roo-ar", listOf(ExampleSentence("Der Februar ist kurz.", "// February is short.")), "Type: Noun (m) | Category: Months | IPA: /ˈfeːbʁuaːɐ̯/", "A1"),
    VocabularyWord("Frühling", "Spring", "FROO-ling", listOf(ExampleSentence("Der Frühling ist schön.", "// Spring is beautiful.")), "Type: Noun (m) | Category: Seasons | IPA: /ˈfʁyːlɪŋ/", "A1"),
    VocabularyWord("Sommer", "Summer", "ZOM-er", listOf(ExampleSentence("Wir fahren im Sommer in den Urlaub.", "// We go on vacation in the summer.")), "Type: Noun (m) | Category: Seasons | IPA: /ˈzɔmɐ/", "A1"),
    VocabularyWord("Herbst", "Autumn", "hairpst", listOf(ExampleSentence("Im Herbst fallen die Blätter.", "// In autumn the leaves fall.")), "Type: Noun (m) | Category: Seasons | IPA: /hɛʁpst/", "A1"),
    VocabularyWord("Winter", "Winter", "VIN-ter", listOf(ExampleSentence("Es schneit im Winter.", "// It snows in winter.")), "Type: Noun (m) | Category: Seasons | IPA: /ˈvɪntɐ/", "A1"),

    VocabularyWord("Familie", "Family", "fa-MEE-lee-eh", listOf(ExampleSentence("Meine Familie ist groß.", "// My family is big.")), "Type: Noun (f) | Category: Family | IPA: /faˈmiːliə/", "A1"),
    VocabularyWord("Mutter", "Mother", "MOO-ter", listOf(ExampleSentence("Meine Mutter kocht gut.", "// My mother cooks well.")), "Type: Noun (f) | Category: Family | IPA: /ˈmʊtɐ/", "A1"),
    VocabularyWord("Vater", "Father", "FAH-ter", listOf(ExampleSentence("Mein Vater arbeitet viel.", "// My father works a lot.")), "Type: Noun (m) | Category: Family | IPA: /ˈfaːtɐ/", "A1"),
    VocabularyWord("Bruder", "Brother", "BROO-der", listOf(ExampleSentence("Er ist mein Bruder.", "// He is my brother.")), "Type: Noun (m) | Category: Family | IPA: /ˈbʁuːdɐ/", "A1"),
    VocabularyWord("Schwester", "Sister", "SHVES-ter", listOf(ExampleSentence("Meine Schwester studiert.", "// My sister studies.")), "Type: Noun (f) | Category: Family | IPA: /ˈʃvɛstɐ/", "A1"),
    VocabularyWord("Essen", "Food / To eat", "ES-sen", listOf(ExampleSentence("Das Essen ist lecker.", "// The food is tasty.")), "Type: Noun (n)/Verb | Category: Daily Life | IPA: /ˈɛsn̩/", "A1"),
    VocabularyWord("Trinken", "To drink", "TRINK-en", listOf(ExampleSentence("Ich trinke Wasser.", "// I drink water.")), "Type: Verb | Category: Daily Life | IPA: /ˈtʁɪŋkn̩/", "A1"),
    VocabularyWord("Haus", "House", "howss", listOf(ExampleSentence("Das Haus ist alt.", "// The house is old.")), "Type: Noun (n) | Category: Daily Life | IPA: /haʊ̯s/", "A1"),

    VocabularyWord("Der / Die / Das", "The", "dair / dee / dahs", listOf(ExampleSentence("Der Mann, die Frau, das Kind.", "// The man, the woman, the child.")), "Type: Article | Category: Grammar | IPA: /deːɐ̯/ /diː/ /das/", "A1"),
    VocabularyWord("Ein / Eine", "A / An", "eyen / EYEN-eh", listOf(ExampleSentence("Ich habe ein Auto.", "// I have a car.")), "Type: Article | Category: Grammar | IPA: /aɪ̯n/ /ˈaɪ̯nə/", "A1"),
    VocabularyWord("Ich", "I", "ikh", listOf(ExampleSentence("Ich bin müde.", "// I am tired.")), "Type: Pronoun | Category: Grammar | IPA: /ɪç/", "A1"),
    VocabularyWord("Du", "You (informal)", "doo", listOf(ExampleSentence("Bist du fertig?", "// Are you ready?")), "Type: Pronoun | Category: Grammar | IPA: /duː/", "A1"),
    VocabularyWord("Sie", "She / They / You (formal)", "zee", listOf(ExampleSentence("Sie ist nett. / Können Sie mir helfen?", "// She is nice. / Can you help me?")), "Type: Pronoun | Category: Grammar | IPA: /ziː/", "A1"),
    VocabularyWord("Sein", "To be", "zeyen", listOf(ExampleSentence("Ich bin hier.", "// I am here.")), "Type: Verb | Category: Verbs | IPA: /zaɪ̯n/", "A1"),
    VocabularyWord("Haben", "To have", "HAH-ben", listOf(ExampleSentence("Wir haben Zeit.", "// We have time.")), "Type: Verb | Category: Verbs | IPA: /ˈhaːbn̩/", "A1"),
    VocabularyWord("Machen", "To make/do", "MAH-khen", listOf(ExampleSentence("Was machst du?", "// What are you doing?")), "Type: Verb | Category: Verbs | IPA: /ˈmaxn̩/", "A1"),
    VocabularyWord("Gehen", "To go", "GAY-en", listOf(ExampleSentence("Ich gehe nach Hause.", "// I am going home.")), "Type: Verb | Category: Verbs | IPA: /ˈɡeːən/", "A1"),
    VocabularyWord("Wollen", "To want", "VOL-en", listOf(ExampleSentence("Ich will schlafen.", "// I want to sleep.")), "Type: Modal Verb | Category: Verbs | IPA: /ˈvɔlən/", "A1"),
    VocabularyWord("Können", "Can / To be able to", "KER-nen", listOf(ExampleSentence("Kannst du schwimmen?", "// Can you swim?")), "Type: Modal Verb | Category: Verbs | IPA: /ˈkœnən/", "A1"),
    VocabularyWord("Aber", "But", "AH-ber", listOf(ExampleSentence("Ich will, aber ich kann nicht.", "// I want to, but I can't.")), "Type: Conjunction | Category: Grammar | IPA: /ˈaːbɐ/", "A1"),
    VocabularyWord("Und", "And", "oont", listOf(ExampleSentence("Du und ich.", "// You and I.")), "Type: Conjunction | Category: Grammar | IPA: /ʊnt/", "A1"),
    VocabularyWord("Oder", "Or", "OH-der", listOf(ExampleSentence("Tee oder Kaffee?", "// Tea or coffee?")), "Type: Conjunction | Category: Grammar | IPA: /ˈoːdɐ/", "A1"),
    VocabularyWord("Wer?", "Who?", "vair", listOf(ExampleSentence("Wer ist da?", "// Who is there?")), "Type: Question Word | Category: Grammar | IPA: /veːɐ̯/", "A1"),
    VocabularyWord("Was?", "What?", "vahs", listOf(ExampleSentence("Was ist das?", "// What is that?")), "Type: Question Word | Category: Grammar | IPA: /vas/", "A1"),
    VocabularyWord("Wo?", "Where?", "voh", listOf(ExampleSentence("Wo wohnst du?", "// Where do you live?")), "Type: Question Word | Category: Grammar | IPA: /voː/", "A1"),

    // Practice Sentences
    VocabularyWord("Ich komme aus Deutschland.", "I come from Germany.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Wie heißt du?", "What is your name?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Ich habe eine Frage.", "I have a question.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Wo wohnst du?", "Where do you live?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Ich bin Student.", "I am a student.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Haben Sie Kinder?", "Do you have children?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Das ist mein Freund.", "That is my friend.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Wie viel Uhr ist es?", "What time is it?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Ich habe Hunger und Durst.", "I am hungry and thirsty.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Kommst du mit?", "Are you coming along?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Ich muss jetzt nach Hause gehen.", "I must go home now.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Kannst du das bitte wiederholen?", "Can you please repeat that?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Entschuldigung, ich verstehe das nicht.", "Sorry, I don't understand that.", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Was machst du heute?", "What are you doing today?", "-", emptyList(), "Category: Practice Sentences", "A1"),
    VocabularyWord("Das Wetter ist heute sehr schön.", "The weather is very nice today.", "-", emptyList(), "Category: Practice Sentences", "A1"),

    // Extended Vocabulary
    VocabularyWord("der Morgen", "morning", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Abend", "evening", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Woche", "week", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Monat", "month", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Stunde", "hour", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Minute", "minute", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Tisch", "table", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Stuhl", "chair", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("das Bett", "bed", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Lampe", "lamp", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Tür", "door", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("das Fenster", "window", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Schlüssel", "key", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Tasche", "bag", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("das Handy", "mobile phone", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Uhr", "watch/clock", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Brille", "glasses", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Brief", "letter", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Zeitung", "newspaper", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Regenschirm", "umbrella", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Jacke", "jacket", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Schuh", "shoe", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Hose", "trousers", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("das Hemd", "shirt", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("die Farbe", "colour", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("das Papier", "paper", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("der Kuli", "pen", "-", emptyList(), "Category: Daily Life", "A1"),
    VocabularyWord("das Feuerzeug", "lighter", "-", emptyList(), "Category: Daily Life", "A1"),

    // Phrases
    VocabularyWord("Hallo!", "Hello!", "-", emptyList(), "Category: Greetings", "A1"),
    VocabularyWord("Guten Morgen!", "Good morning!", "-", emptyList(), "Category: Greetings", "A1"),
    VocabularyWord("Guten Tag!", "Good day!", "-", emptyList(), "Category: Greetings", "A1"),
    VocabularyWord("Auf Wiedersehen!", "Goodbye!", "-", emptyList(), "Category: Greetings", "A1"),
    VocabularyWord("Tschüss!", "Bye!", "-", emptyList(), "Category: Greetings", "A1"),
    VocabularyWord("Wie geht es Ihnen?", "How are you? (formal)", "-", emptyList(), "Category: Communication", "A1"),
    VocabularyWord("Wie geht's?", "How are you? (informal)", "-", emptyList(), "Category: Communication", "A1"),
    VocabularyWord("Freut mich!", "Pleased to meet you!", "-", emptyList(), "Category: Communication", "A1"),

    // Verb Prepositions
    VocabularyWord("warten auf (+ Akk)", "to wait for", "-", listOf(ExampleSentence("Ich warte auf den Bus.", "// I'm waiting for the bus.")), "Category: Verb Prepositions", "A1"),
    VocabularyWord("fragen nach", "to ask about/for", "-", listOf(ExampleSentence("Er fragt nach dem Weg.", "// He's asking for directions.")), "Category: Verb Prepositions", "A1"),
    VocabularyWord("helfen bei", "to help with", "-", listOf(ExampleSentence("Kannst du mir bei der Hausaufgabe helfen?", "// Can you help me with the homework?")), "Category: Verb Prepositions", "A1"),

    // Collocations
    VocabularyWord("Kaffee trinken", "to drink coffee", "-", emptyList(), "Category: Collocations", "A1"),
    VocabularyWord("Deutsch lernen", "to learn German", "-", emptyList(), "Category: Collocations", "A1"),
    VocabularyWord("zur Schule gehen", "to go to school", "-", emptyList(), "Category: Collocations", "A1"),

    // Idioms
    VocabularyWord("Es ist mir kalt.", "I feel cold.", "-", emptyList(), "Category: Idioms", "A1"),
    VocabularyWord("Alles klar.", "All right.", "-", emptyList(), "Category: Idioms", "A1"),
    VocabularyWord("Keine Ahnung.", "No idea.", "-", emptyList(), "Category: Idioms", "A1")
)

val readVocabularyData = listOf(
    VocabularyWord(
        "Der Hund bellt laut im Garten. Er sieht eine kleine Katze. Die Katze läuft sehr schnell auf einen hohen Baum. Der treue Hund wartet unten und wedelt mit dem Schwanz.",
        "The dog barks loudly in the garden. He sees a small cat. The cat runs very quickly up a tall tree. The faithful dog waits below and wags its tail.",
        "Story: Der Hund und die Katze",
        emptyList(),
        "Reading Level: A1-A2 | Topic: Animals & Nature",
        "READ"
    ),
    VocabularyWord(
        "Anna steht jeden Morgen um sechs Uhr auf. Sie trinkt ein Glas Wasser und joggt eine Stunde im Park. Danach duscht sie sich und kauft frische Brötchen beim Bäcker für das Frühstück mit ihrer Familie.",
        "Anna gets up every morning at six o'clock. She drinks a glass of water and jogs for an hour in the park. After that, she showers and buys fresh bread rolls at the bakery for breakfast with her family.",
        "Story: Annas Morgenroutine",
        emptyList(),
        "Reading Level: A2 | Topic: Daily Routine & Habits",
        "READ"
    ),
    VocabularyWord(
        "Gestern war das Wetter absolut herrlich. Wir haben uns entschieden, ein schönes Picknick am grünen See zu machen. Meine Mutter hat einen leckeren Erdbeerkuchen gebacken und mein Vater hat kalte Limonade mitgebracht.",
        "Yesterday the weather was absolutely wonderful. We decided to have a beautiful picnic by the green lake. My mother baked a delicious strawberry cake and my father brought cold lemonade.",
        "Story: Ein Ausflug zum See",
        emptyList(),
        "Reading Level: B1 | Topic: Travel, Food & Family",
        "READ"
    ),
    VocabularyWord(
        "In der modernen Gesellschaft spielt die Digitalisierung eine immer größere Rolle. Viele Menschen arbeiten mittlerweile flexibel im Homeoffice. Dies spart nicht nur wertvolle Pendelzeit, sondern schont auch die Umwelt durch reduzierten Verkehr.",
        "In modern society, digitalization plays an increasingly larger role. Many people now work flexibly from home. This not only saves valuable commuting time, but also protects the environment through reduced traffic.",
        "Story: Digitalisierung und Homeoffice",
        emptyList(),
        "Reading Level: B2 | Topic: Work & Society",
        "READ"
    ),
    VocabularyWord(
        "Die Erforschung des Weltraums fasziniert die Menschheit seit Generationen. Durch hochentwickelte Teleskope und unbemannte Sonden gelingt es Wissenschaftlern zunehmend, die komplexen Geheimnisse weit entfernter Galaxien zu entschlüsseln.",
        "The exploration of space has fascinated humanity for generations. Through highly developed telescopes and unmanned probes, scientists are increasingly succeeding in deciphering the complex mysteries of far-away galaxies.",
        "Story: Das unendliche Weltall",
        emptyList(),
        "Reading Level: C1 | Topic: Science & Astronomy",
        "READ"
    )
)

val allVocabularyData by lazy { 
    a1VocabularyData + 
    a2VocabularyData + 
    b1VocabularyData + 
    b2VocabularyData + 
    c1VocabularyData + 
    c2VocabularyData + 
    top1000VocabularyData + 
    top1000VocabularyDataPart2 + 
    top300VerbsData + 
    topListsVocabularyData +
    readVocabularyData
}
