# Minio client voorbeeld

### Wat is het?

Dit is een voorbeeld project dat de onderdelen bevat om verbinding te maken met een Minio S3 database 
en er een file naartoe te sturen.

### Hoe lokaal te testen

1. Lokale minio server opstarten

Start een lokale minio server op met het commando
`docker run -p 9000:9000 -p 9001:9001 --name minio minio/minio server /data --console-address ":9001"`

(De volgende keer kan het gewoon opgestart worden met `docker start minio`)

2. Configuratie van minio

   1. Surf naar http://127.0.0.1:9001/login en login met _minioadmin / minioadmin_.
   2. Maak een nieuwe bucket aan: bv _dvtest_
   3. Maak onder "identity" een nieuwe service account aan, bewaar de access key en de secret key

3. Configuratie van het project

Onder de folder /src/main/resources vind je het bestand _application.properties_:
````
minio.url=http://localhost:9000
minio.accesskey=8GEO3S73CKLNBKV3SEUE
minio.secretkey=Dnnnq7643XAoXLPo5bZN6LrzowRPONy4i1UJ5toA

minio.bucket=dvtest
````
In dit bestand pas je de waarden aan zoals die geconfigureerd staan in Minio

4. Opstarten van het project

Start het project op vanuit de hoofdfolder van het project met het commando `mvn spring-boot:run`
Wanneer alles goed gaat, zal de boodschap _"Completed initialization in ... ms"_ verschijnen

5. Een bestand opladen naar Minio via het project

Met behulp van Postman of Curl kan een bestand verzonden worden (HTTP POST) naar url http://localhost:8080/upload, 
waarbij het bestand in **form-data** als parameter "file" verstuurd wordt.

6. Controle

In de Minio console kan het opgeladen bestand opnieuw gedownload worden, 
dit zou identiek moeten zijn aan het opgeladen bestand.