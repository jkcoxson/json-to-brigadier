/*
 * MIT License
 *
 * Copyright (c) 2021 OroArmor (Eli Orona)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.oroarmor.json.brigadier.parsers;

import com.google.gson.JsonObject;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;

public class FloatArgumentParser {
    @SuppressWarnings("unchecked")
    public static <T, S extends ArgumentBuilder<T, S>> ArgumentBuilder<T, S> parse(JsonObject object) {
        FloatArgumentType floatArgument;
        JsonObject argument = object.get("argument").getAsJsonObject();
        if(argument.has("min")) {
            float min = argument.get("min").getAsFloat();
            if (argument.has("max")) {
                floatArgument = FloatArgumentType.floatArg(min, argument.get("max").getAsFloat());
            } else {
                floatArgument = FloatArgumentType.floatArg(min);
            }
        } else {
            floatArgument = FloatArgumentType.floatArg();
        }

        return (ArgumentBuilder<T, S>) RequiredArgumentBuilder.argument(object.get("name").getAsString(), floatArgument);
    }
}
