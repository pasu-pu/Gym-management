
# Gym Management System

Dieses Repository enthält die Backend-Lösung für das Gym Management System-Projekt.  
Es demonstriert ein verteiltes System, das mit **Java** und **gRPC** unter Verwendung einer **hexagonalen Architektur** entwickelt wurde.  
Das System umfasst eine **API**, die **Geschäftslogik** sowie eine **Persistenzkomponente** (basierend auf Hibernate und JPA) und unterstützt **CRUD-Operationen** mit Filterung, Paging und einer 1:n-Beziehung zwischen den Entitäten.

---

## Überblick

Das System ist in folgende Schichten unterteilt:

- **Domain Layer:**  
  Enthält die Kerndomänen wie `Member`, `Trainer`, `Course` und `Booking`.  
  Jede Entität verwendet das **Builder Pattern** und ist mit den entsprechenden JPA-Annotationen versehen.
  Implementiert ausserdem die Geschäftsregeln mittels Klassen wie `MemberLogic`, `TrainerLogic`, `CourseLogic` und `BookingLogic`.

- **Infrastructure Layer:**  
  Beinhaltet Repository-Schnittstellen (z. B. `MemberRepository`, `TrainerRepository`) und deren Implementierungen, die CRUD-Operationen über Hibernate realisieren.  
  Ebenfalls enthalten sind Konfigurationsdateien (z. B. für Hibernate).

- **application Layer (gRPC):**  
  Stellt über **Protocol Buffers** die externe Schnittstelle bereit.  
  Adapter-Klassen (z. B. `MemberServiceImpl`, `TrainerServiceImpl`) transformieren gRPC-Nachrichten in Domänenobjekte und umgekehrt.

---

## Voraussetzungen

- **Java JDK 21**  
- **Maven**  
- **Docker** (für das Container-Deployment)

---

## Systemstart mit Docker

Das Projekt nutzt **Jib**, um das Docker-Image direkt über Maven zu erstellen – ein manuelles Dockerfile ist nicht notwendig.

### 1. Docker-Image mit Jib bauen

Führe folgenden Befehl im Projektverzeichnis aus, um das Docker-Image zu bauen und in die lokale Docker-Registry zu laden:

```bash
mvn clean compile jib:dockerBuild
```

Dieser Befehl:
- Kompiliert den Code,
- Erzeugt das Docker-Image und
- Lädt das Image in deine lokale Docker-Registry.

### 2. Docker-Container starten

Sobald das Image gebaut wurde, starte den Container mit:

```bash
docker run -p 8080:8080 gym-management-tests
```


---

## Tests ausführen

### Unit-Tests

Um Unit-Tests zu starten, verwende:

```bash
mvn test
```

### Integrationstests

Integrationstests werden mit diesem Befehl ausgeführt:

```bash
mvn verify
```

---

## Docker-Integration im Detail

Das Projekt verwendet **Jib**, um das Docker-Image zu erstellen, ohne dass ein manuelles Dockerfile benötigt wird.

- **Image bauen und lokal speichern:**
  ```bash
  mvn clean compile jib:dockerBuild
  ```

- **Container starten:**
  ```bash
  docker run -p 8080:8080 gym-management-tests
  ```

Mit dieser Integration wird sichergestellt, dass alle notwendigen Abhängigkeiten und der Anwendungscode im Container vorhanden sind, sodass das System reproduzierbar und selbstständig lauffähig ist.

---

## Weitere Informationen

- **Hexagonale Architektur:**  
  Das System folgt dem Ports-and-Adapters-Prinzip, wodurch die Domänenlogik von externen Schnittstellen getrennt wird.

- **API-Technologie:**  
  Es kommt **gRPC** mit einem contract-first Ansatz (über Protocol Buffers) zum Einsatz.

- **Persistenz:**  
  Hibernate ORM verwaltet die Datenbankinteraktionen, wobei als Testdatenbank **H2** verwendet wird.

- **Automatisierter Build & Deployment:**  
  Durch die Integration von **Jib** in den Maven-Build-Prozess wird das Erstellen des Docker-Containers vollständig automatisiert.

---

## Teammitglieder

- [Pascal Putz 5123135]
- [Manuel Stöth 5123045]
- [Marvin Kraus 5123143]


---

## Lizenz

Dieses Projekt steht unter der **MIT License**. Siehe die Datei [LICENSE](LICENSE).

---

