# Auto-Kill Ender Dragon — Fabric 1.21.1 (fixed)

This version removes the original Mixin and uses Fabric API's `ServerEntityEvents.ENTITY_LOAD` event instead. When an Ender Dragon loads into a server world, its health is set to zero so vanilla can process its death sequence. This also targets dragons spawned by respawning, although death/portal/XP behavior has not been verified in-game.

## Requirements
- Minecraft 1.21.1 / Fabric Loader
- Fabric API for 1.21.1 (tested dependency target: 0.116.17+1.21.1)

## Replace the old GitHub files
1. Delete `src/main/java/com/example/autokilldragon/mixin/EnderDragonEntityMixin.java` and `src/main/resources/autokilldragon.mixins.json` from your GitHub repository.
2. Upload the files **inside** this ZIP to the **root** of the same repository, allowing replacement of `build.gradle`, `gradle.properties`, `src/main/resources/fabric.mod.json`, and `README.md`. Ensure `src/main/java/com/example/autokilldragon/AutoKillDragon.java` is added.
3. Keep `.github/workflows/build.yml` and `settings.gradle`.
4. In GitHub Actions, run `Build Fabric Mod` and download the artifact from a successful build.
5. Remove the previous auto-kill mod JAR from your CurseForge mods folder, and put in the new JAR (not the `-sources.jar`).

This is a source project for GitHub Actions, not a compiled JAR. No compilation or Minecraft runtime test was performed here.
