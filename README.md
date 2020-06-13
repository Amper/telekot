# [WIP] telekot

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/Amper/telekot/CI)
[![Codacy grade](https://img.shields.io/codacy/grade/004e390276064f9b9c2ae374dbf4ae40)](https://app.codacy.com/manual/__3/telekot?utm_source=github.com&utm_medium=referral&utm_content=Amper/telekot&utm_campaign=Badge_Grade_Settings)
[![codecov](https://img.shields.io/codecov/c/github/Amper/telekot)](https://codecov.io/gh/Amper/telekot)
![GitHub last commit](https://img.shields.io/github/last-commit/Amper/telekot)
![GitHub top language](https://img.shields.io/github/languages/top/Amper/telekot)
![GitHub](https://img.shields.io/github/license/Amper/telekot)

🤖 **telekot** is a kotlin library for creating [Telegram](https://telegram.org) bots.

**`Warning!` This project is currently under active development and is not yet ready for use.**

## 📦 Installation

Using a JVM dependency manager, simply link `telekot` to your project.

With Gradle:

```groovy
dependencies {
    compile(group: 'vision.alter', name: 'telekot', version: "0.0.1-SNAPSHOT")
}
```

With Gradle (Kotlin Script):

```kotlin
dependencies {
    implementation("vision.alter:telekot:0.0.1-SNAPSHOT")
}
```

With Maven:
```xml
<dependency>
  <groupId>vision.alter</groupId>
  <artifactId>telekot</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## ⌨️ Usage

### Usage of Simple Client

```kotlin
val api = BotApiClient(token)
val msg = api.commonApi.sendMessage(
    chatId = "1234",
    text = "Hello, world!"
)
```

### Usage of Simple Bot

```kotlin
val repeatingBot = LongPoolingBot(token) { update ->
    val message = update.message ?: return@LongPoolingBot
    apiClient.commonApi.sendMessage(
        chatId = "${message.chat.id}",
        text = "message text: ${message.text}",
        replyToMessageId = message.messageId
    )
}
repeatingBot.run()
```

### Usage of Bot DSL

```kotlin
bot {
    apiToken = "TOKEN"
    updatingType = LongPooling(batchSize = 100, timeout = 1)

    command("start") { event ->
        event.answer("Hello, ${event.user.username}")
    }

    unknownCommand { event ->
        event.answer("Unknown command: ${event.command.name}")
    }
}
```

### Usage of Test Server

...

## 📋 Documentation

...

## ✏️ Contributing

To get started, please fork the repo and checkout a new branch. 
You can then build the library locally with Gradle

```shell script
gradle clean build
```

See more info in [CONTRIBUTING.md](CONTRIBUTING.md)

## 🔒 Security

To report a potential vulnerability in telekot please use the [security advisory feature of GitHub](https://github.com/Amper/telekot/security/advisories).

See more info in [SECURITY.md](SECURITY.md)

## ⚖️ License

This library is licensed under the [Apache License, Version 2.0](LICENSE.md)
