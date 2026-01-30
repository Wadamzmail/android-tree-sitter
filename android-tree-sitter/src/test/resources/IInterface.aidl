<<<<<<< HEAD
package com.itsaky.androidide.treesitter.test;
=======
package dev.mutwakil.androidide.treesitter.test;
>>>>>>> 5f5d5e8 (init)

@SomeMarker
@Something(withParam1 = "value", withParam2 = "value")
@SomethingWithArrayParam({"value1", "value2", "value3"})
@UnsupportedAppUsage
interface IInterface {

  @OnAMethod
  void notify();

  void fill(
    in @OnAParam String somethingWeReceive,
    out @OnAParam @CanBeMultiple byte[] somethingWeProvide,
    inout @MayHaveValues(something = "something") int somethingWeBothUse
  );

  oneway void thereIsOnlyOneWay();
}