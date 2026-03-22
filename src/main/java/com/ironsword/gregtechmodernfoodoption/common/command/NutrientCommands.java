package com.ironsword.gregtechmodernfoodoption.common.command;

import com.ironsword.gregtechmodernfoodoption.api.capability.Nutrients;
import com.ironsword.gregtechmodernfoodoption.api.capability.NutrientsTracker;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

import static net.minecraft.commands.Commands.*;
import static com.ironsword.gregtechmodernfoodoption.api.capability.forge.GTMFOCapability.getNutrientsTracker;

public class NutrientCommands {
    private static final SimpleCommandExceptionType ERROR_NOT_NUTRIENT = new SimpleCommandExceptionType(
            Component.literal("ERROR_NOT_NUTRIENT"));

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext buildContext){
        LiteralArgumentBuilder<CommandSourceStack> nutrientArgumentBuilder = literal("nutrient");

        LiteralArgumentBuilder<CommandSourceStack> queryArgumentBuilder = literal("query").executes(ctx->query(ctx.getSource()));
        LiteralArgumentBuilder<CommandSourceStack> clearArgumentBuilder = literal("clear").requires(ctx-> ctx.hasPermission(LEVEL_ADMINS)).executes(ctx->clear(ctx.getSource()));
        LiteralArgumentBuilder<CommandSourceStack> gainArgumentBuilder = literal("gain").requires(ctx-> ctx.hasPermission(LEVEL_ADMINS));

        for (String name:Nutrients.LIST){
            clearArgumentBuilder.then(literal(name).executes(ctx->clear(ctx.getSource(),name)));
            gainArgumentBuilder.then(literal(name).then(argument("amount", FloatArgumentType.floatArg(0))
                    .executes(ctx->{
                        float amount = FloatArgumentType.getFloat(ctx,"amount");
                        return gain(ctx.getSource(),name,amount);
                    })));
        }

        dispatcher.register(
                nutrientArgumentBuilder
                .then(queryArgumentBuilder)
                .then(clearArgumentBuilder)
                .then(gainArgumentBuilder));

    }

    private static int query(CommandSourceStack source) throws CommandSyntaxException{
        Player player = source.getPlayerOrException();
        NutrientsTracker tracker = getNutrientsTracker(player);
        if (tracker == null) {
            throw EntityArgument.NO_PLAYERS_FOUND.create();
        }
        Object2FloatMap<String> map = tracker.getNutrients();
        if (!map.isEmpty()) {
            source.sendSystemMessage(Component.literal(player.getName().getString()+" has "+map.size()+" nutrients:"));

            Nutrients.LIST.forEach(name->{
                if (map.containsKey(name)){
                    source.sendSystemMessage(
                            Component.literal("-- "+name+" : "+map.getFloat(name)));
                }
            });
        }else {
            source.sendSystemMessage(Component.literal(player.getName().getString()+" has no nutrients."));
        }

        return map.size();
    }

    private static int clear(CommandSourceStack source) throws CommandSyntaxException{
        Player player = source.getPlayerOrException();
        NutrientsTracker tracker = getNutrientsTracker(player);
        if (tracker == null) {
            throw EntityArgument.NO_PLAYERS_FOUND.create();
        }

        int count  = tracker.getNutrients().size();
        tracker.getNutrients().clear();
        source.sendSystemMessage(Component.literal("Clear " + count + " nutrients on " + player.getName().getString()));
        return count;
    }

    private static int clear(CommandSourceStack source, String name) throws CommandSyntaxException{
        Player player = source.getPlayerOrException();
        NutrientsTracker tracker = getNutrientsTracker(player);
        if (tracker == null) {
            throw EntityArgument.NO_PLAYERS_FOUND.create();
        }

        if (Nutrients.LIST.contains(name)){
            float amount = tracker.getNutrients().getOrDefault(name,0f);
            tracker.remove(name);
            source.sendSystemMessage(Component.literal("Clear " + amount + " " + name + " on " + player.getName().getString()));
            return 1;
        }else {
            throw ERROR_NOT_NUTRIENT.create();
        }

    }

    private static int gain(CommandSourceStack source, String name, float amount) throws CommandSyntaxException{
        Player player = source.getPlayerOrException();
        NutrientsTracker tracker = getNutrientsTracker(player);
        if (tracker == null) {
            throw EntityArgument.NO_PLAYERS_FOUND.create();
        }

        if (Nutrients.LIST.contains(name)){
            tracker.gain(name,amount);
            source.sendSystemMessage(Component.literal(player.getName().getString()+" gains " + amount + " " + name + " successfully"));
            return 1;
        }else {
            throw ERROR_NOT_NUTRIENT.create();
        }
    }

}
