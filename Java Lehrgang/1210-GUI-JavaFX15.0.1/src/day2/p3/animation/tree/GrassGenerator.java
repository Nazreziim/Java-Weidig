/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved. DO NOT ALTER OR REMOVE
 * COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package day2.p3.animation.tree;

import static day2.p3.animation.tree.Util.addChildToParent;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;

class GrassGenerator {

  Group content;
  private final int numBlades;

  public GrassGenerator( Group content, int numBlades ) {
    this.content = content;
    this.numBlades = numBlades;
  }

  public List< Blade > generateGrass() {

    List< Blade > grass = new ArrayList< Blade >( numBlades );
    for ( int i = 0; i < numBlades; i++ ) {

      final Blade blade = new Blade();
      grass.add( blade );

      addChildToParent( content, blade );
    }
    return grass;
  }
}
