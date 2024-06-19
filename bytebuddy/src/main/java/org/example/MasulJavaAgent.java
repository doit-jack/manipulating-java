package org.example;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.pool.TypePool.Default;

public class MasulJavaAgent {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Masul.class.getClassLoader();
        TypePool typePool = Default.of(classLoader);

        new ByteBuddy().redefine(typePool.describe("org.example.Moja").resolve(),
                ClassFileLocator.ForClassLoader.of(classLoader))
            .method(ElementMatchers.named("pullOut")).intercept(FixedValue.value("Rabbit"))
            .make().saveIn(new File("/Users/jack/99_Study/github/javamagic/out/production/classes"));

        System.out.println(new Moja().pullOut());
    }

}
