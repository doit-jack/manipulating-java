package org.example;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class Masul {

    public static void main(String[] args) throws IOException {

//        new ByteBuddy().redefine(Moja.class)
//            .method(named("pullOut")).intercept(FixedValue.value("Rabbit"))
//            .make().saveIn(new File("/Users/jack/99_Study/github/javamagic/out/production/classes"));

        System.out.println(new Moja().pullOut());
    }

}
