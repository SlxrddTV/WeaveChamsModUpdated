# WeaveChamsMod

A Weave mod for Minecraft 1.8.9 that renders player chams (visible through walls using OpenGL polygon offset).

> **Note:** This is an updated fork of the original project by [Tryflle](https://github.com/Tryflle/WeaveChamsMod).  
> The original repository is no longer maintained and was not compatible with Weave Loader 1.1.0.  
> This fork updates the mod to work with the latest version of Weave, fixes the polygon offset values, and migrates the source from Java to Kotlin.

---

## Changes from the original

- Updated Gradle wrapper to 9.4.0 and plugin to Weave Gradle 1.1.0
- Migrated all source code from **Java to Kotlin**
- Replaced deprecated `net.weavemc.loader.api.*` imports with `net.weavemc.api.*`
- Replaced `preInit()` entry point with the new `init()` method
- Removed `CommandBus` (no longer available in Weave 1.1.0) — `/togglechams` is now handled via `ChatSentEvent`
- Fixed polygon offset values:
  - Pre-render: `glPolygonOffset(1.0f, -1000000.0f)` (was `-1100000.0f`)
  - Post-render: `glPolygonOffset(1.0f, 1000000.0f)` (was `1100000.0f`)

---

## Usage

Type `/togglechams` in chat to toggle chams on or off. You will receive a confirmation message in chat.

When enabled, other players' models will render through walls using OpenGL polygon offset fill.

---

## Building

Requirements:
- JDK 17+
- Internet connection (Gradle will download dependencies automatically)

```bash
.\gradlew build
```

The output JAR will be in `build/libs/`.

---

## Installation

1. Build the mod or download a release JAR
2. Drop the JAR into your `.weave/mods/` folder
3. Launch Minecraft with Weave Loader 1.1.0 attached

---

## Original project

- **Author:** [Tryflle](https://github.com/Tryflle)
- **Original repository:** https://github.com/Tryflle/WeaveChamsMod
- **License:** See [LICENSE](LICENSE)

---

*Updated for Weave 1.1.0 by **Slxrdd***
