package fi.dy.masa.litematica.world;


import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameMode;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.LevelGeneratorType;
import net.minecraft.world.level.LevelInfo;
import fi.dy.masa.litematica.render.LitematicaRenderer;

public class SchematicWorldHandler
{
     private static WorldSchematic world;

    
    public static WorldSchematic getSchematicWorld()
    {
        return world;
    }

    public static WorldSchematic createSchematicWorld()
    {
        LevelInfo info = new LevelInfo(0, GameMode.CREATIVE, false, false, LevelGeneratorType.FLAT.getDefaultOptions());
        return new WorldSchematic(null, info, DimensionType.THE_END, MinecraftClient.getInstance()::getProfiler);
    }

    public static void recreateSchematicWorld(boolean remove)
    {
        if (remove)
        {
            world = null;
        }
        else
        {
            // Note: The dimension used here must have no skylight, because the custom Chunks don't have those arrays
            world = createSchematicWorld();
        }

        LitematicaRenderer.getInstance().onSchematicWorldChanged(world);
    }
}
