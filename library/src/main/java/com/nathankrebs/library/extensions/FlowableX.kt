package com.nathankrebs.library.extensions

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Flowable<T>.subscribeIO(): Flowable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.io())


fun <T> Flowable<T>.subscribeIoObserveMain(): Flowable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


fun <T> Flowable<T>.subscribeComputationObserveMain(): Flowable<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())


fun <T> Flowable<T>.subscribeTrampoline(): Flowable<T> =
    this.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline())


fun <T> Flowable<T>.subscribeComputation(): Flowable<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation())


fun <T> Flowable<T>.subscribeIoObserveComputation(): Flowable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())