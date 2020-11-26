package com.electrosugar.foodevolution.blocks;

import net.fabricmc.loader.util.sat4j.core.Vec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import sun.awt.windows.WPrinterJob;

import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class Pot extends Block {

    public Pot(Settings settings) {
        super(settings);
    }

    public static VoxelShape ConvertVoxelShape(VoxelShape voxelShape){
        return VoxelShapes.cuboid(voxelShape.getMin(Direction.Axis.X)/16,voxelShape.getMin(Direction.Axis.Y)/16,voxelShape.getMin(Direction.Axis.Z)/16,
                voxelShape.getMax(Direction.Axis.X)/16,voxelShape.getMax(Direction.Axis.Y)/16,voxelShape.getMax(Direction.Axis.Z)/16);
    }
    public static VoxelShape ConvertBlockOutline(Stream<VoxelShape> voxelShapeStream){
        voxelShapeStream.forEach(Pot::ConvertVoxelShape);
        return voxelShapeStream.reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR);}).get();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("Hello, world!"), false);
        }

        return ActionResult.SUCCESS;
    }


//    private static final VoxelShape SHAPE_N = Stream.of(
//            ConvertBlockOutline(VoxelShapes.cuboid(1, 8, 6, 2, 9, 7)),
//            ConvertBlockOutline(VoxelShapes.cuboid(0, 8, 6, 1, 9, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(1, 8, 9, 2, 9, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(14, 8, 9, 15, 9, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(15, 8, 6, 16, 9, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(14, 8, 6, 15, 9, 7)),
//            ConvertBlockOutline(VoxelShapes.cuboid(10, 0, 6, 11, 1.5, 7)),
//            ConvertBlockOutline(VoxelShapes.cuboid(10, 0, 9, 11, 1, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(10, 0, 8, 11, 1.5, 9)),
//            ConvertBlockOutline(VoxelShapes.cuboid(10, 0, 7, 11, 1, 8)),
//            ConvertBlockOutline(VoxelShapes.cuboid(5, 0, 9, 6, 1.5, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(5, 0, 6, 6, 1, 7)),
//            ConvertBlockOutline(VoxelShapes.cuboid(5, 0, 7, 6, 1.5, 8)),
//            ConvertBlockOutline(VoxelShapes.cuboid(5, 0, 8, 6, 1, 9)),
//            ConvertBlockOutline(VoxelShapes.cuboid(7, 0, 5, 8, 1, 6)),
//            ConvertBlockOutline(VoxelShapes.cuboid(6, 0, 5, 7, 1.5, 6)),
//            ConvertBlockOutline(VoxelShapes.cuboid(9, 0, 5, 10, 1, 6)),
//            ConvertBlockOutline(VoxelShapes.cuboid(8, 0, 5, 9, 1.5, 6)),
//            ConvertBlockOutline(VoxelShapes.cuboid(8, 0, 10, 9, 1, 11)),
//            ConvertBlockOutline(VoxelShapes.cuboid(9, 0, 10, 10, 1.5, 11)),
//            ConvertBlockOutline(VoxelShapes.cuboid(6, 0, 10, 7, 1, 11)),
//            ConvertBlockOutline(VoxelShapes.cuboid(7, 0, 10, 8, 1.5, 11)),
//            ConvertBlockOutline(VoxelShapes.cuboid(2, 3, 3.0000000000000036, 3, 13, 13)),
//            ConvertBlockOutline(VoxelShapes.cuboid(3, 2, 3, 13, 3, 13)),
//            ConvertBlockOutline(VoxelShapes.cuboid(3, 3, 13, 13, 13, 14)),
//            ConvertBlockOutline(VoxelShapes.cuboid(3, 3, 2.0000000000000036, 13, 13, 3.0000000000000036)),
//            ConvertBlockOutline(VoxelShapes.cuboid(13, 3, 3.0000000000000036, 14, 13, 13)),
//            ConvertBlockOutline(VoxelShapes.cuboid(6, 0, 6, 10, 0.5, 10)),
//            ConvertBlockOutline(VoxelShapes.cuboid(4, 0, 11, 5, 2, 12)),
//            ConvertBlockOutline(VoxelShapes.cuboid(4, 0, 4, 5, 2, 5)),
//            ConvertBlockOutline(VoxelShapes.cuboid(11, 0, 11, 12, 2, 12)),
//            ConvertBlockOutline(VoxelShapes.cuboid(11, 0, 4, 12, 2, 5))
//    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR);}).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return ConvertBlockOutline();
    }

}

