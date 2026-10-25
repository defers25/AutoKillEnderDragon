# Auto-Kill Ender Dragon (Fabric 1.21.1)

A minimal Fabric mod that forces the Ender Dragon to zero health at the beginning of its first server tick (and every subsequent tick if needed). It is intended to let Minecraft run its normal dragon death animation and fight-completion logic, including the exit portal and experience rewards. It also affects dragons respawned using End Crystals.

## Requirements

- Minecraft Java Edition 1.21.1
- Fabric Loader 0.16.10 or compatible newer release
- Java 21
- Gradle 8.x (or add a Gradle wrapper to this source project)

## Build

From the project directory, run:

```bash
gradle build
```

The mod JAR will appear in `build/libs/`. Install the non-`-sources` JAR into your Minecraft instance's `mods` folder. Install Fabric Loader in that instance. Fabric API is not required by this mod.

## Implementation

A server-side health change is injected at the beginning of `EnderDragonEntity.tick()`. Unlike instantly discarding/removing the entity, the aim is to preserve vanilla dragon fight completion logic.

## Limitations

This project has not been compiled or tested against a live Minecraft instance in this environment. Confirm the dragon's death animation, XP, and portal behavior in a test world before deploying to a production server. Some dragon/fight overhaul mods may change the behavior. The dragon does not vanish instantly: its vanilla death sequence should still play.
