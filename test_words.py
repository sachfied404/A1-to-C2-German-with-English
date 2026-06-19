words="""
Hallo
Tschüss
Guten Morgen
Guten Abend
Bitte
Danke
Entschuldigung
Ja
Nein
Wie geht's
Ich
Du
Wir
Mann
Frau
Kind
Familie
Kollege
Leute
Sein
Haben
Gehen
Kommen
Machen
Sagen
Wollen
Brauchen
Wissen
Kaufen
Essen
Trinken
Helfen
Haus
Wohnung
Supermarkt
Bahnhof
Arbeit
Apotheke
Büro
Schule
Restaurant
Wasser
Kaffee
Brot
Frühstück
Mittagessen
Abendessen
Limonade
Auto
Bus
Zug
Ticket
Geld
Euro
Preis
Kasse
Rabatt
Uhr
Heute
Morgen
Gestern
Jetzt
Woche
Wochenende
Monat
Jahr
Gut
Schlecht
Müde
Glücklich
Krank
Hungrig
Fertig
Und
Oder
Aber
Weil
Alt
Zu
Vielleicht
"""

import os
found = []
missing = []

all_files = []
for root, dirs, files in os.walk('./app/src/main/java/com/example'):
    for f in files:
        if f.endswith('.kt'):
            all_files.append(os.path.join(root, f))

for word in words.split('\n'):
    word = word.strip()
    if not word:
        continue
    is_found = False
    for fpath in all_files:
        with open(fpath, 'r', encoding='utf-8') as f:
            if word.lower() in f.read().lower():
                is_found = True
                break
    if is_found:
        found.append(word)
    else:
        missing.append(word)

print("Found: " + str(len(found)))
print("Missing: " + str(len(missing)))
for m in missing:
    print("- " + m)
