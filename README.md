# URL Shortener

A Spring Boot service that turns long URLs into short codes and redirects short codes back to the original URL.

## How it works

1. `POST /urlshortner/shortenUrl` saves the long URL in MySQL and gets back an auto-generated numeric ID.
2. The ID is encoded in **base 26** (A–Z) by `BaseConverter` to make the short code.
3. `GET /urlshortner/getLongUrl?urlReq=<code>` decodes the short code back to the ID, looks up the original URL, and answers with **HTTP 302 Found** and a `Location` header, so the browser follows the redirect.

Encoding the database ID, instead of hashing the URL, means two URLs can never get the same short code. It also means no collision checks are needed.

## Tech stack

Java 17 · Spring Boot 3.1 · Spring Data JPA · MySQL · Maven

## API

| Method | Endpoint | Body / Params | Response |
|---|---|---|---|
| POST | `/urlshortner/shortenUrl` | `{ "longUrl": "https://example.com/some/long/path" }` | Short code, e.g. `BC` |
| GET | `/urlshortner/getLongUrl` | `?urlReq=BC` | `302` redirect to the long URL |

## Run locally

1. Create a MySQL database named `jbdl53`, or change the URL in `application.properties`.
2. Set `DB_PASSWORD` (and `DB_USERNAME` if it isn't `root`) as environment variables.
3. Start the app:

   ```bash
   ./mvnw spring-boot:run
   ```

## Possible improvements

- Use base 62 (`a–z`, `A–Z`, `0–9`) for shorter codes
- Enforce the `expiryDate` field that's already in the entity
- Cache popular short codes in Redis
