package com.nathankrebs.library.extensions

import com.nathankrebs.library.IObservableScheduler
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Completable.subscribeIO(): Completable =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.io())

fun Completable.subscribeIoObserveMain(): Completable =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun Completable.subscribeComputationObserveMain(): Completable =
    this.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())

fun Completable.subscribeTrampoline(): Completable =
    this.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline())

fun Completable.subscribeComputation(): Completable =
    this.subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation())

fun Completable.subscribeIoObserveComputation(): Completable =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())

fun Completable.composeScheduler(scheduler: IObservableScheduler) : Completable =
    this.compose(scheduler.scheduleCompletable())
