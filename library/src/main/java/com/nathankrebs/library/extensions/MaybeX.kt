package com.nathankrebs.library.extensions

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Maybe<T>.subscribeIO(): Maybe<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.io())


fun <T> Maybe<T>.subscribeIoObserveMain(): Maybe<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


fun <T> Maybe<T>.subscribeComputationObserveMain(): Maybe<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())


fun <T> Maybe<T>.subscribeTrampoline(): Maybe<T> =
    this.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline())


fun <T> Maybe<T>.subscribeComputation(): Maybe<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation())


fun <T> Maybe<T>.subscribeIoObserveComputation(): Maybe<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())