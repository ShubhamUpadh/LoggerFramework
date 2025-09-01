# Custom Logger Design

## Step 1: Core Requirements

- Provide simple API for logging (`info()`, `warn()`, `error()`, `debug()`). [x]
- Support multiple log levels. [x]
- Print logs in a structured format (e.g., `timestamp - level - class - message`). [x]
- Support at least one output destination (console). [x]
- Ensure logging failures don’t crash the application. [x]
- Keep performance overhead minimal. []

---

## Step 2: Core Components

### Logger API (Facade Layer)
-  Central logger class with methods for each level. [x]

### Log Record / Event
- Object containing: [x]
  - `timestamp`
  - `level`
  - `message`
  - `class/module name`
  - `thread ID`

### Appenders / Handlers
- Console output first. [x]
- Later add File, Database, Socket, etc. []
- Allow multiple appenders at once. []

### Formatter
<<<<<<< Updated upstream
- Define string or JSON output format.
- Make formatter pluggable.
=======
- Define string or JSON output format - Selection can be made via a [x] 
- Make formatter pluggable - Enter a generic format []
>>>>>>> Stashed changes

### Filters / Level Control
- Drop logs below configured level. [x]
- Add optional sensitive data redaction. []

### Configuration
- Externalize setup (YAML/JSON/properties).
- Support per-class/package level settings.

---

## Step 3: Advanced Features

- Asynchronous logging with queue + background worker.
- Log rotation (by size or time) and retention.
- Add contextual info (request ID, correlation ID, session).
- Fail-safe design (if one appender fails, others still work).

---

## Step 4: Example Logging Flow

1. Developer calls a log method (`logger.error("DB connection failed")`).
2. Framework creates a `LogRecord` with metadata.
3. Record passes through filters.
4. Framework sends it to all active appenders.
5. Each appender applies its formatter and outputs the log.
