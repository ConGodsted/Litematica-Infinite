package fi.dy.masa.litematica.schematic.container;


import net.minecraft.block.BlockState;
import net.minecraft.nbt.ListTag;

public interface ILitematicaBlockStatePalette
{
    /**
     * Gets the palette id for the given block state and adds
     * the state to the palette if it doesn't exist there yet.
     */
    int idFor(BlockState state);

    /**
     * Gets the block state by the palette id.
     */
    
    BlockState getBlockState(int indexKey);

    int getPaletteSize();

    void readFromNBT(ListTag tagList);

    ListTag writeToNBT();
}
