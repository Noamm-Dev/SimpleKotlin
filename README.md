# SimpleKotlin

Kotlin + Gradle starter. Builds a fat jar or a GraalVM native binary, and logs the way Minecraft does (SLF4J + Log4j2).

## Build & run

Needs JDK 17+.

```bash
./gradlew build
java -jar build/libs/SimpleKotlin.jar
```

## Native image

Needs [GraalVM](https://www.graalvm.org/downloads/) with `GRAALVM_HOME` set. On Windows you also need the Visual Studio Build Tools.

```bash
./gradlew nativeCompile
./build/native/nativeCompile/SimpleKotlin
```

If a library you add uses reflection, run the jar once with the tracing agent and copy what it finds into `src/main/resources/META-INF/native-image/`:

```bash
$GRAALVM_HOME/bin/java -agentlib:native-image-agent=config-output-dir=agent-out -jar build/libs/SimpleKotlin.jar
```